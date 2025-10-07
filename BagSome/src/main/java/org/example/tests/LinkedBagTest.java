package org.example;

public class LinkedBagDemo {
    public static void main(String[] args) {
        BagInterface<String> bag = new LinkedBag<>();

        // Add items
        bag.add("apple");
        bag.add("banana");
        bag.add("apple");
        bag.add("cherry");

        System.out.println("Bag contents after adding:");
        displayBag(bag);

        // Test getCurrentSize and getFrequencyOf
        System.out.println("Current size: " + bag.getCurrentSize());
        System.out.println("Frequency of 'apple': " + bag.getFrequencyOf("apple"));
        System.out.println("Contains 'banana'? " + bag.contains("banana"));
        System.out.println("Contains 'grape'? " + bag.contains("grape"));

        // Remove one item
        System.out.println("\nRemoving one item: " + bag.remove());
        System.out.println("Bag after removing one item:");
        displayBag(bag);

        // Remove specific item
        System.out.println("\nRemoving 'apple': " + bag.remove("apple"));
        System.out.println("Bag after removing 'apple':");
        displayBag(bag);

        // Clear bag
        bag.clear();
        System.out.println("\nBag after clear():");
        displayBag(bag);
        System.out.println("Is bag empty? " + bag.isEmpty());
    }

    private static void displayBag(BagInterface<String> bag) {
        Object[] bagArray = bag.toArray();
        System.out.print("Bag: ");
        for (Object item : bagArray) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
