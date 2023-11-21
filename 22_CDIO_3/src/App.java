class App {
    public static void main(String[] args) throws Exception{
        Introduktion.intro();

        //Variables
        var s = new java.util.Scanner(System.in);

        String temp = "";

        var die1 = 0;
        var die2 = 0;

        var pAmount = 0;
        var playerWithLowestAge = 0;
        var playerWhosTurnItIs = 0;
        var currentTurnNumber = 1;

        var gameBoard = new Board();

        //User chooses how many playeirs
        System.out.println("Vaelg mellem 2 og 4 spillere: ");
        while (true) {
            try {
                pAmount = Integer.parseInt(s.nextLine());
            }
            catch (Exception e) {
                System.out.println("Du skal skrive et tal for at vaelge en figur!");
                continue;
            }

            if (pAmount < 2 || pAmount > 4) {
                System.out.println(pAmount + " er ikke et gyldigt valg");
                continue;
            }

            break;
        }


        //Player array created with amount of players as length
        Player[] players = new Player[pAmount];
        var figures = new Figure();

        //Initialise each player
        for (var i = 0; i < players.length; i++) {
            players[i] = new Player(players.length);
        }
        
        //Set players numbers, figures and ages
        for (var i = 0; i < players.length; i++) {
            players[i].setPlayerNumber(i + 1);
            System.out.println("");
            FigureChecker.setFigures(players[i], i, figures, s);
            players[i].setAge(Agechecker.getAge(players[i].getFigure(), s));
        }

        //Showing the information of players to the user
        System.out.println(System.lineSeparator() + "Du har valgt: " + System.lineSeparator());
        for (var p : players) {
            System.out.println("For spiller " + p.getPlayerNumber() + ": " + p.getFigure() + ", " + p.getPoints() + "M, " + p.getAge() + " aar gammel.");
        }

        //Youngest player is selected
        for (var i = 1; i < players.length; i++) {
            if (players[i].getAge() < players[playerWithLowestAge].getAge())
            playerWithLowestAge = i;
        }

        pAmount--;
        playerWhosTurnItIs = playerWithLowestAge;
        playerWithLowestAge++;

        //Game begins
        System.out.println(System.lineSeparator() + "Spiller " + playerWithLowestAge + ", " + players[playerWhosTurnItIs].getFigure() + " begynder" + System.lineSeparator());
        System.out.println("Er i klar? Tryk Enter for at begynde.");

        temp = s.nextLine();

        while (true) {
            System.out.println("----------------------------" + System.lineSeparator() + "Tur nummer " + currentTurnNumber + ".");

            //Player has a figure card
            if (players[playerWhosTurnItIs].getHasFigureCard()) {
                players[playerWhosTurnItIs].figurkort(players, gameBoard.getBoard(), s);

                players[playerWhosTurnItIs].getStatus();

                //Next player's turn
                if (playerWhosTurnItIs == pAmount)
                playerWhosTurnItIs = 0;
                else
                playerWhosTurnItIs++;
                continue;
            }
            
            //If player is in jail, this will run
            players[playerWhosTurnItIs].getOutOfJail();
            
            //Get players status before turn
            players[playerWhosTurnItIs].getStatus();

            die1 = Dice.rollDice();
            die2 = Dice.rollDice();
            
            System.out.println(System.lineSeparator() + players[playerWhosTurnItIs].getFigure() + " slaar " + die1 + " og " + die2 + ", hvilket giver " + (die1 + die2) + System.lineSeparator());

            players[playerWhosTurnItIs].move(die1 + die2);

            System.out.print(players[playerWhosTurnItIs].getFigure() + " lander paa ");
            gameBoard.giveTurn(players, players[playerWhosTurnItIs], gameBoard.getBoard(), s);
            
            if (players[playerWhosTurnItIs].getPoints() <= 0) //Current player is broke
            break;

            //Get players status after turn
            players[playerWhosTurnItIs].getStatus();

            System.out.println("Tryk Enter for at fortsaette");

            temp = s.nextLine();

            currentTurnNumber++;

            //Next player's turn
            if (playerWhosTurnItIs == pAmount)
            playerWhosTurnItIs = 0;
            else
            playerWhosTurnItIs++;
        }

        s.close();

        //Checking how many properties each player has
        var amountOfProperties = new int[players.length];

        for (var i = 0; i < gameBoard.getBoard().length; i++) {
            for (var j = 0; j < players.length; j++) {
                if (gameBoard.getBoard()[i].getOwnedBy() == players[j].getPlayerNumber()) {
                    amountOfProperties[j]++;
                }
            }
        }

        WinCheck.checkWinner(players, players[playerWhosTurnItIs], amountOfProperties);
    }
}
