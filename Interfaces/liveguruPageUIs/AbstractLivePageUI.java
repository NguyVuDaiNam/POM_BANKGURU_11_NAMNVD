package liveguruPageUIs;

public class AbstractLivePageUI {
	public static final String DYNAMIC_MENU = "//header[@id='header']//span[text()='%s']";

	public static final String DYNAMIC_LINK = "//a[text()='%s']";//
		
	public static final String DYNAMIC_TEXTBOX_TEXTAREA_RADIO = "(//textarea | //input) [@id='%s']";
	
	public static final String DYNAMIC_BUTTON = "//button[@title='%s']";

	public static final String DYNAMIC_VERIFY_TEXT = "//span[text()='%s']";
	
	public static final String DYNAMIC_COST_LIST="//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
	
	public static final String DYNAMIC_COST_DETAIL = "//span[@class='%s']";

	public static final String DYNAMIC_ADD_CART = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//span[text()='Add to Cart']";
	
	public static final String QTY_TEXTBOX="//a[text()='%s']/ancestor::td/following-sibling::td[@class='product-cart-actions']/input";
	
	public static final String DYNAMIC_COMPARE = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Compare']";
	
	public static final String DYNAMIC_TEXT_H1_H2 = "//h1 | h2 [text()='%s']";//
	
	public static final String DYNAMIC_WISHLIST = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Wishlist']";
	
	public static final String DYNAMIC_TEXT_EMPTY_REVIEW = "//div[@id='%s']";
	
	public static final String DYNAMIC_DROPDOWN="//select[@name='%s']";
	
	public static final String DYNAMIC_DROPDOWN_ID="//select[@id='%s']";
	
	public static final String DYNAMIC_CONTINUE="//h2[text()='%s']/parent::div/following-sibling::div//span[text()='Continue']";
	
	public static final String DYNAMIC_ORDER_GENERATED="//td[contains(text(),'%s')]/following-sibling::td//span";
	
	public static final String DYNAMIC_IMG="//a[text()='%s']/ancestor::div[@class='product-info']/preceding-sibling::a";

	public static final String VERIFY_TABLE_CUSTOMERS="//table[@id='customerGrid_table']/tbody/tr[1]/td[%s]";
	
	public static final String VERIFY_ITEMS_SELECTED="//strong [@id='%s']";
	
	//

}
