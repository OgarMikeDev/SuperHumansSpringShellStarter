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

    //TODO create_super_hero {"name":"Писючкин","description_super_power":"Пися становится больше","count_save_human":20}
    @Command(command = "create_super_hero")
    public String createSuperHero(@Option(longNames = "json", required = true) String jsonInputToText) {
        try {
            System.out.println("Принимаю херь: " + jsonInputToText);
            SuperHeroDto superHeroDto = superHeroService.addSuperHero(jsonInputToText);
            return superHeroDto.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
