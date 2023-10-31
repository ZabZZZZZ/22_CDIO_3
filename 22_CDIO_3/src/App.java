class App {
    public static void main(String[] args) {
        Introduktion.intro();

        //Variables
        var s = new java.util.Scanner(System.in);

        String temp = "";

        var die1 = 0;
        var die2 = 0;

        //Create and initialize players
        Player player1 = new Player(Namechecker.checkName(1, s));
        Player player2 = new Player(Namechecker.checkName(2, s));

        //Checking if name is same
        Namechecker.isNameSame(player1, player2);

        DiceSelecter.selectDice();

        //Game begins
        System.out.println("Spillet begynder med " + player1.getName() + "'s tur." + System.lineSeparator());

        while(true) {
            //Player 1 rolls
            die1 = Dice.rollDice();
            die2 = Dice.rollDice();
            
            System.out.println(player1.getName() + " slaar " + die1 + " og " + die2 + ", hvilket giver " + (die1 + die2));

            //Points are checked and added or subtracted
            SumChecker.checkSum(die1, die2, player1, s);

            System.out.println(player1.getName() + " har nu " + player1.getPoints() + " points.");
            System.out.println("Tryk Enter for at fortsaette" + System.lineSeparator());

            temp = s.nextLine();
            
            //Player 2 rolls
            die1 = Dice.rollDice();
            die2 = Dice.rollDice();

            System.out.println(player2.getName() + " slaar " + die1 + " og " + die2 + ", hvilket giver " + (die1 + die2));

            //Points are checked and added or subtracted
            SumChecker.checkSum(die1, die2, player2, s);

            System.out.println(player2.getName() + " har nu " + player2.getPoints() + " points.");
            System.out.println("Tryk Enter for at fortsaette" + System.lineSeparator());

            temp = s.nextLine();

            //Check if someone won
            if (player1.getPoints() >= 3000 || player2.getPoints() >= 3000)
            break;
        }
        s.close();

        //Checking who won
        WinCheck.checkWinner(player1, player2);
    }
}
