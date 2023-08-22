package assignment2;

public class MyStack<E> {
    private MyDoublyLinkedList<E> DLL;
    public MyStack(){
        MyDoublyLinkedList<E> DLL1= new MyDoublyLinkedList<E>();
        this.DLL=DLL1;
    }
    public boolean push(E element){
        return this.DLL.addFirst(element);
    }
    public E pop(){
        return this.DLL.removeFirst();
    }
    public E peek(){
        return this.DLL.peekFirst();
    }
    public boolean isEmpty(){
        return this.DLL.isEmpty();
    }
    public void clear(){
        this.DLL.clear();
    }
    public int getSize(){
        return this.DLL.getSize();
    }
}
