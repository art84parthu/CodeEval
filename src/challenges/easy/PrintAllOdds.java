package challenges.easy;

public class PrintAllOdds {
	public static void main(String[] args){
		printModulo();
	}
	
	/*
	 * This got maximum score - 29.975
	 */
	public static void printBitWise(){
		for(int i=1; i<=99; i++){
			if((i & 1) == 1){
				System.out.println(i);
			}
		}
	}
	
	/*
	 * This one got 29.091
	 */
	public static void printIncrement(){
		for(int i=1; i<=99; i=i+2){
				System.out.println(i);
		}
	}
	
	/*
	 * This one got just 21.something
	 */
	public static void printModulo(){
		for(int i=1; i<=99; i++){
			if((i % 2) > 0){
				System.out.println(i);
			}
		}
	}
}
