package org.example;

/** An interface for a bag of objects
 * Alog with methods for manipulating the bag
 * but not the contents themselves
 * @param <T>
 */
public interface BagInterface<T>
{
    /** Gets the current number of entries in the bag
     * @return the int [#] of entries in the bag
     */
    public int getCurrentSize();

    /** Checks if the bag is empty
     * @return true if the bag is empty, false otherwise
     */
    public boolean isEmpty();

    /**Adds a new entry in the bag
     * @param newEntry the object to be added
     * @return true if the addition was successful, false otherwise
     */
    public boolean add(T newEntry);

    /** Removes an unspecified entry from the bag, if possible
     * @return the removed object, or null if the removal was unsuccessful
     */
    public T remove();

    /** Removes one occurrence of a given entry from the bag, if possible
     * @param anEntry the object to be removed
     * @return true if the removal was successful, false otherwise
     */
    public boolean remove(T anEntry);

    /**Empties the bag of all contents
     */
    public void clear();

    /** Counts the number of times a given entry appears
     * @param anEntry the entry to find
     * @return int [#] the number of times anEntry appears.
     */
    public int getFrequencyOf(T anEntry);

    /** tests whether th bag contains (an instance of) a given entry
     * @param anEntry the entry to find
     * @return True if the bag contains anEntry, false otherwise
     */
    public boolean contains(T anEntry);

    /** Gathers all bag entries and converts them into an array
     * @return An array of all the entries in the bag
     */
    public T[] toArray();

    /*
     * ┌───────────────────────────────────────────────────┐
     * │                 To be implemented                 │
     * └───────────────────────────────────────────────────┘
     */
    public BagInterface<T> union();
    public BagInterface<T> intersection(BagInterface<T> In);
    public BagInterface<T> difference();
}
