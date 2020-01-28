public class Test {
    public static void main(String[] args) {
        String[] friends = {
                "aram:hakob",
                "vardan:hakob",
                "aram:ani",
                "aram:shahen",
                "ani:karen",
                "gevorg:vazgen",
                "tiko:yervand",
                "mxo:ani",
                "vazgen:zaven",
                "zaven:aram"
        };
        System.out.println(FriendsCounter.countFriends(friends, "aram"));
    }
}
