package assignment2;

public class MyQueue<E> {
    private  MyDoublyLinkedList<E> DoubLL;
    public MyQueue(){
        MyDoublyLinkedList<E> DLL1= new MyDoublyLinkedList<E>();
        this.DoubLL=DLL1;
    }
    public boolean enqueue(E obj){
        return this.DoubLL.addLast(obj);

    }
    public E dequeue(){
        return this.DoubLL.removeFirst();
    }
    public boolean isEmpty(){
        return this.DoubLL.isEmpty();
    }
    public void clear(){
        this.DoubLL.clear();
    }
    public boolean equals(Object obj){
        if (obj instanceof MyQueue) {
            return this.DoubLL.equals(((MyQueue) obj).DoubLL);
        }
        else{
            return false;
        }
    }
}
