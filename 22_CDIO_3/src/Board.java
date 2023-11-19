class Board {
    Felt[] board;

    public Board() {
        board = new Felt[24];

        board[0] = new Felt(0, "Start: Du modtager 2M", -2, null);
        board[1] = new Felt(1, "Burgerbaren: Pris: 1M", 1, "brun");
        board[2] = new Felt(2, "Pizzahuset: Pris: 1M", 1, "brun");
        board[3] = new Felt(3,"Chance og traekker et kort" + System.lineSeparator(), 0, null);
        board[4] = new Felt(4,"Slikbutikken: Pris: 1M", 1, "lyseblaa");
        board[5] = new Felt(5,"Iskiosken: Pris: 1M", 1, "lyseblaa");
        board[6] = new Felt(6,"Besoeger en ven i faengsel", 0, null);
        board[7] = new Felt(7,"Museet: Pris: 2M", 2, "pink");
        board[8] = new Felt(8,"Biblioteket: Pris: 2M", 2, "pink");
        board[9] = new Felt(9,"Chance og traekker et kort" + System.lineSeparator(), 0, null);
        board[10] = new Felt(10,"Skaterparken: Pris: 2M", 2, "orange");
        board[11] = new Felt(11,"Swimmingpoolen: Pris: 2M", 2, "orange");
        board[12] = new Felt(12,"Gratis parkering, bare slap af", 0, null);
        board[13] = new Felt(13,"Spillehallen: Pris: 3M", 3, "roed");
        board[14] = new Felt(14,"Biografen: Pris: 3M", 3, "roed");
        board[15] = new Felt(15,"Chance og traekker et kort" + System.lineSeparator(), 0, null);
        board[16] = new Felt(16,"Legetoejsbutikken: Pris: 3M", 3, "gul");
        board[17] = new Felt(17,"Dyrehandlen: Pris: 3M", 3, "gul");
        board[18] = new Felt(18,"Gaa i faengsel: Du har koert for hurtigt", 0, null);
        board[19] = new Felt(19,"Bowlinghallen: Pris: 4M", 4, "groen");
        board[20] = new Felt(20,"Zoologisk have: Pris: 4M", 4, "groen");
        board[21] = new Felt(21,"Chance og traekker et kort" + System.lineSeparator(), 0, null);
        board[22] = new Felt(22,"Vandlandet: Pris: 5M", 5, "moerkeblaa");
        board[23] = new Felt(23,"Strandpromenaden: Pris: 5M", 5, "moerkeblaa");
    }

    public Felt[] getBoard() {
        return this.board;
    }

    public void giveTurn(Player[] players, Player player, Felt[] board, java.util.Scanner s) {
        switch (player.getCurrentField()) {
            case 0: //Start
                this.board[0].showFieldInfo();
                player.deposit(2);
            break;
                
            case 6: //Besoeg
                this.board[6].showFieldInfo();
            break;

            case 12: //Parkering
                this.board[12].showFieldInfo();
            break;

            case 18: //Faengsel
                this.board[18].showFieldInfo();
                player.setJail();
            break;

            case 3, 9, 15, 21: //Chancekort
                this.board[player.getCurrentField()].showFieldInfo();
                ChancekortCaller.chooseRandomCard(players, player, board, s);
            break;
        
            default: //Ejendom
                this.board[player.getCurrentField()].showFieldInfo();
                this.board[player.getCurrentField()].buyField(players, player);
            break;
        }
    }
}
