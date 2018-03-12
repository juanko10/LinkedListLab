package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		// TODO Auto-generated method stub
		if(length == 0)
			last = (SNode<E>) nuevo;
		else
			((SNode<E>) nuevo).setNext(first);
		first = (SNode<E>) nuevo;
		length++;
		
	}
	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		if(target == last)
			last = (SNode<E>) nuevo;
		else
			((SNode<E>) nuevo).setNext(((SNode<E>) target).getNext());
		((SNode<E>) target).setNext( (SNode<E>) nuevo);
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if(target == first)
			this.addFirstNode(nuevo);
		else {
			SNode<E> prev = (SNode<E>) this.getNodeBefore(target);
			this.addNodeAfter(prev, nuevo);
		}
	}

	public Node<E> getFirstNode()  {
		if (length == 0)
			throw new NoSuchElementException("get: index=1 is out of bounds. length = 0");
		return first;
	}

	public Node<E> getLastNode() {
		if (length == 0)
			throw new NoSuchElementException("get: index out of bounds. length = 0");
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target){
		if(target == last)
			throw new NoSuchElementException("get: target is the last node");
		return ((SNode<E>) target).getNext();
	}

	public Node<E> getNodeBefore(Node<E> target){
		if(target == first)
			throw new NoSuchElementException("get: target is the first node");
		SNode<E> prev = first;
		while(prev.getNext() != target && prev != null) {
			prev = prev.getNext();
		}
		return prev;
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		SNode<E> ntr = (SNode<E>) target;
		if(ntr == first)
			first = ntr.getNext();
		else if(ntr == last)
			last = (SNode<E>) getNodeBefore(ntr);
		else {
			SNode<E> prev = (SNode<E>) getNodeBefore(ntr);
			prev.setNext(ntr.getNext());
		}
		ntr.setNext(null);
		length--;
	}

	public Node<E> createNewNode() {
		return new SNode<E>();
	}

	// The following two methods are to be implemented as part of an exercise
	public Object[] toArray() {
		// TODO es in Exercise 3
		Object[] array = new Object[this.length()];
		SNode<E> tempFirst = first;
		for (int i = 0 ; i < length; i++) {
			array[i] = tempFirst;
			tempFirst = tempFirst.getNext() ;
		}
		return array;
	}


	public <T1> T1[] toArray(T1[] array) {
		// TODO as in Exercise 3
		if (array.length < this.length()) {
			// if arr.length < this.size, allocate a new array of the same
			// type as arr (components of the new array are set to be of equal
			// runtime type as components of the original array arr)
			// and big enough to hold all the elements in this set. For
			// this, we need to use the Array class....
			array = (T1[]) Array.newInstance(array.getClass().getComponentType(), this.length());
		} else if (array.length > this.length())
			// Set to null all those positions of arr that won't be used.
			for (int j=this.length(); j< array.length; j++)
				array[j] = null;
		SNode<E> tempFirst = first ;
		for (int i = 0; i < array.length; i ++) {
			if (i==array.length)
				break;
			array[i] = (T1) tempFirst.getNext();   // It is assumed E can be casted to T
			tempFirst = tempFirst.getNext() ;
		}
		return array;
	}
}
