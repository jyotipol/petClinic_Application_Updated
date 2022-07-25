package common;

import okhttp3.Address;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import javax.swing.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import pages.AddOwners;
import pages.Homepage;

public class launchApplicationPetClinic {


    public static void main(String args[]) throws InterruptedException {


        WebDriver oDriver;
        AddOwners objAddOwners;
        Homepage objHomepage;

            oDriver = new SafariDriver();
            oDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            oDriver.get("http://localhost:8080/owners/11");
            oDriver.manage().window().maximize();

            objHomepage = new Homepage(oDriver);
            objHomepage.ValidateHomePageImage();
            objAddOwners = new AddOwners(oDriver);
            objAddOwners.AddNewOwner();
            objAddOwners.AddPetForAddedOwner();
            oDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            oDriver.close();
        
    }

}

