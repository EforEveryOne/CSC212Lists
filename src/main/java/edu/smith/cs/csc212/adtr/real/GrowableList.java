package edu.smith.cs.csc212.adtr.real;

import edu.smith.cs.csc212.adtr.ListADT;
import edu.smith.cs.csc212.adtr.errors.TODOErr;

public class GrowableList<T> extends ListADT<T> {
	public static final int START_SIZE = 10;
	private Object[] array;
	private int fill;
	
	public GrowableList() {
		this.array = new Object[START_SIZE];
		this.fill = 0;
	}

	@Override
	public T removeFront() {
		this.checkNotEmpty();
//		we call remove index here, which is all we need, but we need the method removeIndex(arg) to work!
		return removeIndex(0);
	}

	@Override
	public T removeBack() {
		this.checkNotEmpty();
		return removeIndex(fill-1);
	}

//	We have our method defined here, now we need to make it work!
	@Override
	public T removeIndex(int index) {
//		Check if not empty, so we don't crash.
		checkNotEmpty();
		checkExclusiveIndex(index);

		T removed = this.getIndex(index);
		// TODO: Now we need to slide everything to the left.
		fill--;
		for (int i=index; i<fill; i++) {
			this.array[i] = this.array[i+1];
		}
		this.array[fill] = null;
//		throw new TODOErr();
		// When we're done, give back the thing that we removed.
		return removed;
	}

	@Override
	public void addFront(T item) {
		addIndex(0, item);
	}

	@Override
	public void addBack(T item) {
		if (fill >= array.length) {
			this.resizeArray();
		}
		array[fill++] = item;
	}
	
	/**
	 * This private method is called when we need to make room in our GrowableList.
	 */
	private void resizeArray() {
//		throw new TODOErr();
		int newSize = fill * 2;
		Object[] newArray = new Object[newSize];
//		This is O(n), but we don't do it all the time. Only when we need to grow our list.
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		this.array = newArray;
		
		
		
		
	}

	@Override
	public void addIndex(int index, T item) {
		this.checkInclusiveIndex(index);
		if (fill >= array.length) {
			resizeArray();
		}
		// loop backwards, shifting items to the right.
		for (int j=fill; j>index; j--) {
			array[j] = array[j-1];
		}
		// put this item in the middle
		array[index] = item;
		fill++;
	}
	
	@Override
	public T getFront() {
		checkNotEmpty();
		return this.getIndex(0);
	}

	@Override
	public T getBack() {
		checkNotEmpty();
		return this.getIndex(this.fill-1);
	}

	/**
	 * Do not allow unchecked warnings in any other method.
	 * Keep the "guessing" the objects are actually a T here.
	 * Do that by calling this method instead of using the array directly.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getIndex(int index) {
		checkNotEmpty();
		checkExclusiveIndex(index);
		return (T) this.array[index];
	}

	@Override
	public int size() {
		return this.fill;
	}

	@Override
	public boolean isEmpty() {
		return this.fill == 0;
	}

	@Override
	public void setIndex(int index, T value) {
//		value = (T) this.array[index];
//		throw new TODOErr();
		checkNotEmpty();
		this.checkExclusiveIndex(index);
		this.array[index] = value;
	}

}
