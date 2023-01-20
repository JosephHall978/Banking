import org.jetbrains.annotations.NotNull;

public class Money {
    private double balance;
    private double overdraft;
    public Money(double balance,double overdraft) {
        this.balance = balance;
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "Money{" +
                "balance=" + balance +
                ", overdraft=" + overdraft +
                '}';
    }

    //getters setters
    public boolean setBalance(@NotNull double amount){
        this.balance = amount;
        return true;
    }
    public boolean setOverdraft(@NotNull double amount){
        this.overdraft = amount;
        return true;
    }
    public double getBalance(){
        return balance;
    }
    public double getOverdraft() {
        return overdraft;
    }

    //functionality
    public boolean addBalance(@NotNull double amount){
        if(amount <= 0){
            return false;
        }
        else{
            balance += amount;
            return true;
        }
    }
    public boolean subBalance(@NotNull double amount){
        if(amount <= 0){
            return false;
        }
        else{
            if(balance-amount < overdraft){
                balance -= amount + 5;
                return true;
            }
            else{
                balance -= amount;
                return true;
            }
        }
    }
}
