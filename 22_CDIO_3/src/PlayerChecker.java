import java.util.Scanner;

class PlayerChecker {
    

    public PlayerChecker() {
        scanner = new Scanner(System.in);
    }

    public int getPlayerCount() {
        int minPlayers = 2;
        int maxPlayers = 4;
        int numPlayers;

        do {
            System.out.print("Hvor mange spillere er i? (mellem 2 og 4)? ");
            numPlayers = Integer.parseInt(scanner.nextLine());

            if (numPlayers < minPlayers || numPlayers > maxPlayers) {
                System.out.println("Ugyldigt antal af spillere.");
            }
        } while (numPlayers < minPlayers || numPlayers > maxPlayers);

        players = new Player[numPlayers]; 
        
        
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player();
        }

        return numPlayers;
    }

    public Player[] getPlayers() {
        return players;
    }
}