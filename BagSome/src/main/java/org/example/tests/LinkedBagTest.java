package org.example.tests;

import org.example.LinkedBag;
import org.example.*;
import java.util.Arrays;

public class LinkedBagTest
{
    public static void main(String[] args)
    {
        LinkedBag<String> bag1 = new LinkedBag<>();
        ResizableArrayBag<String> bag2 = new ResizableArrayBag<>();
        LinkedBag<Integer> bagA = new LinkedBag<>();
        LinkedBag<Integer> bagB = new LinkedBag<>();
        //Empty
        LinkedBag<Integer> emptyBagA = new LinkedBag<>();
        LinkedBag<Integer> emptyBagB = new LinkedBag<>();
        LinkedBag<String> emptyBag1 = new LinkedBag<>();
        ResizableArrayBag<String> emptyBag2 = new ResizableArrayBag<>();

        emptyBag1.add("Bopple");
        emptyBag1.remove();



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
        System.out.println("Bag1 n empty1: " + Arrays.toString(bag1.intersection(emptyBag1).toArray()));
        System.out.println("empty1 n empty2: " + Arrays.toString(emptyBag1.intersection(emptyBag2).toArray()));

        intersectionBag.add("pineapple");
        intersectionBag.add("apple");
        intersectionBag.add("Apple");

        System.out.println("Intersection bag: " + Arrays.toString(intersectionBag.toArray()));
        System.out.println("Intersection bag n bag2: " + Arrays.toString(intersectionBag.intersection(bag2).toArray()));

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
        System.out.println("Intersecting ");
    }
}
