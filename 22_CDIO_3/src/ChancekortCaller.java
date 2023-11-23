import java.util.Random;

class ChancekortCaller {
    public static void chooseRandomCard(Player[] players, Player player, Felt[] board, java.util.Scanner scanner) {
        var rand = new Random();
        var c = new Chancekort();

        switch (rand.nextInt(20)) {
            case 0:
            c.fremTilStart(player);
            break;

            case 1:
            c.enEllerAndenRandom(players, player, board, "moerkeblaa", "pink", scanner);
            break;

            case 2:
            c.enEllerAndenRandom(players, player, board, "orange", "groen", scanner);
            break;

            case 3:
            c.enEllerAndenRandom(players, player, board, "roed", "lyseblaa", scanner);
            break;

            case 4:
            c.enEllerAndenRandom(players, player, board, "brun", "gul", scanner);
            break;

            case 5:
            c.enRandom(players, player, board, "orange", scanner);
            break;

            case 6:
            c.enRandom(players, player, board, "roed", scanner);
            break;

            case 7:
            c.enFremEllerOm(players, player, board, scanner);
            break;

            case 8:
            c.femFrem(players, player, board, scanner);
            break;

            case 9:
            c.spistForMeget(player);
            break;

            case 10:
            c.foedselsdag(players, player);
            break;

            case 11:
            c.fremTilSkaterpark(players, player, board);
            break;

            case 12:
            c.fremTilStrand(player);
            break;

            case 13:
            c.lavetAlleLektier(player);
            break;

            case 14:
            c.figurKort(players, player, board, scanner, "Bil");
            break;

            case 15:
            c.figurKort(players, player, board, scanner, "Skib");
            break;

            case 16:
            c.figurKort(players, player, board, scanner, "Hund");
            break;

            case 17:
            c.figurKort(players, player, board, scanner, "Kat");
            break;

            case 18:
            c.faengselskort(player);
            break;

            case 19:
            c.enRandom(players, player, board, "lyseblaa", scanner);
        }
    }
}