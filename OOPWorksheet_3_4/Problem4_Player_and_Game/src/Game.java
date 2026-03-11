import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void addPlayer(__________ player) { // TODO: parameter type
        players.add(player);
    }

    public String getWinner() {
        if (players.size() == 0) return "No players";

        Player winner = players.__________(0); // TODO

        for (__________ p : players) { // TODO: fill in type
            if (p.__________() > winner.getScore()) { // TODO: getter
                winner = __________; // TODO
            }
        }

        return winner.__________(); // TODO
    }

    public void printLeaderboard() {
        for (int i = 0; i < players.__________(); i++) { // TODO
            Player p = players.get(__________); // TODO
            System.out.println((i __________ 1) + ". "
                + p.getName() + " - " + p.__________()); // TODO: score getter
        }
    }
}
