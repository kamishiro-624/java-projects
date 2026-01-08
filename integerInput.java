import java.util.*;

/*  
    @param input  Scanner Instance
    @param prompt  Message shown to user
    @param min  Minimum valid integer (inclusive)
    @param max  Maximum valid integer (inclusive)
    @return  Valid user integer input 
*/

public class integerInput
{
    public static int promptInt(Scanner input, String prompt, int min, int max) {
        
        System.out.println(prompt);
        System.out.print("> ");
        
        boolean gaveValid = false;
        int returnValue = 0;
        
        while (!gaveValid) {
            if (input.hasNextInt()) {
                returnValue = input.nextInt();
                input.nextLine();
                if (returnValue < min || returnValue > max) {
                    System.out.println("[ERROR] The inputted value is invalid.");
                    System.out.print("> ");
                } else {
                    gaveValid = true;
                }
            } else {
                System.out.println("[ERROR] The inputted value is invalid.");
                input.nextLine();
                System.out.print("> ");
                gaveValid = false;
            }
        }
        return returnValue;
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // put this in main
        int int1 = promptInt(input, "Please enter an integer between 1 and 20, inclusive.", 1, 20);
        
        System.out.println(int1);
        input.close();
    }
}
