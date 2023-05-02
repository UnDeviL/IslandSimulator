package IslandSimulator.src.engine;

import IslandSimulator.src.Island.Island;
import IslandSimulator.src.Services.AnimalCreator;
import IslandSimulator.src.Services.IslandLifeSimulationService;
import lombok.Getter;

public class Launcher {
    @Getter
    public static int dayCounter;

    public static void launchSimulation(){
        dayCounter++;
        Island.initializeIsland();
        AnimalCreator.populateIslandWithAnimals();
        IslandLifeSimulationService.startSimulation();
    }
}
