package source;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	public BinaryNode<T> root;  //creating top node or root of our tree
	
	private void initializeTree() {
		root = null;
	}
	private void initializeTree(Word<T> rootData) {
		root = new BinaryNode<>(rootData);
	}
	private void initializeTree(Word<T> rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);
		if((leftTree != null) && !leftTree.isEmpty()) {
			root.setLeftChild(leftTree.root.copy());  //copies entire left tree
		}
		if((rightTree != null) && !rightTree.isEmpty()) {
			root.setRightChild(rightTree.root.copy());  //copies entire right tree
		}
	}
	public BinaryTree() {
		initializeTree();
	}
	public BinaryTree(Word<T> rootData) {
		initializeTree(rootData);
	}
	public BinaryTree(Word<T> rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	}
	public void setTree(Word<T> rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		initializeTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}
	public void setTree(Word<T> rootData) {
		initializeTree(rootData);
	}
	
	public Word<T> getRootData() {
		if(isEmpty()) {
			return null;
		}
		else {
			return root.getData();
		}
	}
	public int getHeight() {
		return root.getHeight();
	}
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}
	public boolean isEmpty() {
		return root == null;
	}
	public void clear() {
	    root = null;
	}
	public void setRootData(Word<T> rootData) {
		root.setData(rootData);
	}
	public BinaryNode<T> add(BinaryNode<T> node, Word<T> item){  //add item starting at this node
		if(node == null) {
			node = new BinaryNode<T>(item);
		}
		else {
			if(item.wordLength() < node.getData().wordLength()) {
				node.setLeftChild(add(node.getLeftChild(), item));
			}
			else {
				node.setRightChild(add(node.getRightChild(), item));
			}
		}
		return node;
	}
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	private void inorderTraversal(BinaryNode<T> node) {  //start at root
		if(node == null) {
			return;
		}
		inorderTraversal(node.getLeftChild());
		System.out.print(node.getData().getWord() + " ");
		inorderTraversal(node.getRightChild());
		return;
		
	}
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}
	private void preOrderTraversal(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getData().getWord() + " ");
		preOrderTraversal(node.getLeftChild());
		preOrderTraversal(node.getRightChild());
		return;
		
	}
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}
	private void postOrderTraversal(BinaryNode<T> node) {
		if(node == null) {
			return;
		}
		postOrderTraversal(node.getLeftChild());
		postOrderTraversal(node.getRightChild());
		System.out.print(node.getData().getWord() + " ");
		return;
		
	}

}
