package edu.smith.cs.csc212.adtr.real;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.TODOErr;

public class SinglyLinkedList<T> extends ListADT<T> {
	/**
	 * The start of this list.
	 * Node is defined at the bottom of this file.
	 */
	Node<T> start;
	
	@Override
	public T removeFront() {
		checkNotEmpty();
//		return removeIndex(0);
		
		Node<T> n = this.start;
		this.start = start.next;
		return n.value;
//		start = start.next;
//		return (T) start.value;
		
		
		
		

//		this.start = new Node<T>(item, start);
		
//		for (Node<T> n = this.start;
//				n != null;
//				n = n.next) {
//		return (T) n.next
//				}
//		return n;
		
		
//		
//		Node<T> current = this.start; n = this.next;
//		
//		this.next = null;
//		current = this.next;
			
			
//		current.start = null;
//		while (current != null) {
//		System.out.println(current.value);
//		current.value = null;
//		current = current.next;
//		}
//		return null;
//		return (T) current;

//        start = start.next;
//        return (T) start;
//		
//		remove index(0)
//		 if (start == null) {
//			 return null;
//		 }
//		 else {
//             if (start == next) {
//
//                   start = null;
//
//                   next = null;
//
//             } else {
//                   start = start.next;
//             }
//       }
//		return null;
		
//		if this node this.n = start
//		then this.start = this.next
//		We know how to grab the front, index 0, but how to delete it?
//		Node<T> b = this.start;
//		if (b.next != null) {
//			b.next = this.start;
//			this.start = null;
//		}
//		return b.value;
		
				
//		throw new TODOErr();
		
	}

	@Override
	public T removeBack() {
		throw new TODOErr();
	}

	@Override
	public T removeIndex(int index) {
		getIndex(0);
//		n.value = null;
		
		
		throw new TODOErr();
	}

	@Override
	public void addFront(T item) {
		this.start = new Node<T>(item, start);
	}

	@Override
	public void addBack(T item) {
		if (this.isEmpty()) {
			this.addFront(item);
			return;
		}
		for (Node<T> b = this.start; b != null; b = b.next) {
			if (b.next == null) {
			b.next = new Node<T>(item, null);
				return;
				}
		}
//		for (int i=1; item.next!=null;i++);
//		for (Node<T>)
		
//		Node<T> lastInList = null;
//		for (Node<T> current = this.start;
//		current != null;
//		current = current.next) {
//		lastInList = current;
//		}
//		if (lastInList != null) {
//			lastInList.next = new Node<T>(value);
//			} else {
//			this.start = new Node<T>(value);
//			}
//			
//		this.next = new Node<T>(item, next);
		
		
//		throw new TODOErr();
	}

	@Override
	public void addIndex(int index, T item) {
		throw new TODOErr();
	}
	
	@Override
	public T getFront() {
		checkNotEmpty();
//		Node<T> 
//		n = this.start;
//		n.value = (T) "a";
//		System.out.println(this.start);
//		System.out.println(n.value);
//		return n.value;	
		return getIndex(0);
//		throw new TODOErr();
	}

	@Override
	public T getBack() {
		checkNotEmpty();
		throw new TODOErr();
	}

	@Override
	public T getIndex(int index) {
		checkNotEmpty();
		int at = 0;
		for (Node<T> n = this.start; n != null; n = n.next) {
			if (at++ == index) {
				return n.value;
			}
		}
		throw new BadIndexError(index);
	}
	

	@Override
	public void setIndex(int index, T value) {
		checkNotEmpty();
		throw new TODOErr();
	}

	@Override
	public int size() {
		int count = 0;
		for (Node<T> n = this.start; n != null; n = n.next) {
			count++;
		}
		return count;
	}


	@Override
	public boolean isEmpty() {
		return this.start == null;
	}
	
	/**
	 * The node on any linked list should not be exposed.
	 * Static means we don't need a "this" of SinglyLinkedList to make a node.
	 * @param <T> the type of the values stored.
	 */
	private static class Node<T> {
		public Object start;
		/**
		 * What node comes after me?
		 */
		public Node<T> next;
		/**
		 * What value is stored in this node?
		 */
		public T value;
		/**
		 * Create a node with no friends.
		 * @param value - the value to put in it.
		 */
		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}

}
