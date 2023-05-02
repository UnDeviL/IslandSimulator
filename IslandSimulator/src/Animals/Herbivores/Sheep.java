package IslandSimulator.src.Animals.Herbivores;

import IslandSimulator.src.Animals.AnimalType;
import lombok.Getter;

public class Sheep extends Herbivore{
    @Getter
    private static final String PROPERTIES_PATH =
            "IslandSimulator/src/resources/animalConfig/sheepProperties.json";
    private Sheep(){
    }
    @Override
    public AnimalType getAnimalType() {
        return AnimalType.SHEEP;
    }
}
