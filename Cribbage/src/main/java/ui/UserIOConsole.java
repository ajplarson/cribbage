package ui;

import java.util.Scanner;

/**
 *
 * @author jackelder
 */
public class UserIOConsole {
    private static final String INVALID_NUMBER
            = "[INVALD] Enter a valid number.";
    private static final String NUMBER_OUT_OF_RANGE
            = "[INVALID] Enter a number between %s and %s";
    private static final String REQUIRED
            = "[INVALID] Value is required.";

    private final Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String readString(String prompt) {
        print(prompt);
        return scanner.nextLine();
    }

    public String readRequiredString(String prompt) {
        while (true) {
            String result = readString(prompt);
            if (!result.isBlank()) {
                return result;
            }
            print(REQUIRED);
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readRequiredString(prompt));
            } catch (NumberFormatException ex) {
                print(INVALID_NUMBER);
            }
        }
    }

    public double readDouble(String prompt, double min, double max) {
        while (true) {
            double result = readDouble(prompt);
            if (result >= min && result <= max) {
                return result;
            }
            print(String.format(NUMBER_OUT_OF_RANGE, min, max));
        }
    }

    public float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(readRequiredString(prompt));
            } catch (NumberFormatException ex) {
                print(INVALID_NUMBER);
            }
        }
    }

    public float readFloat(String prompt, float min, float max) {
        while (true) {
            float result = readFloat(prompt);
            if (result >= min && result <= max) {
                return result;
            }
            print(String.format(NUMBER_OUT_OF_RANGE, min, max));
        }
    }

    public int readInt(String prompt) {
        while(true){
            try{
                return Integer.parseInt(readRequiredString(prompt));
            }catch(NumberFormatException ex){
                print(INVALID_NUMBER);
            }
        }
    }

    public int readInt(String prompt, int min, int max) {
        while(true){
            int result = readInt(prompt);
            if(result >= min && result <= max){
                return result;
            }
            print(String.format(NUMBER_OUT_OF_RANGE, min, max));
        }
    }

    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(readRequiredString(prompt));
            } catch (NumberFormatException ex) {
                print(INVALID_NUMBER);
            }
        }
    }

    public long readLong(String prompt, long min, long max) {
        while (true) {
            long result = readLong(prompt);
            if (result >= min && result <= max) {
                return result;
            }
            print(String.format(NUMBER_OUT_OF_RANGE, min, max));
        }
    }
}
