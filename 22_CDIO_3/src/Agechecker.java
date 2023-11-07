import java.util.Scanner;

class Agechecker {
    public static int getAge(playerName);
    int age = 0;
    boolean validAge = false;

    while (!validAge) {
        try {
            System.out.println("Indtast alderen af " + playerName + ": ");
            age = Integer.parseInt(scanner.nextLine());

            if (age < 1) {
                System.out.println("Dette er en ugyldig alder. Indtast igen.");
            
            } else {
                validAge = true;
            }

        } catch (numberExeption n) {
            System.out.println("Dette er en ugyldig alder. Indtast igen.");
        }
    }
    return age;

    scanner.close();

}
