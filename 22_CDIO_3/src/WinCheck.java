class WinCheck {
    public static void checkWinner(Player[] players, Player loser, int[] amountOfProperties) {
        var tempPlayer = new Player();

        System.out.println(System.lineSeparator() + loser.getFigure() + " er gaet fallit, og har tabt spillet!" + System.lineSeparator() + "Spillernes stilling er:");
        for (var i = 0; i < players.length; i++) {
            players[i].getFinalStatus(amountOfProperties[i]);
        }

        for(int i = 0; i < players.length - 1; i++) {
            if (players[i].getPoints() > players[i + 1].getPoints() && players[i].getPoints() > tempPlayer.getPoints()) {
                tempPlayer = players[i];
            }
            else if (players[i].getPoints() < players[i + 1].getPoints() && players[i].getPoints() < tempPlayer.getPoints()) {
                tempPlayer = players[i + 1];
            }
        }

        System.out.println(System.lineSeparator() + tempPlayer.getFigure() + " har vundet spillet!");
    }
}
