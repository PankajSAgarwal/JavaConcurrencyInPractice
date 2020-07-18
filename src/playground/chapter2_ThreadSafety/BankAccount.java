package playground.chapter2_ThreadSafety;

/**
 * What's wrong with this
 * private final fields should be used as lock to guard critical section
 * which do not change
 */
public class BankAccount {
    private Long balance = 0L;

    public void deposit(int amount){
        synchronized (balance){
            balance += amount;
        }
    }
}
