class Felt {
    private final int fieldNumber;
    private String fieldDescription;
    private int price;
    private final String color;
    private int ownedBy;
    private boolean match;

    public Felt(int fieldNumber, String fieldDescription, int price, String color) {
        this.fieldNumber = fieldNumber;
        this.fieldDescription = fieldDescription;
        this.price = price;
        this.color = color;
        this.ownedBy = -1;
        this.match = false;
    }

    //Getters
    public int getFieldNumber() {
        return this.fieldNumber;
    }
    
    public String getFieldDescription() {
        return this.fieldDescription;
    }

    public int getPrice(){
        return this.price;
    }

    public String getColor(){
        return this.color;
    }

    public int getOwnedBy(){
        return this.ownedBy;
    }

    public boolean getMatch() {
        return this.match;
    }

    //Setters
    public void setMatch(boolean match) {
        this.match = match;
    }
    
    public void setOwnedBy(int playernum){
        this.ownedBy = playernum;
    }

    public void doublePrice() {
        this.price *= 2;
        this.fieldDescription += ". Ejeren har begge ejendomme af samme farve, saa prisen er fordoblet.";
    }

    //Methods
    public static void colormatch(Felt[] board){
        for(int i = 0; i < board.length; i++){
            if(board[i].ownedBy == -1){
                continue;
            }

            for(int t = 0; t < board.length; t++){
                if(board[i].getColor() != null && board[t].getColor() != null && board[i].getColor().equals(board[t].getColor()) && !(board[i].equals(board[t])) && board[i].getOwnedBy() == board[t].getOwnedBy()){
                    if (board[i].getMatch() == false) {
                        board[i].doublePrice();
                        board[t].doublePrice();
                        board[i].setMatch(true);
                        board[t].setMatch(true);
                    }
                }
            }
        }
    }
    
    //Buy field
    public void buyField(Player[] players, Player player) {
        //Not owned by anyone
        if (this.ownedBy == -1) {
            player.withdraw(this.price);
            this.ownedBy = player.getPlayerNumber();
            System.out.println(System.lineSeparator() + player.getFigure() + " koeber ejendommen for " + this.getPrice() + "M");
        }
        else if (this.ownedBy == player.getPlayerNumber()) { //Player owns it
            System.out.println(System.lineSeparator() + "Du landede paa din egen ejendom, saa du slapper bare af.");
        }
        else { //Find out who owns it and pay rent
            for(int i = 0; i < players.length; i++){
                if(players[i].getPlayerNumber() == this.ownedBy){
                    players[i].deposit(this.price);
                    player.withdraw(this.price);
                    System.out.println(System.lineSeparator() + players[i].getFigure() + " ejer denne ejendom, saa " + player.getFigure() + " skal betale " + this.getPrice() + "M i leje.");
                    break;
                }
            }
        }
    }

    //Buy already owned field
    public void buyOwnedField(Player[] players, Player player) {
        for(int i = 0; i < players.length; i++){
            if(players[i].getPlayerNumber() == this.ownedBy){
                players[i].deposit(this.price);
                player.withdraw(this.price);
                this.ownedBy = player.getPlayerNumber();
                System.out.println(System.lineSeparator() + player.getFigure() + " koeber denne ejendom fra " + players[i].getFigure() + " for " + this.getPrice() + "M.");
                break;
            }
        }
        
    }

    //Print field description
    public void showFieldInfo() {
        System.out.println(getFieldDescription());
    }
}
