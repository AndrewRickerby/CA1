package util;

public interface LinkedListADT<T> {
    void add(T element);
    void add(T element, int position); 
    T remove();
    boolean isEmpty();
    int size();
    T getFirst();
    T getLast();
    boolean contains(T element);
    String toString();
}
