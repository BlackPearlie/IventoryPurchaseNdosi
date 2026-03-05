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

        // Populate the inventory form with the required details and submit the form
        // Verify that the grid exists and is visible on the page
        inventoryPage.selectedDeviceOption();
        inventoryPage.verifyInventoryGrid();
        inventoryPage.selectedBrand();
        inventoryPage.selectedStorageOption();
        inventoryPage.setSelectedColor();
        inventoryPage.setProductQuantity(2);
        inventoryPage.setInputAddress("123 Test Street");
        inventoryPage.clickNextButton();
        inventoryPage.selectShippingOption();
        inventoryPage.selectWarrantyOption();
        inventoryPage.captureDiscountCode("SAVE10");
        inventoryPage.clickApplyDiscountButton();
        inventoryPage.calculateDiscountedTotal();
        inventoryPage.confirmPurchase();

        // call the method to verify the invoice details
        invoicePage.clickViewInvoiceButton();
        invoicePage.verifyInvoiceHistoryPanel();
        invoicePage.clickViewInvoiceSummary();
    }


}
