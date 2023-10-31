import java.util.Scanner;

class SumChecker{
    public static void checkSum(int die1, int die2, Player player, Scanner s) {
        var sum = die1 + die2;

        //Create fields
        FeltListe[] fields = initalizeFields();

        for (int i = 0; i < fields.length; i++) {
            //Give extra turn
            if (sum == 10) {
                fields[8].landOnField(player);

                System.out.println("Tryk Enter for at fortsaette" + System.lineSeparator());

                var temp = s.nextLine();

                die1 = Dice.rollDice();
                die2 = Dice.rollDice();

                sum = die1 + die2;

                System.out.println(player.getName() + " slaar " + die1 + " og " + die2 + ", hvilket giver " + (die1 + die2));

                if (sum == 10) {
                    System.out.println("Du slog 10 igen, saa du bliver rykket til feltet nummer 12");
                    fields[10].landOnField(player);
                    break;
                }
                
                for (int j = 0; j < fields.length; j++) {
                    if (sum == fields[j].getFieldNumber()) {
                        fields[j].landOnField(player);
                        break;
                    }
                }
                break;
            }
            //Otherwise, give regular turn
            else if (sum == fields[i].getFieldNumber()) {
                fields[i].landOnField(player);
                break;
            }
        }
    }

    //Initialize fields
    public static FeltListe[] initalizeFields() {
        FeltListe[] retFields = new FeltListe[11];

        retFields[0] = new FeltListe(2, "Prinsessen i taarnet gav dig 250 points!", 250);
        retFields[1] = new FeltListe(3, "Du blev ramt af en meteor og du tabte 100 point i sandbunkerne fra krateret.", -100);
        retFields[2] = new FeltListe(4, "Du er naaet til Amalienborg og dronning Margrete kastede 100 points paa dig.", 100);
        retFields[3] = new FeltListe(5, "Du koebte en frakke for at undslippe kulden for 20 points.", -20);
        retFields[4] = new FeltListe(6, "Du naar til Kings Landing og Jamie Lannister giver dig 180 points.", 180);
        retFields[5] = new FeltListe(7, "Monkene i byen har intet til overs saa du faar eller mister ingenting.", 0);
        retFields[6] = new FeltListe(8, "Juiced up Batman stjaeler 70 points fra dig.", -70);
        retFields[7] = new FeltListe(9, "Du finder 70 point i en efterladt hytte.", 70);
        retFields[8] = new FeltListe(10, "Du bliver overfaldet af nogle varulve og mister 80 points, men du faar en ekstra tur.", -80);
        retFields[9] = new FeltListe(11, "Du snubler i en vandpytte og mister 50 points.", -50);
        retFields[10] = new FeltListe(12, "Du har fundet guld i bjergene og saelger det for 650 points.", 650);

        return retFields;
    }
}