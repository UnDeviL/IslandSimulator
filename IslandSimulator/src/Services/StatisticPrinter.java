package IslandSimulator.src.Services;

import IslandSimulator.src.Animals.Animal;
import IslandSimulator.src.Animals.Herbivores.Herbivore;
import IslandSimulator.src.Animals.Predators.Predator;
import IslandSimulator.src.Island.Island;
import IslandSimulator.src.engine.Launcher;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticPrinter {

    public static void printDailyStatistic(){
        System.out.printf("Day %d %n",Launcher.dayCounter);
        List<Animal>animalList = Island.getListOfAllAnimals();
        printDiedAnimals(animalList);
        printTotalAmountOfHerbivores(animalList);
        printTotalAmountOfPredators(animalList);
        printOffspring(animalList);
        printHerbivoreIcons(animalList);
        printPredatorIcons(animalList);
    }
    private static void printDiedAnimals(List<Animal> animalList){
        long diedAnimals = animalList.stream()
                .filter(Animal::isDead)
                .count();
        System.out.printf("Amount of dead animals for day %s is: %s %n",Launcher.getDayCounter(),diedAnimals);
    }

    private static void printTotalAmountOfPredators(List<Animal> allAnimals) {
        System.out.printf("total amount of carnivores for day %s is: %s\n",Launcher.getDayCounter(),
                allAnimals.stream()
                        .filter(animal -> animal instanceof Predator)
                        .filter(animal -> !animal.isDead())
                        .count());
    }

    private static void printTotalAmountOfHerbivores(List<Animal> allAnimals) {
        System.out.printf("total amount of herbivores for day %s is: %s\n",Launcher.getDayCounter(),
                allAnimals.stream()
                        .filter(animal -> animal instanceof Herbivore)
                        .filter(animal -> !animal.isDead())
                        .count());
    }

    private static void printOffspring(List<Animal> allAnimals) {
        long babyQuantity = allAnimals.stream()
                .filter(animal -> animal.getDayOfCreation() == Launcher.dayCounter)
                .count();
        System.out.printf("new babies born at day %s is : %s\n",Launcher.getDayCounter(), babyQuantity);
    }

    private static void printHerbivoreIcons(List<Animal> allAnimals) {

        Map<String, Long> herbivoreCountMap = allAnimals.stream()
                .filter(Animal::isAlive)
                .filter(animal -> animal instanceof Herbivore)
                .collect(Collectors.groupingBy(Animal::toString, Collectors.counting()));
        for (Map.Entry<String, Long> entry : herbivoreCountMap.entrySet()) {
            System.out.printf("%s: %s | ", entry.getKey(),entry.getValue());
        }
        System.out.println(" ");
    }

    private static void printPredatorIcons(List<Animal> allAnimals) {

        Map<String, Long> predatorCountMap = allAnimals.stream()
                .filter(Animal::isAlive)
                .filter(animal -> animal instanceof Predator)
                .collect(Collectors.groupingBy(Animal::toString, Collectors.counting()));
        for (Map.Entry<String, Long> entry : predatorCountMap.entrySet()) {
            System.out.printf("%s: %s | ", entry.getKey(),entry.getValue());
        }
        System.out.println(" ");
    }

}

