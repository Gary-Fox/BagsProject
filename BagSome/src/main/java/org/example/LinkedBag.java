package org.example;

import org.example.tests.LinkedBagTest;

public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    /** Constructor
     * Sets bag to null, number of entries set to 0
     */
    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /** Adds a new member into the bag, must be the same dataType as the bag
     * @param newEntry the new entry into the bag
     * @return true if successful
     */
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

    /** Removes the entry at the first node, sets the 2nd node as the new first node
     * @return the entry removed
     */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.getData();
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
        }
        return result;
    }

    /** Removes a specific entry in the bag (must be in the bag when called)
     * @param anEntry the entry to be removed
     * @return true if successful
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.setData(firstNode.getData());
            firstNode = firstNode.getNextNode();
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    /**Searches every member of the bag for a specific entry
     * @param anEntry the entry that should exist in our bag
     * @return the node that holds our desired entry, should be null if it does not.
     */
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    /**Checks if our bag is currently empty
     * @return true if our bag is empty
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**Acquires the number of members within our bag
     * @return the number of entries in our bag
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**Empties the bag of all contents, remaining value is null
     */
    public void clear() {
        while (!isEmpty())
            remove();
    }

    /**Acquires the amount of times a given entry has occurred
     * @param anEntry The entry of interest
     * @return the number of times anEntry is in our bag, returns 0 if 0.
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        Node currentNode = firstNode;
        while (counter < numberOfEntries && currentNode != null) {
            if (anEntry.equals(currentNode.getData()))
                frequency++;
            counter++;
            currentNode = currentNode.getNextNode();
        }
        return frequency;
    }

    /**Checks to see if a desired entry occurs even once in our bag
     * @param anEntry the desired entry
     * @return true if our bag contains anEntry, false otherwise
     */
    public boolean contains(T anEntry) {
        return getReferenceTo(anEntry) != null;
    }

    /**Converts the content of the bag into an array of the same datatype
     * @return the array of the same data type
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while (index < numberOfEntries && currentNode != null) {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        }
        return result;
    }

    /**Nodes object to make the bag linked
     * Nodes contain data, and the address of the next node object.
     */
    private class Node {
        private T data;
        private Node next;

        /** creates a new node based on the data inputted, next node is null
         * @param dataPortion the data we want to store in the node
         */
        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        /** Creates a new node based on the data inputted, and points to the next node
         * @param dataPortion the data we want to store in the node
         * @param nextNode the next node after our current one
         */
        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        /** Acquires the data stored in the node
         * @return the data stored in the node
         */
        private T getData() {
            return data;
        }

        /** Sets the data stored in the node
         * @param newData the data we want in our node
         */
        private void setData(T newData) {
            data = newData;
        }

        /** Acquires the address to the next node
         * @return the address to the next node
         */
        private Node getNextNode() {
            return next;
        }
    }

    /** Creates and returns a bag comprised of the union of our two bags
     * @param addBag the bag we want to union with our current bag object
     * @return A bag containing the union of our current bag and bagIn
     */
    public BagInterface<T> union(BagInterface<T> addBag)
    {
        T[] bagA = this.toArray();
        T[] bagB = addBag.toArray();

        BagInterface<T> unifyList = new LinkedBag<>();

        for (int i = 0; i < bagA.length; i++) {
            unifyList.add(bagA[i]);
        }
        for (int j = 0; j < bagB.length; j++) {
            unifyList.add(bagB[j]);
        }
        return unifyList;
    }

    /** Creates and returns a bag comprised of the intersection of two bags
     * @param bagIn the bag we want to intersect with our current bag object
     * @return A bag containing the intersection of our current bag and bagIn
     */
    public BagInterface<T> intersection(BagInterface<T> bagIn)
    {
        T[] bagA = this.toArray();
        T[] bagB = bagIn.toArray();
        LinkedBag<T> result = new LinkedBag<>();
        //T searchVar;
        if (this.isEmpty() || bagIn.isEmpty())
        {
            return result;
        }

        for (int i = 0; i < bagB.length; i++)
        {
            if (bagB[i] != null)
            {
                for (int j = 0; j < bagA.length; j++)
                {
                    if(bagB[i] == bagA[j] && bagA[j] != null)
                    {
                        result.add(bagB[i]);
                        bagB[i] = null;
                        bagA[j] = null;
                    }
                }
            }
        }


        return result;
    }

    /** Creates and returns a bag comprised of the difference of two bags
     *  The current bag object minus the bagIn
     * @param bagIn the bag we want to subtract from our current bag object
     * @return A bag containing the difference between our bags
     */
    public BagInterface<T> difference(BagInterface<T> bagIn)
    {
        T[] bagA = this.toArray();
        T[] bagB = bagIn.toArray();

        java.util.ArrayList<T> resultList = new java.util.ArrayList<>();
        java.util.Collections.addAll(resultList, bagA);

        for (T otherItem : bagB) {
            if (otherItem == null) continue;
            boolean removed = false;
            for (int k = 0; k < resultList.size() && !removed; k++) {
                T candidate = resultList.get(k);
                if (candidate != null && otherItem.equals(candidate)) {
                    resultList.remove(k);
                    removed = true;
                }
            }
        }

        BagInterface<T> result = new ResizableArrayBag<>();
        for (T element : resultList) {
            result.add(element);
        }
        return result;
    }
}