package source;

public class BinaryNode<T> {
	
	private Word<T> data;  //portion of node that contains data
	private BinaryNode<T> leftChild;  //portion of node that contains reference to the left child
	private BinaryNode<T> rightChild;  //portion of node that contains reference to the right child
	
	public BinaryNode() {  //constructors
		this(null);
	}
	public BinaryNode(Word<T> dataPortion) {
		this(dataPortion, null, null);
	}
	public BinaryNode(Word<T> dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild) {
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	public Word<T> getData() {  //gets data of node in question
		return data;
	}
	public void setData(Word<T> newData) {  //sets data in node to something else
		data = newData;
	}
	public BinaryNode<T> getLeftChild(){  //gets reference to left child of node, another node
		return leftChild;
	}
	public void setLeftChild(BinaryNode<T> newLeftChild) {  //sets left child
		leftChild = newLeftChild;
	}
	public boolean hasLeftChild() {  //boolean on if left child exists
		if(leftChild == null) {
			return false;
	}
		else {
			return true;
		}
	}
	public BinaryNode<T> getRightChild(){
		return rightChild;
	}
	public void setRightChild(BinaryNode<T> newRightChild) {
		rightChild = newRightChild;
	}
	public boolean hasRightChild() {
		if(rightChild == null) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean isLeaf() {
		if(leftChild == null && rightChild == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getNumberOfNodes() {  //recursive method to get number of nodes under a certain node
		int leftNumber = 0;
		int rightNumber = 0;
		if(leftChild != null) {
			leftNumber = leftChild.getNumberOfNodes();
		}
		if(rightChild != null) {
			rightNumber = rightChild.getNumberOfNodes();
		}
		return 1 + leftNumber + rightNumber;
	}
	public int getHeight() {
		return getHeight(this);  //getHeight that does not need argument
	}
	private int getHeight(BinaryNode<T> node) {  //recursive method to get height of tree at certain node
		int height = 0;
		if(node != null) {
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		}
		return height;
	}
	public BinaryNode<T> copy(){
		BinaryNode<T> newRoot = new BinaryNode<T>(data);  //returns entire tree by calling its root
		if(leftChild != null) {
			newRoot.setLeftChild(leftChild.copy());
		}
		if(rightChild != null) {
			newRoot.setRightChild(rightChild.copy());
		}
		return newRoot;
	}
	
}
