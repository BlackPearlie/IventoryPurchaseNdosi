package Tests;

import Basic.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PurchaseTest  extends BaseTest {


    @Test
    public void PurchaseProduct() throws InterruptedException {
        //Navigate to login page and perform login
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress("mpho@gmail.com");
        loginPage.enterPassword("1234567890@");
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess("Here's an overview of your learning journey");

        // Navigate to inventory page and verify the inventory form
        inventoryPage.clickLearnBtn();
        inventoryPage.clickMaterials();
        inventoryPage.clickWebAdvance();
        inventoryPage.verifyInventoryForm("Inventory Form");
    }


}
