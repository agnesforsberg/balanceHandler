public class BalanceControlSystem {
    
    private int balance;
    
    public BalanceControlSystem(){
        // Default start balance is 0
        this(0);
    }

    public BalanceControlSystem(int startBalance){
        balance = startBalance;
    }

    int getBalance(){
        return balance;
    }

    void increaseBalance(int x){
        balance += x;
    }

    void decreaseBalance(int x){
        balance = Math.max(0, balance - x);
    }

    boolean canSell(int x){
        return balance >= x;
    }
    
}
