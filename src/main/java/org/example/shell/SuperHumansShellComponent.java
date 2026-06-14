package org.example.shell;

import org.example.dto.SuperHeroDto;
import org.example.services.SuperHeroService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
@Command
public class SuperHumansShellComponent {
    private final SuperHeroService superHeroService;

    public SuperHumansShellComponent(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    //TODO create_super_hero '{"name":"Писючкин","description_super_power":"Пися становится больше","count_save_human":20}'
    @Command(command = "create_super_hero")
    public String createSuperHero(@Option(longNames = "json", required = true) String jsonInputToText) {
        try {
            SuperHeroDto superHeroDto = superHeroService.addSuperHero(jsonInputToText);
            return superHeroDto.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    //TODO update_super_hero --name Писючкин --json '{"description_super_power" : "Вырастает третья пися"}'
    //TODO update_super_hero Писючкин '{"description_super_power" : "Вырастает вторая пися"}'
    @Command(command = "update_super_hero")
    public String updateSuperHero(@Option(longNames = "name", required = true) String name,
                                  @Option(longNames = "json", required = true) String jsonInputToText) {
        try {
            SuperHeroDto superHeroDto = superHeroService.updateSuperHero(name, jsonInputToText);
            return superHeroDto.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @Command(command = "get_list_all_superhero")
    public String getListAllSuperHero() {
        return superHeroService.getSuperHeroList().toString();
    }
}
