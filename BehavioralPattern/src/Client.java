public class Client {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Investor john = new Investor("John");
        Investor alice = new Investor("Alice");
        Investor bob = new Investor("Bob");

        stockMarket.subscribe(john);
        stockMarket.subscribe(alice);
        stockMarket.subscribe(bob);

        stockMarket.setStockPrice(100.50);
        System.out.println();

        stockMarket.unsubscribe(alice);
        stockMarket.setStockPrice(98.20);
        System.out.println();

        stockMarket.unsubscribe(bob);
        stockMarket.setStockPrice(99.30);
    }
}



