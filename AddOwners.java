package pages;

import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class AddOwners {

    String FirstName,LastName,Address,City;
    int Telephone;
    WebDriver oDriver;
    By findOwners = By.xpath("//a[@title='find owners']");
    By newOwner = By.xpath("//a[@href='/owners/new']");
    By firstname = By.xpath("//input[@id='firstName']");
    By lastname = By.xpath("//input[@id='lastName']");
    By address = By.xpath("//input[@id='address']");
    By city = By.xpath("//input[@id='city']");
    By telephone = By.xpath("//input[@id='telephone']");
    By addownerbtn = By.xpath("//*[@id='add-owner-form']/div[2]/div/button");
    By addowner = By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b");
        public AddOwners(WebDriver oDriver){

            this.oDriver=oDriver;
        }

    /*Add New Owner*/
        public void AddNewOwner() throws InterruptedException {

            oDriver.findElement(findOwners).click();
            Thread.sleep(1000);
            oDriver.findElement(newOwner).click();
            Thread.sleep(2000);

            System.out.println("Please enter First Name: ");
            Scanner scan1 = new Scanner(System.in);
            FirstName = scan1.nextLine();
            oDriver.findElement(firstname).sendKeys(FirstName);

            System.out.println("Please enter Last Name: ");
            Scanner scan2 = new Scanner(System.in);
            LastName = scan2.nextLine();
            oDriver.findElement(lastname).sendKeys(LastName);

            System.out.println("Please enter Address: ");
            Scanner scan3 = new Scanner(System.in);
            Address = scan3.nextLine();
            oDriver.findElement(address).sendKeys(Address);

            System.out.println("Please enter City: ");
            Scanner scan4 = new Scanner(System.in);
            City = scan4.nextLine();
            oDriver.findElement(city).sendKeys(City);

            System.out.println("Please enter Telephone: ");
            Scanner scan5 = new Scanner(System.in);
            Telephone = Integer.parseInt(scan5.nextLine());
            oDriver.findElement(telephone).sendKeys(String.valueOf(Telephone));

            WebElement AddOwnerBtn = oDriver.findElement(addownerbtn);
            // oDriver.findElement(By.xpath("//button[contains(text(),'Add Owner')]")).click();
            if(AddOwnerBtn.isEnabled()){
                ((JavascriptExecutor) oDriver).executeScript("arguments[0].click();",AddOwnerBtn);
                System.out.println("Add Owner button clicked successfully");
            }
            else{
                //Assert.fail(AddOwnerBtn + "is  not enabled");
                System.out.println("Add Owner button not enabled");
            }
            Thread.sleep(1500);
            String AddedOwner = oDriver.findElement(addowner).getText();
            System.out.println("Owner " + AddedOwner + " added successfully");
            Thread.sleep(2000);
        }

    /*Add Pet for added Owner*/
    public void AddPetForAddedOwner() throws InterruptedException {
        String PetName, BirthDate,Type;
        By addpetbtn = By.xpath("//a[contains(@href,'pets/new')]");
        By petname = By.xpath("//input[@id='name']");
        By birthdate = By.xpath("//input[@id='birthDate']");
        By type = By.id("type");
        By typedropdown = By.xpath("//button[@type='submit']");
        By submitBtn = By.xpath("//button[@type='submit']");

        WebElement AddPetBtn = oDriver.findElement(addpetbtn);
        if(AddPetBtn.isEnabled()){
            ((JavascriptExecutor) oDriver).executeScript("arguments[0].click();",AddPetBtn);
            System.out.println("Add New Pet button clicked successfully");
        }
        else{
            //Assert.fail(AddPetBtn + " is  not enabled");
            System.out.println("Add New Pet button is not enabled");
        }

        System.out.println("Please enter Pet Name: ");
        Scanner scan1 = new Scanner(System.in);
        PetName = scan1.nextLine();
        oDriver.findElement(petname).sendKeys(PetName);

        WebElement BirthDateBtn = oDriver.findElement(birthdate);
        ((JavascriptExecutor) oDriver).executeScript("arguments[0].value=('2019-10-14')",BirthDateBtn);

        System.out.println("Please enter Type as bird/cat/dog/hamster/lizard/snake ");
        Scanner scan3 = new Scanner(System.in);
        Type = scan3.nextLine();
        Select PetType = new Select(oDriver.findElement(type));
        PetType.selectByVisibleText(Type);
        oDriver.findElement(typedropdown).click();

        WebElement AddPetBtn2 = oDriver.findElement(submitBtn);
        if(AddPetBtn2.isEnabled()){
            ((JavascriptExecutor) oDriver).executeScript("arguments[0].click();",AddPetBtn2);
            System.out.println("Add Pet button clicked successfully");
        }
        else{
            //Assert.fail(AddPetBtn2 + " is  not enabled");
            System.out.println("Add Pet button is not enabled");
        }

    }


}
