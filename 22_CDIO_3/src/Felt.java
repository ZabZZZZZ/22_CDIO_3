import java.util.Scanner;

class Felt {
    private final int fieldNumber;
    private final String fieldDescription;
    private final int price;
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

    public void setMatch(boolean match) {
        this.match = match;
    }
    
    //Setter
    public void setOwned(int playernum){
        this.ownedBy = playernum;
    }

    //Methods
    public void colormatch(Felt[] board){
        for(int i = 0; i < board.length; i++){
            if(board[i].ownedBy == -1){
                continue;
            }

            for(int t = 0; t < board.length; t++){
                if(board[i].getColor().equals(board[t].getColor()) && !(board[i].equals(board[t])) && board[i].getOwnedBy() == board[t].getOwnedBy()){
                    board[i].setMatch(true);
                    board[t].setMatch(true);
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
        }
        else{ //Find out who owns it and pay rent
            for(int i = 0; i < players.length; i++){
                if(players[i].getPlayerNumber() == this.ownedBy){
                    players[i].deposit(this.price);
                    player.withdraw(this.price);
                }
            }
        }
    }

    //Print field description
    public void showFieldInfo() {
        System.out.println(getFieldDescription());
    }
    
    //Player has a figurecard
    public void figurkort(Player player, Felt[] board, Scanner scanner){
        if(player.gethasfigurecard()){
            if(player.getFigure().equals("bil")){
            System.out.println("Nu skal du bruge dit chancekort og drøne hen til dit ønskede felt");
            }else if(player.getFigure().equals("skib")){
            System.out.println("Nu skal du bruge dit chancekort og sejle hen til dit ønskede felt");
            }else if(player.getFigure().equals("kat")){
            System.out.println("Nu skal du bruge dit chancekort og liste hen til dit ønskede felt");
            }else if(player.getFigure().equals("hund")){
            System.out.println("Nu skal du bruge dit chancekort og hoppe hen til dit ønskede felt");
            }
            // Print available fields
            System.out.println("Felter at vælge mellem:");
            for (int i = 1; i < board.length; i++) {
                if (board[i].ownedBy == -1) {
                    System.out.println("Field " + i + ": " + board[i].getFieldDescription());
                }
            }
        
            int destination;
            do {
                System.out.println("Enter the field number (1-23) where you want to drive and buy:");
                destination = scanner.nextInt();
            } while (destination < 1 || destination > 23 || board[destination].ownedBy != -1);
        
            // Check if the chosen field is available
            if (board[destination].ownedBy == -1) {
                // Field is available, player can buy it
                player.setPosition(destination);
                board[destination].setOwned(player.getNumber());
                System.out.println("You drove to field " + destination + " and bought it.");
            } else {
                // Field is owned by another player, player needs to buy from them
                int seller = board[destination].ownedBy;
                player.setPosition(destination);
                board[destination].setOwned(player.getNumber());
                players[seller - 1].withdraw(board[destination].price);
                player.deposit(board[destination].price);
                System.out.println("You drove to field " + destination + " and bought it from Player " + seller + ".");
            }
            player.setHasFigureCard(false);
        }
    }

    public void landOnField(Player player, Scanner scanner, Felt[] board) {
        if(player.getHasFigureCard()){
            figurkort(player, board, scanner);
            return;
        }
        buyField(player);
        showFieldInfo();
        colormatch(board);
    }

    //chancekort effekter

}
