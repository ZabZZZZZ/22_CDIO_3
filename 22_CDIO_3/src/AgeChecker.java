import java.util.Scanner;

class Agechecker {
    public static int getAge(String playerName, Scanner scanner){
        int age = 0;
        boolean validAge = false;

        while (!validAge) {
            try {
                System.out.println("Indtast alderen af " + playerName + ": ");
                age = Integer.parseInt(scanner.nextLine());

                if (age < 1 || age > 120) {
                    System.out.println("Dette er en ugyldig alder. Indtast igen.");
                
                } else {
                    validAge = true;
                }

            } catch (Exception e) {
                System.out.println("Dette er en ugyldig alder. Indtast igen.");
            }
        }

        return age;
    }

}
