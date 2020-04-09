package adts;

import java.util.ArrayList;

import interfaces.ListInterface;
import nodes.DLLNode;

public class ListADT<E extends Comparable<E>> implements ListInterface<E> {
	
	private DLLNode<E> head;
	private DLLNode<E> tail;
	private DLLNode<E> newNode;
	private DLLNode<E> forwardIterator;
	private DLLNode<E> backwardIterator;
	private int size;
	private DLLNode<E> location;
	private boolean found; 
	private boolean added;
	private ArrayList<DLLNode<E>> arr;

	public ListADT() {		
	
	}
//	public ListADT(E element) {
//		this.add(element);
//	}
	
	@Override
	public void add(E element) {
		this.newNode = new DLLNode<E>(element);
//		System.out.println("Hello I am element " + element.toString());
		// Add the element passed as a parameter to the appropriate position in the list so that the list remains sorted.
		// when add is done running the list will remain sorted
		if (this.isEmpty() == false) { // this checks if there are already elements in the list i.e that it is NOT empty
			this.resetIterator();
			while(forwardIterator != null) {
				// If the pointer's element is less than the new element move the pointer forward, else stop
				if( forwardIterator.getInfo().compareTo(element) < 0) this.forwardIterator = this.forwardIterator.getNext();
				else break;		
			}
			if (forwardIterator == null) { // add at the tail
				newNode.setPrev(tail);
				tail.setNext(newNode);
				tail = newNode;
			}
			else if(forwardIterator.getPrev() ==  null) { // add at the head
				forwardIterator.setPrev(newNode);
				newNode.setNext(head);
				head = newNode;
			}
			else { //add in the middle
			// now insert
				forwardIterator.getPrev().setNext(newNode);
				newNode.setNext(forwardIterator);
				newNode.setPrev(forwardIterator.getPrev());
				forwardIterator.setPrev(newNode);
			}
			this.size++;
			this.added = true;
		}
		else {
			this.head = this.newNode;
			this.tail = this.head;
			this.forwardIterator = this.head;
			this.backwardIterator = this.tail;
			this.size = 1;
			this.added = true;
		}
	}

	@Override
	public boolean remove(E element) {
		this.get(element);
		if(!found) return false;
		else {
			if(location == head) { //remove the head
				if(this.size == 1) { //this is if size is 1
					head = null;
					tail = null;
				}
				else { // this is if there is more than 1 element in the list
					head = head.getNext();
					head.setPrev(null);
				}
			}
			else if (location == tail) { //remove the tail
				tail = tail.getPrev();
				tail.setNext(null);
			}
			else { //remove from the middle
				location.getNext().setPrev(location.getPrev());
				location.getPrev().setNext(location.getNext());
			}
			this.size--;
			return true;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean contains(E element) {
//		find(element);
//		if(found) return true;
//		else return false;
		if(this.get(element) != null) return true;
		else return false;
		
	}

	@Override
	public E get(E element) {
		find(element);
		if(found) return element;
		else return null;
	}

	@Override
	public void resetIterator() {
			// set the current position for the getNextItem() iterator to the first item on the list
		this.forwardIterator = this.head;
//		System.out.println("The reset iterator is null?");
//		System.out.println(this.forwardIterator==null);
	}

	@Override
	public E getNextItem() {
		// Preconditions: the list is not empty
		  //                the resetIterator() method has been called
		  //                the list has not been modified since the most recent resetIterator() call
		  //
		  // return the item at the current iterator position on this list
		  // update the current pointer to point to the next item on the list
		  // note: if the item returned is the last item on the list,
		  //       set the value of the current position to the first item on the list
		if (forwardIterator != tail) {
			E temp = forwardIterator.getInfo();
			forwardIterator = forwardIterator.getNext();
			return temp;
		}
		else {
			E temp = forwardIterator.getInfo();
			forwardIterator = head;
			return temp;
		}
	}
	
	public void resetBackIterator() {
		  // set the current position for the getPrevItem() iterator to the last item on the list
		backwardIterator = tail;
	}
	
	public E getPrevItem () {
		if (backwardIterator != head) {
			E temp = backwardIterator.getInfo();
			backwardIterator = backwardIterator.getPrev();
			return temp;
		}
		else {
			E temp = backwardIterator.getInfo();
			backwardIterator = tail;
			return temp;
		}
	}
	
	public String toString() {		
		String r = "";
		this.resetIterator();
		
		while(forwardIterator != null) {
			// System.out.println(r);
			r = r + " " + forwardIterator.getInfo().toString();
			forwardIterator = forwardIterator.getNext();
		}
		return r;
	}
	
	public void find(E element) {
		this.location = head;
		this.found = false;
		// move through the list 1 by 1 to see if the pointer contains the element needed. 
		// when done the pointer will point to that node, or point to null if no element has it
		while(location != null) {
			if (location.getInfo() == element ) {
				found = true;
				break;
			}
			this.location = this.location.getNext();
		}
	}
	
//	public void find2(E element) {
//		if(added) {
//			this.resetIterator();
//			arr.clear();
//			while(forwardIterator != null) {
//				arr.add(forwardIterator);
//				forwardIterator = forwardIterator.getNext();
//			}
//			added = false;
//		}
//
//		
//		int start = 0;
//		int end = size;
//		int middle = size/2;
//		int offset = middle;
//		found = false;
//		while(offset > 0) {
//			if( arr.get(offset).getInfo().compareTo(element) < 0) {
//				start = middle + 1;
//				offset = (end - start)/2;
//				middle = start + offset;
//			}
//			else if (  arr.get(offset).getInfo().compareTo(element) > 0) {
//				end = middle - 1;
//				offset = (end - start)/2;
//				middle = start + offset;
//			}
//			else {
//				location = arr.get(middle);
//				found = true;
//				break;
//			}
//		}
//	}
	
	public void find2(E element, int start, int end) {
		if(added) {
			this.resetIterator();
			this.arr = new ArrayList<DLLNode<E>>();
			while(forwardIterator != null) {
				this.arr.add(forwardIterator);
				this.forwardIterator = this.forwardIterator.getNext();
			}
			added = false;
		}
		
		int middle = (start + end)/2;
		
		if (end - start >= 0) {
			if( this.arr.get(middle).getInfo().compareTo(element) < 0) {
				find2(element, middle + 1, end);
			}
			else if ( this.arr.get(middle).getInfo().compareTo(element) > 0) {
				find2(element, start, middle-1);
			}
			else {
				this.location = arr.get(middle);
				this.found = true;
			}
		}
		else {
			this.found = false;
		}
	}
	
	public boolean found() {
		return this.found;
	}

}
