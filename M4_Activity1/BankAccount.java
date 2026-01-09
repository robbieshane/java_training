package M4.Activities;

public class BankAccount { // M4_Activity1
	public static String getAccountName(String accountNumber) {
		
		if (accountNumber == "ACC-001") {
			return "Juan Dela Cruz";
		} else if (accountNumber == "ACC-002") {
			return "Maria Santos";
		} else {
			return null;
		}
		
	}
	
	public static void testCase(String accountNumber) {
		
		System.out.println("Looking up Account: " + accountNumber);
		try {
			String name = getAccountName(accountNumber);
			String toUpperName = name.toUpperCase();
			System.out.println("Account Holder: " + toUpperName + "\n");
		} catch (NullPointerException e) {
			System.out.println("Error: Account not found! \n");
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("=== Bank Account Name Display ===");
		System.out.println("");
		BankAccount.testCase("ACC-001");
		BankAccount.testCase("ACC-999");
		System.out.println("=== Program Completed successfully! ===");

	}
}
