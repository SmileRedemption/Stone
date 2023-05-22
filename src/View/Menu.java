package View;

import Exceptions.NotValidInputException;
import Factories.Factory;
import Model.Necklace;
import Model.Stones.Stone;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Factory stoneFactory;
    private Necklace necklace;

    public Menu(Scanner scanner, Necklace necklace) {
        this.scanner = scanner;
        this.necklace = necklace;
        this.stoneFactory = new Factory();
    }

    public void showMenu() {
        System.out.println("МЕНЮ:");
        System.out.println("1) Додати камінь у намисто");
        System.out.println("2) Вивести список камінь у намисті");
        System.out.println("3) Розрахувати загальну вартість");
        System.out.println("4) Сортувати камні за ціною");
        System.out.println("5) Зберегти намисто у файл");
        System.out.println("6) Завантажити намисто з файлу");
        System.out.println("0) Вийти");
    }

    public void run() {
        int choice;
        do {
            showMenu();
            choice = getChoice();

            switch (choice) {
                case 1 -> addStone();
                case 2 -> showStones();
                case 3 -> calculateTotalPrice();
                case 4 -> sortByPrice();
                case 5 -> saveNecklaceToFile();
                case 6 -> loadNecklaceFromFile();
                case 0 -> System.out.println("Программа завершена!");
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        } while (choice != 0);
    }

    private void sortByPrice() {
        necklace.sortByPrice();
        System.out.println("Каміня у намисті відсортовано за ціною.");
    }

    private void calculateTotalPrice() {
        double totalPrice = necklace.getTotalPrice();
        System.out.println("Загальна вартість намиста: " + totalPrice + "$");
    }

    private void showStones() {
        necklace.show();
    }

    private void addStone() {
        try {
            System.out.print("Введіть назву каміння: ");
            String name = scanner.nextLine();
            System.out.print("Введіть вагу у каратах: ");
            double caratWeight = scanner.nextDouble();
            System.out.print("Введіть ціну: ");
            double price = scanner.nextDouble();
            System.out.print("Введіть прозорість: ");
            double transparency = scanner.nextDouble();
            scanner.nextLine();

            if (caratWeight <= 0 || price <= 0 || transparency <= 0) {
                throw new NotValidInputException("Некоректні дані каміння!");
            }

            Stone stone = stoneFactory.create(name, caratWeight, price, transparency);
            necklace.addStone(stone);
            System.out.println("Камінь " + name + " успішно додано до намиста!");
        } catch (NotValidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getChoice() {
        int choice = -1;
        try {
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }
        return choice;
    }

    private void saveNecklaceToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("necklace.dat"))) {
            oos.writeObject(necklace);
            System.out.println("Намисто збережено до файлу.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні Намиста до файлу: " + e.getMessage());
        }
    }

    private void loadNecklaceFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("necklace.dat"))) {
            necklace = (Necklace) ois.readObject();
            System.out.println("Намисто завантажено з файлу.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при завантаженні салату з файлу: " + e.getMessage());
        }
    }
}
