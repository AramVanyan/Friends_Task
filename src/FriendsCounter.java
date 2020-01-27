import java.util.*;

public class FriendsCounter {
    public static int countFriends(String[] listOfRelationships,String name) {
        int currentIndex = -1;
        String[] listOfNames = null;
        HashSet<String> setOfNonRepeatingNames = new HashSet<>();
        HashSet<String> setOfFriends = null;
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
            String[] friends = new String[setOfNonRepeatingNames.size()-1];
            int currentIndexOfFriends = -1;
            Iterator<String> it = setOfNonRepeatingNames.iterator();
            currentName = it.next().toString();
            for (int j = 0; j < listOfNames.length; j+=2) {
                if (currentName.equals(listOfNames[j])) {
                    friends[++currentIndexOfFriends] = listOfNames[j+1];
                }
                if (currentName.equals(listOfNames[j+1])) {
                    friends[++currentIndexOfFriends] = listOfNames[j];
                }
            }
            mapOfRelationships.put(currentName,friends);
        }
        String[] tempFriends = mapOfRelationships.get(name);
        for (String friend:tempFriends) {
            setOfFriends.add(friend);
        }
        Iterator it = mapOfRelationships.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (pair.getKey() == name) {
                continue;
            }
            tempFriends = (String[]) pair.getValue();
            for (String friend:tempFriends) {
                if (friend == name ) {
                    continue;
                }
                setOfFriends.add(friend);
            }

        }
        return setOfFriends.size();
    }
}
