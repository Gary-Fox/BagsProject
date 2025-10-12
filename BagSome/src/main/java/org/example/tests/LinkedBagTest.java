package org.example.tests;

import java.util.Arrays;

import org.example.BagInterface;
import org.example.LinkedBag;
import org.example.ResizableArrayBag;

public class LinkedBagTest
{
    public static void main(String[] args)
    {
        LinkedBag<String> bag1 = new LinkedBag<>();
        ResizableArrayBag<String> bag2 = new ResizableArrayBag<>();
        LinkedBag<Integer> bagA = new LinkedBag<>();
        LinkedBag<Integer> bagB = new LinkedBag<>();
        ResizableArrayBag<String> emptyBag1 = new ResizableArrayBag<>();
        LinkedBag<String> emptyBag2 = new LinkedBag<>();

        emptyBag2.add("Wobble");
        emptyBag2.remove();


        bag1.add("apple");
        bag1.add("banana");
        bag1.add("orange");
        bag1.add("apple");
        bag1.add("banana");
        bag1.add("orange");

        bag2.add("banana");
        bag2.add("kiwi");
        bag2.add("apple");
        bag2.add("apple");
        bag2.add("apple");
        bag2.add("apple");
        bag2.add("dragonfruit");


        BagInterface<String> intersectionBag = bag1.intersection(bag2);

        System.out.println("Intersection: " + Arrays.toString(bag1.intersection(bag2).toArray()));
        System.out.println("Intersection var: " + Arrays.toString(intersectionBag.toArray()));

        bagA.add(1);
        bagA.add(1);
        bagA.add(0);
        bagA.add(1);
        bagA.add(0);
        bagA.add(10);
        bagA.add(3);

        bagB.add(1);
        bagB.add(2);
        bagB.add(3);
        bagB.add(4);
        bagB.add(5);
        bagB.add(6);
        bagB.add(7);
        bagB.add(8);
        bagB.add(9);
        bagB.add(0);
        bagB.add(1);
        bagB.add(1);
        bagB.add(1);

        System.out.println("Intersection[AB]: " + Arrays.toString(bagA.intersection(bagB).toArray()));
        System.out.println("Intersection[BA]: " + Arrays.toString(bagB.intersection(bagA).toArray()));

        //Testing Difference method
        System.out.println("BagA: " + Arrays.toString(bagB.toArray()));
        System.out.println("BagA: " + Arrays.toString(bagA.toArray()));
        System.out.println("Difference[BA]: " + Arrays.toString(bagB.difference(bagA).toArray()));
        System.out.println("Difference[BA]: " + Arrays.toString(bagA.difference(bagB).toArray()));
        System.out.println("BagA: " + Arrays.toString(bagB.toArray()));
        System.out.println("BagA: " + Arrays.toString(bagA.toArray()));
        //Empty bag tests
        System.out.println("Bag1: " + Arrays.toString(bag1.toArray()));
        System.out.println("Difference[1 - (empty)]: " + Arrays.toString(bag1.difference(emptyBag1).toArray()));
        System.out.println("Difference[(empty) - 1]: " + Arrays.toString(emptyBag2.difference(bag1).toArray()));
        System.out.println("Difference[(empty) - (empty)]: " + Arrays.toString(emptyBag2.difference(emptyBag1).toArray()));
    }
}
