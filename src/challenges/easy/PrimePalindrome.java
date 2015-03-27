package challenges.easy;

public class PrimePalindrome {
	public static void main(String[] args){
		for(int i=999; i>0; i--){
			if(checkIfPrime(i) && checkIfPalindrome(i)){
				System.out.println(i);
				break;
			}
		}
	}
	
	private static boolean checkIfPrime(int number){
		if(number <= 1) return false;
		for(int i=2; i*i <= number; i++){
			if(number % i == 0) return false;
		}
		
		return true;
	}
	
	private static boolean checkIfPalindrome(int num){
		int div = 1;
		
		while(num / div > 10){
			div = div * 10;
		}
		
		while(num != 0){
			int q = num / div;
			int r = num % 10;
			
			if(q == r){
				num = (num % div) / 10;
				div = div / 100;
			}else{
				return false;
			}
		}
		return true;
	}
}
