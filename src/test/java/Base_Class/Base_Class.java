package Base_Class;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Base_Class {    // this method is used to open browser
    public WebDriver driver =new ChromeDriver();
    @BeforeClass
        public void  open_browser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void Close_browser(){ // this method is used to close browser
        driver.quit();
    }

    // page objects
    public By Register_Link = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    public By Gender_Select = By.xpath("//*[@id=\"gender\"]/span[1]");
    public By FirstName_Input= By.xpath("//*[@id=\"FirstName\"]");
    public By LastName_Input = By.xpath("//*[@id=\"LastName\"]");
    public By Email_Input = By.xpath("//*[@id='Email']");
    public By Day_Select = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]");
    public By Month_Select= By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    public By Year_Select= By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]");
    public By Company_Input = By.xpath("//*[@id=\"Company\"]");
    public By Password_Input = By.xpath("//*[@id=\"Password\"]");
    public By Confirm_Password_Input = By.xpath("//*[@id=\"ConfirmPassword\"]");
    public By Register_Btn = By.xpath("//*[@id=\"register-button\"]");
    public By Register01_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]");
    public By Register02_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[5]/span[2]");
    public By Login_Link = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    public By Logout_Link = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
    public By Login_Btn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");
    public By Forgot_Password_Link = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[3]/span/a");
    public By Recover_Password_Btn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button");
    public By Login01_Assertion_Element = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    public By Login02_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");
    public By Login04_Assertion_Element = By.xpath("//*[@id=\"Email-error\"]");
    public By Login05_Assertion_Element = By.xpath("//*[@id=\"bar-notification\"]/div/p");
    public By Store_Computers = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
    public By Desktops_Section = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a");
    public By Product = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[1]/a");
    public By Ram_Select = By.xpath("//*[@id=\"product_attribute_2\"]");
    public By Hdd_Radio_Btn = By.xpath("//*[@id=\"product_attribute_input_3\"]/ul/li[1]/label");
    public By Add_To_Cart_Btn = By.xpath("//*[@id=\"add-to-cart-button-1\"]");
    public By Add_To_Wishlist_Btn = By.xpath("//*[@id=\"add-to-wishlist-button-1\"]");
    public By Send_to_Friend_Btn = By.xpath("//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[9]/div[3]/button");
    public By Friend_Email_Input = By.xpath("//*[@id=\"FriendEmail\"]");
    public By Store02_Assertion_Element = By.xpath("//*[@id=\"bar-notification\"]/div/p");
    public By Store03_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]");
    public By Cart = By.xpath("//*[@id=\"topcartlink\"]/a");
    public By Terms_Of_Service = By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[3]/label");
    public By Checkout_Btn = By.xpath("//*[@id=\"checkout\"]");
    public By Country_Select = By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]");
    public By State_Select = By.xpath("//*[@id=\"BillingNewAddress_StateProvinceId\"]");
    public By City_Input = By.xpath("//*[@id=\"BillingNewAddress_City\"]");
    public By Address1_Input = By.xpath("//*[@id=\"BillingNewAddress_Address1\"]");
    public By Address2_Input = By.xpath("//*[@id=\"BillingNewAddress_Address2\"]");
    public By Zip_Code_Input = By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]");
    public By Phone_Input = By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]");
    public By Fax_Input = By.xpath("//*[@id=\"BillingNewAddress_FaxNumber\"]");
    public By Checkout_Btn2 = By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");
    public By Checkout_Btn3 = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    public By Checkout_Btn4 = By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
    public By Checkout_Btn5 = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    public By Confirm_Order_Btn = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
    public By Shopping_Cart_01_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
    public By Qty_Value  = By.className("qty-input");
    public By Update_Cart = By.xpath("//*[@id=\"updatecart\"]");
    public By Total_Value = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]/span");
    public By Shopping_Cart_04_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div");
    public By Remove_Btn = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[7]/button");
    public By Remove_Btn2 = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]/button");
    public By WishList_Link = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a");
    public By Wishlist_01_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div");
    public By Add_To_Cart_Btn2 = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[2]/button[2]");
    public By Select_Products = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]/input");
    public By Send_to_Friend_Btn2 = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[2]/button[3]");
    public By Send_Email_Btn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button");
    public By Search_Bar = By.xpath("//*[@id=\"small-searchterms\"]");
    public By Search_Submit = By.xpath("//*[@id=\"small-search-box-form\"]/button");
    public By Search_Result = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a");
    public By Search_02_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div");
    public By My_Account_Link = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    public By New_First_Name_Input = By.xpath("//*[@id=\"FirstName\"]");
    public By New_Last_Name_Input = By.xpath("//*[@id=\"LastName\"]");
    public By Save_Info_Btn = By.xpath("//*[@id=\"save-info-button\"]");
    public By My_Account_03_Assertion_Element = By.xpath("//*[@id=\"FirstName-error\"]");
    public By Address_Page = By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[2]/a");
    public By Add_New_Address = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/button");
    public By Save_New_Address = By.xpath("/html/body/div[6]/div[3]/div/div[2]/form/div/div[2]/div[2]/button");
    public By Address_First_Name_Input = By.xpath("//*[@id=\"Address_FirstName\"]");
    public By Address_Last_Name_Input = By.xpath("//*[@id=\"Address_LastName\"]");
    public By Address_Email_Input = By.xpath("//*[@id=\"Address_Email\"]");
    public By Address_Company_Input = By.xpath("//*[@id=\"Address_Company\"]");
    public By Address_Country_Select = By.xpath("//*[@id=\"Address_CountryId\"]");
    public By Address_City_Input = By.xpath("//*[@id=\"Address_City\"]");
    public By Add_Address1_Input = By.xpath("//*[@id=\"Address_Address1\"]");
    public By Add_Address2_Input = By.xpath("//*[@id=\"Address_Address2\"]");
    public By Address_Zip_Code_Input = By.xpath("//*[@id=\"Address_ZipPostalCode\"]");
    public By Address_Phone_Input = By.xpath("//*[@id=\"Address_PhoneNumber\"]");
    public By Address_Fax_Input = By.xpath("//*[@id=\"Address_FaxNumber\"]");
    public By Edit_Address_Btn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[1]/div/div[2]/button[1]");
    public By Delete_Address_Btn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[1]/div/div[2]/button[2]");
    public By My_Account_07_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[1]");
    public By Password_Page = By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a");
    public By Old_Password_Input = By.xpath("//*[@id=\"OldPassword\"]");
    public By New_Password_Input = By.xpath("//*[@id=\"NewPassword\"]");
    public By Confirm_New_Password_Input = By.xpath("//*[@id=\"ConfirmNewPassword\"]");
    public By Change_Password_Btn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button");
    public By My_Account_09_Assertion_Element = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[1]/ul/li");

    // page objects

}
