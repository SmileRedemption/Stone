import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Necklace {
    private final List<Stone> stones;

    public Necklace() {
        stones = new ArrayList<>();
    }

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public double getTotalWeight() {
        double totalWeight = 0.0;
        for (Stone stone : stones) {
            totalWeight += stone.getCaratWeight();
        }
        return totalWeight;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Stone stone : stones) {
            totalPrice += stone.getPrice();
        }
        return totalPrice;
    }

    public void sortByValue() {
        Collections.sort(stones);
    }

    public void show(){
        for (Stone stone : stones) {
            System.out.println(stone);
        }
    }

    public List<Stone> findStonesByTransparencyRange(double minTransparency, double maxTransparency) {
        List<Stone> result = new ArrayList<>();
        for (Stone stone : stones) {
            double transparency = stone.getTransparency();
            if (transparency >= minTransparency && transparency <= maxTransparency) {
                result.add(stone);
            }
        }
        return result;
    }
}
