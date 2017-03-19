package poc.gane.datastructures;

class Queue<T> {
	LinkedList<T> list;

	Queue() {
		list = new LinkedList<T>();
	}

	public void push(T item) {
		list.addatEnd(item);
	}

	public T pop() {
		T item = list.getFirst();
		list.removeFirst();
		return item;
	}

	public String toString() {
		return this.list.toString();
	}
}

public class QueuesTest {
	public static void main(String[] args) {
		Queue<Integer> que = new Queue<Integer>();
		que.push(3);
		que.push(1);
		que.push(6);
		que.push(7);
		que.push(2);
		que.push(5);
		System.out.println(que);
	}
}
