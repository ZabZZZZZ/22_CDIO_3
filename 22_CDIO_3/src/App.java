class App {
    public static void main(String[] args) throws Exception{
        Introduktion.intro();

        //Variables
        var s = new java.util.Scanner(System.in);

        String temp = "";

        var die1 = 0;
        var die2 = 0;

        var playerWithLowestAge = 0;
        var playerWhosTurnItIs = 0;

        var gameBoard = new Board();

        //User chooses how many playeirs
        System.out.println("Vaelg mellem 2 og 4 spillere: ");
        var pAmount = Integer.parseInt(s.nextLine());

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
        System.out.println(System.lineSeparator() + "Du har valgt: ");
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
        System.out.println("Spiller " + playerWithLowestAge + ", " + players[playerWhosTurnItIs].getFigure() + " begynder");

        while (true) {
            die1 = Dice.rollDice();
            die2 = Dice.rollDice();
            
            System.out.println(players[playerWhosTurnItIs].getFigure() + " slaar " + die1 + " og " + die2 + ", hvilket giver " + (die1 + die2));

            players[playerWhosTurnItIs].move(die1 + die2);

            System.out.print(players[playerWhosTurnItIs].getFigure() + " lander paa ");
            gameBoard.giveTurn(players, players[playerWhosTurnItIs]);

            players[playerWhosTurnItIs].getStatus();

            System.out.println("Tryk Enter for at fortsaette");

            temp = s.nextLine();

            if (players[playerWhosTurnItIs].getPoints() <= 0) //Current player is broke
            break;

            //Next player's turn
            if (playerWhosTurnItIs == pAmount)
            playerWhosTurnItIs = 0;
            else
            playerWhosTurnItIs++;
        }
    }
}
//         while(true) {
//             //Player 1 rolls
//             die1 = Dice.rollDice();
//             die2 = Dice.rollDice();
            
//             System.out.println(player1.getName() + " slaar " + die1 + " og " + die2 + ", hvilket giver " + (die1 + die2));

//             //Points are checked and added or subtracted
//             SumChecker.checkSum(die1, die2, player1, s);

//             System.out.println(player1.getName() + " har nu " + player1.getPoints() + " points.");
//             System.out.println("Tryk Enter for at fortsaette" + System.lineSeparator());

//             temp = s.nextLine();
            
//             //Player 2 rolls
//             die1 = Dice.rollDice();
//             die2 = Dice.rollDice();

//             System.out.println(player2.getName() + " slaar " + die1 + " og " + die2 + ", hvilket giver " + (die1 + die2));

//             //Points are checked and added or subtracted
//             SumChecker.checkSum(die1, die2, player2, s);

//             System.out.println(player2.getName() + " har nu " + player2.getPoints() + " points.");
//             System.out.println("Tryk Enter for at fortsaette" + System.lineSeparator());

//             temp = s.nextLine();

//             //Check if someone won
//             if (player1.getPoints() >= 3000 || player2.getPoints() >= 3000)
//             break;
//         }
//         s.close();

//         //Checking who won
//         WinCheck.checkWinner(player1, player2);
//     }
// }
