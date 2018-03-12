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


}
