package IslandSimulator.src.Animals.Herbivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Rabbit extends Herbivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/rabbitProperties.json";
    private Rabbit(){
    }
    @Override
    public AnimalType getAnimalType() {
        return AnimalType.RABBIT;
    }
}
