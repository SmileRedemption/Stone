import java.util.List;

public class Main {
    public static void main(String[] args) {
        PreciousStone diamond = new PreciousStone("Diamond", 2.5, 5000, 0.9);
        PreciousStone emerald = new PreciousStone("Emerald", 1.8, 4000, 0.8);
        SemiPreciousStone amethyst = new SemiPreciousStone("Amethyst", 3.2, 1000, 0.6);
        SemiPreciousStone topaz = new SemiPreciousStone("Topaz", 2.7, 800, 0.7);

        Necklace necklace = new Necklace();
        necklace.addStone(diamond);
        necklace.addStone(emerald);
        necklace.addStone(amethyst);
        necklace.addStone(topaz);
        necklace.show();
        System.out.println();

        double totalWeight = necklace.getTotalWeight();
        double totalPrice = necklace.getTotalPrice();
        System.out.println("Total Weight: " + totalWeight + " carats");
        System.out.println("Total Price: $" + totalPrice);

        System.out.println();

        necklace.sortByValue();
        necklace.show();

        System.out.println();
        double minTransparency = 0.7;
        double maxTransparency = 0.9;
        List<Stone> foundStones = necklace.findStonesByTransparencyRange(minTransparency, maxTransparency);
        System.out.println("Stones with Transparency Range [" + minTransparency + ", " + maxTransparency + "]:");
        for (Stone stone : foundStones) {
            System.out.println(stone);
        }
    }
}

