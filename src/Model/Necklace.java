package Model;

import Model.Stones.Stone;

import java.io.Serializable;
import java.util.*;

public class Necklace implements Serializable {
    private Deque<Stone> stones;

    public Necklace() {
        stones = new ArrayDeque<>();
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

    public void sortByPrice() {
        List<Stone> sortedStone = new ArrayList<>(stones);
        Collections.sort(sortedStone);
        stones = new ArrayDeque<>(sortedStone);
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

    public Deque<Stone> getStones() {
        return stones;
    }
}
