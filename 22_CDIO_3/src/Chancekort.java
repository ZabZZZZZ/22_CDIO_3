import java.util.Scanner;

class Chancekort {
    
    public void fremTilStart(Player player){
        System.out.println("Du har trukket kortet: Frem til start." + System.lineSeparator() + "Du bliver rykket til START, og modtager 2M.");
        player.setPosition(0);
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

    public void spistForMeget(Player player) {
        System.out.println("Du trak kortet: spist for meget slik. Du skal betale 2M til banken");
        player.withdraw(2);
    }

    public void foedselsdag(Player[] players, Player player) {
        System.out.println("Du trak kortet: det er din foedselsdag. Alle skal give dig 1M");

        for (var i = 0; i < players.length; i++) {
            if (players[i] == player)
            continue;
            else {
                players[i].withdraw(1);
            }
        }

        player.deposit(players.length - 1);
    }

    public void lavetAlleLektier(Player player) {
        System.out.println("Du trak kortet: du har lavet alle dine lektier. Du modtager 2M");
        player.deposit(2);
    }

    public void enFremEllerOm(Player[] players, Player player, Felt[] board, Scanner scanner){
        System.out.println("Du trak kortet: ryk en frem eller tag et chancekort mere.");
        int choice = 0;

        System.out.println("Tryk 1 for et rykke et felt frem eller tryk 2 for at trække endnu et chancekort");

        System.out.println("Det naeste felt er " + board[player.getCurrentField() + 1].getFieldNumber() + ": " + board[player.getCurrentField() + 1].getFieldDescription());
        
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Du skal taste 1 for at rykke frem eller 2 for at traekke endnu et chancekort");
                continue;
            }

            if (choice == 1 || choice == 2)
            break;
        }
        
        //Spilleren rykker en frem
        if(choice == 1){
            player.move(1);
        }
        else { //Spilleren faar et nyt chancekort
            ChancekortCaller.chooseRandomCard(players, player, board, scanner);
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

    public void enRandom(Player[] players, Player player, Felt[] board, String farve, Scanner scanner) {
        var felter = new int[2];
        var j = 0;
        var choice = 0;

        System.out.println("Du trak kortet: " + farve + ", hvilket betyder at du skal vaelge et felt den farve." + System.lineSeparator());

        // Print available fields
        System.out.println("Alle " + farve + " felter:" + System.lineSeparator());
        for (int i = 1; i < board.length; i++) {
            if (board[i].getColor().equals(farve)) {
                if (board[i].getOwnedBy() == -1)
                System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription());
                else
                System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy()].getFigure());
                
                felter[j] = i;
                j++;
            }
        }

        System.out.println("Tast et af tallene for at flytte til det felt.");

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Du skal taste en af tallene: ");

                for (var i : felter) {
                    System.out.println((i + 1));
                }

                System.out.println("");
            }

            if (choice == felter[0] || choice == felter[1])
            break;
            else {
                System.out.println("Du skal taste en af tallene: ");

                for (var i : felter) {
                    System.out.println((i + 1));
                }

                System.out.println("");
            }
        }

        var actualChoice = choice - 1;

        // tjek om feltet er ledigt
        if (board[actualChoice].getOwnedBy() == -1) {
            // feltet er ledigt
            player.setPosition(choice);
            board[actualChoice].setOwned(player.getPlayerNumber());

            System.out.println("Du valgte " + choice + " og fik feltet gratis");

            board[actualChoice].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[actualChoice].getOwnedBy();
            player.setPosition(choice);

            int rent = board[actualChoice].getPrice();

            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Du valgte " + choice + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
        }
    }
        
    public void enEllerAndenRandom(Player[] players, Player player, Felt[] board, String farve1, String farve2, Scanner scanner) {
        var felter = new int[4];
        var j = 0;
        var choice = 0;

        System.out.println("Du trak kortet: " + farve1 + " eller " + farve2 + ", hvilket betyder at du skal vaelge et felt med en af de to farver.");

        // Print available fields
        System.out.println("Alle " + farve1 + " og " + farve2 + " felter:");
        for (int i = 1; i < board.length; i++) {
            if ((board[i].getColor().equals(farve1) || board[i].getColor().equals(farve2))) {
                if (board[i].getOwnedBy() == -1)
                System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription());
                else
                System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy() - 1].getFigure());
                
                felter[j] = i;
                j++;
            }
        }

        System.out.println(System.lineSeparator() + "Tast et af tallene for at flytte til det felt.");

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Du skal taste en af tallene: ");

                for (var i : felter) {
                    System.out.println((i + 1));
                }
            }

            if (choice == felter[0] || choice == felter[1] || choice == felter[2] || choice == felter[3])
            break;
            else {
                System.out.println("Du skal taste en af tallene: ");

                for (var i : felter) {
                    System.out.println((i + 1));
                }
            }
        }

        System.out.println("");

        var actualChoice = choice - 1;

        // tjek om feltet er ledigt
        if (board[actualChoice].getOwnedBy() == -1) {
            // feltet er ledigt
            player.setPosition(choice);
            board[actualChoice].setOwned(player.getPlayerNumber());

            System.out.println("Du valgte " + choice + " og fik feltet gratis");

            board[actualChoice].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[actualChoice].getOwnedBy();
            player.setPosition(choice);

            int rent = board[actualChoice].getPrice();

            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Du valgte " + choice + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
        }
    }

    public void fremTilSkaterpark(Player[] players, Player player, Felt[] board){
        System.out.println("Du trak kortet: ryk frem til skaterparken");

        player.setPosition(10);

        // tjek om feltet er ledigt
        if (board[10].getOwnedBy() == -1) {
            // feltet er ledigt
            board[10].setOwned(player.getPlayerNumber());

            System.out.println("Da feltet ikke er ejet af nogen, fik du feltet gratis!");

            board[10].colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[10].getOwnedBy();
            player.setPosition(10);

            int rent = board[10].getPrice();

            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Da skaterparken er ejet af " + players[owner].getFigure() + ", skulle du betale " + rent + "M til ejeren.");
        }
    }
    
    public void fængselskort(Player player){
        System.out.println("Du har trukket et fængselskort! Du løslades fra fængslet uden omkostninger, behold det til du får brug for kortet");
        player.setHasJailCard(true);
    }
    
    // public void BlåEllerpink(Player[] players, Player player, Felt[] board, Scanner scanner) {
    //     System.out.println("Du trak kortet: '");
        
    //     // Print available blue and pink fields
    //     System.out.println("Alle blå og pink felter:");
    //     for (int i = 1; i < board.length; i++) {
    //         if ((board[i].getColor().equals("blå") || board[i].getColor().equals("pink"))) {
    //             System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
    //         }
    //     }
    
    //     int destination;
    //     do {
    //         System.out.println("Enter the field number where you want to move (1-23):");
    //         destination = scanner.nextInt();
    //     } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("blå") || board[destination].getColor().equals("pink")));
    
    //     // tjek om feltet er ledigt
    //     if (board[destination].getOwnedBy()==-1) {
    //         // feltet er ledigt
    //         player.setPosition(destination);
    //         board[destination].setOwned(player.getPlayerNumber());
    //         System.out.println("Du valgte " + destination + " og fik feltet gratis");
    //         board[destination].colormatch(board); // Tjek om vi har et colormatch nu
    //     } else {
    //         // feltet er ejet
    //         int owner = board[destination].getOwnedBy();
    //         player.setPosition(destination);
    //         int rent = board[destination].getPrice();
    //         player.withdraw(rent); // withdraw for at betale husleje
    //         players[owner - 1].deposit(rent);
    //         System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
    //     }
    // }

    // public void GrønEllerOrange(Player player, Felt[] board, Scanner scanner) {
    //     System.out.println("Du trak kortet: '");
        
    //     // vis mulige felter
    //     System.out.println("Available Blue and Pink Fields:");
    //     for (int i = 1; i < board.length; i++) {
    //         if ((board[i].getColor().equals("orange") || board[i].getColor().equals("grøn"))) {
    //             System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
    //         }
    //     }
    //     int destination;
    //     do {
    //         System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
    //         destination = scanner.nextInt();
    //     } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("blå") || board[destination].getColor().equals("pink")));
    
    //     // tjek om feltet er ledigt
    //     if (board[destination].getOwned()==-1) {
    //         // feltet er ledigt
    //         player.setPosition(destination);
    //         board[destination].setOwned(player.getNumber());
    //         System.out.println("Du valgte " + destination + " og fik feltet gratis");
    //         board[destination].colormatch(board); // Tjek om vi har et colormatch nu
    //     } else {
    //         // feltet er ejet
    //         int owner = board[destination].getOwned();
    //         player.setPosition(destination);
    //         int rent = board[destination].getPrice();
    //         player.withdraw(rent); // withdraw for at betale husleje
    //         players[owner - 1].deposit(rent);
    //         System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
    //     }
    // }
        
    // public void LyselåEllerRød(Player player, Felt[] board, Scanner scanner) {
    //     System.out.println("Du trak kortet: Lyseblå eller Rød, vælg venligst et lyseblåt eller rødt felt, hvis feltet er ledigt får du det gratis, ellers skal du betale husleje til ejeren");
        
    //     // vis mulige felter
    //     System.out.println("Lyseblå og røde felter");
    //     for (int i = 1; i < board.length; i++) {
    //         if ((board[i].getColor().equals("lyseblå") || board[i].getColor().equals("rød"))) {
    //             System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
    //         }
    //     }
        
    //     int destination;
    //     do {
    //         System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
    //         destination = scanner.nextInt();
    //     } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("lyseblå") || board[destination].getColor().equals("rød")));
        
    //     // tjek om feltet er ledigt
    //     if (board[destination].getOwned()==-1) {
    //         // feltet er ledigt
    //         player.setPosition(destination);
    //         board[destination].setOwned(player.getNumber());
    //         System.out.println("Du valgte " + destination + " og fik feltet gratis");
    //         board[destination].colormatch(board); // Tjek om vi har et colormatch nu
    //     } else {
    //         // feltet er ejet
    //         int owner = board[destination].getOwned();
    //         player.setPosition(destination);
    //         int rent = board[destination].getPrice();
    //         player.withdraw(rent); // withdraw for at betale husleje
    //         players[owner - 1].deposit(rent);
    //         System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
    //     }
    // }
        
    // public void BrunEllerGul(Player player, Felt[] board, Scanner scanner) {
    //     System.out.println("Du trak kortet: Lyseblå eller Rød, vælg venligst et lyseblåt eller rødt felt, hvis feltet er ledigt får du det gratis, ellers skal du betale husleje til ejeren");
        
    //     // vis mulige felter
    //     System.out.println("Brune og Gule felter");
    //     for (int i = 1; i < board.length; i++) {
    //         if ((board[i].getColor().equals("brun") || board[i].getColor().equals("gul"))) {
    //             System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
    //         }
    //     }
        
    //     int destination;
    //     do {
    //         System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
    //         destination = scanner.nextInt();
    //     } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("brun") || board[destination].getColor().equals("gul")));
        
    //     // tjek om feltet er ledigt
    //     if (board[destination].getOwned()==-1) {
    //         // feltet er ledigt
    //         player.setPosition(destination);
    //         board[destination].setOwned(player.getNumber());
    //         System.out.println("Du valgte " + destination + " og fik feltet gratis");
    //         board[destination].colormatch(board); // Tjek om vi har et colormatch nu
    //     } else {
    //         // feltet er ejet
    //         int owner = board[destination].getOwned();
    //         player.setPosition(destination);
    //         int rent = board[destination].getPrice();
    //         player.withdraw(rent); // withdraw for at betale husleje
    //         players[owner - 1].deposit(rent);
    //         System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
    //     }
    // }
        
    // public void FremTilRød(Player player, Felt[] board, Scanner scanner) {
    //     System.out.println("Du trak kortet: frem til Rød, vælg venligst et rødt felt, hvis feltet er ledigt får du det gratis, ellers skal du betale husleje til ejeren");
        
    //     // vis mulige felter
    //     System.out.println("Røde felter");
    //     for (int i = 1; i < board.length; i++) {
    //         if (board[i].getColor().equals("rød")) {
    //             System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
    //         }
    //     }
        
    //     int destination;
    //     do {
    //         System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
    //         destination = scanner.nextInt();
    //     } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("rød")));
        
    //     // tjek om feltet er ledigt
    //     if (board[destination].getOwned()==-1) {
    //         // feltet er ledigt
    //         player.setPosition(destination);
    //         board[destination].setOwned(player.getNumber());
    //         System.out.println("Du valgte " + destination + " og fik feltet gratis");
    //         board[destination].colormatch(board); // Tjek om vi har et colormatch nu
    //     } else {
    //         // feltet er ejet
    //         int owner = board[destination].getOwned();
    //         player.setPosition(destination);
    //         int rent = board[destination].getPrice();
    //         player.withdraw(rent); // withdraw for at betale husleje
    //         players[owner - 1].deposit(rent);
    //         System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
    //     }
    // }
        
    // public void FremTilLyseblå(Player player, Felt[] board, Scanner scanner) {
    //     System.out.println("Du trak kortet: frem til lyseblå, vælg venligst et lyseblå felt, hvis feltet er ledigt får du det gratis, ellers skal du betale husleje til ejeren");
        
    //     // vis mulige felter
    //     System.out.println("Lyseblå felter");
    //     for (int i = 1; i < board.length; i++) {
    //         if (board[i].getColor().equals("rød")) {
    //             System.out.println("Felt " + i + ": " + board[i].getFieldDescription());
    //         }
    //     }
        
    //     int destination;
    //     do {
    //         System.out.println("Indtast feltnummeret du skal over til, Husk at feltet skal være på listen");
    //         destination = scanner.nextInt();
    //     } while (destination < 1 || destination > 23 || !(board[destination].getColor().equals("rød")));
        
    //     // tjek om feltet er ledigt
    //     if (board[destination].getOwned()==-1) {
    //         // feltet er ledigt
    //         player.setPosition(destination);
    //         board[destination].setOwned(player.getNumber());
    //         System.out.println("Du valgte " + destination + " og fik feltet gratis");
    //         board[destination].colormatch(board); // Tjek om vi har et colormatch nu
    //     } else {
    //         // feltet er ejet
    //         int owner = board[destination].getOwned();
    //         player.setPosition(destination);
    //         int rent = board[destination].getPrice();
    //         player.withdraw(rent); // withdraw for at betale husleje
    //         players[owner - 1].deposit(rent);
    //         System.out.println("Du valgte " + destination + " ejet af " + owner + " og betalte husleje: " + rent + "m.");
    //     }
    // }
    
}

