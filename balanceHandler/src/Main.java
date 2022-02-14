public class Main{
    public static void main(String[] args) {
        BalanceControlSystem control;
        // Possible argument for start balance
        if(args.length > 0){
            control = new BalanceControlSystem(Integer.parseInt(args[0]));
        } else {
            control = new BalanceControlSystem();
        }
        
        BalanceHandler handler = new BalanceHandler(control);

        handler.run();
    }
}