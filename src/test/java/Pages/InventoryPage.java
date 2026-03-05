package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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
        wait.until(ExpectedConditions.visibilityOf(learningMaterials)).click();
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

    // Populate the inventory form with the required details and submit the form
    @FindBy(id = "deviceType")
    WebElement selectOption;

    public void selectedDeviceOption() {
        wait.until(ExpectedConditions.elementToBeClickable(selectOption));
        Select dropdown = new Select(selectOption);
        dropdown.selectByIndex(1); // Selects the second option (index 1)
    }


    @FindBy(id = "inventory-form-grid")
    WebElement inventoryFormGrid;
    // CHECK THAT THE FORM GRID IS VISIBLE
    public void verifyInventoryGrid() {
        wait.until(ExpectedConditions.visibilityOf(inventoryFormGrid));
        if (inventoryFormGrid.isDisplayed()) {
                System.out.println("Inventory form grid is visible on the page.");
                return; // Exit the method if the grid is visible
        }

    }

    @FindBy(id = "brand")
    WebElement selectBrand;

    @FindBy(xpath = "//*[@id=\"device-preview\"]/div/div/div[2]")
    WebElement previewedBrand;
    public void selectedBrand() {

        wait.until(ExpectedConditions.elementToBeClickable(selectBrand));
        Select dropdownBrand = new Select(selectBrand);
        dropdownBrand.selectByIndex(1); // Selects the second option (index 1)
        String selectedBrandText = dropdownBrand.getFirstSelectedOption().getText();
        System.out.println("Selected brand: " + selectedBrandText); // Debugging line

        wait.until(ExpectedConditions.visibilityOf(previewedBrand));
        String previewedBrandText = previewedBrand.getText();

        if (!selectedBrandText.equals(previewedBrandText)) {

            throw new AssertionError("Expected message: " + selectedBrandText + ", but got: " + previewedBrandText);
            }
    }

    // select storage option radio button and verify that the correct option is selected
    @FindBy(id = "storage-128GB")
    WebElement selectedStorage;
    @FindBy(id="unit-price-value")
    WebElement unitPriceValue;

    public void selectedStorageOption() {
        wait.until(ExpectedConditions.elementToBeClickable(selectedStorage)).click();
        if (selectedStorage.isSelected()) {
            System.out.println("128GB storage option is selected.");
            wait.until(ExpectedConditions.visibilityOf(unitPriceValue));
            String unitPriceText = unitPriceValue.getText();

            System.out.println("Unit price value: " + unitPriceText); // Debugging line
                if (!unitPriceText.equals("R480.00")) {
                    throw new AssertionError("Expected unit price: R480.00, but got: "+unitPriceText);
                }
                else
                {
                    System.out.println("Unit price value is correct for the selected storage option.");
                }

        }
        else {
            throw new AssertionError("128GB storage option is not selected.");
        }

    }

    @FindBy(id = "color")
    WebElement selectedColor;
        public void setSelectedColor() {

            wait.until(ExpectedConditions.elementToBeClickable(selectedColor));
            Select dropdownColor= new Select(selectedColor);
            dropdownColor.selectByIndex(3); // Selects the forth option (index 3)
            String selectedColorText = dropdownColor.getFirstSelectedOption().getText();
            System.out.println("Selected color: " + selectedColorText); // Debugging line


        }

    // capture product quatity
        @FindBy(id = "quantity")
        WebElement quantityField;
        @FindBy(id = "subtotal-value")
        WebElement subTotalPriceValue;
    String subTotalPriceText;
    public void setProductQuantity(int quantity) {
            wait.until(ExpectedConditions.visibilityOf(quantityField));
            quantityField.clear();
            quantityField.sendKeys(String.valueOf(quantity));
            System.out.println("Product quantity set to: " + quantity); // Debugging line
            // get subtotal value
            wait.until(ExpectedConditions.visibilityOf(subTotalPriceValue));
             subTotalPriceText = subTotalPriceValue.getText();
            System.out.println("Subtotal price value: " + subTotalPriceText); // Debugging
            if (!subTotalPriceText.equals("R960.00")) {
                throw new AssertionError("Expected subtotal price: R960.00, but got: "+subTotalPriceText);
            }
            else
            {
                System.out.println("Subtotal price value is correct for the selected quantity.");
            }

        }
        // add address
            @FindBy(id = "address")
            WebElement inputAddress;
            public void setInputAddress(String address) {
                wait.until(ExpectedConditions.visibilityOf(inputAddress));
                inputAddress.sendKeys(address);
                System.out.println("Address entered: " + address); // Debugging line

            }

        // Click Next button
        @FindBy(id = "inventory-next-btn")
        WebElement nextButton;

        @FindBy(xpath = "//*[@id=\"device-preview-wrapper\"]/div/div/div[1]")
        WebElement previewSummary;

        public void clickNextButton() {
            wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
            System.out.println("Next button clicked."); // Debugging line

            wait.until(ExpectedConditions.visibilityOf(previewSummary));
            String previewSummaryText = previewSummary.getText();
            System.out.println("Preview summary text: " + previewSummaryText); // Debugging line
            if (!previewSummaryText.contains("PREVIEW")) {
                throw new AssertionError("Expected preview summary to contain: PREVIEW, but got: " + previewSummaryText);
            }
        }

    @FindBy(id = "shipping-option-express")
    WebElement expressShippingOption;
    @FindBy(id ="breakdown-shipping-value")
    WebElement shippingCostValue;
    String shippingCostText;
    public void selectShippingOption() {
        wait.until(ExpectedConditions.visibilityOf(expressShippingOption));
        System.out.println("Express shipping option is visible.");

        wait.until(ExpectedConditions.elementToBeClickable(expressShippingOption)).click();

        System.out.println("Express shipping option is selected.");
        // verify cost value for express shipping
        wait.until(ExpectedConditions.visibilityOf(shippingCostValue));
         shippingCostText = shippingCostValue.getText();
        System.out.println("Shipping cost value: " + shippingCostText); // Debugging line
        if (!shippingCostText.equals("R25.00")) {
            throw new AssertionError("Expected shipping cost: R25.00, but got: " + shippingCostText);
        }
    }
    @FindBy(id = "warranty-option-1yr")
    WebElement warrantyOption;

    @FindBy(id = "breakdown-warranty-value")
   WebElement warrantyCostValue;
    String warrantyCostText;
        public void selectWarrantyOption () {
            wait.until(ExpectedConditions.visibilityOf(warrantyOption));
            System.out.println("Express shipping option is visible.");
            wait.until(ExpectedConditions.elementToBeClickable(warrantyOption)).click();
            System.out.println("1-year warranty option is selected.");

                    //verify cost value for 1-year warranty
                    wait.until(ExpectedConditions.visibilityOf(warrantyCostValue));
                     warrantyCostText = warrantyCostValue.getText();
                    System.out.println("Warranty cost value: " + warrantyCostText); // Debugging line
                    if (!warrantyCostText.equals("R49.00")) {
                        throw new AssertionError("Expected warranty cost: R49.00, but got: " + warrantyCostText);
                    }


            }

    @FindBy(id="discount-code")
    WebElement discountCodeField;

        public void captureDiscountCode(String discountCode) {
            wait.until(ExpectedConditions.visibilityOf(discountCodeField));
            discountCodeField.sendKeys(discountCode);
            System.out.println("Discount code entered: " + discountCode); // Debugging line

        }

   @FindBy(id="apply-discount-btn")
   WebElement applyDiscountButton;
        public void clickApplyDiscountButton() {
            wait.until(ExpectedConditions.elementToBeClickable(applyDiscountButton)).click();
            System.out.println("Apply discount button clicked."); // Debugging line
        }

        public void verifyDiscountApplied(String expectedDiscountedTotal) {
            WebElement discountedTotalValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("breakdown-total-value")));
            String actualDiscountedTotal = discountedTotalValue.getText();
            System.out.println("Discounted total value: " + actualDiscountedTotal); // Debugging line
            if (!actualDiscountedTotal.equals(expectedDiscountedTotal)) {
                throw new AssertionError("Expected discounted total: " + expectedDiscountedTotal + ", but got: " + actualDiscountedTotal);
            }
        }

        public void calculateDiscountedTotal() {
            // Assuming the discount is 10% for the "SAVE10" code
            double subTotal = Double.parseDouble(subTotalPriceText.replace("R", "").replace(",", ""));
            double shippingCost = Double.parseDouble(shippingCostText.replace("R", "").replace(",", ""));
            double warrantyCost = Double.parseDouble(warrantyCostText.replace("R", "").replace(",", ""));
            double totalBeforeDiscount = subTotal + shippingCost + warrantyCost;
            double discountAmount = totalBeforeDiscount * 0.10; // 10% discount
            double expectedDiscountedTotal = totalBeforeDiscount - discountAmount;
            // 1. Create a symbol object to change the decimal separator to a comma
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator('.'); // Sets dot instead of comma
            symbols.setGroupingSeparator(' '); // Optional: sets space for thousands

            // 2. Create the formatter with your specific "R" pattern
            DecimalFormat df = new DecimalFormat("R#,##0.00", symbols);
            // 3. Format the double
            String formattedDiscountValue = df.format(expectedDiscountedTotal);
            verifyDiscountApplied(formattedDiscountValue);
        }

        //confirm purchase and verify confirmation message
        @FindBy(id="purchase-device-btn")
        WebElement purchaseButton;
        @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/p[1]")
        WebElement confirmationMessage;
        public void confirmPurchase() {
            wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)).click();
            System.out.println("Confirm Purchase button clicked."); // Debugging line
            String confirmationMessageText = wait.until(ExpectedConditions.visibilityOf(confirmationMessage)).getText();
            String expectedConfirmationMessage = "Mpho, your order was purchased successfully!";
            Assert.assertEquals(expectedConfirmationMessage, confirmationMessageText);        }
}










