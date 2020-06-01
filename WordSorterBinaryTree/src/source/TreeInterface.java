package source;

public interface TreeInterface<T> {
	
	//These are fundamental operations that are common to all trees.

	public Word<T> getRootData();  //Gets data of root
	//returns data from that node
	public int getHeight();  //Gets height of tree.
	//ex: tree with only one root has a height of 1
	public int getNumberOfNodes();  //Gets total number of nodes in tree
	//counts number of nodes in tree
	public boolean isEmpty();
	//boolean on empty or not
	public void clear();
	//wipes tree

}
