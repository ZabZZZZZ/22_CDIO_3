import java.util.Scanner;

class Agechecker {
    public static int getAge(String playerName) {
    int age = 0;
    boolean validAge = false;

    Scanner scanner = new Scanner(System.in);

    while (!validAge) {
        try {
            System.out.println("Indtast alderen af " + playerName + ": ");
            age = Integer.parseInt(scanner.nextLine());

            if (age < 1) {
                System.out.println("Dette er en ugyldig alder. Indtast igen.");
            
            } else {
                validAge = true;
            }

        } catch (NumberFormatException e) {
            System.out.println("Dette er en ugyldig alder. Indtast igen.");
        }
    }
    scanner.close();

    return age;

    
    }
}
