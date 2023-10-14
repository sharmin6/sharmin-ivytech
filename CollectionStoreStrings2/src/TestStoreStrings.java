import java.util.ArrayList;
import stringsCollections.StoreStrings;

public class TestStoreStrings {

	public static void main(String[] args) {
		ArrayList<String> states = new ArrayList<>();
		states.add("Virginia");
		states.add("New York");
		states.add("Michigan");
		states.add("Indiana");
		states.add("Missouri");
		states.add("Oregon");
		
		states.sort(null);
		
		for(String state:states) {
			System.out.println(state);
		}
		
		if (StoreStrings.duplicateString(states)) {
			System.out.println("Error! Contains more than one entry of the same state in the list. Must have only one entry for the state in the list");
		} else {
			System.out.println(StoreStrings.count(states));
		}
		
		
	}

}
