package Wishlist;
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
public class TC_04_Send_Product_To_Friend_By_Email extends Base_Class {

    public void TC_04
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
        driver.findElement(Store_Computers).click(); // open computer store
        driver.findElement(Desktops_Section).click(); // select desktops section
        driver.findElement(Product).click(); // select product

        Select s2 = new Select(driver.findElement(Ram_Select));  // select ram
        s2.selectByValue("4");

        driver.findElement(Hdd_Radio_Btn).click();// select hdd
        driver.findElement(Add_To_Wishlist_Btn).click();// click add to wishlist button
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.findElement(WishList_Link).click();  // go to Wishlist page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.findElement(Send_to_Friend_Btn2).click();
        driver.findElement(Friend_Email_Input).sendKeys(UnRegistered_Email); // enter frind email
        driver.findElement(Send_Email_Btn).click(); // send email


        //Assertion
        String message = driver.findElement(Wishlist_01_Assertion_Element).getText();
        //Expected & Actual Result : [message] "Your message has been sent."
        Assert.assertEquals(message,message);
        //Assertion
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel2 obj = new import_excel2();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }

}






