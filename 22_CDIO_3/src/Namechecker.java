import java.util.Scanner;

class Namechecker {
    public static String checkName(int n, Scanner s) {
        boolean isNameEmpty = true;
        var p = "";
        
        System.out.print("Spiller " + n + ", indtast dit navn: ");
        
        while (isNameEmpty) {
            p = s.nextLine();

            if (p.isEmpty() == false) {
                break;
            }

            System.out.println("Spilleren skal have et navn. Proev igen.");
        }
        return p;
    }

    public static void isNameSame(Player p1, Player p2) {
        if (p1.getName().equals(p2.getName())) {
            p1.setName("Spiller 1");
            p2.setName("Spiller 2");

            System.out.println(System.lineSeparator() + "Du har skrevet samme navn ind for begge spillere, saa de bliver aendret til Spiller 1 og Spiller 2");
        }
    }
}

