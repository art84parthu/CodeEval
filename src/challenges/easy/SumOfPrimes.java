package challenges.easy;


public class SumOfPrimes {
	 public static void main (String[] args) {
	       System.out.println(sumOf1000Primes());	
	 }
	 
	 public static int sumOf1000Primes(){
		 int sum = 0;
		 int count = 0;

		 int i=2;
		 while(count < 1000){
			 if(checkIfPrime(i)){
				 sum += i;
				 count++;
			 }
			i++; 
		 }
		 
		 return sum;
	 }
	 
	 private static boolean checkIfPrime(int number){
		 if(number <= 1) return false;
		 for(int i=2; i*i <= number; i++){
			 if(number % i == 0){
				 return false;
			 }
		 }
		 
		 return true;
	 }
}
