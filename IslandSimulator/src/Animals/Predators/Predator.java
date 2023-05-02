package IslandSimulator.src.Animals.Predators;

import IslandSimulator.src.Animals.Animal;
import IslandSimulator.src.Animals.AnimalType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Predator extends Animal {

    public Predator() {
    }

    @Override
    public void eat() {
        double requiredFood = this.getDailyNeededFood();
        // System.out.printf("%s is use method Eat() %n", this.getAnimalType());
        List<Animal> potentialVictimList = getPotentialVictims();

        if (potentialVictimList.isEmpty()) {
            //  System.out.println("VictimList is empty"); //delete
            double weightLoss = requiredFood * this.getDailyWeightLoss();
            this.setWeight(getWeight() - weightLoss);
            if (this.getWeight() <= 0) {
                this.die();
            }
            //System.out.printf("%s doesn't find any victim and his weigh become %s %n", this.getClass().getSimpleName(), this.getWeight());
        } else {
            Animal victim = chooseRandomVictimFromList(potentialVictimList);
            // System.out.println("Line before " + victim.getAnimalType());
            tryToKillTheVictim(victim);
        }


    }

    private List<Animal> getPotentialVictims() {
        //System.out.println("Using method GetPotentialVictims");
        List<Animal> animalsAtThisCell = this.getCurrentCell().getAnimalList();
        List<Animal> potentialVictimList = new ArrayList<>();
        Map<AnimalType, Integer> victimMap = this.getEatingMap();
        for (Animal victim : animalsAtThisCell) {
            if (victim.isAlive() && victimMap.containsKey(victim.getAnimalType())) {
                potentialVictimList.add(victim);
            }
        }
        //System.out.println("Potential victims is : " + potentialVictimList);
        return potentialVictimList;
    }

    public Animal chooseRandomVictimFromList(List<Animal> potentialVictimList) {
       // System.out.println("Using method GetRandomVictim");
        int randomIndex = ThreadLocalRandom.current().nextInt(potentialVictimList.size());
        return potentialVictimList.get(randomIndex);
    }

    public void tryToKillTheVictim(Animal victim) {
        //System.out.println("Use method Try ToKill");
        Map<AnimalType, Integer> victimMap = this.getEatingMap();
        int successFactor = victimMap.get(victim.getAnimalType());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if (random.nextInt(100) < successFactor) {
            victim.die();
            setWeight(this.getMaximumWeight());
            // System.out.printf("%s is ate %s and his weight become %s %n", this, victim, this.getWeight());
            // System.out.printf("victim %s removed from list %s %n", victim.getAnimalType(), Island.getListOfAllAnimals());
        } else {
            setWeight(getWeight() - this.getDailyWeightLoss());

            // System.out.printf("%s failed to attack %s and his weight become %s %n", this, victim, this.getWeight());
        }
    }
}
