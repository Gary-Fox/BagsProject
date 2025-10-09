package org.example.tests;

import org.example.BagInterface;
import org.example.ResizableArrayBag;

import java.util.Arrays;

public class ResizableArrayBagTest
{
    public static void main(String[] args)
    {
        ResizableArrayBag<String> bag1 = new ResizableArrayBag<>();
        ResizableArrayBag<String> bag2 = new ResizableArrayBag<>();

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
        //System.out.println("Bag12: " + Arrays.toString(bag12));
        System.out.println("bag2.toString: " + Arrays.toString(bag2.intersection(bag1).toArray()));
        //  System.out.println("Bag21: " + Arrays.toString(bag21));

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
        //System.out.println("IntersectBA: " + Arrays.toString(bagIntB.intersection(bagIntA)));
        System.out.println("IntersesctBA: " + Arrays.toString(bagIntB.intersection(bagIntA).toArray()));
        System.out.println("IntersesctAB: " + Arrays.toString(bagIntA.intersection(bagIntB).toArray()));
        //System.out.println("IntersectAB: " + Arrays.toString(bagIntA.intersection(bagIntB)));
        //Double checking initial bags
        System.out.println("bagIntB:" + Arrays.toString(bagIntB.toArray()));
        System.out.println("bagIntA:" + Arrays.toString(bagIntA.toArray()));

        int out1 = bagIntA.getCurrentSize();
        int out2 = bagIntB.getCurrentSize();
        System.out.println(out2 + " " + out1);
        //   System.out.println("Bag12: " + Arrays.toString(bag12));
        //  System.out.println("Bag21: " + Arrays.toString(bag21));
    }

}
