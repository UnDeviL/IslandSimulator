package IslandSimulator.src.Services;

import IslandSimulator.src.Island.Island;
import IslandSimulator.src.Island.IslandPropertiesSerializer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandLifeSimulationService {

private static final int STEP_DURATION = IslandPropertiesSerializer.getDay_duration_ms();

private static final ScheduledExecutorService ANIMALS_EXECUTOR =
        Executors.newScheduledThreadPool(1);

    private static final ScheduledExecutorService PLANTS_EXECUTOR =
            Executors.newScheduledThreadPool(1);
public static void startSimulation (){
    startAnimalLifeCycle();
    plantsLifeCycle();
}

private static void startAnimalLifeCycle() {
    ANIMALS_EXECUTOR.scheduleAtFixedRate(new AnimalDailyActivitySimulation()
            ,0,STEP_DURATION, TimeUnit.MILLISECONDS);
}

    private static void plantsLifeCycle() {
        PLANTS_EXECUTOR.scheduleAtFixedRate(new PlantsDailyActivity()
                , STEP_DURATION, STEP_DURATION, TimeUnit.MILLISECONDS);
    }

protected static void stopSimulation(){
    ANIMALS_EXECUTOR.shutdown();
    PLANTS_EXECUTOR.shutdown();
    System.out.printf("The las living on Island is %s \n ",Island.getListOfAllAnimals());
}

}
