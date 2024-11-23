/*
* AlgoCA1 :
* Andrew Rickerby :
* C23344333 :
* Description of class :
*/  

    package util;


    public class LinearNode<T>
    {
       private LinearNode<T> next;
       private T element;
    
  
       public LinearNode()
       {
          this.next = null;
          this.element = null;
       }

       public LinearNode (T elem)
       {
          this.next = null;
          this.element = elem;
       }

       public LinearNode<T> getNext()
       {
          return this.next;
       }
    
 
       public void setNext (LinearNode<T> node)
       {
          this.next = node;
       }
    
 
       public T getElement()
       {
          return this.element;
       }
    
     
       public void setElement (T elem)
       {
          this.element = elem;
       }
    }

