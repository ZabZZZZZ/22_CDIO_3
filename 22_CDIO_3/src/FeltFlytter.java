import java.lang.Math;

public class FeltFlytter {
    public static void flytTilFelt(Player player, String farve) {
        player.setPosition(randomFelt(farve));
    }
    
    private static int randomFelt(String farve) {
        switch (farve) {
            case "Brun":
            if (Math.random() < 0.5)
            return 1;
            else 
            return 2;
            
            case "Lyseblaa":
            if (Math.random() < 0.5)
            return 4;
            else 
            return 5;

            case "Lilla":
            if (Math.random() < 0.5)
            return 7;
            else 
            return 8;
            
            case "Orange":
            if (Math.random() < 0.5)
            return 10;
            else 
            return 11;
            
            case "Roed":
            if (Math.random() < 0.5)
            return 13;
            else 
            return 14;

            case "Gul":
            if (Math.random() < 0.5)
            return 16;
            else 
            return 17;

            case "Groen":
            if (Math.random() < 0.5)
            return 19;
            else 
            return 20;

            case "Blaa":
            if (Math.random() < 0.5)
            return 22;
            else 
            return 23;

            default:
            return 0;
        }
        
    }
}
