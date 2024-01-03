import java.util.Scanner;

/**
 * @author Cruz Guo
 * @version 1.0.0
 */
public class GeneratorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to generate a password?");
        String answer1 = scan.nextLine();
        if (answer1.toLowerCase().contains("yes")) {
            System.out.println("How long do you want the password to be?");
            int num = scan.nextInt();
            System.out.printf("Type in one to check desired password requirement and 0 to skip the requirement.%nA) " +
                    "Must have at least one upper-case letter%nB) Must have at least one lower-case " +
                    "letter%nC) Must have at least one number%nD) Must have at least one special character%n");
            int[] requirements = new int[4];
            for (int i = 0; i < requirements.length; i++) {
                requirements[i] = scan.nextInt();
            }
            String password = Generator.passwordGenerator(num, requirements);
            if (password != null) {
                System.out.println("Password is " + password);
            }
        } else {
            System.out.println();
        }
        System.out.println("Do you want to generate an User ID?");
        scan.nextLine();
        String answer2 = scan.nextLine();
        if (answer2.toLowerCase().contains("yes")) {
            System.out.println("How long do you want the UID to be?");
            int num = scan.nextInt();
            Integer UID = Generator.userIDGenerator(num);
            if (UID != null) {
                System.out.println("UID is " + UID);
            }
        } else {
            System.out.println();
        }
    }
}
