package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	private final String workingDir = System.getProperty("user.dir");
	protected final Log log;

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver_) {
		this.driver = driver_;
	}

	@BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		deleteAllFileInFolder();
	}

	public void deleteAllFileInFolder() {
		try {
			String pathFolderDownload = workingDir + "\\ReportNGScreenShots";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected WebDriver opentMultiBrowser(String browserName, String url) {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
			// WebDriverManager.chromedriver().arch32().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions--");
			options.addArguments("disable-infobars");
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,
			// "true");
			// System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, workingDir+
			// "\\FirefoxLog.txt");
			// FirefoxOptions options=new FirefoxOptions();
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\Resources\\IEDriverServer.exe");
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capability.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
			capability.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capability.setCapability("ignoreProtectedModeSettings", true);
			capability.setCapability("ignoreZoomSettings", true);
			capability.setCapability("requireWindowFocus", true);
			capability.setJavascriptEnabled(true);
			capability.setPlatform(org.openqa.selenium.Platform.ANY);
			driver = new InternetExplorerDriver(capability);

		} else if (browserName.equals("chromeheadless")) {
			System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
			// WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("window-size=1266x760");
			driver = new ChromeDriver(chromeOptions);
		}
		/*
		 * else if (browserName.equals("firefoxheadless")) {
		 * WebDriverManager.firefoxdriver().setup(); FirefoxBinary firefoxBinary = new
		 * FirefoxBinary(); firefoxBinary.addCommandLineOptions("--headless");
		 * FirefoxOptions firefoxOptions=new FirefoxOptions();
		 * firefoxOptions.setBinary(firefoxBinary); driver= new
		 * FirefoxDriver(firefoxOptions);
		 * 
		 * }
		 */

		if (url.equals("Bank")) {
			driver.get(Constansts.BANK_URL);
		} else if (url.equals("Live")) {
			driver.get(Constansts.LIVE_URL);
		} else if (url.equals("Live_Backend")) {
			driver.get(Constansts.LIVE_BACKEND_URL);
		}

		// driver.get(Constansts.DEV_URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	protected int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999);
		return number;
	}

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);

		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	// tham khảo
	private boolean checkEqual(Object actual, Object expected) {
		boolean pass = true;
		try {
			if (actual == expected)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		boolean status;//
		try {
			if (actual instanceof String && expected instanceof String) {
				actual = actual.toString().trim();
				log.info("Actual=" + actual);
				expected = expected.toString().trim();
				log.info("Expected=" + expected);
				status = (actual.equals(expected));
			} else {
				status = (actual == expected);
			}
			log.info("Compare value=" + status);
			if (status) {
				log.info("===PASSED===");
			} else {
				log.info("===FAILED===");
			}
			Assert.assertEquals(actual, expected, "Value is not matching");
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			driver.manage().deleteAllCookies();
			String cmd = "";
			if (driver != null) {
				driver.quit();
			}
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("Windows")) {
					cmd = "taskkill/F/FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill/F/FI \"IMAGENAME eq IEDriverServer*\"";
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				}
			}
			log.info("---------------- QUIT BROWSER SUCCESS ---------------- ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
