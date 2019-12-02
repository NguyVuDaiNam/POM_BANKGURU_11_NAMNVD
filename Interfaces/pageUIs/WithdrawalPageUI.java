package pageUIs;

public class WithdrawalPageUI {
	public static final String WITHDRAWAL_TEXT="//p[text()='Amount Withdrawal Form']";
	
	public static final String ACCOUNT_ID_SENKEY="//input[@name='accountno']";
	public static final String AMOUNT_SENKEY="//input[@name='ammount']";
	public static final String DESCRIPTION_SENKEY="//input[@name='desc']";
	public static final String SUBMIT_BUTTON="//input[@name='AccSubmit']";
	
	//public static final String TRANSACTION_SUCCESSFULLY_TEXT="//p[text()='Transaction details of Deposit for Account'"+%s+"']";
	public static final String TRANSACTION_ID_TEXT="//td[text()='Transaction ID']//following-sibling::td";
	public static final String CURRENT_BALACE_TEXT="//td[text()='Current Balance']//following-sibling::td";
	
	
	
}
