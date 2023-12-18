package Shopping_Cart;

import Base_Class.Base_Class;
import Test_Data.import_excel2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
public class TC_03_Increase_Quantity_For_Product extends Base_Class {

    public void TC_03
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
        driver.findElement(Qty_Value).clear(); // delete current value
        driver.findElement(Qty_Value).sendKeys("3"); // enter new value
        driver.findElement(Update_Cart).click(); // click update cart btn

        //Assertion
        String Total = driver.findElement(Total_Value).getText();
        // total value for 1 item = $1,335.00  , for 3 items = $4,005.00
        //Expected & Actual Result : total value = $4,005.00
        Assert.assertEquals("$4,005.00",Total);
        //Assertion
    }

    @DataProvider
    public Object[][]test_data() throws Exception {
        import_excel2 obj = new import_excel2();  // create object  from excelsheet function
        return obj.data_import();   // return object from the inside function
    }



}







