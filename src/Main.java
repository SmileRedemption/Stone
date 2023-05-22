import Model.Necklace;
import View.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu(new Scanner(System.in), new Necklace());
        menu.run();
    }
}

