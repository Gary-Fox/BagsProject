package org.example.tests;

import org.example.BagInterface;
import org.example.LinkedBag;
import org.example.ResizableArrayBag;

import java.util.Arrays;

public class ResizableArrayBagTest
{
    public static void main(String[] args)
    {
        ResizableArrayBag<String> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<String> bag2 = new ResizableArrayBag<>();
        LinkedBag<String> emptyBag1 = new LinkedBag<>();
        ResizableArrayBag<String> emptyBag2 = new ResizableArrayBag<>();


        bag1.add("Alpha");
        bag1.add("Charlie");
        bag1.add("Oscar");
        bag1.add("Romeo");
        bag1.add("Utah");

        bag2.add("Foxtrot");
        bag2.add("Uniform");
        bag2.add("Charlie");
        bag2.add("Kilo");
        bag2.add("Yankee");
        bag2.add("Uniform");
        bag2.add("Oscar");

        BagInterface<String> bag12 = bag1.intersection(bag2);
        BagInterface<String> bag21 = bag2.intersection(bag1);

        System.out.print('\n');
        System.out.println("Bag1:" + Arrays.toString(bag1.toArray()));
        System.out.println("Bag2:" + Arrays.toString(bag2.toArray()));
        System.out.println("bag1.toString: " + Arrays.toString(bag1.intersection(bag2).toArray()));
        System.out.println("bag2.toString: " + Arrays.toString(bag2.intersection(bag1).toArray()));

        //Int bags
        ResizableArrayBag<Integer> bagIntA = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> bagIntB = new ResizableArrayBag<>();

        bagIntB.add(2);
        bagIntB.add(2);
        bagIntB.add(3);
        bagIntB.add(4);
        bagIntB.add(4);

        bagIntA.add(2);
        bagIntA.add(2);
        bagIntA.add(0);
        bagIntA.add(4);
        bagIntA.add(4);
        bagIntA.add(0);
        bagIntA.add(1);
        bagIntA.add(4);

        //Ints
        System.out.print('\n');
        System.out.println("bagIntB:" + Arrays.toString(bagIntB.toArray()));
        System.out.println("bagIntA:" + Arrays.toString(bagIntA.toArray()));
        System.out.println("IntersesctBA: " + Arrays.toString(bagIntB.intersection(bagIntA).toArray()));
        System.out.println("IntersesctAB: " + Arrays.toString(bagIntA.intersection(bagIntB).toArray()));
        //Double checking initial bags
        System.out.println("bagIntB:" + Arrays.toString(bagIntB.toArray()));
        System.out.println("bagIntA:" + Arrays.toString(bagIntA.toArray()));

        //Ensuring bags are unaltered
        int out1 = bagIntA.getCurrentSize();
        int out2 = bagIntB.getCurrentSize();
        System.out.println(out2 + " " + out1);

        //Checking if linked and array bags can interact
        BagInterface<Character> BagOne = new LinkedBag<Character>();
        BagInterface<Character> BagTwo = new ResizableArrayBag<Character>();

        BagOne.add('1');
        BagOne.add('2');
        BagOne.add('2');
        BagOne.add('A');
        BagOne.add('a');
        BagOne.add('@');

        BagTwo.add('$');
        BagTwo.add('$');
        BagTwo.add('1');
        BagTwo.add('2');
        BagTwo.add('2');
        BagTwo.add('A');
        BagTwo.add('3');
        BagTwo.add('4');

        System.out.println("Intersect linked/Array bag [AB]: " + Arrays.toString(BagOne.intersection(BagTwo).toArray()));
        System.out.println("Intersect linked/Array bag [BA]: " + Arrays.toString(BagTwo.intersection(BagOne).toArray()));

        //Testing Union
        BagInterface<String> unionBag = bag1.union(bag2);

        System.out.println("Union: " + Arrays.toString(bag1.union(bag2).toArray()));
        System.out.println("Union var: " + Arrays.toString(unionBag.toArray()));

        System.out.println("Union mixedbags(AB): " + Arrays.toString(BagTwo.union(BagOne).toArray()));
        System.out.println("Union mixedbags(BA): " + Arrays.toString(BagOne.union(BagTwo).toArray()));

        //Testing Difference method
        System.out.println("Bag1: " + Arrays.toString(bag1.toArray()));
        System.out.println("Bag2: " + Arrays.toString(bag2.toArray()));
        System.out.println("Difference[12]: " + Arrays.toString(bag1.difference(bag2).toArray()));
        System.out.println("Difference[21]: " + Arrays.toString(bag2.difference(bag1).toArray()));
        System.out.println("Bag1: " + Arrays.toString(bag1.toArray()));
        System.out.println("Bag2: " + Arrays.toString(bag2.toArray()));
        //Empty bag tests
        System.out.println("Bag1: " + Arrays.toString(bag1.toArray()));
        System.out.println("Difference[1 - (empty)]: " + Arrays.toString(bag1.difference(emptyBag1).toArray()));
        System.out.println("Difference[(empty) - 1]: " + Arrays.toString(emptyBag2.difference(bag1).toArray()));
        System.out.println("Difference[(empty) - (empty)]: " + Arrays.toString(emptyBag2.difference(emptyBag1).toArray()));



    }

}
