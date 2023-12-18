package Register;
import Base_Class.Base_Class;
import Test_Data.import_excel;
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

@Test(dataProvider ="test_data")
public class TC_01_Register_Using_Valid_Email extends Base_Class {

    public void TC_01
        (String First_Name,String Last_Name,String Reg_Email,String UserName,String Password,
         String Company_Name,String Invalid_Email_Format,String Wrong_Password,
         String UnRegistered_Email,String City, String Address1,String Address2,
         String Zip_Code,String Phone_Number,String Fax_Number, String Existing_Product,
         String Non_Existing_Product,String New_First_Name,String New_Last_Name,
         String New_Address1,String New_Address2,String New_Password){

        driver.get("https://demo.nopcommerce.com");  // open website
        driver.findElement(Register_Link).click();// click register link
        driver.findElement(Gender_Select).click(); // select gender
        driver.findElement(FirstName_Input).sendKeys(First_Name); // enter firstname
        driver.findElement(LastName_Input).sendKeys(Last_Name);  //enter lastname

        Select s1= new Select(driver.findElement(Day_Select));
        s1.selectByVisibleText("5");

        Select s2 = new Select(driver.findElement(Month_Select));
        s2.selectByVisibleText("April");

        Select s3= new Select(driver.findElement(Year_Select));
        s3.selectByVisibleText("1999");

        driver.findElement(Email_Input).sendKeys(Reg_Email);   //enter email
        driver.findElement(Company_Input).sendKeys(Company_Name); // enter company name
        driver.findElement(Password_Input).sendKeys(Password); //enter password
        driver.findElement(Confirm_Password_Input).sendKeys(Password);//confirm password
        driver.findElement(Register_Btn).submit();  //subit data to register

        //Assertion
        String message = driver.findElement(Register01_Assertion_Element).getText();
        //Expected & Actual Result : user see [message] "Your registration completed"
        Assert.assertEquals(message,message);
        //Assertion
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel obj = new import_excel();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }


}







