import java.io.IOException;

class Introduktion {
    public static void intro() throws IOException {
        var fileName = "introduction.txt";
        var introFile = new java.io.File(fileName);

        try {
            var s = new java.util.Scanner(introFile);

            while (s.hasNextLine()) {
                var nextLine = s.nextLine();
                System.out.println(nextLine);
            }

            s.close();
        }
        catch (IOException e) {
            System.out.println("Der gik noget galt! " + e.getMessage());
        }
        

        // System.out.println("IOOuterActive praesenterer: Monopoly Junior");
        // System.out.println("Velkommen til dette spil!" + System.lineSeparator());
        // System.out.println("I dette spil vil du deltage i en duel mod en anden spiller.");
        // System.out.println("Hver spiller kaster to terninger og lander paa forskellige felter med numrene fra 2 til 12.");
        // System.out.println("Hvert felt har en positiv eller negativ effekt paa din pengebeholdning.");
        // System.out.println("Hver spiller begynder med 1000 points");
        // System.out.println("Maalet er at naa 3000 points for at vinde spillet.");
        // System.out.println(System.lineSeparator() + "Lad spillet begynde!" + System.lineSeparator());
    }
}
