public abstract class Stone implements Comparable<Stone> {
    private final String name;
    private final double caratWeight;
    private final double price;
    private final double transparency;

    public Stone(String name, double caratWeight, double price, double transparency) {
        this.name = name;
        this.caratWeight = caratWeight;
        this.price = price;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public double getCaratWeight() {
        return caratWeight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Stone other) {
        return Double.compare(this.price, other.price);
    }

    public double getTransparency() {
        return transparency;
    }

    @Override
    public String toString() {
        return name + " - Carat Weight: " + caratWeight + ", Price: " + price + ", Transparency: " + transparency;
    }
}
