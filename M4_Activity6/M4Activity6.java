package M4.Activities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class InvalidAmountException extends Exception {
	public InvalidAmountException(String message) {
		super(message);
	}
}

class InsufficientFundsException extends Exception {
	private double balance;
	private double requestedAmount;

	public InsufficientFundsException(String message, double balance, double requestedAmount) {
		super(message);
		this.balance = balance;
		this.requestedAmount = requestedAmount;
	}

	public double getBalance() {
		return balance;
	}

	public double getRequestedAmount() {
		return requestedAmount;
	}
}


@FunctionalInterface
interface BankTestOperation {
	void execute() throws InvalidAmountException, InsufficientFundsException;
}



class BankAccount1 {
    private static final Logger logger = LoggerFactory.getLogger(BankAccount1.class);
    private double balance;

    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
    }

    
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        logger.info("Withdrawal requested: ₱{}", amount);

        if (amount < 0) {
            logger.error("Invalid withdrawal amount: ₱{}", amount);
            throw new InvalidAmountException("Amount must be positive.");
        }

        if (amount > balance) {
            logger.warn("Insufficient funds: ₱{} Available ", balance);
            throw new InsufficientFundsException("Insufficient funds for withdrawal", balance, amount);
        }

        balance -= amount;
        logger.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance);
    }

    
    public void deposit(double amount) throws InvalidAmountException {
        logger.info("Deposit requested: ₱{}", amount);

        if (amount < 0) {
            logger.error("Invalid deposit amount: ₱{}", amount);
            throw new InvalidAmountException("Deposit amount must be positive.");
        }

        if (amount > 50000) {
            logger.warn("Large deposit: ₱{} - requires verification", amount);
        }

        balance += amount;
        logger.info("Deposit completed: ₱{}, New balance: ₱{}", amount, balance);
    }
    
}


public class M4Activity6 {
	private static final Logger logger = LoggerFactory.getLogger(M4Activity6.class);
	public static void runTest(BankTestOperation operation, String operationName) {
        try {
            operation.execute();
        } catch (InvalidAmountException e) {
            logger.error("Deposit failed: {}", e.getMessage(), e);
        } catch (InsufficientFundsException e) {
            logger.error("Withdrawal failed: {}", e.getMessage(), e);
        }
    }
	
	public static void main(String[] args) {
		BankAccount1 account = new BankAccount1(10000);
		
		runTest(() -> account.deposit(5000), "Deposit");
		runTest(() -> account.withdraw(3000), "Withdrawal");
		runTest(() -> account.deposit(-500), "Deposit");
		runTest(() -> account.withdraw(20000), "Withdrawal");
		runTest(() -> account.deposit(60000), "Deposit");
		

	}

}
