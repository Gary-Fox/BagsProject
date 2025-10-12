package org.example;

import java.util.Arrays;

public class BagDriver
{
    public static void main(String[] args)
    {
        ResizableArrayBag<Integer> aBag1 = new ResizableArrayBag<>();
        ResizableArrayBag<Integer> aBag2 = new ResizableArrayBag<>();
        LinkedBag<Integer> lBag3 = new LinkedBag<>();
        LinkedBag<Integer> emptyLinked = new LinkedBag<>();
        ResizableArrayBag<Integer> emptyArray = new ResizableArrayBag<>();

        // contents: 1, 2, 3, 4,
        aBag1.add(1);
        aBag1.add(3);
        aBag1.add(2);
        aBag1.add(4);

        // contents: 4, 4, 4,
        aBag2.add(4);
        aBag2.add(4);
        aBag2.add(4);

        // contents: 1
        lBag3.add(5);

        // contents: [empty]
        emptyArray.add(1500);
        emptyArray.remove();

        // Union
        BagInterface<Integer> unionBag21 = aBag2.union(aBag1);
        BagInterface<Integer> unionBag12 = aBag1.union(aBag2);
        System.out.println("########## * Union * ##########");
        System.out.println("aBag1: " + Arrays.toString(aBag1.toArray()));
        System.out.println("aBag2: " + Arrays.toString(aBag2.toArray()));
        System.out.println("lBag3: " + Arrays.toString(lBag3.toArray()));
        System.out.println("emptyArray: " + Arrays.toString(emptyArray.toArray()));
        System.out.println("emptyLinked: " + Arrays.toString(emptyLinked.toArray()));
        System.out.println("bag1 U bag2: " + Arrays.toString(unionBag12.toArray()));
        System.out.println("bag2 U bag1: " + Arrays.toString(unionBag21.toArray()));
        System.out.println("[Array]bag12 U [Linked]bag3: " + Arrays.toString(unionBag12.union(lBag3).toArray()));
        System.out.println("Emptybag U bag12: " + Arrays.toString(emptyArray.union(unionBag12).toArray()));
        System.out.println("[Array]Emptybag U [Linked]Emptybag: " + Arrays.toString(emptyArray.union(emptyLinked).toArray()));
        System.out.print('\n');

        //Intersection
        System.out.println("########## * Intersection * ##########");
        System.out.println("Intersection of an intersection: " + Arrays.toString(aBag1.intersection(unionBag12.intersection(aBag2)).toArray()));
        System.out.println("aBag1: " + Arrays.toString(aBag1.toArray()));
        System.out.println("aBag2: " + Arrays.toString(aBag2.toArray()));
        System.out.println("lBag3: " + Arrays.toString(lBag3.toArray()));
        System.out.println("emptyArray: " + Arrays.toString(emptyArray.toArray()));
        System.out.println("emptyLinked: " + Arrays.toString(emptyLinked.toArray()));

        System.out.print('\n');

        //Difference
        System.out.println("########## * Difference * ##########");
        System.out.println("aBag1: " + Arrays.toString(aBag1.toArray()));
        System.out.println("aBag2: " + Arrays.toString(aBag2.toArray()));
        System.out.println("lBag3: " + Arrays.toString(lBag3.toArray()));
        System.out.println("emptyArray: " + Arrays.toString(emptyArray.toArray()));
        System.out.println("emptyLinked: " + Arrays.toString(emptyLinked.toArray()));


    }
}
