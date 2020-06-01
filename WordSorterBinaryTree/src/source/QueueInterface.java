package source;

public interface QueueInterface<T> {
	
	public boolean enqueue(Word<T> newEntry);
	
	public Word<T> getFront();
	
	public Word<T> dequeue();
	
	public boolean isEmpty();
	
	public void clear();

}
