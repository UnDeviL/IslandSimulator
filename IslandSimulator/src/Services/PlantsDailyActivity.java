package IslandSimulator.src.Services;

import IslandSimulator.src.Island.Cell;
import IslandSimulator.src.Island.Island;
import IslandSimulator.src.Island.IslandPropertiesSerializer;

import java.util.Arrays;

public class PlantsDailyActivity implements Runnable{
    protected static final double PLANTS_GROWTH_MULTIPLIER =
            IslandPropertiesSerializer.getPlantsFloweringFactor();

    @Override
    public void run() {
        Arrays.stream(Island.getIslandGrid())
                .flatMap(Arrays::stream)
                .filter(cell -> cell.getPlants()
                        < Math.floor(Cell.MAX_AMOUNT_OF_PLANTS / PLANTS_GROWTH_MULTIPLIER))
                .forEach(cell -> cell.setPlants((int) (cell.getPlants() * PLANTS_GROWTH_MULTIPLIER)));
    }
}
