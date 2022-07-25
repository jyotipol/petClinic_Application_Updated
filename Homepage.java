package pages;

import org.junit.Assert;
//import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Homepage {
    WebDriver oDriver;
    By ImageFile = By.xpath("//img[@class='img-responsive']");
    By homepage = By.xpath("//a[@title='home page']");
    public Homepage(WebDriver oDriver){

        this.oDriver=oDriver;
    }

    /*Validate Home Page Image*/

    public void ValidateHomePageImage() throws InterruptedException{

       oDriver.findElement(homepage).click();
       WebElement ImageFile = oDriver.findElement(By.xpath("//img[@class='img-responsive']"));

       Boolean ImagePresent = (Boolean) ((JavascriptExecutor) oDriver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
       Assert.assertEquals(true, ImageFile.isDisplayed());
        //System.out.println("Welcome page image is displayed – Assert passed");

    }



}
