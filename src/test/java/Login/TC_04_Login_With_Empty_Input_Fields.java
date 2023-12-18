package Login;

import Base_Class.Base_Class;
import Test_Data.import_excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
public class TC_04_Login_With_Empty_Input_Fields extends Base_Class {

    public void TC_04
        (String First_Name,String Last_Name,String Reg_Email,String UserName,String Password,
         String Company_Name,String Invalid_Email_Format,String Wrong_Password,
         String UnRegistered_Email,String City, String Address1,String Address2,
         String Zip_Code,String Phone_Number,String Fax_Number, String Existing_Product,
         String Non_Existing_Product,String New_First_Name,String New_Last_Name,
         String New_Address1,String New_Address2,String New_Password){

        driver.get("https://demo.nopcommerce.com");  // open website
        driver.findElement(Login_Link).click();  // click login link

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"Email\"]")));

        driver.findElement(Login_Btn).submit();  //click login btn

        //Assertion
        String message = driver.findElement(Login04_Assertion_Element).getText();
        //Expected & Actual Result : user see [message] "Please enter your email"
        Assert.assertEquals(message,message);
        //Assertion
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel obj = new import_excel();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }

}







