package source;

public class Queue<T> implements QueueInterface<T> {
	
	private class Node<T>{
		private Word<T> data;
		private Node<T> next;
		
		private Node(Node<T> prev, Word<T> data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		private Node(Word<T> data) {
			this.data = data;
		}
		private Word<T> getNodeData() {
			return data;
		}
		private void setNodeData(Word<T> newEntry) {
			data = newEntry;
		}
		private Node<T> getNextNode() {
			return next;
		}
		private void setNextNode(Node<T> newNode) {
			next = newNode;
		}
	
	}
	
	private Node<T> firstNode;
	private Node<T> currentNode;
	
	public Queue() {
		firstNode = null;
		currentNode = null;
	}

	public boolean enqueue(Word<T> newEntry) {
		
		Node<T> newNode = new Node<T>(newEntry);
		
		if(firstNode == null) {
			firstNode = newNode;
			return true;
		}
		else {
			if(newEntry.startsWithVowel()) {
				currentNode = firstNode;
				while(currentNode.getNextNode() != null) {
					if(!currentNode.getNextNode().getNodeData().startsWithVowel()) {
						break;
					}
					currentNode = currentNode.getNextNode();
				}
				Node<T> currentNext = currentNode.getNextNode();
				currentNode.setNextNode(newNode);
				newNode.setNextNode(currentNext);
				return true;
			}
			if(newEntry.startsWithNonVowel()) {
				currentNode = firstNode;
				while(currentNode.getNextNode() != null) {
					if(!currentNode.getNextNode().getNodeData().startsWithNonVowel() && 
							!currentNode.getNextNode().getNodeData().startsWithNonVowel()) {
						break;
					}
					currentNode = currentNode.getNextNode();
				}
				
				Node<T> currentNext = currentNode.getNextNode();
				currentNode.setNextNode(newNode);
				newNode.setNextNode(currentNext);
				return true;
			}
			if(newEntry.notWord()) {
				currentNode = firstNode;
				while(currentNode.getNextNode() != null) {
					currentNode = currentNode.getNextNode();
				}
				Node<T> currentNext = currentNode.getNextNode();
				currentNode.setNextNode(newNode);
				newNode.setNextNode(currentNext);
				return true;
			}
			else {
				return false;
			}
		}
	}
	public Word<T> getFront() {
		if(isEmpty()) {
			return null;
		}
		return firstNode.getNodeData();
	}
	public Word<T> dequeue() {
		Word<T> front = getFront();
		firstNode.setNodeData(null);
		firstNode = firstNode.getNextNode();
		return front;
	}
	public boolean isEmpty() {
		return firstNode == null;
	}
	public void clear() {
		firstNode = null;
	}
}
