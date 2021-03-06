package poc.gane.datastructures;

class LinkedList<T> {
	protected Node<T> firstNode;
	protected Node<T> lastNode;
	protected int size;

	public LinkedList() {
		firstNode = null;
		lastNode = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void addatStart(T item) {
		Node<T> newNode = new Node<T>();
		newNode.setItem(item);
		newNode.setLink(firstNode);
		if(firstNode == null) {
			lastNode = newNode;
		}
		firstNode = newNode;
		this.size++;
	}

	public void addatEnd(T item) throws Exception{
		Node<T> newNode = new Node<T>(item, null);
		if(lastNode == null) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			System.out.println("last: " + lastNode);
			addatPosition(item, size + 1);
		}
		this.size++;
	}

	public void addatPosition(T item, int position) throws Exception {
		int index = 1;
		Node<T> thisNode = firstNode;
		if(index > (size + 1)) {
			throw new Exception("Out of Size limit Exception");
		}
		while(index <= size) {
			if(index == position - 1) {
				Node<T> newNode = new Node<T>(item, thisNode.getLink());
				thisNode.setLink(newNode);
				size++;
			}
			thisNode = thisNode.getLink();
			index++;
		}
	}

	public void removeAt(int position) throws Exception {
		int index = 1;
		Node<T> thisNode = firstNode;
		if(index > size) {
			throw new Exception("Out of Size limit Exception");
		}
		while(index <= size) {
			if(index == position - 1) {
				thisNode.setLink(thisNode.getLink().getLink());
				size--;
			}
			thisNode = thisNode.getLink();
			index++;
		}
	}

	public void removeLast() {
		int index = 1;
		Node<T> thisNode = firstNode;
		if(size > 0) {
			while(index < (size - 1)) {
				thisNode = thisNode.getLink();
				index++;
			}
		}
		thisNode.setLink(null);
		size--;
	}

	public void removeFirst() {
		if(firstNode != null) {
			firstNode = firstNode.getLink();
			size--;
		}
		if(firstNode == null) {
			lastNode = null;
		}
	}
	
	public T getFirst() {
		return firstNode.getItem();
	}
	
	public T getLast() {
		return lastNode.getItem();
	}
	
	public T getAt(int position) {
		T item = null;
		Node<T> thisNode = firstNode;
		int index = 1;
		while(index <= size) {
			if(index == position) {
				item = thisNode.getItem();
				break;
			}
			thisNode = thisNode.getLink();
			index++;
		}
		return item;
	}

	public String toString() {
		String allItems = "";
		if(size < 1) {
			allItems = "[]";
		} else {
			Node<T> thisNode = firstNode;
			allItems = "[";
			while (thisNode != null) {
				allItems += thisNode.getItem().toString() + ", ";
				thisNode = thisNode.getLink();
			}
			allItems = allItems.substring(0, allItems.length() - 2) + "]";
		}
		return allItems;
	}
}


class Node<T> {
	public T item;
	public Node<T> link;

	public Node() {
		item = null;
		link = null;
	}
	public Node(T item, Node<T> link) {
		this.item = item;
		this.link = link;
	}
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	public Node<T> getLink() {
		return link;
	}
	public void setLink(Node<T> nextNode) {
		this.link = nextNode;
	}
	public String toString() {
		return "(" + this.item + ")";
	}
}

public class LinkedListTest {
	public static void main(String[] args) throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addatStart(12);
		list.addatEnd(1);
		list.addatEnd(2);
		list.addatStart(3);
		list.addatStart(4);
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.addatPosition(0, 3);
		list.addatPosition(9, 3);
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.removeAt(2);
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.removeFirst();
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.addatStart(8);
		list.addatEnd(7);
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.removeFirst();
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.removeLast();
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.addatEnd(5);
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.removeLast();
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		System.out.println(list.getAt(4));
		list.addatEnd(6);
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.addatEnd(7);
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
		list.addatEnd(8);
		System.out.println(list.size() + " : " + list + " First : " + list.getFirst() + " Last : " + list.getLast());
	}
}