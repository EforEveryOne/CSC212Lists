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
		
		throw new TODOErr();
		
	}

	@Override
	public T removeBack() {
		throw new TODOErr();
	}

	@Override
	public T removeIndex(int index) {
		throw new TODOErr();
	}

	@Override
	public void addFront(T item) {
		this.start = new Node<T>(item, start);
	}

	@Override
	public void addBack(T item) {
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
		
		
		throw new TODOErr();
	}

	@Override
	public void addIndex(int index, T item) {
		throw new TODOErr();
	}
	
	
//	this needs more work, gotta check for index?
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
