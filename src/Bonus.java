import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;

public class Bonus {

    public static void main(String[] args) {

        // Onderstaande code is uitgecommentarieerd. Haal de code uit de comment (delete /* en */) om aan de slag te gaan met de bonus
        // In de code staan op verschillende plekken comments tussen "/*...*/" als hint wat je moet doen

        boolean go = true;

        while (go) {
            HashSet<Integer> secretnumber = randomnumbergenerator();
            String stringnumber = setToStringConverter(secretnumber);
            System.out.println(stringnumber);
            feedback(stringnumber);

            Scanner scanner = new Scanner(in);
            System.out.println("Wil je nog een keer? (j/n)");
            String input =  scanner.nextLine().toLowerCase();

            if (input.equals("j")) {
                // go stays true
            } else if (input.equals("n")) {
                go = false;
            } else {
                System.out.println("Foute invoer, programma afgebroken");
                go = false;
            }
        }

    }

    public static HashSet<Integer> randomnumbergenerator(){
        HashSet<Integer> fourRandom = new HashSet<>();

        while (fourRandom.size() < 4) {
            Random rand = new Random();

            int rand_int = rand.nextInt(10);
            fourRandom.add(rand_int);
        }

        return fourRandom;
    }

    public static String setToStringConverter(HashSet<Integer> getallen){
        StringBuilder str = new StringBuilder();
        for ( int getal : getallen) {
            str.append(getal);
        }

        return str.toString();
    }



    public static void feedback(String stringnumber) {
        Scanner scanner = new Scanner(in);
        StringBuilder feedback = new StringBuilder();
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");

        boolean go = true;
        while (go) {
            System.out.println("Doe een gok, Let op vul 4 getallen in.");
            String guess = scanner.nextLine();
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
        }


    }
}

// HashSet accepteert geen dubbele waarden.
// Dus als je 4x een random int genereert, maar er zitten dubbele bij. Zal je niet vier ints in je HashSet als resultaat hebben.