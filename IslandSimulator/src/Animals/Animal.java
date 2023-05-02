package IslandSimulator.src.Animals;

import IslandSimulator.src.Animals.animalFactory.AnimalFactory;
import IslandSimulator.src.Island.Cell;
import IslandSimulator.src.Island.Island;
import IslandSimulator.src.engine.Launcher;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {

    @Getter
    @Setter
    private double weight;
    @Getter
    protected double maximumWeight;
    @Getter
    protected double dailyWeightLoss;
    @Getter
    protected double dailyNeededFood;
    @Getter
    @Setter
    private int maxAmountPerCell;
    @Getter
    @Setter
    private int couldPassCellsPerMove;
    @Getter
    @Setter
    private boolean isAlive = true;
    @Getter
    protected boolean isFemale;
    @Getter
    private Cell currentCell;
    @Getter
    @Setter
    private int dayOfCreation;
    private boolean hasOffspring;
    @Getter
    protected String icon;

    @Getter
    protected Map<AnimalType, Integer> eatingMap;

    public Animal() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        isFemale = random.nextBoolean();
    }

    public void putToCellAnimalList() {
        this.currentCell.getAnimalList().add(this);
    }

    public void goToRandomCell() {
        currentCell = Island.getRandomCellOfIsland();
    }

    public void move() {

        if (!this.isDead()) {
            Cell currentPosition = this.currentCell;
            List<Cell> availableCellsToMove = getAvailableCellsToMove();
            Cell newPosition = decideWhereToMove(availableCellsToMove);
            if (newPosition != currentPosition
                    && newPosition.countType(this.getAnimalType()) < this.getMaxAmountPerCell()) {
                this.currentCell = newPosition;
                synchronized (currentPosition.getAnimalList()) {
                    currentPosition.getAnimalList().remove(this);
                }
                synchronized (this.currentCell.getAnimalList()) {
                    this.currentCell.getAnimalList().add(this);
                }
            }
        }
    }

    private List<Cell> getAvailableCellsToMove() {

        Cell[][] allCells = Island.getIslandGrid();
        List<Cell> availableCellsToGo = new ArrayList<>();
        for (int i = -this.getCouldPassCellsPerMove(); i <= this.getCouldPassCellsPerMove(); i++) {
            for (int j = -this.getCouldPassCellsPerMove(); j <= this.getCouldPassCellsPerMove(); j++) {
                if (Math.abs(i) + Math.abs(j) > this.getCouldPassCellsPerMove()) {
                    continue;
                }
                int currentXCell = this.currentCell.getX() + i;
                int currentYCell = this.currentCell.getY() + j;
                if (currentXCell >= 0
                        && currentXCell < Island.getXDimension()
                        && currentYCell >= 0
                        && currentYCell < Island.getYDimension()
                ) {
                    Cell current = allCells[currentXCell][currentYCell];
                    availableCellsToGo.add(current);
                }
            }
        }
        return availableCellsToGo;
    }

    public Cell decideWhereToMove(List<Cell> availableCellsToMove) {

        int randomIndex = ThreadLocalRandom.current().nextInt(availableCellsToMove.size());
        return availableCellsToMove.get(randomIndex);
    }

    public abstract void eat();

    public void die() {

        isAlive = false;
    }

    public boolean isDead() {
        return !isAlive;
    }

    public void reproduce() {
        if (this.isFemale) {
            return;
        }
        if (this.hasOffspring) {
            return;
        }
        List<Animal> animalsReadyToReproduce = this.currentCell.getAnimalList().stream()
                .filter(animal -> animal.isAlive)
                .filter(animal -> animal.getAnimalType() == this.getAnimalType())
                .filter(animal -> animal.isFemale)
                .toList();
        if (animalsReadyToReproduce.size() > 0) {
            Animal baby = AnimalFactory.getInstance().createAnimal(this.getAnimalType());
            baby.currentCell = this.currentCell;
            baby.putToCellAnimalList();
            baby.setDayOfCreation(Launcher.getDayCounter());
            this.hasOffspring = true;
            animalsReadyToReproduce.stream().findAny().get().hasOffspring = true;
        }
    }

    public abstract AnimalType getAnimalType();

    @Override
    public String toString() {

        return icon + '\'';
    }

}
