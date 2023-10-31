import java.util.Random;

public class Dice {
    public static int rollDice(){
        Random rand = new Random();
        var number = rand.nextInt(7);

        while (number == 0){
            number = rand.nextInt(7);
        }
        return number;
    }
}
