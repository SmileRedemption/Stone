import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Subject {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    public void setStockPrice(double price) {
        stockPrice = price;
        invoke();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void invoke() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}
