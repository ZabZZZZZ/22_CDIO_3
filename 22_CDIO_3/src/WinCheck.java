class WinCheck {
    public static void checkWinner(Player player1, Player player2) {
        if (player1.getPoints() >= 3000 && player2.getPoints() >= 3000) {
            if (player1.getPoints() > player2.getPoints())
            System.out.println("Spillet er nu slut, og begge spillere nåede over 3000 points. Men i sidste ende vandt " + player1.getName() + " med " + player1.getPoints() + " points.");
            else
            System.out.println("Spillet er nu slut, og begge spillere nåede over 3000 points. Men i sidste ende vandt " + player2.getName() + " med " + player2.getPoints() + " points.");
        }
        else if (player1.getPoints() >= 3000) {
            System.out.println("Spillet er nu slut, og spilleren " + player1.getName() + " har vundet med " + player1.getPoints() + " points.");
        }
        else {
            System.out.println("Spillet er nu slut, og spilleren " + player2.getName() + " har vundet med " + player2.getPoints() + " points.");
        }
    }
}
