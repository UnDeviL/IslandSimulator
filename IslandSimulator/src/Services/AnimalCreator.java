package IslandSimulator.src.Services;

import IslandSimulator.src.Animals.Animal;
import IslandSimulator.src.Animals.AnimalType;
import IslandSimulator.src.Animals.animalFactory.AnimalAmount;
import IslandSimulator.src.Animals.animalFactory.AnimalFactory;
import IslandSimulator.src.engine.Launcher;

public class AnimalCreator {

    public static void populateIslandWithAnimals() {
        for (AnimalType type : AnimalType.values()) {
            int amountOfEachAnimalWilLBeGenerated = AnimalAmount.getAmountOfEachAnimalToCreate(type);
            for (int i = 0; i < amountOfEachAnimalWilLBeGenerated; i++) {
                    Animal animal = AnimalFactory.getInstance().createAnimal(type);
                    animal.setDayOfCreation(Launcher.dayCounter);
                    animal.goToRandomCell();
                    animal.putToCellAnimalList();
                }
            }
        }





    }
