package challenges.medium;

import java.nio.ByteOrder;

public class CheckEndianness{
	public static void main(String[] args){
		if(ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN){
			System.out.println("BigEndian");
		}else if(ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN){
			System.out.println("LittleEndian");
		}else{
		  //This will never happen actually.
			System.out.println("Unknown");
		}
	}
}
