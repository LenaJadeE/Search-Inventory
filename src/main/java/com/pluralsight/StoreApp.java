package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class StoreApp {

    private static final String InventoryFile = "inventory.csv";

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

            switch (command) {
                case "1" -> listAllProducts(inventory);
                case "2" -> lookupById(inventory, scanner);
                case "3" -> findByPriceRange(inventory, scanner);
                case "4" -> addProduct(inventory, scanner);
                case "5" -> running = false;
                default -> System.out.println("Please enter a command from 1 to 5.");
            }
        }

        System.out.println("Goodbye!");
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(InventoryFile))){
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());

                inventory.add(new Product(id, name, price));
            }
        } catch (IOException e) {
            System.out.println("ERROR: Could not read " + InventoryFile + ": " + e.getMessage());
        }

        sortByName(inventory);
        return inventory;
    }

    private static void  sortByName(ArrayList<Product> inventory) {
        Collections.sort(inventory, (a,b) -> a.getName().compareToIgnoreCase(b.getName()));
    }

    private static void listAllProducts(ArrayList<Product> inventory) {
        System.out.println("We carry the following inventory: ");
        for (Product product : inventory) {
            printProduct(product);
        }
    }

    private static void  lookupById(ArrayList<Product> inventory, Scanner scanner) {
        System.out.print("Enter product id: ");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());

            for(Product product : inventory) {
                if (product.getId() == id) {
                    printProduct(product);
                    return;
                }
            }
            System.out.println("No product found with id " + id + ".");
        } catch (NumberFormatException e) {
            System.out.println("That wasn't a valid id. Please enter a whole number.");
        }

    }

    private static void findByPriceRange(ArrayList<Product> inventory, Scanner scanner) {
        try {
            System.out.print("Enter the minimum price: ");
            double min = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Enter the maximum price: ");
            double max = Double.parseDouble(scanner.nextLine().trim());

            int matches = 0;
            for (Product product : inventory) {
                if (product.getPrice() >= min && product.getPrice() <= max) {
                    printProduct(product);
                    matches++;
                }
            }
            if (matches == 0) {
                System.out.printf("No products between $%.2f and $%.2f.%n", min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println("That wasn't a valid price range. Please enter a number such as 9.99.");
        }
    }

    private  static void addProduct(ArrayList<Product> inventory, Scanner scanner) {
        try {
            System.out.print("Enter the new product's id: ");

        }
    }
}
