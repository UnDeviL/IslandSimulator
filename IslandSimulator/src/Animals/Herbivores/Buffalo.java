package IslandSimulator.src.Animals.Herbivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Buffalo extends Herbivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/buffaloProperties.json";
    private Buffalo(){
    }
    @Override
    public AnimalType getAnimalType() {
        return AnimalType.BUFFALO;
    }
}
