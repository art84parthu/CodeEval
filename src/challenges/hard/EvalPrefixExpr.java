package challenges.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

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
	 
	 private static int evalPrefixExpr(String[] expr){
		 int len = expr.length;
		 Stack<String> myStack = new Stack<String>();
		 
		 for(int i=len-1; i>=0; i--){
			 String s = expr[i].trim();
			 
			 if(s.equals("*") || s.equals("/") || s.equals("+")){
				 double result = 0;
				 if(myStack.size() >= 2){
					 double leftOperand = Double.valueOf(myStack.pop());
					 double rightOperand = Double.valueOf(myStack.pop());
					 switch(s){
					 case "+":
						 	result = leftOperand + rightOperand;
						 	break;
					 case "*":
						 	result = leftOperand * rightOperand;
						 	break;
					 case "/":
						 	if(rightOperand > 0){
						 		result = leftOperand / rightOperand;
						 	}
						 	break;
					 }
					 myStack.push(String.valueOf(result));
				 }
			 }else{
				 myStack.push(s);
			 }
		 }
		 return Double.valueOf(myStack.pop()).intValue();
	 }
}
