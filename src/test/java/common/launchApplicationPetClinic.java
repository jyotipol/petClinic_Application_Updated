package common;

import org.apache.commons.math3.analysis.function.Add;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;

import javax.swing.*;
import java.io.*;

import java.io.File;
import java.util.Scanner;

public class launchApplicationPetClinic {
    //public WebDriver oDriver;
    static WebDriver oDriver = new SafariDriver();

    public static void main(String args[]) throws InterruptedException, IOException {

        oDriver.navigate().to("http://localhost:8080/owners/11");
        oDriver.manage().window().maximize();
        Thread.sleep(1000);
        oDriver.findElement(By.xpath("//a[@title='home page']")).click();
        Thread.sleep(1000);
        //driver.quit();
        CheckHomepageImage();
        //new ReadExcelData();
        AddFindOwners();
        AddPetForAddedOwner();
    }

    public static void CheckHomepageImage() {


        WebElement ImageFile = oDriver.findElement(By.xpath("//img[@class='img-responsive']"));

        Boolean ImagePresent = (Boolean) ((JavascriptExecutor) oDriver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        Assert.assertEquals(true, ImageFile.isDisplayed());
        System.out.println("Welcome page image is displayed – Assert passed");
    }

    public static void AddFindOwners() throws InterruptedException {
        String FirstName,LastName,Address,City;
        int Telephone;
        oDriver.findElement(By.xpath("//a[@title='find owners']")).click();
        Thread.sleep(1000);
        oDriver.findElement(By.xpath("//a[@href='/owners/new']")).click();
        Thread.sleep(2000);
        //WebElement fName = oDriver.findElement(By.xpath("//input[@name='firstName' and type='text']"));
        System.out.println("Please enter First Name: ");
        Scanner scan1 = new Scanner(System.in);
        FirstName = scan1.nextLine();
        //System.out.println(FirstName);
        oDriver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(FirstName);

        System.out.println("Please enter Last Name: ");
        Scanner scan2 = new Scanner(System.in);
        LastName = scan2.nextLine();
        //System.out.println(LastName);
        oDriver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(LastName);

        System.out.println("Please enter Address: ");
        Scanner scan3 = new Scanner(System.in);
        Address = scan3.nextLine();
        //System.out.println(Address);
        oDriver.findElement(By.xpath("//input[@id='address']")).sendKeys(Address);

        System.out.println("Please enter City: ");
        Scanner scan4 = new Scanner(System.in);
        City = scan4.nextLine();
        //System.out.println(City);
        oDriver.findElement(By.xpath("//input[@id='city']")).sendKeys(City);

        System.out.println("Please enter Telephone: ");
        Scanner scan5 = new Scanner(System.in);
        Telephone = Integer.parseInt(scan5.nextLine());
        //System.out.println(Telephone);
        oDriver.findElement(By.xpath("//input[@id='telephone']")).sendKeys(String.valueOf(Telephone));

        WebElement AddOwnerBtn = oDriver.findElement(By.xpath("//*[@id='add-owner-form']/div[2]/div/button"));
       // oDriver.findElement(By.xpath("//button[contains(text(),'Add Owner')]")).click();
        if(AddOwnerBtn.isEnabled()){
            ((JavascriptExecutor) oDriver).executeScript("arguments[0].click();",AddOwnerBtn);
            System.out.println("Add Owner button clicked successfully");
        }
        else{
            Assert.fail(AddOwnerBtn + "is  not enabled");
        }
        Thread.sleep(1500);
        String AddedOwner = oDriver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b")).getText();
        System.out.println("Owner " + AddedOwner + " added successfully");
        Thread.sleep(2000);

    }

    public static void AddPetForAddedOwner() throws InterruptedException {
        String PetName, BirthDate,Type;
        WebElement AddPetBtn = oDriver.findElement(By.xpath("//a[contains(@href,'pets/new')]"));
        if(AddPetBtn.isEnabled()){
            ((JavascriptExecutor) oDriver).executeScript("arguments[0].click();",AddPetBtn);
            System.out.println("Add New Pet button clicked successfully");
        }
        else{
            Assert.fail(AddPetBtn + " is  not enabled");
        }

        System.out.println("Please enter Pet Name: ");
        Scanner scan1 = new Scanner(System.in);
        PetName = scan1.nextLine();
        //System.out.println(FirstName);
        oDriver.findElement(By.xpath("//input[@id='name']")).sendKeys(PetName);

        //WebElement BirthDateBtn = oDriver.findElement(By.xpath("//input[@id='birthDate']"));
        System.out.println("Please enter BirthDate in the form of DD: ");
        Scanner scan2 = new Scanner(System.in);
        BirthDate = scan2.nextLine();
        //WebElement birthdate = oDriver.findElement(By.xpath("//form//input[@name='birthDate']"));

        //birthdate.sendKeys(Keys.TAB);
        //birthdate.sendKeys("03");
        //oDriver.findElement(By.xpath("//input[@id='birthDate']")).sendKeys(BirthDate);

        //System.out.println("Please enter BirthDate inform of DD MM YYYY: ");
        //Scanner scan3 = new Scanner(System.in);
        //String BirthMonth = scan3.nextLine();
        //birthdate.sendKeys(BirthMonth);

        //oDriver.findElement(By.xpath("//input[@id='birthDate']")).sendKeys(BirthMonth);

    }

}


