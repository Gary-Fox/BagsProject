package org.example;

import java.util.Arrays;

public class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    private int numberOfEntries;
    private boolean integrityOK = false;

    /**Constructor
     * */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }
    /**constructor with known capacity
     * */
    public ResizableArrayBag(int capacity)
    {
        checkCapacity(capacity);
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
        numberOfEntries = 0;
        integrityOK = true;
    }

    /** Gets the current number of entries in the bag
     * @return the int [#] of entries in the bag
     */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    /** Checks if the bag is empty
     * @return true if the bag is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }

    /**Adds a new entry in the bag
     * @param newEntry the object to be added
     * @return true if the addition was successful, false otherwise
     */
    public boolean add(T newEntry)
    {
        checkIntegrity();
        boolean result = true;
        if (isArrayFull())
        {
            doubleCapacity();
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return result;
    }

    /** Removes an unspecified entry from the bag, if possible
     * @return the removed object, or null if the removal was unsuccessful
     */
    public T remove()
    {
        checkIntegrity();
        return removeEntry(numberOfEntries);
    }

    /** Removes one occurrence of a given entry from the bag, if possible
     * @param anEntry the object to be removed
     * @return true if the removal was successful, false otherwise
     */
    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    /**Empties the bag of all contents
     */
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }

    /** Counts the number of times a given entry appears
     * @param anEntry the entry to find
     * @return int [#] the number of times anEntry appears.
     */
    public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int counter = 0;
        for (int i = 0; i < numberOfEntries; i++)
        {
            if (anEntry.equals(bag[i]))
            {
                counter++;
            }
        }
        return counter;
    }

    /** tests whether th bag contains (an instance of) a given entry
     * @param anEntry the entry to find
     * @return True if the bag contains anEntry, false otherwise
     */
    public boolean contains(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry) > -1;
    }

    /** Gathers all bag entries and converts them into an array
     * @return An array of all the entries in the bag
     */
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        for(int index = 0; index < numberOfEntries; index++)
        {
            result[index] = bag[index];
        }
        return result;
    }

    /*
     * ┌───────────────────────────────────────────────────┐
     * │                 To be implemented                 │
     * └───────────────────────────────────────────────────┘
     */
    public T[] union()
    {
        return null;
    }
    public T[] intersection()
    {
        return null;
    }
    public T[] difference()
    {
        return null;
    }

  /*
   * ┌───────────────────────────────────────────────────┐
   * │              Non-inherited Methods                │
   * └───────────────────────────────────────────────────┘
   */

    /** Tests if the array is full
     * @return true if the array is full, false otherwise
   */
    public boolean isArrayFull()
    {
        return numberOfEntries == bag.length;
    }

    /** Ensures users do not make a bag too big to handle
     *  @param capacity the desired capacity
     * @throws IllegalStateException if the capacity is too large
     */
    private void checkCapacity(int capacity)
    {
        if (capacity >= MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose" +
                    "capacity exceeds allowed maximum of " + MAX_CAPACITY);
    }

    /** Doubles the size of the array bag
    */
    private void doubleCapacity()
    {
        int newLength = 2 * bag.length;
        checkCapacity(newLength);
        bag = Arrays.copyOf(bag, newLength);
    }

    /** Tests if the object is corrupt
     * @throws SecurityException if the object is corrupt
     */
    public void checkIntegrity()
    {
        if(!integrityOK)
            throw new SecurityException("ResizableArrayBag object is corrupt.");
    }

    /** Finds the index of a given entry
     * @param anEntry the entry to find
     * @return the removed entry, or -1 if nonexistent
     */
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int index = 0;

        while(!found && (index < numberOfEntries))
        {
            if(anEntry.equals(bag[index]))
            {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    /** Removes the entry at a given index
     * @param index the index of the entry to be removed
     * @return the removed entry, or null if the index is invalid
     */
    private T removeEntry(int index)
    {
        T result = null;
        if(!isEmpty() && (index >= 0))
        {
            result = bag[index];
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }


}
