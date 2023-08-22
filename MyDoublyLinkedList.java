package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {
	private DNode head;
	private DNode tail;

	public boolean add(E obj){
		if (this.isEmpty()){
			DNode node1= new DNode();
			node1.element=obj;
			node1.next=null;
			node1.prev=null;
			this.tail=node1;
			this.head=node1;
			this.size=1;
		}
		else if ( !(this.head.element instanceof E )) {
			return false;
		}

		else {
			DNode node1 = new DNode();
			node1.element = obj;
			node1.next = null;
			node1.prev = this.tail;
			this.tail.next = node1;
			this.tail = node1;
			this.size++;

		}
		return true;
	}
	public E remove(){
		if (this.isEmpty()){
			throw new NoSuchElementException("List is empty");
		}
		else if(this.size==1){
			E tmp=tail.element;
			this.tail.element=null;
			this.head = null;
			this.tail = null;
			this.size=0;
			return tmp;
		}
		else{
			E tmp=tail.element;
			this.tail = tail.prev;
			this.tail.next.element = null;
			this.tail.next.prev = null;
			this.tail.next = null ;
			this.size--;
			return tmp;
		}
	}
	public boolean addFirst(E object){
		if (this.getSize()!=0 && !(this.head.element instanceof E) ){
			return false;
		}
		else if(this.isEmpty()){
			DNode node1= new DNode();
			node1.element=object;
			node1.prev=null;
			node1.next=null;
			this.head=node1;
			this.tail=node1;
			this.size=1;
		}
		else {
			DNode node1= new DNode();
			node1.element=object;
			node1.prev=null;
			node1.next=this.head;
			this.head.prev=node1;
			this.head=node1;
			this.size++;
		}
	return true;
	}
	public boolean addLast(E object){
		return add(object);
	}
	public E removeFirst(){
		if (this.isEmpty()){
			throw new NoSuchElementException("List is empty");
		}
		else if(this.size==1){
			E tmp=head.element;
			this.size--;
			return tmp;
		}
		else{
			E tmp=head.element;
			this.head.next.prev = null;
			this.head= this.head.next;
			this.size--;
			return tmp;
		}
	}
	public E removeLast(){
		return this.remove();
	}
	public E peekFirst(){
		if (this.isEmpty()){
			throw new NoSuchElementException("List is empty");
		}
		else {
			return this.head.element;
		}

	}
	public E peekLast(){
		if (this.isEmpty()){
			throw new NoSuchElementException("List is empty");
		}
		else {
			return this.tail.element;
		}
	}

	public void clear() {
		while(!this.isEmpty()){
			this.remove();
		}

	}

	public boolean equals(Object o) {
		if (o instanceof MyDoublyLinkedList) {
			MyDoublyLinkedList<E> obj = (MyDoublyLinkedList<E>) o;
			if (this.getSize() == obj.getSize()) {
				Iterator<E> iter1 = this.iterator();
				Iterator<E> iter2 = obj.iterator();
				while (iter1.hasNext()) {
					if ((iter1.next()).equals(iter2.next())) {
						continue;
					} else {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	private class DNode {
		private E element;
		private DNode next;
		private DNode prev;

	}

	
	public Iterator<E> iterator() {
		return new DLLIterator();
	}
	
	private class DLLIterator implements Iterator<E> {
		DNode curr;

		public DLLIterator() {
			this.curr = head;
		}

		public boolean hasNext() {
			return this.curr != null;
		}

		public E next() {
			if (!this.hasNext())
				throw new NoSuchElementException();

			E element = this.curr.element;
			this.curr = this.curr.next;
			return element;
		}
	}
}
