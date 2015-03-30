package challenges.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class EvalPrefixExpr {
	 public static void main (String[] args) throws IOException {
	        File file = new File(args[0]);
	        BufferedReader buffer = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = buffer.readLine()) != null) {
	            line = line.trim();
	            if(line.length() > 0){
	            	String[] expression = line.split("\\s");
	            	System.out.println(evalPrefixExpr(expression));
	            }
	        }
	        buffer.close();
	 }
	 
	 private static String evalPrefixExpr(String[] expr){
		 int len = expr.length;
		 LinkedList<Integer> myStack = new LinkedList<Integer>();
		 
		 for(int i=len-1; i>=0; i--){
			 String s = expr[i];
			 if(s.equals("+") || s.equals("*") || s.equals("/")){
				 if(myStack.size() >= 2){
					 int leftOperand = myStack.pop();
					 int rightOperand = myStack.pop();
					 switch(s){
					 case "+":
						 myStack.push(leftOperand + rightOperand);
						 break;
					 case "*":
						 myStack.push(leftOperand * rightOperand);
						 break;
					 case "/":
						 if(rightOperand > 0){
							 myStack.push(leftOperand / rightOperand);
						 }else{
							 myStack.push(0);
						 }
						 break;
					 }
				 }else{
					 return "-1";
				 }
			 }else{
				 try{
					 int number = Integer.parseInt(s);
					 myStack.push(number);
				 }catch(NumberFormatException e){
					 return "-1";
				 }
			 }
		 }
		 
		 return myStack.pop().toString();
	 }
}
