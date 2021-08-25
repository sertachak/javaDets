public class League {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("JOE");
        BasketballPlayer henry = new BasketballPlayer("HENRY");
        BaseballPlayer josh = new BaseballPlayer("JOSH");

        Team<FootballPlayer> mixed = new Team<>("Mixed");
        mixed.addToTeam(joe);
       /* mixed.addToTeam(henry);
        mixed.addToTeam(josh);*/

        System.out.println(mixed.numPlayers());
    }
}
