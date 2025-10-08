package org.example;

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

       System.out.println("bag1.intersection.tostring: " + bag1.intersection(bag2).toString() + '\n');
       System.out.println("Bag12: " + bag12.toString() + '\n');
       System.out.println("bag2.intersection.tostring: " + bag2.intersection(bag1).toString()+'\n');
       System.out.println("Bag21: " + bag21.toString() + '\n');

    }
}
