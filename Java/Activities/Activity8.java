package activities;

import java.util.ArrayList;

public class Activity8 {
    public static void main(String[] args) {

        // Create ArrayList
        ArrayList<String> myList = new ArrayList<String>();

        // Add elements
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Orange");

        // Add at specific index
        myList.add(3, "Grapes");
        myList.add(1, "Papaya");

        // Print all elements
        System.out.println("Print All the Objects:");
        for(String s : myList){
            System.out.println(s);
        }

        // Get 3rd element (index 2)
        System.out.println("3rd element in the list is: " + myList.get(2));

        // Check element exists
        System.out.println("Is Chicku is in list: " + myList.contains("Chicku"));

        // Print size
        System.out.println("Size of ArrayList: " + myList.size());

        // Remove element
        myList.remove("Papaya");

        // Print updated size
        System.out.println("New Size of ArrayList: " + myList.size());
    }
}
