package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.SuperHeroDto;
import org.example.model.SuperHero;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SuperHeroService {
    private List<SuperHero> superHeroList = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public SuperHeroDto addSuperHero(String jsonInputToText) {
        try {
            System.out.println("Service: " + jsonInputToText);
            Map<String, Object> map = objectMapper.readValue(jsonInputToText, Map.class);
            String mapToText = objectMapper.writeValueAsString(map);
            SuperHero superHero = objectMapper.readValue(mapToText, SuperHero.class);
            System.out.println("SuperHero:" + superHero);
            superHeroList.add(superHero);
            return mapperFromSuperHeroToSuperHeroDto(superHero);
        } catch (Exception ex) {
            return new SuperHeroDto();
        }
    }

    public SuperHeroDto updateSuperHero(String name, String jsonInputToText) {
        try {
            SuperHero superHeroForUpdate = null;
            for (SuperHero superHero : superHeroList) {
                if (superHero.getName().compareToIgnoreCase(name) == 0) {
                    Map<String, Object> map = objectMapper.readValue(jsonInputToText, Map.class);
                    String key = "";
                    Object value = null;
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        key = entry.getKey();
                        value = entry.getValue();
                    }
                    System.out.println("Key: " + key);
                    System.out.println("Value: " + value);
                    if (key.equals("description_super_power")) {
                        superHero.setDescription_super_power(String.valueOf(value));
                        System.out.println("Изменённый герой: " + superHero);
                    }
                    superHeroForUpdate = superHero;
                    System.out.println("Герой кот-й был получен по имени: " + superHeroForUpdate);
                }
            }
            return mapperFromSuperHeroToSuperHeroDto(superHeroForUpdate);
        } catch (Exception ex) {
            return new SuperHeroDto();
        }
    }

    public SuperHeroDto mapperFromSuperHeroToSuperHeroDto(SuperHero superHero) {
        SuperHeroDto superHeroDto = new SuperHeroDto();
        superHeroDto.setName(superHero.getName());
        superHeroDto.setDescription_super_power(superHero.getDescription_super_power());
        superHeroDto.setCount_save_human(superHero.getCount_save_human());
        return superHeroDto;
    }

    public List<SuperHero> getSuperHeroList() {
        return superHeroList;
    }
}
