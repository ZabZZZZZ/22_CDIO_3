import java.util.Scanner;

class Player {

    private String figure;
    private int playerNumber;
    private int age;
    private int currentField;
    private Account account;
    private boolean hasJailCard;
    private boolean isJailed;
    private boolean hasFigureCard;

    //Constructor
    public Player(int amountOfPlayers) {
        this.figure = "";
        this.playerNumber = 0;
        this.age = 0;

        switch (amountOfPlayers) {
            case 2:
            this.account = new Account(20);
            break;

            case 3:
            this.account = new Account(18);
            break;

            case 4:
            this.account = new Account(16);
            break;
        }

        this.currentField = 0;
        this.hasJailCard = false;
        this.isJailed = false;
        this.hasFigureCard = false;
    }

    //Getters
    public String getFigure() {
        return this.figure;
    }

    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public int getAge() {
        return this.age;
    }

    public int getPoints() {
        return account.GetBalance();
    }

    public int getCurrentField() {
        return this.currentField;
    }

    public boolean getHasJailCard() {
        return this.hasJailCard;
    }

    public boolean getHasFigureCard() {
        return this.hasFigureCard;
    }

    public boolean getIsJailed() {
        return this.isJailed;
    }

    public void getStatus() {
        System.out.println(System.lineSeparator() + "Spiller " + this.playerNumber + ", " + this.figure + ", har " + this.getPoints() + "M, og staar paa felt nummer " + (this.currentField + 1));
    }

    public void getFinalStatus(int amountOfProperties) {
        if (amountOfProperties == 1)
        System.out.println(System.lineSeparator() + "Spiller " + this.playerNumber + ", " + this.figure + ", afslutter spillet med " + this.getPoints() + "M, og ejer " + amountOfProperties + " ejendom");
        else
        System.out.println(System.lineSeparator() + "Spiller " + this.playerNumber + ", " + this.figure + ", afslutter spillet med " + this.getPoints() + "M, og ejer " + amountOfProperties + " ejendomme");
    }

    //Setters
    public void setFigure(String figure) {
        this.figure = figure;
    }

    public void setPlayerNumber(int playerNum) {
        this.playerNumber = playerNum;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(int n) {
        this.currentField = n;
    }

    public void move(int n) {
        this.currentField += n;

        if (this.currentField > 23) { //Player has passed start
            this.currentField -= 24;
            if (this.currentField != 0) {
                this.deposit(2);
                System.out.println("Du har passeret start, saa du modtager 2M" + System.lineSeparator());
            }
        }
    }

    public void setJail() {
        this.currentField = 6;
        this.isJailed = true;
    }

    public void unJail() {
        this.isJailed = false;
    }

    public void setHasJailCard(boolean bool) {
        this.hasJailCard = bool;
    }

    public void setHasFigureCard(boolean bool) {
        this.hasFigureCard = bool;
    }
    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    public void deposit(int amount) {
        account.deposit(amount);
    }

    //Player has a figurecard
    public void figurkort(Player[] players, Felt[] board, Scanner scanner){
        //Checking the amount of available fields
        var amount = 0;

        for (int i = 1; i < board.length; i++) {
            if (board[i].getOwnedBy() == -1 && board[i].getColor() != null)
            amount++;
        }

        if (amount == 0) { //There are no available fields
            System.out.println("Der er ingen ledige felter, saa du skal vaelge en ejendom ejet af en anden spiller og koebe det fra dem.");

            //Find available fields that are not owned by the player
            var feltString = "0";

            for (var i = 1; i < board.length; i++) {
                if (board[i].getOwnedBy() != this.getPlayerNumber() && board[i].getColor() != null) {
                    System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy() - 1].getFigure());
                    feltString += "," + i;
                }
            }
            
            var feltStringArray = feltString.split(",");

            var felter = new int[feltStringArray.length - 1];

            for (var i = 1; i < feltStringArray.length - 1; i++) {
                felter[i - 1] = Integer.parseInt(feltStringArray[i]);
            }

            var choice = 0;
            
            //Getting a choice from the player
            while (true) {
                var isIn = false;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                }
                catch (Exception e) { //Player input a non integer
                    System.out.println("Du skal taste en af tallene: ");
    
                    for (var i : felter) {
                        System.out.println((i + 1));
                    }
                }

                for (var i = 1; i < felter.length; i++) {
                    if (choice == felter[i]) {
                        isIn = true;
                        break;
                    }
                }

                if (isIn) //Player input a valid integer
                break;
                else { //Player input an integer that wasnt part of the choices
                    System.out.println("Du skal taste en af tallene: ");
    
                    for (var i : felter) {
                        System.out.println((i + 1));
                    }
                }
            }

            this.setPosition(choice);
            board[choice].buyOwnedField(players, this);
        }
        else { //There is one or more available fields and method proceeds as intended
            switch (this.getFigure()) {
                case "Bil":
                System.out.println("Nu skal du bruge dit chancekort, droene hen til dit oenskede felt og koebe det.");
                break;

                case "Skib":
                System.out.println("Nu skal du bruge dit chancekort, sejle hen til dit oenskede felt og koebe det.");
                break;

                case "Hund":
                System.out.println("Nu skal du bruge dit chancekort, hoppe hen til dit oenskede felt og koebe det.");
                break;

                case "Kat":
                System.out.println("Nu skal du bruge dit chancekort, liste hen til dit oenskede felt og koebe det.");
                break;
            }

            var felter = new int[amount];

            int choice = 0;

            //Noting down the available field numebers in an array
            for (int i = 1; i < board.length; i++) {
                if (board[i].getOwnedBy() == -1 && board[i].getColor() != null) {
                    felter[choice] = board[i].getFieldNumber();
                    choice++;
                }
            }

            // Print available fields
            System.out.println("Ledige felter at vaelge mellem:" + System.lineSeparator());

            for (int i = 0; i < felter.length; i++) {
                for (var j = 1; j < board.length; j++) {
                    if (board[j].getFieldNumber() == felter[i]) {
                        System.out.println("Felt " + (felter[i] + 1) + ": " + board[j].getFieldDescription());
                        break;
                    }
                }
            }

            choice = 0;

            //Getting a choice from the player
            while (true) {
                var isIn = false;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                }
                catch (Exception e) { //Player input a non integer
                    System.out.println("Du skal taste en af tallene: " + System.lineSeparator());
    
                    for (int i = 0; i < felter.length; i++) {
                        for (var j = 1; j < board.length; j++) {
                            if (board[j].getFieldNumber() == felter[i]) {
                                System.out.println("Felt " + (felter[i] + 1) + ": " + board[j].getFieldDescription());
                                break;
                            }
                        }
                    }   
                }

                for (var i = 0; i < felter.length; i++) {
                    if (choice - 1 == felter[i]) {
                        isIn = true;
                        break;
                    }
                }

                if (isIn && choice >= 2 && choice <= 24) //Player input a valid integer
                break;
                else { //Player input an integer that wasnt part of the choices
                    System.out.println("Du skal taste en af tallene: " + System.lineSeparator());
                    for (int i = 0; i < felter.length; i++) {
                        for (var j = 1; j < board.length; j++) {
                            if (board[j].getFieldNumber() == felter[i]) {
                                System.out.println("Felt " + (felter[i] + 1) + ": " + board[j].getFieldDescription());
                                break;
                            }
                        }
                    }
                }
            }

            this.setPosition(choice - 1);
            board[choice].buyField(players, this);
        }

        this.setHasFigureCard(false);
    }

    public void getOutOfJail() {
        if (this.getIsJailed()) { //Player is jailed
            if (this.getHasJailCard()) { //Player has get out of prison card
                System.out.println("Du var faengslet men du brugte dit faengselskort til at slippe ud!");
                this.unJail();
            }
            else { //Player gets rekt
                System.out.println("Du var faengslet og skulle betale 1M for at komme ud!");
                this.withdraw(1);
                this.unJail();
            }
        }
    }
}
