import java.util.ArrayList;

public class Team<T extends Player> {
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    public Team(String name){
        this.name = name;
    }

    private ArrayList<T> members = new ArrayList<>();


    public boolean addToTeam(T player) {
        if(members.contains(player)){
            System.out.println("Already in the team");
            return false;
        }
        else {
            members.add(player);
            System.out.println(getClass().getSimpleName() + " " + player.getName() + " picked for the team");
            return true;
        }
    }

    public int numPlayers() {
        return members.size();
    }

    public void matchResult(Team<T> opponent, int opponentScore, int teamScore){
        if(opponentScore > teamScore){
            lost++;
        } else  if(opponentScore == teamScore){
            tied++;
        }
        else {
            won++;
        }
        played++;
        if(opponent != null){
            opponent.matchResult(null, teamScore, opponentScore);
        }
    }
}
