import java.util.Scanner;

class Chancekort {
    
    public void fremTilStart(Player player){
        player.setPosition(1);
        player.deposit(2);
    }
    public void femFrem(Player player, Scanner scanner){
        int felter = 0;
        System.out.println("Du har trukket chancekortet 'fem felter frem!'. indtast et tal fra 1-5 i terminalen");
        felter = scanner.nextInt();
        if (felter > 5){
            felter = 5;
        }
        else if (felter <= 1) {
            felter = 1;
        }
        
        if(player.getCurrentField() + felter <=23){
            player.setPosition(player.getCurrentField()+felter);
        }else{
            player.setPosition(player.getCurrentField()+felter-23);
        }
    }

    public void fremEllerOm(Player player, Scanner scanner){
        int choice = 0;
        System.out.println("Tryk 1 for et rykke et felt frem eller tryk 2 for at trække endnu et chancekort");
        choice = scanner.nextInt();
        if(choice==1){
                player.setPosition(player.getCurrentField()+1);
            }
        
        else{
            //simulatelanding på chancekort felt
        }
    }

    public void fremTilStrand(Player player){
        player.setPosition(23);
    }

    public void Kør(Player player, Felt[] board, Scanner scanner) {
        System.out.println("You drew the chance card: 'Next turn, you have to drive to any available field and buy it.'");
    
        // Bruger har nu et kort
        player.setHasFigureCard(true);
        System.out.println("Næste runde skal du vælge et felt at køre over til.");
    }
        
    public void BlåEllerLilla(Player player, Felt[] board, Scanner scanner) {
        System.out.println("Du trak kortet: '");
        
        // Print available blue and pink fields
        System.out.println("Alle blå og lilla felter:");
        for (int i = 1; i < board.length; i++) {
            if ((board[i].getColor().equals("blå") || board[i].getColor().equals("lilla"))) {
                System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
            }
        }
    
        int destination;
        do {
            System.out.println("Enter the field number where you want to move (1-23):");
            destination = scanner.nextInt();
        } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("blå") || board[destination].getColor().equals("lilla")));
    
        // tjek om feltet er ledigt
        if (board[destination].getOwnedBy()==-1) {
            // feltet er ledigt
            player.setPosition(destination);
            board[destination].setOwned(player.getPlayerNumber());
            System.out.println("Du valgte " + destination + " og fik feltet gratis");
            board[destination].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[destination].getOwnedBy();
            player.setPosition(destination);
            int rent = board[destination].getPrice();
            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
        }
    }

    public void GrønEllerOrange(Player player, Felt[] board, Scanner scanner) {
        System.out.println("Du trak kortet: '");
        
        // vis mulige felter
        System.out.println("Available Blue and Pink Fields:");
        for (int i = 1; i < board.length; i++) {
            if ((board[i].getColor().equals("orange") || board[i].getColor().equals("grøn"))) {
                System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
            }
        }
        int destination;
        do {
            System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
            destination = scanner.nextInt();
        } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("blå") || board[destination].getColor().equals("lilla")));
    
        // tjek om feltet er ledigt
        if (board[destination].getOwned()==-1) {
            // feltet er ledigt
            player.setPosition(destination);
            board[destination].setOwned(player.getNumber());
            System.out.println("Du valgte " + destination + " og fik feltet gratis");
            board[destination].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[destination].getOwned();
            player.setPosition(destination);
            int rent = board[destination].getPrice();
            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
        }
    }
        
    public void LyselåEllerRød(Player player, Felt[] board, Scanner scanner) {
        System.out.println("Du trak kortet: Lyseblå eller Rød, vælg venligst et lyseblåt eller rødt felt, hvis feltet er ledigt får du det gratis, ellers skal du betale husleje til ejeren");
        
        // vis mulige felter
        System.out.println("Lyseblå og røde felter");
        for (int i = 1; i < board.length; i++) {
            if ((board[i].getColor().equals("lyseblå") || board[i].getColor().equals("rød"))) {
                System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
            }
        }
        
        int destination;
        do {
            System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
            destination = scanner.nextInt();
        } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("lyseblå") || board[destination].getColor().equals("rød")));
        
        // tjek om feltet er ledigt
        if (board[destination].getOwned()==-1) {
            // feltet er ledigt
            player.setPosition(destination);
            board[destination].setOwned(player.getNumber());
            System.out.println("Du valgte " + destination + " og fik feltet gratis");
            board[destination].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[destination].getOwned();
            player.setPosition(destination);
            int rent = board[destination].getPrice();
            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
        }
    }
        
    public void BrunEllerGul(Player player, Felt[] board, Scanner scanner) {
        System.out.println("Du trak kortet: Lyseblå eller Rød, vælg venligst et lyseblåt eller rødt felt, hvis feltet er ledigt får du det gratis, ellers skal du betale husleje til ejeren");
        
        // vis mulige felter
        System.out.println("Brune og Gule felter");
        for (int i = 1; i < board.length; i++) {
            if ((board[i].getColor().equals("brun") || board[i].getColor().equals("gul"))) {
                System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
            }
        }
        
        int destination;
        do {
            System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
            destination = scanner.nextInt();
        } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("brun") || board[destination].getColor().equals("gul")));
        
        // tjek om feltet er ledigt
        if (board[destination].getOwned()==-1) {
            // feltet er ledigt
            player.setPosition(destination);
            board[destination].setOwned(player.getNumber());
            System.out.println("Du valgte " + destination + " og fik feltet gratis");
            board[destination].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[destination].getOwned();
            player.setPosition(destination);
            int rent = board[destination].getPrice();
            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
        }
    }
        
    public void FremTilRød(Player player, Felt[] board, Scanner scanner) {
        System.out.println("Du trak kortet: frem til Rød, vælg venligst et rødt felt, hvis feltet er ledigt får du det gratis, ellers skal du betale husleje til ejeren");
        
        // vis mulige felter
        System.out.println("Røde felter");
        for (int i = 1; i < board.length; i++) {
            if (board[i].getColor().equals("rød")) {
                System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
            }
        }
        
        int destination;
        do {
            System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
            destination = scanner.nextInt();
        } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("rød")));
        
        // tjek om feltet er ledigt
        if (board[destination].getOwned()==-1) {
            // feltet er ledigt
            player.setPosition(destination);
            board[destination].setOwned(player.getNumber());
            System.out.println("Du valgte " + destination + " og fik feltet gratis");
            board[destination].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[destination].getOwned();
            player.setPosition(destination);
            int rent = board[destination].getPrice();
            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
        }
    }
        
    public void FremTilLyseblå(Player player, Felt[] board, Scanner scanner) {
        System.out.println("Du trak kortet: frem til lyseblå, vælg venligst et lyseblå felt, hvis feltet er ledigt får du det gratis, ellers skal du betale husleje til ejeren");
        
        // vis mulige felter
        System.out.println("Lyseblå felter");
        for (int i = 1; i < board.length; i++) {
            if (board[i].getColor().equals("rød")) {
                System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
            }
        }
        
        int destination;
        do {
            System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
            destination = scanner.nextInt();
        } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("rød")));
        
        // tjek om feltet er ledigt
        if (board[destination].getOwned()==-1) {
            // feltet er ledigt
            player.setPosition(destination);
            board[destination].setOwned(player.getNumber());
            System.out.println("Du valgte " + destination + " og fik feltet gratis");
            board[destination].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[destination].getOwned();
            player.setPosition(destination);
            int rent = board[destination].getPrice();
            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
        }
    }
        
    public void fremTilPark(Player player){
        player.setPosition(10);
    }
    /*
    public void fængselskort(Player player){
        System.out.println("Du har trukket et fængselskort! Du løslades fra fængslet uden omkostninger, Behold det til du får brug for kortet");
        player.fængselskort = true;
    }*/
    
    

}

