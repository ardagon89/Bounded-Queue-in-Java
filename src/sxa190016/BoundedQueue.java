package sxa190016;

public class BoundedQueue<T> {
	
	private T[] arr;
	private int front;
	private int end;
	private int size;
	
	public BoundedQueue(int size) {
		this.arr = (T[]) new Object[size];
		this.front = 0;
		this.end = 0;
		this.size = 0;
		
	}
	
	public boolean offer(T x) {
		if (this.size == this.arr.length) {
			return false;
		}
		this.arr[this.end] = x;
		this.end = (this.end+1)%this.arr.length;
		this.size++;
		return true;
	}
	
	public T poll() {
		T item = this.peek();
		if (item != null) {
			this.size--;
			this.front = (this.front+1)%this.arr.length;
		}
		return item;
	}
	
	public T peek() {
		if (this.size == 0) {
			return null;
		}
		T item = this.arr[this.front];
		return item;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void clear() {
		this.front = 0;
		this.end = 0;
		this.size = 0;
	}
	
	public void toArray(T[] a) {
		int start = this.front;
		for(int i=0; i<this.size; i++) {
			a[i] = this.arr[start];
			start = (start+1)%this.arr.length;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoundedQueue<Integer> bq = new BoundedQueue<Integer>(5);
		Integer[] result = new Integer[5];
		System.out.println(bq.offer(1));
		System.out.println(bq.offer(2));
		System.out.println(bq.offer(3));
		System.out.println(bq.size());
		System.out.println(bq.isEmpty());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.isEmpty());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.poll());
		System.out.println(bq.isEmpty());
		System.out.println(bq.offer(4));
		System.out.println(bq.offer(5));
		System.out.println(bq.offer(6));
		System.out.println(bq.offer(7));
		System.out.println(bq.size());
		System.out.println(bq.offer(8));
		System.out.println(bq.size());
		System.out.println(bq.offer(9));
		System.out.println(bq.offer(0));
		bq.clear();
		System.out.println(bq.size());
		
		bq.toArray(result);
		for(Integer a : result) {
			System.out.println(a);
		}
	}

}
