/*
* AlgoCA1 :
* Andrew Rickerby :
* C23344333 :
* Description of class :
*/




package util;

public class LinkedList<T> implements LinkedListADT<T> {

    private int count;
    private LinearNode<T> front;
    private LinearNode<T> last;

    public LinkedList() {
        count = 0;
        front = null;
        last = null;
    }

    public LinearNode<T> getFront() {
        return front;
    }
    

    public void setFront(LinearNode<T> newFront) {
        front = newFront;
        if (front == null) {
            last = null;  
        }
    }


    public void setLast(LinearNode<T> newLast) {
        last = newLast;
        if (last == null) {
            front = null;  
        } else {
            last.setNext(null);  
        }
    }

    public void add(T element) {
        LinearNode<T> node = new LinearNode<>(element);

        if (isEmpty()) {
            front = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        count++;
    }

    public void add(T element, int position) {
        LinearNode<T> newNode = new LinearNode<>(element);

        if (position <= 1) {
            newNode.setNext(front);
            front = newNode;
            if (count == 0) last = front;
        } else {
            LinearNode<T> current = front;
            int index = 1;
            while (index < position - 1 && current.getNext() != null) {
                current = current.getNext();
                index++;
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) last = newNode;
        }
        count++;
    }

    public T remove() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return null;
        }

        T result = front.getElement();
        front = front.getNext();
        count--;
        if (isEmpty()) last = null;

        return result;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return front.getElement();
    }

    public T getLast() {
        if (isEmpty()) return null;
        return last.getElement();
    }

    public boolean contains(T element) {
        LinearNode<T> current = front;
        while (current != null) {
            if (current.getElement().equals(element)) return true;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinearNode<T> current = front;
        while (current != null) {
            result.append(current.getElement().toString()).append("\n");
            current = current.getNext();
        }
        return result.toString();
    }
}
