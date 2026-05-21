package org.example.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.SuperHeroDto;
import org.example.model.SuperHero;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SuperHeroService {
    private List<SuperHero> superHeroList = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public SuperHeroDto addSuperHero(String jsonInputToText) {
        try {
            Map<String, Object> map = objectMapper.readValue(jsonInputToText, Map.class);
            String mapToText = objectMapper.writeValueAsString(map);
            SuperHero superHero = objectMapper.readValue(mapToText, SuperHero.class);
            return mapperFromSuperHeroToSuperHeroDto(superHero);
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
}
