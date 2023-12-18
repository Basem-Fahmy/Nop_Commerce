package My_Account;
import Base_Class.Base_Class;
import Test_Data.import_excel2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
public class TC_07_Delete_Existing_Address extends Base_Class {

    public void TC_07
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
        driver.findElement(My_Account_Link).click();  // go to user profile page
        driver.findElement(Address_Page).click(); // go to address page
        driver.findElement(Add_New_Address).click();  // click add new address button

        driver.findElement(Address_First_Name_Input).sendKeys(First_Name);
        driver.findElement(Address_Last_Name_Input).sendKeys(Last_Name);
        driver.findElement(Address_Email_Input).sendKeys(Reg_Email);
        driver.findElement(Address_Company_Input).sendKeys(Company_Name);

        Select s2 = new Select(driver.findElement(Address_Country_Select));   // select country
        s2.selectByValue("1");

        driver.findElement(Address_City_Input).sendKeys(City); // enter city
        driver.findElement(Add_Address1_Input).sendKeys(Address1); // enter address1
        driver.findElement(Add_Address2_Input).sendKeys(Address2); // enter address2
        driver.findElement(Address_Zip_Code_Input).sendKeys(Zip_Code); // enter zip code
        driver.findElement(Address_Phone_Input).sendKeys(Phone_Number); // enter phone number
        driver.findElement(Address_Fax_Input).sendKeys(Fax_Number); // enter fax number
        driver.findElement(Save_New_Address).click();   // click save changes button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(Delete_Address_Btn).click();  // click delete address button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().alert().accept();  // confirm address delete

        //Assertion
        String message = driver.findElement(My_Account_07_Assertion_Element).getText();
        //Expected & Actual Result : user see [message] "No addresses"
        Assert.assertEquals(message,message);
        //Assertion
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel2 obj = new import_excel2();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }

}







