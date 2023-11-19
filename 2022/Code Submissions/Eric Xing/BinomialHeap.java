import java.util.NoSuchElementException;

public class BinomialHeap<Key extends Comparable<Key>> {
	private Node<Key> head;
	private int size;

	// representation of a node in the heap
	// use of this class assumes no protection of
	// of the attributes in Node class
	static class Node<Key extends Comparable<Key>> {
		Key key;
		int order;
		Node<Key> child;
		Node<Key> sibling;
		Node<Key> parent;

		public Node(Key key) {
			this.key = key;
			this.order = 0;
			this.child = null;
			this.sibling = null;
			this.parent = null;
		}

		private Node<Key> findKey(Key tar) {
			Node<Key> cur = this, ret = null;
			
			while (cur != null) {
				if (cur.key.equals(tar)) {
					ret = cur;
					break;
				}

				if (cur.child == null) {
					cur = cur.sibling;

				} else {
					ret = cur.child.findKey(tar);
					if (ret == null) {
						cur = cur.sibling;
					} else {
						break;
					}
				}
			}

			return ret;
		}

		public Node<Key> reverse(Node<Key> other) {
			Node<Key> ret;
			if (sibling != null) {
				ret = this.sibling.reverse(this);
			} else {
				ret = this;
			}
			this.sibling = other;
			return ret;
		}

	}

	public BinomialHeap() {
		this.head = null;
		this.size = 0;
	}
	
	public Node<Key> find(Key key) {
		return head.findKey(key);
	}

	/**
	 * Whether the priority queue is empty
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Number of elements currently in the heap
	 */
	public int size() {
		return size;
	}

	/**
	 * Puts a Key in the heap
	 * 
	 * @return return the node where the key is located in the heap.
	 */
	public Node<Key> insert(Key key) {
		Node<Key> temp = new Node<Key>(key);
		if (head == null) {
			head = temp;
		} else {
			union(temp);
		}
		size++;
		return head.findKey(key);
	}

	/**
	 * Get the minimum key currently in the queue
	 * 
	 * @throws java.util.NoSuchElementException if the priority queue is empty
	 * @return the minimum key
	 */
	public Key minKey() {

		if (head == null) {
			throw new NoSuchElementException();
		}

		return this.min().key;
	}

	public Node<Key> min() {
		Node<Key> cur = head, prev = head;
		Key min = cur.key;

		while (cur != null) {
			if (cur.key.compareTo(min) < 0) {
				prev = cur;
				min = cur.key;
			}
			cur = cur.sibling;
		}

		return prev;
	}

	/**
	 * Extract the minimum key value from the queue.
	 * 
	 * @throws java.util.NoSuchElementException if the priority queue is empty
	 * @return the minimum key
	 */
	public Key extractMin() {

		if (head == null) {
			throw new NoSuchElementException();
		}

		Node<Key> cur = head, prev = null;
		Node<Key> min = this.min();

		while (cur.key != min.key) {
			prev = cur;
			cur = cur.sibling;
		}

		if (prev == null) {
			head = cur.sibling;
		} else {
			prev.sibling = cur.sibling;
		}

		cur = cur.child;
		Node<Key> temp = cur;

		while (cur != null) {
			cur.parent = null;
			cur = cur.sibling;
		}

		if (head == null && temp == null) {
			size = 0;
		} else {
			if (head == null && temp != null) {
				head = temp.reverse(null);
			} else {
				if (!(head != null && temp == null)) {
					union(temp.reverse(null));
				}
			}
		}
      this.size--;
		return min.key;
	}

	/**
	 * Decreases the key value of the node in the heap. If the nKey is large, no
	 * actions will be taken.
	 * 
	 * @return the node that holds the nKey.
	 * 
	 */
	public Node<Key> decreaseKey(Node<Key> orig, Key key) {
		orig.key = key;
		Node<Key> parent = orig.parent;

		while (parent != null && orig.key.compareTo(parent.key) < 0) {
			Key oKey = orig.key;
			orig.key = parent.key;
			parent.key = oKey;

			orig = parent;
			parent = parent.parent;
		}
		return orig;
	}

	private void union(Node<Key> binHeap) {

		Node<Key> cur = head, otherCur = binHeap;

		while (cur != null && otherCur != null) {

			if (cur.order == otherCur.order) {

				Node<Key> temp = otherCur;
				otherCur = otherCur.sibling;
				temp.sibling = cur.sibling;
				cur.sibling = temp;
				cur = temp.sibling;
			} else {

				if (cur.order < otherCur.order) {

					if (cur.sibling == null || cur.sibling.order > otherCur.order) {
						Node<Key> tmp = otherCur;
						otherCur = otherCur.sibling;
						tmp.sibling = cur.sibling;
						cur.sibling = tmp;
						cur = tmp.sibling;
					} else {
						cur = cur.sibling;
					}
				} else {
					Node<Key> temp = cur;
					cur = otherCur;
					otherCur = otherCur.sibling;
					cur.sibling = temp;

					if (temp == head) {
						head = cur;
					}
				}
			}
		}

		if (cur == null) {
			cur = head;

			while (cur.sibling != null) {
				cur = cur.sibling;
			}
			cur.sibling = otherCur;
		}

		Node<Key> prevTemp = null, temp = head, nextTemp = head.sibling;

		while (nextTemp != null) {

			if (temp.order != nextTemp.order
					|| (nextTemp.sibling != null && nextTemp.sibling.order == temp.order)) {
				prevTemp = temp;
				temp = nextTemp;
			} else {

				if (temp.key.compareTo(nextTemp.key) <= 0) {
					temp.sibling = nextTemp.sibling;
					nextTemp.parent = temp;
					nextTemp.sibling = temp.child;
					temp.child = nextTemp;
					temp.order++;

				} else {

					if (prevTemp == null) {
						head = nextTemp;
					} else {
						prevTemp.sibling = nextTemp;
					}

					temp.parent = nextTemp;
					temp.sibling = nextTemp.child;
					nextTemp.child = temp;
					nextTemp.order++;
					temp = nextTemp;
				}
			}
			nextTemp = temp.sibling;
		}
	}

}
