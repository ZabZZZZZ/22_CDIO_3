import java.util.Scanner;

class FigureChecker {
    public static void setFigures(Player player, int n, Figure fig, Scanner s) {
        var figures = fig;
        var isValidNum = false;
        var choice = 0;
        
        System.out.println("Spiller " + (n + 1) + ", vaelg en figur: " + System.lineSeparator() + "Tast: " + System.lineSeparator());

        for (var i = 0; i < 4; i++) {
            if (figures.getTaken(i) == false) {
                System.out.println(figures.getFigNum(i) + " for " + figures.getFigure(i));
            }
        }

        System.out.println("");

        while (!isValidNum) {
            choice = Integer.parseInt(s.nextLine());

            if (choice < 1 || choice > 4) {
                System.out.println(choice + " er ikke et gyldigt valg");
            }
            else if (figures.getTaken(choice - 1) == false) {
                isValidNum = true;
            }
            else {
                System.out.println(choice + " er allerede taget!!");
            }
        }

        figures.setTaken(choice - 1);

        player.setFigure(figures.getFigure(choice - 1));
    }
}

class Figure{
    String[] figures;
    int[] figNum;
    boolean[] isTaken;

    public Figure() {
        figures = new String[] {"Bil", "Skib", "Hund", "Kat"};
        figNum = new int[] {1, 2, 3, 4};
        isTaken = new boolean[] {false, false, false, false};
    }

    public String getFigure(int n) {
        return this.figures[n];
    }

    public boolean getTaken(int n) {
        return this.isTaken[n];
    }

    public int getFigNum(int n) {
        return this.figNum[n];
    }
    public void setTaken(int n) {
        this.isTaken[n] = true;
    }

}