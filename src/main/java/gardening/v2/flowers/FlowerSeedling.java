package gardening.v2.flowers;

// TODO for students: Choose whether you want this to be an abstract class or
// interface

// Since we want to make grow methd and canHarvest method to be protected,
// I keep using abstract Class here.

// TODO for students: Add in appropriate generic parameter
public abstract class FlowerSeedling<T extends Flower> implements Sellable {
    // each time called by the flower box, the flower grows a litte bit
    protected abstract void grow();

    // once a flower is fully grown, it can be harvested
    protected abstract boolean canHarvest();

    protected abstract T harvestFlower();
}
