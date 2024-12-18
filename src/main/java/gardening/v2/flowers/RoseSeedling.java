package gardening.v2.flowers;

import java.util.Random;

public class RoseSeedling extends FlowerSeedling<Rose> {

    // part of public contract
    public static final int REVEAL_DURATION = 3;

    private static final Random RNG = new Random();
    private int revealTime = REVEAL_DURATION;
    private String chosenMessage;
    public static final String[] MESSAGES = {
            "Abscence makes the heart grow fonder", "A rose by any other name would smell as sweet",
            "One rose says more than the dozen",
            "If every tiny flower wanted to be a rose, spring would lose its loveliness",
            "No Message Written"
    };

    public RoseSeedling() {
        this.chosenMessage = MESSAGES[RNG.nextInt(MESSAGES.length)];
    }

    @Override
    public void grow() {
        this.revealTime = Math.max(0, this.revealTime - 1);
    }

    @Override
    public boolean canHarvest() {
        return this.revealTime == 0;
    }

    @Override
    protected Rose harvestFlower() {
        return new Rose();
    }

    @Override
    public int getPrice() {
        return 25 + 3 * chosenMessage.length();
    }
}
