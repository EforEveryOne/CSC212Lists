package edu.smith.cs.csc212.adtr.real;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.TODOErr;


public class DoublyLinkedList<T> extends ListADT<T> {
	private Node<T> start;
	private Node<T> end;
	
	/**
	 * A doubly-linked list starts empty.
	 */
	public DoublyLinkedList() {
		this.start = null;
		this.end = null;
	}
	

	@Override
	public T removeFront() {
		checkNotEmpty();
//		throw new TODOErr();
		Node<T> n = this.start;
		this.start = this.start.after;
		return n.value;
	}

	@Override
	public T removeBack() {
		checkNotEmpty();
		if (this.size() == 1) {
			Node<T> n = this.start;
			this.end = this.start = null;
			return n.value;
		} else {
			T n = this.end.value;
			this.end = this.end.before;
			this.end.after = null;
			return n;
		}
		

		
//		Node<T> n = this.end;
//		this.end = this.end.before;
//		return n.value;
//		
		
//		throw new TODOErr();
	}

	@Override
	public T removeIndex(int index) {
		checkNotEmpty();
		throw new TODOErr();
	}

	
	
	
//	Should work?
	@Override
	public void addFront(T item) {
		if (start == null) {
			start = end = new Node<T>(item);
			}
		else {
			Node<T> second = start;
			start = new Node<T>(item);
			start.after = second;
			second.before = start;
			}
//		throw new TODOErr();
	}

	@Override
	public void addBack(T item) {
		if (end == null) {
			start = end = new Node<T>(item);
		} else {
			Node<T> secondLast = end;
			end = new Node<T>(item);
			end.before = secondLast;
			secondLast.after = end;
		}
	}

	@Override
	public void addIndex(int index, T item) {
		throw new TODOErr();
	}

	@Override
	public T getFront() {
		return getIndex(0);
//		throw new TODOErr();
	}

	@Override
	public T getBack() {
		checkNotEmpty();
		if (this.size() == 1) {
			Node<T> n = this.start;
			return n.value;
		} else {
			T n = this.end.value;
			return n;
		}

//		Node<T> n = this.start;
//		
//		while (this.start.after != null) {
//			n = this.start.after;
//		}
//		return n.value;
		
//		
//		if (this.size() == 1) {
//			Node<T> n = this.start;
//			this.end = this.start = null;
//			return n.value;
//		} else {
//			T n = this.end.value;
//			this.end = this.end.before;
//			this.end.after = null;
//			return n;
//		}
//		Node<T> n = this.start;
//		
//		if (this.end.after == null) {
//			return n.value;
//		}
//		else if (this.start != null) {
//			n = n.after;
//			if (n.after == null) {
//				return n.value;
//			}
//			
//		}
//
//		return n.value;
//			Node<T> secondLast = end;
//			end.before = secondLast;
//			secondLast.after = end;
//		return n.value;
//		return null;
		
		
//		Node<T> gettingBack = (Node<T>) end.value;
		
//		return gettingBack.value;
		
		
		
		
//		throw new TODOErr();
	}
	
	@Override
	public T getIndex(int index) {
		checkNotEmpty();
		int at = 0;
		for (Node<T> n = this.start; n != null; n = n.after) {
		if (at++ == index) {
		return n.value;
		}
		
		}
		throw new BadIndexError(index);
		
//		throw new TODOErr();
	}
	
	public void setIndex(int index, T value) {
		throw new TODOErr();
	}

	@Override
	public int size() {
		int count = 0;
		for (Node<T> n = this.start; n != null; n = n.after) {
		count++;
		}
		return count;
//		throw new TODOErr();
	}

	
	
	
	@Override
	public boolean isEmpty() {
		if (this.start == null) {
			return true;
		}
		else {
			return false;
		}
//		return this.start == null;
//		throw new TODOErr();
	}
	
	/**
	 * The node on any linked list should not be exposed.
	 * Static means we don't need a "this" of DoublyLinkedList to make a node.
	 * @param <T> the type of the values stored.
	 */
	private static class Node<T> {
		/**
		 * What node comes before me?
		 */
		public Node<T> before;
		/**
		 * What node comes after me?
		 */
		public Node<T> after;
		/**
		 * What value is stored in this node?
		 */
		public T value;
		/**
		 * Create a node with no friends.
		 * @param value - the value to put in it.
		 */
		public Node(T value) {
			this.value = value;
			this.before = null;
			this.after = null;
		}
	}
}
