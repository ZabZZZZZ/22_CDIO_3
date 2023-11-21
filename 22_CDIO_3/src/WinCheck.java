class WinCheck {
    public static void checkWinner(Player[] players, Player loser, int[] amountOfProperties) {
        System.out.println(System.lineSeparator() + loser.getFigure() + " er gaet fallit, og har tabt spillet!" + System.lineSeparator() + "Spillernes stilling er:");
        for (var i = 0; i < players.length; i++) {
            players[i].getFinalStatus(amountOfProperties[i]);
        }
    }
}
