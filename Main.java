/*Program Name: ExceptionHandle
 *Program Purpose: Ask user to input floating point values. If the user inputs an improper input, handle the exception and give the user a second chance
 *Created / Edited by: jramrez */
 
 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        double sum = 0;
        int tries = 2;
        boolean inputting = true;


        while (inputting) {
            try {
                while (tries > 0) {
                    System.out.println("Enter a decimal \nType 'done' to end\n---------");
                    input = scan.nextLine();
                    sum += Double.parseDouble(input);
                }
            }
            catch (Exception e) {
                if (input.equals("done")) {
                    tries = 0;
                }
                else {
                    if (tries == 2) {
                        System.out.println("Don't make me catch you doing that again");
                        tries--;
                    }
                    else if (tries == 1) {
                        System.out.println("Too many wrong inputs");
                        tries--;
                    }
                }
            }
            finally {
                if (tries == 0) {
                    System.out.println("total is: "  + sum);
                    inputting = false;
                    scan.close();
                }
                else {
                    continue;
                }
            }
        }
    }
}