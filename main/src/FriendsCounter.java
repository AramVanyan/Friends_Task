import java.util.*;

public class FriendsCounter {
    public static int countFriends(String[] listOfRelationships,String name) {
        ArrayList<String> listOfNames = new ArrayList<>();
        HashSet<String> setOfFriends = new HashSet<>();
        HashMap<String,ArrayList<String>> mapOfRelationships = new HashMap<>();


        for (String listOfRelationship : listOfRelationships) {
            String[] tempArrayOfNames = listOfRelationship.split(":");
            listOfNames.addAll(Arrays.asList(tempArrayOfNames));
        }

        HashSet<String> setOfNonRepeatingNames = new HashSet<>(listOfNames);
        Iterator<String> it = setOfNonRepeatingNames.iterator();

        for (int i = 0; i < setOfNonRepeatingNames.size(); i++) {
            String currentName = it.next();
            ArrayList<String> friends = new ArrayList<>();

            for (int j = 0; j < listOfNames.size(); j+=2) {
                if (currentName.equals(listOfNames.get(j))) {
                    friends.add(listOfNames.get(j+1));
                }
                 if (currentName.equals(listOfNames.get(j+1))) {
                    friends.add(listOfNames.get(j));
                }
            }
            mapOfRelationships.put(currentName,friends);
        }

        addFriends(mapOfRelationships,setOfFriends,name,null);
        System.out.println(setOfFriends);
        return setOfFriends.size();
    }

    public static void addFriends(Map<String, ArrayList<String>> mapOfRelationships, Set<String> setOfFriends,
                                  String name,String previousFriend) {

        for (Map.Entry<String, ArrayList<String>> pair : mapOfRelationships.entrySet()) {
            if (!pair.getKey().equals(name)) {
                continue;
            }

            HashSet<String> previousSetOfFriends = new HashSet<>(setOfFriends);
            ArrayList<String> tempFriends = pair.getValue();

            for (String friend : tempFriends) {
                if (friend.equals(name) || friend.equals(previousFriend)) {
                    continue;
                }
                setOfFriends.add(friend);
            }

            HashSet<String> tempHashSet = new HashSet<>(setOfFriends);
            tempHashSet.removeAll(previousSetOfFriends);

            for (String s : tempHashSet) {
                addFriends(mapOfRelationships, setOfFriends, s, name);
            }
        }
    }
}
