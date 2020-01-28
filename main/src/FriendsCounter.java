import java.util.*;

public class FriendsCounter {
    public static int countFriends(String[] listOfRelationships,String name) {
        ArrayList<String> listOfNames = new ArrayList<>();
        HashSet<String> setOfNonRepeatingNames = new HashSet<>();
        HashSet<String> setOfFriends = new HashSet<>();
        HashMap<String,ArrayList<String>> mapOfRelationships = new HashMap<>();


        for (int i = 0; i < listOfRelationships.length; i++) {
            String[] tempArrayOfNames = listOfRelationships[i].split(":");
            listOfNames.addAll(Arrays.asList(tempArrayOfNames));
        }

        setOfNonRepeatingNames.addAll(listOfNames);
        Iterator<String> it = setOfNonRepeatingNames.iterator();
        for (int i = 0; i < setOfNonRepeatingNames.size(); i++) {
            String currentName;
            ArrayList<String> friends = new ArrayList<>();
            currentName = it.next();
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
        Iterator<Map.Entry<String, ArrayList<String>>> mapIterator = mapOfRelationships.entrySet().iterator();

        while (mapIterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> pair = mapIterator.next();

            if (!pair.getKey().equals(name)) {
                continue;
            }
            HashSet<String> previousSetOfFriends = new HashSet<>(setOfFriends);

            ArrayList<String> tempFriends = pair.getValue();
            for (String friend:tempFriends) {
                if (friend.equals(name) || friend.equals(previousFriend)) {
                    continue;
                }
                setOfFriends.add(friend);
            }

            HashSet<String> tempHashSet = new HashSet<>(setOfFriends);
            tempHashSet.removeAll(previousSetOfFriends);
            Iterator<String> setIt2 = tempHashSet.iterator();
            while (setIt2.hasNext()) {
                addFriends(mapOfRelationships,setOfFriends,setIt2.next(),name);
            }

        }
    }
}
