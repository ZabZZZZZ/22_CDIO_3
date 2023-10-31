class FeltListe {
    private int fieldNumber;
    private String fieldDescription;
    private int Effect;

    public FeltListe(int n, String d, int e) {
        this.fieldNumber = n;
        this.fieldDescription = d;
        this.Effect = e;
    }

    //Getters
    public int getFieldNumber() {
        return this.fieldNumber;
    }

    public String getFieldDescription() {
        return this.fieldDescription;
    }

    //Methods
    public void useEffect(Player player) {
        if (this.Effect < 0) {
            player.withdraw(this.Effect);
        }
        else {
            player.deposit(this.Effect);
        }
    }

    public void showFieldInfo() {
        System.out.println(getFieldDescription());
    }

    public void landOnField(Player player) {
        useEffect(player);
        showFieldInfo();
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
