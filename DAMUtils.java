package DAMlib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DAMUtils{

    private static String vowels = "ÁÀÂÄÉÈËÊÍÌÏÎÓÒÔÖÚÙÜÛ";
    public static Scanner lector = new Scanner(System.in);

    /**
     * Deploys an error on System.err and prints n args, then breaks the program
     * 
     * @param args Strings to be printed
     */
    public static void deployError(String... args) {
        for (String s : args)
            System.err.println(s);

        System.exit(1);
    }

    /**
     * Receives an string and prints the number of vowels and consonants
     * <p>
     * Example:
     * <blockquote>
     * 
     * <pre>
     * count("Hola buenas")
     * // 5 vowels, 5 consonants
     * </pre>
     * 
     * </blockquote>
     * 
     * @param s String to be analized
     */
    public static void count(String s) {
        // Variable definition
        s = s.toUpperCase();
        int counter = 0;

        // Count the vowels
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.indexOf(c) != -1)
                counter++;
        }

        // Number of consonants = string length without spaces- number of vowels
        System.out.print(counter + " vocales");
        System.out.println(" y " + (s.replaceAll("\\s+", "").length() - counter) + " consonantes");
    }


    /**
     * Gets q alphanumeric number of chars over an String and saves it into a char
     * Array
     * 
     * @param s String with the alphanumeric characters
     * @param q Number of chars to be
     * @return char Array length q
     */
    public static char[] charDivider(String s, int q) {

        if (q > s.length())
            deployError("String length is below the divisor", "<Error at charDivider>");

        s = cleanString(s);
        char[] cArray = new char[q];

        for (int i = 0; i < q; i++) {
            cArray[i] = s.charAt(i);
        }

        return cArray;
    }


    /**
     * Reads and validates a double
     * 
     * @param msj String to be printed
     * @return Validated double
     */
    public static double leerDouble(String msj) {
        boolean valid;
        double d;
        do {
            d = 0;
            valid = true;
            System.out.print(msj);

            try {
                d = lector.nextDouble();
                lector.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida");
                lector.nextLine();
                valid = false;
            }

        } while (!valid);

        return d;
    }



    /**
     * Reads an integer with a personalized message
     * 
     * @param msj String with the message
     * @return Validated integer
     */
    public static int leerInt(String msj) {
        try (Scanner lector = new Scanner(System.in)) {
            int res = 0;
            boolean valid;

            do {
                System.out.println(msj);
                valid = true;
                try {
                    res = lector.nextInt();
                    lector.nextLine();
                } catch (InputMismatchException e) {
                    lector.nextLine();
                    System.out.println("Entrada no valida");
                    valid = false;
                }
            } while (!valid);

            return res;
        }

    }

}