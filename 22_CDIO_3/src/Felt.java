import java.util.Scanner;

class Felt {
    private int fieldNumber;
    private String fieldDescription;
    private int price;
    private String Color;
    private int owned = -1;
    private boolean match = false;

    public Felt(int n, String d, int e, String c) {
        this.fieldNumber = n;
        this.fieldDescription = d;
        this.price = e;
        this.Color = c;
    }
    public void colormatch(Felt board[]){
        for(int i = 0;i<board.length;i++){
            if(board[i].owned == -1){
                continue;
            }
            for(int t = 0;t<board.length;t++){
                if(board[i].Color.equals(board[t].Color)&&!(board[i].equals(board[t]))&&board[i].owned == board[t].owned){
                    board[i].match = true;
                    board[t].match = true;
                }
            }
        }
    }
    //Getters
    public int getFieldNumber() {
        return this.fieldNumber;
    }
    public String getColor(){
        return this.Color;
    }
    public int getOwned(){
        return this.owned;
    }
    public int getPrice(){
        return this.price;
    }

    public String getFieldDescription() {
        return this.fieldDescription;
    }

    //Methods
    public void buyField(Player[] players, Player player) {
        //Not owned by anyone
        if (this.owned == -1) {
            player.withdraw(this.price);
            this.owned = player.getPlayerNumber();
        }
        else{ //Find out who owns it and pay rent
            for(int i = 0; i < 4; i++){
                if(players[i].getPlayerNumber() == this.owned){
                    players[i].deposit(this.price);
                    player.withdraw(this.price);
                }
            }
        }
    }

    public void showFieldInfo() {
        System.out.println(getFieldDescription());
    }
    
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
                if (board[i].owned == -1) {
                    System.out.println("Field " + i + ": " + board[i].getFieldDescription());
                }
            }
        
            int destination;
            do {
                System.out.println("Enter the field number (1-23) where you want to drive and buy:");
                destination = scanner.nextInt();
            } while (destination < 1 || destination > 23 || board[destination].owned != -1);
        
            // Check if the chosen field is available
            if (board[destination].owned == -1) {
                // Field is available, player can buy it
                player.setPosition(destination);
                board[destination].setOwned(player.getNumber());
                System.out.println("You drove to field " + destination + " and bought it.");
            } else {
                // Field is owned by another player, player needs to buy from them
                int seller = board[destination].owned;
                player.setPosition(destination);
                board[destination].setOwned(player.getNumber());
                players[seller - 1].withdraw(board[destination].price);
                player.deposit(board[destination].price);
                System.out.println("You drove to field " + destination + " and bought it from Player " + seller + ".");
            }
            player.setHasFigureCard(false);
        }
    }
    public void setOwned(int playernum){
        this.owned = playernum;
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
