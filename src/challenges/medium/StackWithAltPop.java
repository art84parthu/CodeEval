package challenges.medium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class StackWithAltPop {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			String[] lineArray = line.split("\\s");
            if (lineArray.length > 0) {
            	boolean inputError = false;
            	MyStack stack = new MyStack();
            	for(int i=0; i<lineArray.length; i++){
            		try{
            			int n = Integer.parseInt(lineArray[i]);
            			stack.push(n);
            		}catch(NumberFormatException nbe){
            			inputError = true;
            			break;
            		}
            	}
            	if(!inputError){
            		boolean alt = false;
            		for(int i=0; i<lineArray.length-1; i++){
            			if(!alt){
            				System.out.print(stack.pop() + " ");
            				alt = true;
            			}else{
            				stack.pop();
            				alt = false;
            			}
            		}
            		if(!alt){
            			System.out.print(stack.pop() + "\n");
            		}else{
            			stack.pop();
            			System.out.println();
            		}
            	}
            } 
		}
		buffer.close();
	}

}

class MyStack{
private Node head; 
	
	public MyStack(){
		head = null;
	}
	
	public void push(int i){
		Node newHead = new Node(i, head);
		head = newHead;
	}
	
	public int pop(){
		Node next = head.next;
		int i = head.value;
		head.next = null;
		head = next;
		
		return i;
		
	}
	
	class Node{
		int value;
		Node next;
		
		public Node(int i, Node n){
			this.value = i;
			this.next = n;
		}
	}
}
