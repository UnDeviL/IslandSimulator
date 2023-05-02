package IslandSimulator.src.Animals.animalFactory;

import IslandSimulator.src.Animals.AnimalType;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class AnimalAmount {
    private static final String propertiesPath =
            "IslandSimulator/src/resources/animalFactoryConfig/animalAmountToInitialize.json";
    @Getter
    private static Map<AnimalType, Integer> amountOfEachAnimalToCreate;
    @Getter
    protected Map<AnimalType, Integer> countAnimal;
    public AnimalAmount() {

    }

    private static void deserializeAmountOfEachAnimalToCreate() {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            amountOfEachAnimalToCreate = objectMapper.readValue(new File(propertiesPath), AnimalAmount.class).getCountAnimal();
        } catch (StreamReadException | DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getAmountOfEachAnimalToCreate(AnimalType animalType) {
        deserializeAmountOfEachAnimalToCreate();
        if (amountOfEachAnimalToCreate.containsKey(animalType)) {
            return amountOfEachAnimalToCreate.get(animalType);
        }
        return 0;
    }

}

