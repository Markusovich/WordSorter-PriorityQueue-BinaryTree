package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Queue<Word> x = new Queue<Word>();
		x.enqueue(new Word("NULL"));
		
		try{
			FileReader fr = new FileReader("file.txt");
			BufferedReader br = new BufferedReader(fr);
			
			Scanner scan = new Scanner(br);
			String[] str = new String[4];
	        while(scan.hasNextLine()){
				String line = scan.nextLine();
		        if((line.length() > 0)){
		        	str = line.split(" ");
		        	int i = 0;
		        	while(i < str.length) {
				        String name = str[i];
				        x.enqueue(new Word(name));
				        i++;
		        	}
		        }
	        }
			br.close();
			scan.close();
		}
		catch(IOException e){
			System.out.println("Not working");
		}
		
		System.out.println("List that prioritizes words that start with a vowel, then other words, then invalid words: \n");
		BinaryTree<Word> tree = new BinaryTree<Word>();
		tree.setTree(x.dequeue());
		while(!x.isEmpty()) {
			Word var = x.dequeue();
			System.out.println(var.getWord());
			tree.add(tree.root, var);
		}
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Next I empty contents in tree, using the length as a placement mechanism: \n");
		
		System.out.println("Tree Root: " + tree.getRootData().getWord());
		System.out.println("Number of nodes: " + tree.getNumberOfNodes());
		System.out.println("Height of tree: " + tree.getHeight());
		
		System.out.print("Inorder traversal: ");
		tree.inorderTraversal();
		System.out.println();
		
	}

}
