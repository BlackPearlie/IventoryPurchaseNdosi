# Inventory Purchase Ndosi - Test Automation Framework

## Overview
**Inventory Purchase Ndosi** is a comprehensive Selenium-based test automation framework designed to test the Ndosi Simplified Automation web application. This framework automates the end-to-end purchase workflow, including user authentication, product inventory management, invoice processing, and transaction verification.

## Technology Stack

### Core Technologies
- **Selenium WebDriver**: 4.40.0 - For web browser automation
- **TestNG**: 7.12.0 - For test execution and reporting
- **Java**: 21 - Programming language
- **Maven**: Build automation and dependency management

### Supported Browsers
- Chrome (Primary)
- Firefox
- Safari
- Edge
- Internet Explorer

## Project Structure

```
IventoryPurchaseNdosi/
├── src/
│   ├── main/
│   │   ├── java/org/example/Main.java
│   │   └── resources/
│   └── test/
│       └── java/
│           ├── Basic/
│           │   └── BaseTest.java           # Base test class with setup & teardown
│           ├── Pages/
│           │   ├── LoginPage.java          # Login page object
│           │   ├── InventoryPage.java      # Inventory management page object
│           │   └── InvoicePage.java        # Invoice view page object
│           ├── Tests/
│           │   └── PurchaseTest.java       # Main test scenarios
│           └── Utilities/
│               └── BrowserFactory.java     # Browser initialization utility
├── pom.xml                                 # Maven configuration
└── README.md                               # Project documentation
```

## Design Patterns

### 1. **Page Object Model (POM)**
The framework implements the Page Object Model design pattern to maintain clean, maintainable test code:
- Each web page is represented as a separate Java class (e.g., `LoginPage`, `InventoryPage`, `InvoicePage`)
- Web elements are defined using `@FindBy` annotations
- Page interactions are encapsulated in methods

### 2. **Base Test Class**
`BaseTest.java` provides:
- Centralized browser driver initialization
- Page object instantiation
- Test URL and browser choice configuration
- Consistent setup and teardown operations

### 3. **Browser Factory Pattern**
`BrowserFactory.java` handles:
- Multi-browser support (Chrome, Firefox, Safari, Edge, IE)
- Driver initialization
- Window maximization
- URL navigation

## Test Scenarios

### PurchaseTest.java - Complete Purchase Workflow

The `PurchaseProductPS` test executes a complete end-to-end purchase workflow:

#### 1. **Authentication**
- User login with valid credentials (Email: mpho@gmail.com)
- Verification of successful login with welcome message

#### 2. **Product Selection**
- Navigate to learning materials
- Select "Web Advance" course
- Verify inventory form appearance

#### 3. **Inventory Form Population**
- Select device option
- Choose product brand
- Select storage capacity
- Set product color
- Specify quantity (e.g., 2 units)
- Enter delivery address

#### 4. **Shipping & Warranty**
- Select shipping option
- Choose warranty option
- Apply discount code ("SAVE10")
- Calculate total after discount

#### 5. **Invoice Verification**
- Confirm purchase
- View generated invoice
- Verify invoice history panel
- View invoice summary details

## Key Features

### Explicit Waits
The framework uses **WebDriverWait** with 15-second timeouts for:
- Element visibility checks
- Element clickability
- Dynamic element loading

### Robust Element Locators
Multiple locator strategies:
- **ID-based selectors**: For stable elements
- **XPath**: For complex hierarchical navigation
- **Contains locators**: For elements with dynamic IDs

### Custom Assertions
- Login success verification
- Inventory form validation
- Invoice content verification
- Discount calculation validation

## Key Page Objects

### LoginPage
Methods:
- `clickLoginButton()`
- `enterEmailAddress(String email)`
- `enterPassword(String password)`
- `clickSubmitButton()`
- `verifyLoginSuccess(String expectedMessage)`

### InventoryPage
Methods:
- `clickLearnBtn()` - Navigate to learning section
- `clickMaterials()` - Open learning materials
- `clickWebAdvance()` - Select web advancement course
- `selectedDeviceOption()` - Choose device type
- `selectedBrand()` - Select product brand
- `selectedStorageOption()` - Pick storage capacity
- `setSelectedColor()` - Choose product color
- `setProductQuantity(int quantity)` - Set quantity
- `setInputAddress(String address)` - Enter delivery address
- `clickNextButton()` - Proceed to checkout
- `selectShippingOption()` - Choose shipping method
- `selectWarrantyOption()` - Select warranty
- `captureDiscountCode(String code)` - Input discount code
- `clickApplyDiscountButton()` - Apply discount
- `calculateDiscountedTotal()` - Verify discount calculation
- `confirmPurchase()` - Complete purchase

### InvoicePage
Methods:
- `clickViewInvoiceButton()` - Open invoice details
- `verifyInvoiceHistoryPanel()` - Validate history panel
- `clickViewInvoiceSummary()` - View invoice summary

## Test Execution

### Prerequisites
- Java 21 installed
- Maven installed
- Chrome browser installed (or alternative supported browser)

### Running Tests
```bash
mvn clean test
```

### Running Specific Test Class
```bash
mvn test -Dtest=PurchaseTest
```

## Wait Strategies

The framework uses explicit waits to handle dynamic content:
- **Element Visibility**: Waits for elements to be visible before interaction
- **Element Clickability**: Ensures elements are clickable before clicking
- **Default Timeout**: 15 seconds per element operation

## Error Handling

- Custom `AssertionError` messages for verification failures
- Clear identification of expected vs. actual values
- Null pointer exception prevention through proper initialization

## Configuration

### Application Under Test (AUT)
- **URL**: https://ndosisimplifiedautomation.vercel.app/
- **Credentials**: 
  - Email: mpho@gmail.com
  - Password: 1234567890@

### Test Data
- Test Product Quantity: 2 units
- Discount Code: SAVE10
- Delivery Address: 123 Test Street

## Future Enhancements

- [ ] Data-driven testing with external data sources
- [ ] Cross-browser parallel execution
- [ ] Enhanced reporting with screenshots on failures
- [ ] Parameterized test scenarios
- [ ] API integration testing
- [ ] Performance testing
- [ ] Multiple test environments support

## Notes

- Browser teardown is currently commented out in `BaseTest.java` to allow manual inspection of test results
- Tests use dynamic element identification for auto-incrementing IDs
- Discount verification includes numerical precision handling
- Invoice PDF handling support for new window/tab verification

