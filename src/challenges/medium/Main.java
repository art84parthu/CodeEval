package challenges.medium;

import java.io.*;

public class Main{
	
	public static void main(String[] args) {

	    try {
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.split("\\s");
	            boolean badInput = false;
	            if (lineArray.length > 0) {
	               SinglyLinkedList list = new SinglyLinkedList();
	               int m = -1;
	               for(int i=0; i<lineArray.length; i++){
	            	   String s = lineArray[i];
	            	   if(s.length() > 1){
	            		   System.out.println("Input does not match the specifications. skipping.");
	            		   badInput = true;
	            		   continue;
	            	   }
	            	   try{
	            		   m = Integer.parseInt(s);
	            		   if(i < (lineArray.length-1)){
	            			   System.out.println("Input does not match the specifications. skipping.");
		            		   badInput = true;
		            		   continue;
	            		   }
	            		   break;
	            	   }catch(NumberFormatException e){
	            		   list.insertElement(i, s.charAt(0));
	            	   }
	               }
	               if(!badInput){
	            	   char c = SinglyLinkedList.mthFromLast(m, list.getHead());
	            	   if(c == '0'){
	            		   System.out.println("m greater than number of elements. So skipping.");
	            	   }else{
	            		   System.out.println(c);
	            	   }
	               }
	            } 
	        }
	        in.close();
	    } catch (IOException e) {
	        System.out.println("File Read Error: " + e.getMessage());
	    }               
	}
}
	class Node {
		private char value;
		private Node next;
		
		Node(char value, Node node){
			this.value = value;
			this.next = node;
		}
		
		public char getValue(){
			return value;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node elem){
			this.next = elem;
		}
		
		public void setValue(char value){
			this.value = value;
		}
		
	}
	class SinglyLinkedList {

		private Node head;
		
		public SinglyLinkedList(){
			head = null;
		}
		
		public boolean insertElement(int position, char value){
			
			int pos = 0;
			Node cur = head;
			Node prev = null;
			Node elem = new Node(value, cur);
			while(cur != null){
				if(pos == position){
					elem = new Node(value, cur);
					if(prev != null){
						prev.setNext(elem);
					}
					if(pos == 0){
						head = elem;
					}
					return true;
				}
				pos++;
				prev = cur;
				cur = cur.getNext();
				
			}
			
			if(position == 0 && pos == position){
				elem = new Node(value, cur);
				if(head == null){
					head = elem;
				}
				return true;
			}
			if(pos == position && prev.getNext() == null){
				elem = new Node(value, cur);
				prev.setNext(elem);
				return true;
			}
			return false;
		}
		
		/*
		 * mth from last in a singly linked list
		 */
		public static char mthFromLast(int m, Node head){
			if(head == null) return '0';
			
			Node mthNode = head;
			int cnt = 1;
			while(mthNode.getNext() != null){
				if(cnt == m){
					break;
				}
				cnt++;
				mthNode = mthNode.getNext();
			}
			if(cnt < m){
				return '0';
			}
			
			Node first = head;
			while(mthNode.getNext() != null){
				first = first.getNext();
				mthNode = mthNode.getNext();
			}
			
			return first.getValue();
		}
		
		public Node getHead(){
			return this.head;
		}
	}
	
	class ListUtil {
		public static void printList(Node head){
			System.out.print("\n{");
			while(head.getNext() != null){
				System.out.print(head.getValue() + ",");
				head = head.getNext();
			}
			System.out.print(head.getValue() + "}");
		}	
	}
