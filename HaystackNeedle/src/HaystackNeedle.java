import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HaystackNeedle {

	private static Byte[] haystackBytes;
	private static Byte[] needleBytes;
	private static Byte[] needleThreshold;
	private static Byte[] haystackThreshold;


	public static void main(String[] args) {
		
		byte[] haystack = {'v','n','k','2','4','3','5','k','v','a','b','c','o','8','a','w','k','h','1','2','5','k','j','n','e','y','t','b','c','d','1','2','q','j','h','b','4','a','c','d','1','2','3','x','m','n','b','q','w','n','w','4','t'};
		//byte[] haystack = {'a','b','c','d','1','2','3','4'};
		byte[] needle = {'a','b','c','d','1','2','3','4'};
	    int threshold = 3;

	   search(haystack,needle,threshold);
		
	}
	
	
	public static void search(byte[] haystack, byte[] needle, int threshold) {
		
		haystackBytes = toByte(haystack,haystack.length,0,haystack.length);
		needleBytes = toByte(needle, needle.length,0,needle.length);
		
		for(int x=0; x<needleBytes.length; x++){
			needleThreshold = toByte(needle, threshold,x,threshold+x);
			for(int y=0; y<haystackBytes.length;y++){
				haystackThreshold = toByte(haystack, threshold,y,threshold+y);
				 if(Arrays.equals(needleThreshold, haystackThreshold)){
					 		System.out.println("found");
					 		
				 }
			}
		}
		
	}
	
	
	private static Byte[] toByte (byte[] input, int size, int start, int end){
		
	    Byte[] newByte = new Byte[size];
	    for(int x = 0; x<end; x++){
	    	newByte[x] = input[start+x];
	    }
	    return newByte;
	}

	
	
	public static void search2(byte[] input, byte[] searchedFor, int threshold) {
	    //convert byte[] to Byte[]
	    Byte[] searchedForB = new Byte[searchedFor.length];
	    for(int x = 0; x<searchedFor.length; x++){
	        searchedForB[x] = searchedFor[x];
	    }

	    int idx = -1;

	    //search:
	    Deque<Byte> q = new ArrayDeque<Byte>(input.length);
	    
	    for(int i=0; i<input.length; i++){
	        if(q.size() == searchedForB.length){
	            //here I can check
	            Byte[] cur = q.toArray(new Byte[]{});
	            if(Arrays.equals(cur, searchedForB)){
	                //found!
	                idx = i - searchedForB.length;
	                break;
	            } else {
	                //not found
	                q.pop();
	                q.addLast(input[i]);
	            }
	        } else {
	            q.addLast(input[i]);
	        }

		 
	    }
	    System.out.println(idx);

	}
}
