package com.pluralsight;

public class Product {
}


// EXERCISE 1
//  Create a new Java application named search-inventory.
//  You will code the application we saw in the previous pages.
//  The application displays the inventory that our store carries.
//      Remember: When creating a new Java project, create a new git repository and commit your changes often!
//      Don’t forget to push to github.com. Always share your IntelliJ project to GitHub!
//      You will need to code the getInventory() method and create an initial inventory of at least 5 products.
// An ArrayList's size can change and will continue to grow as long as you have the energy to place products in the list.
//  Test the application.
//      BONUS: Replace the code that loaded the ArrayList with code that reads data from a file named inventory.csv.
//      Create a file containing products that resembles the following.
//          4567|10' 2x4  (grade B)|9.99
//          1234|Hammer|19.49
//          2345|Box of nails|9.29
//  Read the file a line at a time. Split the string where you find the pipe ( | ) character and use the parts to create a Product object.
//  Add the object to the ArrayList.
//  The list will be able to accommodate however many products you add to the file.
//      BONUS: Sort the products by name before you display them.
//          Hint:  Collections.sort() with a Comparator on getName()
//      BONUS: Replace the user interface of the program with a menu driven one.
//      Provide a loop and prompt the user using a style resembling the following:
//          What do you want to do?
//              1- List all products
//              2- Lookup a product by its id
//              3- Find all products within a price range
//              4- Add a new product
//              5- Quit the application
//      Enter command:
//          1. Ensure all your changes are committed and pushed to GitHub
//          2. Send your repository URL to your Instructor