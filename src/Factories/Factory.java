package Factories;

import Model.Stones.NotDetectedStone;
import Model.Stones.PreciousStone;
import Model.Stones.SemiPreciousStone;
import Model.Stones.Stone;

public class Factory {
    public Stone create(String name, double caratWeight, double price, double transparency){
        if (name.equals("Diamond"))
            return new PreciousStone(name, caratWeight, price, transparency);
        if (name.equals("Emerald"))
            return new PreciousStone(name, caratWeight, price, transparency);
        if (name.equals("Amethyst"))
            return new SemiPreciousStone(name, caratWeight, price, transparency);
        if (name.equals("Topaz"))
            return new SemiPreciousStone(name, caratWeight, price, transparency);
        else
            return new NotDetectedStone(name, caratWeight, price, transparency);

    }
}
