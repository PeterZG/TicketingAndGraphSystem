package gardening.v2.flowers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// TODO for students: Add in appropriate generic parameters
public class FlowerBox<S extends FlowerSeedling<T>, T extends Flower> {
    private List<S> seedlings = new ArrayList<>();

    public void addFlower(S seedling) {
        seedlings.add(seedling);
    }

    public int numHarvestable() {
        // safely convert from long to int. stream's count method returns a long
        return Math.toIntExact(seedlings.stream().filter(seedling -> seedling.canHarvest()).count());
    }

    public List<T> harvestFlowers() {
        return extractReadyFlowers();
    }

    public void growFlowers() {
        seedlings.forEach((seedling) -> seedling.grow());
    }

    // A helper method. The types of the objects ready to be harvested
    // may be different from the types you return from your flower box.
    // e.g seedlings are ready to harvest but you return flowers once harvested
    protected List<T> extractReadyFlowers() {
        List<T> readyFlowers = seedlings.stream()
            .filter(seedling -> seedling.canHarvest())
            .map(seedling -> seedling.harvestFlower())
            .collect(Collectors.toList());
        seedlings.removeIf(seedling -> seedling.canHarvest());
        return readyFlowers;
    }
}
