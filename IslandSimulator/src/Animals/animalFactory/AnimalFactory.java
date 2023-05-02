package IslandSimulator.src.Animals.animalFactory;

import IslandSimulator.src.Animals.Animal;
import IslandSimulator.src.Animals.AnimalType;
import IslandSimulator.src.Animals.Herbivores.*;
import IslandSimulator.src.Animals.Omnivores.Boar;
import IslandSimulator.src.Animals.Omnivores.Duck;
import IslandSimulator.src.Animals.Omnivores.Mouse;
import IslandSimulator.src.Animals.Predators.*;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AnimalFactory {
    private static AnimalFactory instance;

    private AnimalFactory() {
    }

    public static AnimalFactory getInstance() {
        if (instance == null) {
            instance = new AnimalFactory();
        }
        return instance;
    }

    public Animal createAnimal(AnimalType animalType) {

        try {
            return switch (animalType) {
                case WOLF -> new ObjectMapper().readValue(new File(Wolf.getPROPERTIES_PATH()), Wolf.class);
                case BOA -> new ObjectMapper().readValue(new File(Boa.getPROPERTIES_PATH()), Boa.class);
                case FOX -> new ObjectMapper().readValue(new File(Fox.getPROPERTIES_PATH()), Fox.class);
                case BEAR -> new ObjectMapper().readValue(new File(Bear.getPROPERTIES_PATH()), Bear.class);
                case EAGLE -> new ObjectMapper().readValue(new File(Eagle.getPROPERTIES_PATH()), Eagle.class);

                case HORSE -> new ObjectMapper().readValue(new File(Horse.getPROPERTIES_PATH()), Horse.class);
                case DEER -> new ObjectMapper().readValue(new File(Deer.getPROPERTIES_PATH()), Deer.class);
                case RABBIT -> new ObjectMapper().readValue(new File(Rabbit.getPROPERTIES_PATH()), Rabbit.class);
            case MOUSE -> new ObjectMapper().readValue(new File(Mouse.getPROPERTIES_PATH()), Mouse.class);
            case GOAT -> new ObjectMapper().readValue(new File(Goat.getPROPERTIES_PATH()), Goat.class);
            case SHEEP -> new ObjectMapper().readValue(new File(Sheep.getPROPERTIES_PATH()), Sheep.class);
            case BOAR -> new ObjectMapper().readValue(new File(Boar.getPROPERTIES_PATH()), Boar.class);
            case BUFFALO -> new ObjectMapper().readValue(new File(Buffalo.getPROPERTIES_PATH()), Buffalo.class);
                case DUCK -> new ObjectMapper().readValue(new File(Duck.getPROPERTIES_PATH()), Duck.class);
                case CATERPILLAR ->
                        new ObjectMapper().readValue(new File(Caterpillar.getPROPERTIES_PATH()), Caterpillar.class);
            };
        } catch (StreamReadException | DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

