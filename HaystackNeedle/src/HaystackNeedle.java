import java.util.Arrays;

public class HaystackNeedle {

	private static Byte[] haystackBytes;
	private static Byte[] needleBytes;
	private static Byte[] needleThreshold;
	private static Byte[] haystackThreshold;
	private static String foundAt ="Nothing found";
	static boolean found=false;


	public static void main(String[] args) {
		
		byte[] haystack = {'v','n','k','2','4','3','5','k','v','a','b','c','o','8','a','w','k','h','1','2','5','k','j','n','e','y','t','b','c','d','1','2','q','j','h','b','4','a','c','d','1','2','3','x','m','n','b','q','w','n','w','4','t'};
		byte[] needle = {'a','b','c','d','1','2','3','4'};
	    int threshold = 3;

	   search(haystack,needle,threshold);
		
	}
	
	
	public static void search(byte[] haystack, byte[] needle, int initialThreshold) {
		
		haystackBytes = toByte(haystack,haystack.length,0,haystack.length);
		needleBytes = toByte(needle, needle.length,0,needle.length);
		int threshold= initialThreshold;
		for(int y=0; y<(haystackBytes.length-threshold);y++){
			for(int x=0; x<(needleBytes.length-threshold); x++){
			
				needleThreshold = toByte(needle, threshold,x,threshold);
				haystackThreshold = toByte(haystack, threshold,y,threshold);
				while(Arrays.equals(needleThreshold, haystackThreshold)){
					found=true;
					threshold++;					
					needleThreshold = toByte(needle, threshold,x,threshold);
					haystackThreshold = toByte(haystack, threshold,y,threshold);
				 }		
				
				if(found){
					foundAt = "sequence of length = "+(needleThreshold.length-1)+" found at haystack offset "+y+", needle offset "+x;
					System.out.println(foundAt);
					y=y+threshold;
				}
				found=false;
			}
			threshold= initialThreshold;	
		}
		
	}
	
	
	private static Byte[] toByte (byte[] input, int size, int start, int end){
		
	    Byte[] newByte = new Byte[size];
	    for(int x = 0; x<end; x++){
	    	newByte[x] = input[start+x];
	    }
	    return newByte;
	}
	
	
}
