package IslandSimulator.src.Services;

import IslandSimulator.src.Animals.Animal;
import IslandSimulator.src.Animals.AnimalType;
import IslandSimulator.src.Island.Island;
import IslandSimulator.src.engine.Launcher;

import java.util.List;

public class AnimalDailyActivitySimulation implements Runnable {

    public static final double MAXIMUM_WEIGHT_LOSS = 0.80;
    @Override
    public void run() {
        Launcher.dayCounter++;
        Island.getListOfAllAnimals().forEach(this::deleteDeadAnimals);
        List<Animal> allAnimals = Island.getListOfAllAnimals();
        if (allAnimals.size() < 2 ) {
            IslandLifeSimulationService.stopSimulation();
        }
        dealWithCaterpillars(allAnimals);
        runAnimalLifeCycle(allAnimals);
        StatisticPrinter.printDailyStatistic();
    }

    private void runAnimalLifeCycle(List<Animal> animalList) {
        animalList.stream()
                .filter(this::checkAnimalLifeCondition)
                .forEach(animal -> {
                    animal.eat();
                    animal.move();
                    animal.reproduce();
                });
    }

    private boolean checkAnimalLifeCondition(Animal animal) {
    double animalWeight = animal.getWeight();

    if(animal.getWeight() < (animalWeight * MAXIMUM_WEIGHT_LOSS) && !animal.isDead() || animalWeight < 0.01){
        animal.die();
        return animal.isDead();
    }
        return !animal.isDead();
    }

    private void deleteDeadAnimals(Animal animal) {
        if (animal.isDead()) {
            animal.getCurrentCell().getAnimalList().remove(animal);
        }
    }

    private void dealWithCaterpillars(List<Animal> animalList){
        animalList.stream()
                .filter(animal -> animal.getAnimalType() == AnimalType.CATERPILLAR)
                .filter(animal -> animal.getCurrentCell().getPlants() == 0)
                .forEach(Animal::die);
    }
}
