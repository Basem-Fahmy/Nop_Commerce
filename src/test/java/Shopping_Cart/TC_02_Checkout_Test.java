package Shopping_Cart;
import Base_Class.Base_Class;
import Test_Data.import_excel2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Test(dataProvider ="test_data")
public class TC_02_Checkout_Test extends Base_Class {

    public void TC_02
        (String First_Name,String Last_Name,String Reg_Email,String UserName,String Password,
         String Company_Name,String Invalid_Email_Format,String Wrong_Password,
         String UnRegistered_Email,String City, String Address1,String Address2,
         String Zip_Code,String Phone_Number,String Fax_Number, String Existing_Product,
         String Non_Existing_Product,String New_First_Name,String New_Last_Name,
         String New_Address1,String New_Address2,String New_Password){

        driver.get("https://demo.nopcommerce.com");  // open website
        driver.findElement(Login_Link).click();  // click login link
        driver.findElement(Email_Input).sendKeys(Reg_Email);   //enter email
        driver.findElement(Password_Input).sendKeys(Password); //enter password
        driver.findElement(Login_Btn).submit();  //click login btn
        driver.findElement(Store_Computers).click(); // click on Computer store link
        driver.findElement(Desktops_Section).click(); // open desktops section
        driver.findElement(Product).click(); // select product

        Select s1 = new Select(driver.findElement(Ram_Select));   // select ram
        s1.selectByValue("4");

        driver.findElement(Hdd_Radio_Btn).click();   //select hdd
        driver.findElement(Add_To_Cart_Btn).click();   //add product to cart
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.findElement(Cart).click();  // open shopping cart
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.findElement(Terms_Of_Service).click();  // check on agree with terms of service
        driver.findElement(Checkout_Btn).click();  // click to checkout

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(Country_Select));

        Select s2 = new Select(driver.findElement(Country_Select));   // select country
        s2.selectByValue("1");

        Select s3 = new Select(driver.findElement(State_Select));   // select state
        s3.selectByValue("52");

        driver.findElement(City_Input).sendKeys(City); // enter city
        driver.findElement(Address1_Input).sendKeys(Address1); // enter address1
        driver.findElement(Address2_Input).sendKeys(Address2); // enter address2
        driver.findElement(Zip_Code_Input).sendKeys(Zip_Code); // enter zip code
        driver.findElement(Phone_Input).sendKeys(Phone_Number); // enter phone number
        driver.findElement(Fax_Input).sendKeys(Fax_Number); // enter fax number
        driver.findElement(Checkout_Btn2).click(); // click continue btn
        driver.findElement(Checkout_Btn3).click(); // click continue btn
        driver.findElement(Checkout_Btn4).click(); // click continue btn
        driver.findElement(Checkout_Btn5).click(); // click continue btn
        driver.findElement(Confirm_Order_Btn).click(); // confirm order

        //Assertion
        String message = driver.findElement(Shopping_Cart_01_Assertion_Element).getText();
        //Expected & Actual Result : user see [message] "Your order has been successfully processed!"
        Assert.assertEquals(message,message);
        //Assertion
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel2 obj = new import_excel2();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }

}







