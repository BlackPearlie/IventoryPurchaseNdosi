package Basic;

import Pages.InventoryPage;
import Pages.InvoicePage;
import Pages.LoginPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    BrowserFactory browserFactory = new BrowserFactory();
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    public WebDriver driver; // initialized once per test class
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public InvoicePage invoicePage;
    @BeforeClass
    public void setUp() {
        driver = browserFactory.startBrowser(browserChoice, url);
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        invoicePage = new InvoicePage(driver);
    }

   // @AfterMethod
    //public void tearDown() {
    //    browserFactory.closeBrowser();
  //  }
}
