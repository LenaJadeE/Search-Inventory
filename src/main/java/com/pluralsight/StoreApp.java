package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StoreApp {

    private static final String INVENTORY_FILE = "inventory.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> inventory = getInventory();

        running = true;
        while (running) {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("  1- List all products");
            System.out.println("  2- Lookup a product by its id");
            System.out.println("  3- Find all products within a price range");
            System.out.println("  4- Add a new product");
            System.out.println("  5- Quit the application");
            System.out.print("Enter command: ");

            String command = scanner.nextLine().trim();
    }
}
