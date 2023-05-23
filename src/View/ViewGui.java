package View;

import Factories.Factory;
import Model.Necklace;
import Model.Stones.Stone;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ViewGui extends JFrame {
    private Necklace necklace;
    private final Factory factory = new Factory();
    private JTextArea stoneListTextArea;

    public ViewGui() {
        super("Намисто ");
        necklace = new Necklace();

        initializeGUI();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeGUI() {
        JPanel inputPanel = new JPanel();

        JButton addStoneButton = new JButton("Додати камінь");
        addStoneButton.addActionListener(e -> {
            addStoneButton();
        });
        inputPanel.add(addStoneButton);

        JButton sortStonesButton = new JButton("Сортувати за ціною");
        sortStonesButton.addActionListener(e -> sortStones());
        inputPanel.add(sortStonesButton);

        JButton saveStoneButton = new JButton("Зберегти намисто");
        saveStoneButton.addActionListener(e -> saveNecklaceToFile());
        inputPanel.add(saveStoneButton);

        JButton loadStoneButton = new JButton("Завантажити намисто");
        loadStoneButton.addActionListener(e -> loadNecklaceFromFile());
        inputPanel.add(loadStoneButton);

        add(inputPanel, BorderLayout.NORTH);

        JTable stoneList = new JTable();
        JScrollPane scrollPane = new JScrollPane(stoneList);
        add(scrollPane, BorderLayout.CENTER);

        stoneListTextArea = new JTextArea();
        add(new JScrollPane(stoneListTextArea), BorderLayout.CENTER);
        refreshVegetableList();
    }

    private void refreshVegetableList() {
        stoneListTextArea.setText("");
        for (Stone stone : necklace.getStones()) {
            stoneListTextArea.append(stone.toString() + "\n");
        }
    }

    private void loadNecklaceFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                necklace = (Necklace) ois.readObject();
                refreshVegetableList();
                JOptionPane.showMessageDialog(this, "Намисто завантажено з файлу");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveNecklaceToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(necklace);
                JOptionPane.showMessageDialog(this, "Намисто збережено до файлу");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sortStones() {
        necklace.sortByPrice();
        refreshVegetableList();
    }

    private void addStoneButton() {
        String name = JOptionPane.showInputDialog(this, "Введіть намисто: ");
        if (name != null && !name.isEmpty()) {
            double caratWeight = Double.parseDouble(JOptionPane.showInputDialog(this, "Введіть вагу камня:"));
            double price = Double.parseDouble(JOptionPane.showInputDialog(this, "Введіть ціну камня:"));
            double transparency = Double.parseDouble(JOptionPane.showInputDialog(this, "Введіть прозорість камня:"));
            necklace.addStone(factory.create(name, caratWeight, price, transparency));
            refreshVegetableList();
        }
    }
}
