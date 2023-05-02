package IslandSimulator.src.Animals.Herbivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Horse extends Herbivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/horseProperties.json";
    private Horse(){
    }
    @Override
    public AnimalType getAnimalType() {
        return AnimalType.HORSE;
    }
}
