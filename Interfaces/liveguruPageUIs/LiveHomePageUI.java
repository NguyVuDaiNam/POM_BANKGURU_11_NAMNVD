package liveguruPageUIs;

public class LiveHomePageUI {
	
	public static final String ACCOUNT_MENU_HEADER="//header[@id='header']//span[text()='Account']";
	
	public static final String MYACCOUNT_MENU_HEADER="//header[@id='header']//span[text()='My Account']";
	
	public static final String REGISTER_MENU_HEADER="//a[text()='Register']";
	
	public static final String MYACCOUNT_MENU_FOOTER="//div[@class='footer']//a[text()='My Account']";
	
	public static final String DISCOUNT="//table[@id='shopping-cart-totals-table']//tbody//tr[2]//span[@class='price']";
	
	public static final String GRAND_TOTAL="//table[@id='shopping-cart-totals-table']//tbody//tr[1]//span[@class='price']";
	
	
	public static final String MSG_ERROR_QTY="//p[contains(@class,'item-msg error')]";
	
	public static final String VERIFY_EMPTY_CART="//div[@class='page-title']/h1";
	
	public static final String MSG_WISHLIT="//li[@class='success-msg']//span";
	
	public static final String SHIPPING_COST_TOTAL="//td[contains(text(),'Shipping & Handling (Flat Rate - Fixed)')]/following-sibling::td/span";
	
	public static final String SHIPPING_COST_GENERATED="//dl[@class='sp-methods']//span";
	
	public static final String BUTTON_ADD_TO_CART="//table//button[@title='Add to Cart']";
	
	public static final String BUTTON_UPDATE_QTY="//button[@title='Update']";
	
	public static final String LINK_MY_WISHLIST = "//a[text()='My Wishlist']";
	
	public static final String BUTTON_ESTIMATE = "//a[text()='My Wishlist']";
	
	public static final String TOTAL_ORDER = "//strong[contains(text(),'Grand Total')]/ancestor::tr//span[@class='price']";
	
	public static final String ORDER_NUMBER = "//p[contains(text(),'Your order # is:')]/a";
	
	public static final String BUTTON_SEARCH = "//button[@title='Search' and @class='button']";
	
	public static final String LIST_NAME = "//li[@class='item last']//div[@class='product-info']//h2";
	
	public static final String LIST_PRICE = "//li[@class='item last']//div[@class='product-info']//div[@class='price-box']";
	
	public static final String REVIEW_TAB="//li[@class='last']//span[text()='Reviews']";
	
	public static final String VERYFY_REVIEW_TOP1="//div[@id='customer-reviews']//dl//dt[1]";
	
}
