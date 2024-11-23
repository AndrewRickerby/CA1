/*
* AlgoCA1 :
* Andrew Rickerby :
* C23344333 :
* Description of class :
*/


package util;

public interface LinkedListADT<T> {
    void add(T element);
    void add(T element, int position); // Overloaded add for specific positions
    T remove();
    boolean isEmpty();
    int size();
    T getFirst();
    T getLast();
    boolean contains(T element);
    String toString();
}
