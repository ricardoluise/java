import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HaystackNeedle {

	public static void main(String[] args) {
		
		byte[] haystack = {'v','n','k','2','4','3','5','k','v','a','b','c','o','8','a','w','k','h','1','2','5','k','j','n','e','y','t','b','c','d','1','2','q','j','h','b','4','a','c','d','1','2','3','x','m','n','b','q','w','n','w','4','t'};
	    byte[] needle = {'a','b','c','d','1','2','3','4'};
	    int threshold = 3;

	   search(haystack,needle,threshold);
		
	}
	
	public static void search(byte[] input, byte[] searchedFor, int threshold) {
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
