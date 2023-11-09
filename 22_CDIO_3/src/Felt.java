import java.util.Scanner;

class Felt {
    private int fieldNumber;
    private String fieldDescription;
    private int price;
    private String Color;
    private int owned = -1;
    boolean match = false;

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
    public void colormatch(){
        
    }

    //Methods
    public void useEffect(Player player) {
        if (this.owned == 5) {
            player.withdraw(this.price);
            this.owned = player.number;
        }
        else{
            for(int i = 0;i<4;i++){
                if(app.players[i].number == this.owned){
                    players[i].deposit(this.price);
                    player.withdraw(this.price);
                }
            }
        }
    }

    public void showFieldInfo() {
        System.out.println(getFieldDescription());
    }
    /*
    public void changeloc(Player player){
        player.location = this.FieldNumber;
    }
    public void own(Player player){
        this.owned = player.number;
    }*/
    public void figurkort(Player player, Felt[] board, Scanner scanner){
        if(player.harfigurkort){
            if(player.figure.equals("bil")){
            System.out.println("Nu skal du bruge dit chancekort og drøne hen til dit ønskede felt");
            }else if(player.figure.equals("skib")){
            System.out.println("Nu skal du bruge dit chancekort og sejle hen til dit ønskede felt");
            }else if(player.figure.equals("kat")){
            System.out.println("Nu skal du bruge dit chancekort og liste hen til dit ønskede felt");
            }else if(player.figure.equals("hund")){
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
                player.location = destination;
                board[destination].owned = player.number;
                System.out.println("You drove to field " + destination + " and bought it.");
            } else {
                // Field is owned by another player, player needs to buy from them
                int seller = board[destination].owned;
                player.location = destination;
                board[destination].owned = player.number;
                players[seller - 1].withdraw(board[destination].price);
                player.deposit(board[destination].price);
                System.out.println("You drove to field " + destination + " and bought it from Player " + seller + ".");
            }
            player.harfigurkort = false;
        }
    }

    public void landOnField(Player player, Scanner scanner, Felt[] board) {
        if(player.harfigurkort){
            figurkort(player, board, scanner);
            return;
        }
        useEffect(player);
        showFieldInfo();
        colormatch(board);
    }

    //A method to get the amount to be added or subtracted from the players account
    public static int getAmount(/*String playerName,*/ int sum) {
        switch (sum) {
            case 2:
            return 250;
            
            case 3:
            return -100;
            
            case 4:
            return 100;
            
            case 5:
            return -20;
            
            case 6:
            return 180;
            
            case 7:
            return 0;
            
            case 8:
            return -70;
            
            case 9:
            return 60;
            
            case 10:
            return -70;
            
            case 11:
            return -50;
            
            case 12:
            return 650;

            default:
            return 0;
        }
    }
}
