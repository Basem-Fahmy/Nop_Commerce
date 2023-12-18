package My_Account;
import Base_Class.Base_Class;
import Test_Data.import_excel;
import Test_Data.import_excel2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

@Test(dataProvider ="test_data")
public class TC_01_Change_First_And_Last_Name extends Base_Class {

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
        driver.findElement(My_Account_Link).click();  // go to user profile page
        driver.findElement(New_First_Name_Input).clear();  // clear  first name input
        driver.findElement(New_First_Name_Input).sendKeys("first01 ");  // update first name
        driver.findElement(New_Last_Name_Input).clear();  // clear last name input
        driver.findElement(New_Last_Name_Input).sendKeys("last01 ");  // update last name
        driver.findElement(Save_Info_Btn).click();   // click save info button

        //Assertion
        String message = driver.findElement(Store02_Assertion_Element).getText();
        //Expected & Actual Result : user see [message] "The customer info has been updated successfully."
        Assert.assertEquals(message,message);
        //Assertion
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel2 obj = new import_excel2();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }



}







