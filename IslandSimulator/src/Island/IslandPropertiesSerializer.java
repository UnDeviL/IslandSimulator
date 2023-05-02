package IslandSimulator.src.Island;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class IslandPropertiesSerializer {
    private static final String ISLAND_PROPERTIES_PATH =
            "IslandSimulator/src/resources/IslandConfig/IslandConfig.json";
    @Getter
    protected int x;
    @Getter
    protected int y;
    @Getter
    protected int duration;
    @Getter
    protected int maxPlantsAtCell;
    @Getter
    protected double floweringFactor;
    @Getter
    private static int xDimension;
    @Getter
    private static int yDimension;
    @Getter
    private static int day_duration_ms;
    @Getter
    private static int maxAmountOfPlantsPerCell;
    @Getter
    private static double plantsFloweringFactor;

    IslandPropertiesSerializer() {
    }

    public static void initializeIslandProperties() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            xDimension =
                    objectMapper.readValue(
                            new File(ISLAND_PROPERTIES_PATH),
                            IslandPropertiesSerializer.class).getX();
            yDimension = objectMapper.readValue(
                    new File(ISLAND_PROPERTIES_PATH),
                    IslandPropertiesSerializer.class).getY();
            day_duration_ms = objectMapper.readValue(
                    new File(ISLAND_PROPERTIES_PATH),
                    IslandPropertiesSerializer.class).getDuration();
            maxAmountOfPlantsPerCell = objectMapper.readValue(
                    new File(ISLAND_PROPERTIES_PATH),
                    IslandPropertiesSerializer.class).getMaxPlantsAtCell();
            plantsFloweringFactor = objectMapper.readValue(
                    new File(
                            ISLAND_PROPERTIES_PATH),
                    IslandPropertiesSerializer.class).getFloweringFactor();
        } catch (StreamReadException | DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
