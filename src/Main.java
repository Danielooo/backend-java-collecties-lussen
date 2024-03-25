import java.sql.SQLOutput;
import java.util.Scanner;
import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        int[] numeric = {1,2,3,4,5,6,7,8,9,0};
        String[] alphabetic = {"een", "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "nul"};

        Translator translator = new Translator(numeric, alphabetic);

        Boolean play = true;
        String invalid = "ongeldige invoer";
        Scanner scanner = new Scanner(in);


//        if: number kleiner is dan 10, dan sla je de waarde van translator.translate(number) op in String result en print je "De vertaling van " + number + " is " + result.
//else: anders dan print je ongeldig

        while (play) {
            System.out.println("Type 'x' om te stoppen \nType 'v' om te vertalen");
            String input = scanner.nextLine();
            if (input.equals("x")) {
                play = false;
            } else if (input.equals("v")) {
                System.out.println("Voer een int waarde in om te vertalen.");
                int number = scanner.nextInt();
                scanner.nextLine();
                if (number < 10) {
                    String result = translator.translate(number);
                    System.out.println("De vertaling van " + " number " + " is " + result);
                } else {
                    System.out.println(invalid);
                }
            } else {
                System.out.println(invalid);
            }
        }
        



    }
}
