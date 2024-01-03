import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author Cruz Guo
 * @version 1.0.0
 */
public class Generator {

    private static String[] lowerCaseLetters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
            "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String[] upperCaseLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static String[] specialCharacters = {"{", "}", "#", ",", "!", "_", "@", "\\", "|", "/", "(", ")", ":", ";", ".",
            "'", "\"", "$", "=", "+", "-", "*", "[", "]", "^", "?", "&", "~", "`", "%", ">", "<"};

    public static String passwordGenerator(int num, int[] requirements) {
        if (num <= 0) {
            System.out.println("Please type in a positive number.");
            return null;
        }
        String password = "";
        Random rand = new Random();
        int counter = 0;
        do {
            for (int i = 0; i < num; i++) {
                int gen = rand.nextInt(4);
                if (gen == 0) {
                    gen = rand.nextInt(26);
                    password += lowerCaseLetters[gen];
                } else if (gen == 1) {
                    gen = rand.nextInt(26);
                    password += upperCaseLetters[gen];
                } else if (gen == 2) {
                    gen = rand.nextInt(10);
                    password += numbers[gen];
                } else {
                    gen = rand.nextInt(32);
                    password += specialCharacters[gen];
                }
            }
            if (requirements[0] == 1) {
                if (!Pattern.compile("[0-9]").matcher(password).find()) {
                    counter++;
                }
            }
            if (requirements[1] == 1) {
                if (!Pattern.compile("[a-z]").matcher(password).find()) {
                    counter++;
                }
            }
            if (requirements[2] == 1) {
                if (!Pattern.compile("[A-Z]").matcher(password).find()) {
                    counter++;
                }
            }
            if (requirements[3] == 1) {
                if (!specialCharactersMatcher(password)) {
                    counter++;
                }
            }
        } while (counter != 0);
        return password;
    }

    private static boolean specialCharactersMatcher(String password) {
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < specialCharacters.length; j++) {
                if (password.substring(i, i+1).equals(specialCharacters[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Integer userIDGenerator(int num) {
        if (num <= 0) {
            System.out.println("Please type in a positive number");
            return null;
        }
        String uid = "";
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            int gen = rand.nextInt(10);
            uid += gen;
        }
        Integer UID = Integer.parseInt(uid);
        return UID;
    }
}
