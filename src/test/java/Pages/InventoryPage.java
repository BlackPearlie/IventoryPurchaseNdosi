package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage {
    WebDriver driver;
    WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
   //
      @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button/span[2]")
    WebElement learnButton;


    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
    WebElement learningMaterials;

    @FindBy(xpath = "//*[@id=\"tab-btn-web\"]/span[2]")
    WebElement btnWebAdvance;

    public void clickLearnBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(learnButton)).click();
    }

    public void clickMaterials() {
        wait.until(ExpectedConditions.elementToBeClickable(learningMaterials)).click();
    }

    public void clickWebAdvance() {
        wait.until(ExpectedConditions.elementToBeClickable(btnWebAdvance)).click();
    }

    @FindBy(id ="inventory-title")
    WebElement inventoryHeading;

    public void verifyInventoryForm(String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOf(inventoryHeading));
        String actualMessage = inventoryHeading.getText();
        System.out.println("Actual message: " + actualMessage); // Debugging line
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }
}

