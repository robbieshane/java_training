package M4.Activities;

public class AccountValidator { // M4_Activity4
	public static void validateAccountNumber(String accountNumber) throws Exception{
		if (accountNumber == null) {
			throw new NullPointerException("Cannot be null");
		} else if (accountNumber.length() != 10) {
			throw new Exception("Must be 10 digits");
		} else System.out.println("Valid account: " + accountNumber);
	}
	
	public static void runTest(String accountNumber) {
		try {
			validateAccountNumber(accountNumber);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		runTest("1234567890");
		runTest("123");
		runTest(null);

	}
}
