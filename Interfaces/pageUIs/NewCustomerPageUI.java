package pageUIs;

public class NewCustomerPageUI {
	public static final String NEW_CUSTOMER_TEXT="//p[text()='Add New Customer']";
	public static final String CUSTOMER_FORM="//form[@name='addcust']";
	
	public static final String NAME_SENKEY="//input[@name='name']";
	
	public static final String NAME_EMPTY_TEXT="//label[text()='Customer name must not be blank']";
	public static final String NAME_CANNOT_NUMBER_TEXT="//label[text()='Numbers are not allowed']";
	public static final String NAME_CANNOT_SPECIAL_TEXT="//label[text()='Special characters are not allowed']";
	public static final String NAME_FIRST_CHARACTER_CANNOT_SPACE_TEXT="//label[text()='First character can not have space']";
	
	
	
	public static final String ADDRESS_SENKEY="//textarea[@name='addr']";
	public static final String DATEOFBIRTH_SENKEY="//input[@name='dob']";
	public static final String CITY_SENKEY="//input[@name='city']";
	public static final String STATE_SENKEY="//input[@name='state']";
	public static final String PIN_SENKEY="//input[@name='pinno']";
	public static final String MOBILE_SENKEY="//input[@name='telephoneno']";
	public static final String EMAIL_SENKEY="//input[@name='emailid']";
	public static final String PASSWORD_SENKEY="//input[@name='password']";
	
	public static final String SUBMIT_BUTTON="//input[@name='sub']";
	public static final String NEW_CUSTOMER_SUCCESSFULLY_TEXT=" //p[text()='Customer Registered Successfully!!!']";
	
	
	
	
	
}
