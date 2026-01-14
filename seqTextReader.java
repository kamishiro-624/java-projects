import java.util.*;
import java.lang.String;

public class seqTextReader
{
    public static void clrConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void main(String[] args)
    {
        int delay = 0.035 // 0.035 is default delay factor (seconds). line 44 used
        ArrayList<String> streamText = new ArrayList<String>();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please provide the string to process.");
        System.out.print("> ");
        
        String strSource = input.nextLine();
        clrConsole();
        
        strSource.trim();
        
        while (strSource.contains(" ")) {
            for (int i = 0; i < strSource.length(); i++) {
                if ((strSource.substring(i, i+1)).equals(" ")) {
                    streamText.add((strSource.substring(0,i)).trim());
                    strSource = strSource.substring(i+1,strSource.length());
                    i = 0;
                }
            }
        }
        
        if (!strSource.isEmpty()) {
            streamText.add(strSource);
        }
        
        clrConsole();

        for (int i = 0; i < streamText.size(); i++) {
            System.out.print(streamText.get(i));
            System.out.print(" ");
            int wordDelay = (int) Math.round((0.05 + (streamText.get(i).length() * delay))*1000);
            try {
                Thread.sleep(wordDelay); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                System.err.println("Thread was interrupted: " + e.getMessage());
            }
        
        }
        
    }
}
