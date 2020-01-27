import java.util.*;

public class FriendsCounter {
    public static int countFriends(String[] listOfRelationships,String name) {
        int currentIndex = -1;
        String[] listOfNames = new String[listOfRelationships.length];
        HashSet<String> setOfNonRepeatingNames = new HashSet<>();
        HashSet<String> setOfFriends = new HashSet<>();
        HashMap<String,String[]> mapOfRelationships = new HashMap<>();


        for (int i = 0; i < listOfRelationships.length; i++) {
            String[] tempArrayOfNames = listOfRelationships[i].split(":");
            for (int j = 0; j < tempArrayOfNames.length; j++) {
                listOfNames[++currentIndex] = tempArrayOfNames[j];
            }
        }

        setOfNonRepeatingNames.addAll(Arrays.asList(listOfNames));
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
        setOfFriends.addAll(Arrays.asList(tempFriends));
        Iterator it = mapOfRelationships.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (pair.getKey() == name) {
                continue;
            }
            tempFriends = (String[]) pair.getValue();
            for (String friend:tempFriends) {
                if (friend.equals(name)) {
                    continue;
                }
                setOfFriends.add(friend);
            }

        }
        return setOfFriends.size();
    }
}
