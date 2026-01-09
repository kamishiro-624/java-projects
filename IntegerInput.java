import java.util.*;

/*  
    @param input  Scanner Instance
    @param prompt  Message shown to user
    @param min  Minimum valid integer (inclusive)
    @param max  Maximum valid integer (inclusive)
    @return  Valid user integer input 
*/

public class IntegerInput
{
    public static int promptInt(Scanner input, String prompt, int min, int max) {
        
        System.out.println(prompt);
        System.out.print("> ");
        
        boolean gaveValid = false;
        int returnValue = 0;
        
        if (max <= min) {
            throw new IllegalArgumentException("Maximum parameter (" + max + ") can not be equal to or less than minimum (" + min + ").");
        }
        
        while (!gaveValid) {
            if (input.hasNextInt()) {
                returnValue = input.nextInt();
                input.nextLine();
                if (returnValue < min) {
                    System.out.println("[ERROR] The inputted value is less than the minimum. (" + returnValue + "<" + min + ")");
                    System.out.print("> ");
                } else if (returnValue > max) {
                    System.out.println("[ERROR] The inputted value is greater than the maximum. (" + returnValue + ">" + max + ")");
                    System.out.print("> ");
                } else {
                    gaveValid = true;
                }
            } else {
                System.out.println("[ERROR] The inputted value is not an integer.");
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
