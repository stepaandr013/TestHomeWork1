package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TextBoxTest {

    WebDriver driver;

    @Test
    public void textBoxTest(){

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.navigate().to("https://demoqa.com/text-box");
        String nameText = "Stepan";
        String emailText = "stepan@gmail.com";
        String currentAddressText = "CEITI IS MY HOUSE";
        String permanentAddressText = "HOME";


        WebElement textBoxName = driver.findElement(By.id("userName"));
        textBoxName.click();
        textBoxName.clear();
        textBoxName.sendKeys(nameText);

        WebElement textBoxEmail = driver.findElement(By.id("userEmail"));
        textBoxEmail.click();
        textBoxEmail.clear();
        textBoxEmail.sendKeys(emailText);

        WebElement textBoxCurrentAddress = driver.findElement(By.id("currentAddress"));
        textBoxCurrentAddress.click();
        textBoxCurrentAddress.clear();
        textBoxCurrentAddress.sendKeys(currentAddressText);

        WebElement textBoxPermanentAddress = driver.findElement(By.id("permanentAddress"));
        textBoxPermanentAddress.click();
        textBoxPermanentAddress.clear();
        textBoxPermanentAddress.sendKeys(permanentAddressText);


        WebElement buttonSubmit = driver.findElement(By.id("submit"));
        buttonSubmit.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> submitResult = driver.findElements(By.xpath("//div[@id=\"output\"]/div/p"));
        Assert.assertFalse(submitResult.isEmpty());


        WebElement resultName = driver.findElement(By.xpath("//div[@id=\"output\"]/div/p[@id=\"name\"]"));
        String name = resultName.getText();
        System.out.println(name);
        if(name.substring(5).equals(nameText)){
            System.out.println("Text Box name is correct - " + nameText + "!!!\n");
        }else {
            System.out.println("ERROR!!!!\n" +
                    "Text Box name isn't correct!!! \n");
        }
        Assert.assertTrue(name.substring(5).equals(nameText));


        WebElement resultEmail = driver.findElement(By.xpath("//div[@id=\"output\"]/div/p[@id=\"email\"]"));
        String email = resultEmail.getText();
        System.out.println(email);
        if(email.substring(6).equals(emailText)){
            System.out.println("Text Box email is correct - " + emailText + "!!!\n");
        }else {
            System.out.println("ERROR!!!!\n" +
                    "Text Box email isn't correct!!! \n");
        }
        Assert.assertTrue(email.substring(6).equals(emailText));


        WebElement resultCurrentAddress = driver.findElement(By.xpath("//div[@id=\"output\"]/div/p[@id=\"currentAddress\"]"));
        String currentAddress = resultCurrentAddress.getText();
        System.out.println(currentAddress);
        if(currentAddress.substring(17).equals(currentAddressText)){
            System.out.println("Text Box Current Address is correct - " + currentAddressText + "!!!\n");
        }else {
            System.out.println("ERROR!!!!\n" +
                    "Text Box Current Address isn't correct!!! \n");
        }
        Assert.assertTrue(currentAddress.substring(17).equals(currentAddressText));


        WebElement resultPermanentAddress = driver.findElement(By.xpath("//div[@id=\"output\"]/div/p[@id=\"permanentAddress\"]"));
        String permanentAddress = resultPermanentAddress.getText();
        System.out.println(permanentAddress);
        if(permanentAddress.substring(20).equals(permanentAddressText)){
            System.out.println("Text Box Permanent Address is correct - " + permanentAddressText + "!!!\n");
        }else {
            System.out.println("ERROR!!!!\n" +
                    "Text Box Permanent Address isn't correct!!! \n");
        }
        Assert.assertTrue(permanentAddress.substring(20).equals(permanentAddressText));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }

}
