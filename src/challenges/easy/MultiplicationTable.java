package challenges.easy;

public class MultiplicationTable {
	public static void main(String[] args){
		int n = 12;
		int i=1, j=1;
		for(; i <= n; i++){
			j = 1;
			
			if( i >= 10 &&  j == 1){
				System.out.print(i*j++);
			}else{
				System.out.print(" " + i*j++);
			}
			for(; j<=n; j++){
				int m = i*j;
				String spaces = m >= 100 ? " " : m >= 10 ? "  " : "   ";
				System.out.print(spaces + m);
			}
			System.out.println();
		}
	}
}
