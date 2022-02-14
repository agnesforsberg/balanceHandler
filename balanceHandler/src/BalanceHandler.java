import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BalanceHandler {
    
    private static String startMsg = "Welcome to BalanceHandler2000! \nIf you need help, enter help. \nIf you want to quit, enter quit." 
                                    + "\nEnter commands here:\n--> ";
    private static String helpMsg = "Type L to see available balance. \nType SX to sell, where X is the number you wish to sell." 
                                    + "\nType IX to buy, where X is the number you wish to buy. \nRemember to be case sensitive!";

    private static Pattern buyPattern = Pattern.compile("^I[0-9]+$");
    private static Pattern sellPattern = Pattern.compile("^S[0-9]+$");

    private BalanceControlSystem control;

    public BalanceHandler(BalanceControlSystem control){
        this.control = control;
    }

    /**
     * The main function for the program. Runs until quit by user, parses input and delivers output.
     */
    void run() {
        System.out.print(startMsg);
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean quit = false;
        while(!quit && scanner.hasNext()){
            input = scanner.nextLine();
            quit = handleInput(input);
            
            // Input prompt
            if(!quit) System.out.print("--> ");
        }
        scanner.close();
    }

    boolean handleInput(String input){
        Matcher buyMatcher = buyPattern.matcher(input);
        Matcher sellMatcher = sellPattern.matcher(input);
        int inputNumber;

        if(input.contains("help")){
            System.out.println(helpMsg);
        } else if(input.contains("quit")){
            System.out.println("Your ending balance is: " + control.getBalance() + "\nGoodbye!");
            return true;
        } else if(input.equals("L")){
            System.out.println("Your current balance is: " + control.getBalance());
        } else if(buyMatcher.find()){
            inputNumber = Integer.parseInt(input.substring(1));
            control.increaseBalance(inputNumber);
            System.out.println("Your balance has been increased by " + inputNumber);
        } else if(sellMatcher.find()){
            inputNumber = Integer.parseInt(input.substring(1));
            if(control.canSell(inputNumber)){
                control.decreaseBalance(inputNumber);
                System.out.println("Your balance has been decreased by " + inputNumber);
            } else {
                System.out.println("You can not sell " + inputNumber + ". You only have " + control.getBalance() + " available.");
            }
        } else {
            System.out.println("Your input did not match any pattern. Enter help for avaiable commands.");
        }

        return false;
    }
}
