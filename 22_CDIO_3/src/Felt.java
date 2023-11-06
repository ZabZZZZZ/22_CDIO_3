class Felt {
    private int fieldNumber;
    private String fieldDescription;
    private int price;
    private String Color;
    private int owned = 5;
    boolean match = false;

    public Felt(int n, String d, int e, String c) {
        this.fieldNumber = n;
        this.fieldDescription = d;
        this.price = e;
        this.Color = c;
    }
    public void colormatch(Felt board[]){
        for(int i = 0;i<board.length;i++){
            if(board[i].owned == 5){
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

    public void landOnField(Player player) {
        useEffect(player);
        showFieldInfo();
        colormatch(Feltliste[]);
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
