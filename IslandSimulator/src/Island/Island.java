package IslandSimulator.src.Island;

import IslandSimulator.src.Animals.Animal;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Island {
    @Getter
    private static int xDimension;
    @Getter
    private static int yDimension;
    @Getter
    public static Cell[][] islandGrid;


    private Island() {
    }

    public static void initializeIsland() {
        initializeIslandGridSize();
        initializeIslandGrid();
        initializePlants();
        System.out.printf("Island initiated with xDimension = %d and yDimension = %d %n", getXDimension(), getYDimension());
    }

    private static void initializeIslandGridSize() {
        IslandPropertiesSerializer.initializeIslandProperties();
        xDimension = IslandPropertiesSerializer.getXDimension();
        yDimension = IslandPropertiesSerializer.getYDimension();


    }

    private static void initializeIslandGrid() {
        islandGrid = new Cell[xDimension][yDimension];
        for (int i = 0; i < xDimension; i++) {
            for (int j = 0; j < yDimension; j++) {
                Cell cell = new Cell(i, j, new ArrayList<>());
                islandGrid[i][j] = cell;
            }

        }
    }

    private static void initializePlants(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Arrays.stream(islandGrid)
                .flatMap(Arrays::stream)
                .forEach(cell-> cell.setPlants(random.nextInt(0,Cell.MAX_AMOUNT_OF_PLANTS)));
    }

    public static Cell getRandomCellOfIsland() {
        ThreadLocalRandom randomizer = ThreadLocalRandom.current();
        return islandGrid[randomizer.nextInt(0, Island.xDimension)]
                [randomizer.nextInt(0, Island.yDimension)];
    }

    public static List<Animal> getListOfAllAnimals() {

        return Arrays.stream(islandGrid)
                .parallel()
                .flatMap(Arrays::stream)
                .map(Cell::getAnimalList)
                .flatMap(Collection::stream)
                .toList();
    }


}
