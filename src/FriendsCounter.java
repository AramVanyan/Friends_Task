import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class FriendsCounter {
    public static void countFriends(String[] listOfRelationships,String name) {
        int currentIndex = -1;
        String[] listOfNames = null;
        HashSet<String> setOfNonRepeatingNames = new HashSet<>();
        HashMap<String,String[]> mapOfRelationships = new HashMap<>();
        ArrayList<String> arrayListOfNonRepeatingList = null;


        for (int i = 0; i < listOfRelationships.length; i++) {
            String[] tempArrayOfNames = listOfRelationships[i].split(":");
            for (int j = 0; j < tempArrayOfNames.length; j++) {
                listOfNames[++currentIndex] = tempArrayOfNames[j];
            }
        }

        for (int i = 0; i < listOfNames.length; i++) {
            setOfNonRepeatingNames.add(listOfNames[i]);
        }
        for (Iterator<String> it = setOfNonRepeatingNames.iterator();it.hasNext();) {
            arrayListOfNonRepeatingList.add(it.next());
        }

        for (int i = 0; i < setOfNonRepeatingNames.size(); i++) {
            String currentName;
            String nextName;
            int currentIndex1 = -1;
            String[] tempArrayOfNames;
            Iterator<String> it = setOfNonRepeatingNames.iterator();
            for (int j = 0; j < listOfNames.length; j+=2) {
                currentName = it.next().toString();

            }


        }


    }
}
