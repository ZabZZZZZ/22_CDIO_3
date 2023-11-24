import java.util.Scanner;

class Chancekort {
    
    public void fremTilStart(Player player){
        System.out.println("Du har trukket kortet: Frem til start." + System.lineSeparator() + "Du bliver rykket til START, og modtager 2M.");
        player.setPosition(0);
        player.deposit(2);
    }

    //Ryk fem felter frem
    public void femFrem(Player[] players, Player player, Felt[] board, Scanner scanner){
        int choice = 0;
        var felter = new int[5];
        var j = 0;
        var isIn = false;

        System.out.println("Du har trukket chancekortet 'fem felter frem!'. Du skal indtaste et af de naeste fem felters tal flytte til det felt." + System.lineSeparator() + "De naeste fem felter er:" + System.lineSeparator());

        for (var i = player.getCurrentField() + 1; i < player.getCurrentField() + 6; i++) {
            var k = i % 23;

            if (k != 0) { //It is not the final field 
                if (board[k].getOwnedBy() == -1)
                System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription());
                else if (board[k].getOwnedBy() == player.getPlayerNumber())
                System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription() + ", ejet af dig selv");
                else
                System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription() + ", ejet af " + players[board[k].getOwnedBy() - 1].getFigure());
                
                felter[j] = k;
                j++;   
            }
            else { //It is the final field, so a special case is needed
                if (board[23].getOwnedBy() == -1)
                System.out.println("Felt 24, " + board[23].getFieldDescription());
                else if (board[23].getOwnedBy() == player.getPlayerNumber())
                System.out.println("Felt 24, " + board[23].getFieldDescription() + ", ejet af dig selv");
                else
                System.out.println("Felt 24, " + board[23].getFieldDescription() + ", ejet af " + players[board[23].getOwnedBy() - 1].getFigure());

                felter[j] = 23;
                j++;
            }
        }

        while (!isIn) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println(System.lineSeparator() + "Du skal indtaste et af de naeste fem felters tal. De naeste fem felter er:");
                
                for (var i = player.getCurrentField() + 1; i < player.getCurrentField() + 6; i++) {
                    var k = i % 23;

                    if (k != 0) { //It is not the final field 
                        if (board[k].getOwnedBy() == -1)
                        System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription());
                        else if (board[k].getOwnedBy() == player.getPlayerNumber())
                        System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription() + ", ejet af dig selv");
                        else
                        System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription() + ", ejet af " + players[board[k].getOwnedBy() - 1].getFigure());
                    }
                    else { //It is the final field, so a special case is needed
                        if (board[23].getOwnedBy() == -1)
                        System.out.println("Felt 24, " + board[23].getFieldDescription());
                        else if (board[23].getOwnedBy() == player.getPlayerNumber())
                        System.out.println("Felt 24, " + board[23].getFieldDescription() + ", ejet af dig selv");
                        else
                        System.out.println("Felt 24, " + board[23].getFieldDescription() + ", ejet af " + players[board[23].getOwnedBy() - 1].getFigure());
                    }
                }
                continue;
            }

            for (var i = 0; i < felter.length; i++) {
                if (choice - 1 == felter[i]) {
                    isIn = true;
                    break;
                }
            }

            if (!isIn) {
                System.out.println(System.lineSeparator() + "Du skal indtaste et af de naeste fem felters tal. De naeste fem felter er:");
                
                for (var i = player.getCurrentField() + 1; i < player.getCurrentField() + 6; i++) {

                    var k = i % 23;

                    if (k != 0) { //It is not the final field 
                        if (board[k].getOwnedBy() == -1)
                        System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription());
                        else if (board[k].getOwnedBy() == player.getPlayerNumber())
                        System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription() + ", ejet af dig selv");
                        else
                        System.out.println("Felt " + (k + 1) + ", " + board[k].getFieldDescription() + ", ejet af " + players[board[k].getOwnedBy() - 1].getFigure());
                    }
                    else { //It is the final field, so a special case is needed
                        if (board[23].getOwnedBy() == -1)
                        System.out.println("Felt 24, " + board[23].getFieldDescription());
                        else if (board[23].getOwnedBy() == player.getPlayerNumber())
                        System.out.println("Felt 24, " + board[23].getFieldDescription() + ", ejet af dig selv");
                        else
                        System.out.println("Felt 24, " + board[23].getFieldDescription() + ", ejet af " + players[board[23].getOwnedBy() - 1].getFigure());
                    }
                }
            }
        }

        player.setPosition(choice - 1);
        System.out.println("Du har rykket til felt " + choice + ", " + board[choice - 1].getFieldDescription());
    }

    //Spist for meget
    public void spistForMeget(Player player) {
        System.out.println("Du trak kortet: spist for meget slik. Du skal betale 2M til banken");
        player.withdraw(2);
    }

    //Foedselsdag
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

    //Lavet alle lektier
    public void lavetAlleLektier(Player player) {
        System.out.println("Du trak kortet: du har lavet alle dine lektier. Du modtager 2M");
        player.deposit(2);
    }

    //Ryk en frem eller tag et nyt chancekort
    public void enFremEllerOm(Player[] players, Player player, Felt[] board, Scanner scanner){
        System.out.println("Du trak kortet: ryk en frem eller tag et chancekort mere.");
        int choice = 0;

        System.out.println("Tryk 1 for et rykke et felt frem eller tryk 2 for at traekke endnu et chancekort");

        if (board[player.getCurrentField() + 1].getOwnedBy() == player.getPlayerNumber())
        System.out.println("Det naeste felt er " + board[player.getCurrentField() + 1].getFieldNumber() + ": " + board[player.getCurrentField() + 1].getFieldDescription() + " ejet af dig selv.");
        else if (board[player.getCurrentField() + 1].getOwnedBy() != -1)
        System.out.println("Det naeste felt er " + board[player.getCurrentField() + 1].getFieldNumber() + ": " + board[player.getCurrentField() + 1].getFieldDescription() + " ejet af " + board[player.getCurrentField()].getOwnedBy() + ".");
        else
        System.out.println("Det naeste felt er " + board[player.getCurrentField() + 1].getFieldNumber() + ": " + board[player.getCurrentField() + 1].getFieldDescription() + ".");

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

    //Frem til strand
    public void fremTilStrand(Player player) {
        System.out.println("Du trak kortet: Frem til strand." + System.lineSeparator() + "Du bliver rykket frem til stranden.");
        player.setPosition(23);
    }

    //Ryk frem til en farvet ejendom
    public void enRandom(Player[] players, Player player, Felt[] board, String farve, Scanner scanner) {
        var felter = new int[2];
        var j = 0;
        var choice = 0;

        System.out.println("Du trak kortet: " + farve + ", hvilket betyder at du skal vaelge et felt af den farve." + System.lineSeparator());

        // Print available fields
        System.out.println("Alle " + farve + " felter:" + System.lineSeparator());
        for (int i = 1; i < board.length; i++) {
            if (board[i].getColor() != null && board[i].getColor().equals(farve)) {
                if (board[i].getOwnedBy() == -1)
                System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription());
                else
                System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy() - 1].getFigure());
                
                felter[j] = i;
                j++;
                if (j >= 2)
                break;
            }
        }

        System.out.println("Tast et af tallene for at flytte til det felt.");

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Du skal taste et af tallene: ");

                for (int i = 1; i < board.length; i++) {
                    if ((board[i].getColor() != null && board[i].getColor().equals(farve))) {
                        if (board[i].getOwnedBy() == -1)
                        System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription());
                        else
                        System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy() - 1].getFigure());
                    }
                }

                System.out.println("");
            }

            if (choice - 1 == felter[0] || choice - 1 == felter[1])
            break;
            else {
                System.out.println("Du skal taste en af tallene: ");

                for (int i = 1; i < board.length; i++) {
                    if ((board[i].getColor() != null && board[i].getColor().equals(farve))) {
                        if (board[i].getOwnedBy() == -1)
                        System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription());
                        else
                        System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy() - 1].getFigure());
                    }
                }

                System.out.println("");
            }
        }

        var actualChoice = choice - 1;

        // tjek om feltet er ledigt
        if (board[actualChoice].getOwnedBy() == -1) {
            // feltet er ledigt
            player.setPosition(actualChoice);
            board[actualChoice].setOwnedBy(player.getPlayerNumber());

            System.out.println("Du valgte " + choice + " og fik feltet gratis");

            Felt.colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet af en selv
            if (board[actualChoice].getOwnedBy() == player.getPlayerNumber()) {
                System.out.println("Du valgte " + choice + ", men du ejer det allerede, saa der sker ikke noget.");
            }
            else { //Feltet er ejet af en anden
                int owner = board[actualChoice].getOwnedBy();
                player.setPosition(actualChoice);

                int rent = board[actualChoice].getPrice();

                player.withdraw(rent); // withdraw for at betale husleje
                players[owner - 1].deposit(rent);
                System.out.println("Du valgte " + choice + " ejet af " + players[owner - 1].getFigure() + " og betalte husleje: " + rent + "M.");
            }
        }
    }
    
    //Ryk frem til en farvet ejendom, men 2 farver
    public void enEllerAndenRandom(Player[] players, Player player, Felt[] board, String farve1, String farve2, Scanner scanner) {
        var felter = new int[4];
        var j = 0;
        var choice = 0;

        System.out.println("Du trak kortet: " + farve1 + " eller " + farve2 + ", hvilket betyder at du skal vaelge et felt med en af de to farver.");

        // Print available fields
        System.out.println("Alle " + farve1 + " og " + farve2 + " felter:");
        for (int i = 1; i < board.length; i++) {
            if ((board[i].getColor() != null && (board[i].getColor().equals(farve1) || board[i].getColor().equals(farve2)))) {
                if (board[i].getOwnedBy() == -1)
                System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription());
                else
                System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy() - 1].getFigure());
                
                felter[j] = i;
                j++;

                if (j >= 4)
                break;
            }
        }

        System.out.println(System.lineSeparator() + "Tast et af tallene for at flytte til det felt.");

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Du skal taste en af tallene: ");

                for (int i = 1; i < board.length; i++) {
                    if ((board[i].getColor() != null && (board[i].getColor().equals(farve1) || board[i].getColor().equals(farve2)))) {
                        if (board[i].getOwnedBy() == -1)
                        System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription());
                        else
                        System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy() - 1].getFigure());
                    }
                }

                continue;
            }

            if (choice - 1 == felter[0] || choice - 1 == felter[1] || choice - 1 == felter[2] || choice - 1 == felter[3])
            break;
            else {
                System.out.println("Du skal taste en af tallene: ");

                for (int i = 1; i < board.length; i++) {
                    if ((board[i].getColor() != null && (board[i].getColor().equals(farve1) || board[i].getColor().equals(farve2)))) {
                        if (board[i].getOwnedBy() == -1)
                        System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription());
                        else
                        System.out.println("Felt " + (i + 1) + ": " + board[i].getFieldDescription() + ", ejet af " + players[board[i].getOwnedBy() - 1].getFigure());
                    }
                }
            }
        }

        System.out.println("");

        var actualChoice = choice - 1;

        // tjek om feltet er ledigt
        if (board[actualChoice].getOwnedBy() == -1) {
            // feltet er ledigt
            player.setPosition(actualChoice);
            board[actualChoice].setOwnedBy(player.getPlayerNumber());

            System.out.println("Du valgte " + choice + ", " + board[actualChoice].getFieldDescription() + ", og fik feltet gratis");

            Felt.colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet af en selv
            if (board[actualChoice].getOwnedBy() == player.getPlayerNumber()) {
                System.out.println("Du valgte " + choice + ", " + board[actualChoice].getFieldDescription() + ", men du ejer det allerede, saa der sker ikke noget.");
                player.setPosition(actualChoice);
            }
            else {
                int owner = board[actualChoice].getOwnedBy();
                player.setPosition(actualChoice);

                int rent = board[actualChoice].getPrice();

                player.withdraw(rent); // withdraw for at betale husleje
                players[owner - 1].deposit(rent);
                System.out.println("Du valgte " + choice + " ejet af " + players[owner - 1].getFigure() + " og betalte husleje: " + rent + "M.");
            }
        }
    }

    //Ryk frem til skaterparken
    public void fremTilSkaterpark(Player[] players, Player player, Felt[] board){
        System.out.println("Du trak kortet: ryk frem til skaterparken");

        player.setPosition(10);

        // tjek om feltet er ledigt
        if (board[10].getOwnedBy() == -1) {
            // feltet er ledigt
            board[10].setOwnedBy(player.getPlayerNumber());

            System.out.println("Da feltet ikke er ejet af nogen, fik du feltet gratis!");

            Felt.colormatch(board); // Tjek om vi har et colormatch nu
        } else {
            // feltet er ejet
            int owner = board[10].getOwnedBy();
            player.setPosition(10);

            int rent = board[10].getPrice();

            player.withdraw(rent); // withdraw for at betale husleje
            players[owner - 1].deposit(rent);
            System.out.println("Da skaterparken er ejet af " + players[owner - 1].getFigure() + ", skulle du betale " + rent + "M til ejeren.");
        }
    }
    
    //Faengselskort
    public void faengselskort(Player player){
        System.out.println("Du har trukket et faengselskort! Du loeslades fra faengslet uden omkostninger, behold det til du faar brug for kortet");
        player.setHasJailCard(true);
    }

    //Figurkort
    public void figurKort(Player[] players, Player player, Felt[] board, Scanner scanner, String fig) {
        var playerNumber = -1;

        //Is figure the player himself
        if (fig.equals(player.getFigure())) {
            player.setHasFigureCard(true);
            System.out.println("Du har trukket et figurkort! Da figuren er din egen, traekker du et nyt chancekort denne tur." + System.lineSeparator() + "Tryk enter for at fortsaette.");
            var temp = scanner.nextLine();
            ChancekortCaller.chooseRandomCard(players, player, board, scanner);
            return;
        }
        
        //Does the figure even exist
        for (var i = 0; i < players.length; i++) {
            if (players[i].getFigure().equals(fig)) { //It does
                playerNumber = i;
                break;
            }
        }

        if (playerNumber == -1) { //It doesnt, so we pick another card
            System.out.println("Du har trukket et figurkort, men figuren " + fig + " er ikke taget af nogen, saa du traekker et nyt chancekort!" + System.lineSeparator() + "Tryk enter for at fortsaette.");
            var temp = scanner.nextLine();
            ChancekortCaller.chooseRandomCard(players, player, board, scanner);
        }
        else { //It does
            players[playerNumber].setHasFigureCard(true);
            System.out.println("Du har trukket et figurkort! Dette kort bliver givet til " + fig + " og du traekker et nyt chancekort!" + System.lineSeparator() + "Tryk enter for at fortsaette.");
            var temp = scanner.nextLine();
            ChancekortCaller.chooseRandomCard(players, player, board, scanner);
        }
    }
}

