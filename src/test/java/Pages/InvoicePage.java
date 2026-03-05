package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

public class InvoicePage {
    WebDriver driver;
    WebDriverWait wait;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="view-history-btn")
    WebElement viewInvoiceButton;

    @FindBy(id="invoice-history-panel")
    WebElement invoicepanel;

    @FindBy(xpath = "//*[contains(@id, 'view-invoice-INV-')]")
    WebElement viewInvoiceBtn;


        public void clickViewInvoiceButton() {
            WebElement viewInvoice = driver.findElement(By.id("view-history-btn"));

            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    viewInvoice
            );

            viewInvoice.click();

            System.out.println("view invoice button clicked");//debugging statement
        }

        public void verifyInvoiceHistoryPanel() {
            wait.until(ExpectedConditions.visibilityOf(invoicepanel));
                if (!invoicepanel.isDisplayed()) {
                    throw new AssertionError("Invoice history panel is not displayed.");
                }else{
                    System.out.println("Invoice history panel is displayed.");
                }
        }

        public void clickViewInvoiceSummary() {
            wait.until(ExpectedConditions.visibilityOf(viewInvoiceBtn));
            viewInvoiceBtn.click();
            System.out.println("view invoice button visible and clicked.");


            // Store tabs
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());

          // Switch to new tab
            driver.switchTo().window(tabs.get(1));
            int numberOfTabs =  tabs.size();
            System.out.println("Current tabs "+numberOfTabs);
            // Verify invoice opened
            // Assert.assertTrue(driver.getCurrentUrl().contains("blob"));
            //  System.out.println("Current URL "+driver.getCurrentUrl());

        }

}
