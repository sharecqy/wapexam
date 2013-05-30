package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of objects * 
 * @param <E>
 */
public class PersistentQueue<E> {
	private List<E> queue;

	/**
	 * require default constructor.
	 */
	public PersistentQueue() {
		// modify this constructor if necessary,but do not remove default constructor
		queue = new ArrayList<E>();
	}

	private PersistentQueue(List<E> queue) {
		// modify or remove this constructor if necessary
		this.queue = queue;
	}

	// add other constructor if necessary

	/**
	 * Returns the queue that adds an item into the tail of this queue without
	 * modifying this queue
	 * 
	 * <pre>
	 * e.g
	 * 	When this queue represents the queue (2,1,2,2,6) and we enqueue the value 4 into this queue.
	 *  this method returns a new queue (2,1,2,2,6,4)
	 *  and this object still represents the queue (2,1,2,2,6).
	 * </pre>
	 * 
	 * if the element e is null,throws IllegalArgumentException.
	 * 
	 * @param e
	 * @return
	 * @throws IllegalArgumentException
	 */
	public PersistentQueue<E> enqueue(E e) {
		// TODO:make this method faster
		if (e == null) {
			throw new IllegalArgumentException();
		}
		List<E> clone = new ArrayList<E>(queue);
		clone.add(e);
		return new PersistentQueue<E>(clone);
	}

	/**
	 * Returns the queue that removes the object at the head of this queue
	 * without modifying this queue.
	 * 
	 * <pre>
	 * e.g
	 * 	When this queue represents the queue(7,1,3,3,5,1),
	 * 	this method returns a new queue (1,3,3,5,1)
	 *  and this object still represents the queue (7,1,3,3,5,1).
	 * </pre>
	 * 
	 * if this queue is empty,throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public PersistentQueue<E> dequeue() {
		// TODO:make this method faster
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		List<E> clone = new ArrayList<E>(queue);
		clone.remove(0);
		return new PersistentQueue<E>(clone);
	}

	/**
	 * Looks at the object which is the head of this queue without removing it
	 * from the queue.
	 * 
	 * <pre>
	 * e.g
	 *  When this queue represents the queue(7,1,3,3,5,1),
	 *  this method returns 7 and this object still represents the queue (7,1,3,3,5,1)
	 * </pre>
	 * 
	 * if the queue is empty,throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException.
	 */
	public E peek() {
		// modify this method if needed
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.get(0);
	}

	/**
	 * Returns the number of objects in this queue.	 * 
	 * @return
	 */
	public int size() {
		// modify this method if necessary.
		return queue.size();
	}

}
