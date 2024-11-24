package gardening.v2.flowers;

public class Sunflower extends Flower implements Sellable {
    private int numSeeds = 7;
    private int bloom = 7;

    public int harvestSeeds() {
        int tmpSeeds = numSeeds;
        numSeeds = 0;
        return tmpSeeds;
    }

    @Override
    public int getPrice() {
        return 15 + bloom;
    }

}
