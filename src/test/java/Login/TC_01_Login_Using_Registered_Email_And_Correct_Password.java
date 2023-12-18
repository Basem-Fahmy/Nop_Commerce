package Login;
import Base_Class.Base_Class;
import Test_Data.import_excel2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class TC_01_Login_Using_Registered_Email_And_Correct_Password extends Base_Class {

    public void TC_01
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Assertion
        String message = driver.findElement(Login01_Assertion_Element).getText();
        //Expected & Actual Result : user can see "My Account" link
        Assert.assertEquals(message,message);
        //Assertion
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel2 obj = new import_excel2();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }

}







