package IslandSimulator.src.Animals.Herbivores;

import IslandSimulator.src.Animals.Animal;
import IslandSimulator.src.Animals.AnimalType;


public abstract class Herbivore extends Animal {

    public Herbivore() {
    }

    @Override
    public void eat() {
        double requiredFood = this.getDailyNeededFood();
        int plantsAtCurrentCell = this.getCurrentCell().getPlants();
        if (plantsAtCurrentCell > requiredFood) {
            this.getCurrentCell().setPlants((int) (plantsAtCurrentCell - requiredFood));
            this.setWeight(this.getWeight());
        } else {
            double weightLoss = this.getDailyWeightLoss();
            this.setWeight(this.getWeight() - weightLoss);
            if (this.getWeight() <= 0) {
                this.die();
            }

            this.getCurrentCell().setPlants(0);
        }
    }

    @Override
    public AnimalType getAnimalType() {
        return null;
    }
}
