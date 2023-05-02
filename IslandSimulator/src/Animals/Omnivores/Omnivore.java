package IslandSimulator.src.Animals.Omnivores;

import IslandSimulator.src.Animals.Animal;
import IslandSimulator.src.Animals.AnimalType;
import IslandSimulator.src.Animals.Herbivores.Herbivore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Omnivore extends Herbivore {

    public Omnivore() {
    }

    @Override
    public void eat() {
        super.eat();
        List<Animal> potentialVictimList = getPotentialVictims();
        if (potentialVictimList.isEmpty()) {
            double weightLoss = this.getDailyWeightLoss();
            this.setWeight(getWeight() - weightLoss);
            if (this.getWeight() < 0) {
                this.setWeight(0);
                this.die();
            }
        } else {
            Animal victim = chooseRandomVictimFromList(potentialVictimList);
            tryToKillTheVictim(victim);
        }
    }

    private List<Animal> getPotentialVictims() {
        List<Animal> animalsAtThisCell = this.getCurrentCell().getAnimalList();
        List<Animal> potentialVictimList = new ArrayList<>();
        Map<AnimalType, Integer> victimMap = this.getEatingMap();
        for (Animal victim : animalsAtThisCell) {
            if (victim.isAlive() && victimMap.containsKey(victim.getAnimalType())) {
                potentialVictimList.add(victim);
            }
        }
        return potentialVictimList;
    }

    public Animal chooseRandomVictimFromList(List<Animal> potentialVictimList) {
        int randomIndex = ThreadLocalRandom.current().nextInt(potentialVictimList.size());
        return potentialVictimList.get(randomIndex);
    }

    public void tryToKillTheVictim(Animal victim) {
        Map<AnimalType, Integer> victimMap = this.getEatingMap();
        int successFactor = victimMap.get(victim.getAnimalType());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if (random.nextInt(100) <= successFactor) {
            victim.die();
            setWeight(this.getWeight());
        } else {
            setWeight(getWeight() - this.getDailyWeightLoss());
            if (this.getWeight() < 0) {
                this.setWeight(this.getDailyWeightLoss());
            }
        }
    }
}
