package stringsCollections;

import java.util.ArrayList;

public class StoreStrings {
	
	public static int count(ArrayList <String> words)
    {
        int lSize = 0;
        for(String i : words)
        {
            lSize++;
        }
        
		return lSize;
    
    }
	
	public static boolean duplicateString(ArrayList <String> words) {
		boolean isDuplicateString = false;
		
		ArrayList<String> items = new ArrayList<>();
		
        for(String word : words)
        {
            if (items.contains(word)) {
            	isDuplicateString = true;
            }else {
            	items.add(word);
            }
        }
		
		
		return isDuplicateString;
		
	}
}
