package org.example;

import java.util.Arrays;

public class BagDriver
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

       ResizableArrayBag<String> bag12 = bag1.intersection(bag2);
       ResizableArrayBag<String> bag21 = bag2.intersection(bag1);

       System.out.print('\n');
       System.out.println("Bag1:"+ Arrays.toString(bag1.toArray()));
       System.out.println("Bag2:" + Arrays.toString(bag2.toArray()));
       System.out.println("bag1.toString: " + Arrays.toString(bag1.intersection(bag2).toArray()));
       System.out.println("Bag12: " + Arrays.toString(bag12.toArray()));
       System.out.println("bag2.toString: " + Arrays.toString(bag2.intersection(bag1).toArray()));
       System.out.println("Bag21: " + Arrays.toString(bag21.toArray()));

    }
}
