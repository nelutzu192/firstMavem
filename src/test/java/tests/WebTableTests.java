package tests;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTableTests {

    public static void testWebTable(){
        WebDriver driver = WebDriverManager.createChromeDriver();
        driver.get("http://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        WebElement tableCaption = driver.findElement(By.cssSelector("table#dynamictable caption"));

        System.out.println(tableCaption.getText());

        // select table rows and columns
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table#dynamictable tr"));
        WebElement firstRow = tableRows.get(0);
        List<WebElement> firstRowColumns = firstRow.findElements(By.cssSelector("th"));
        System.out.println("Header din prima coloana: " + firstRowColumns.get(0).getText());
        System.out.println("Header din a doua coloana: " + firstRowColumns.get(1).getText());
        System.out.println("");


        WebElement secondRow = tableRows.get(1);
        List<WebElement> secondRowColumns = secondRow.findElements(By.cssSelector("td"));
        System.out.println("Text din randul 2 coloana 1: " + secondRowColumns.get(0).getText());
        System.out.println("Text din randul 2 coloana 2: " + secondRowColumns.get(1).getText());
        System.out.println("");


        WebElement thirdRow = tableRows.get(2);
        List<WebElement> thirdRowColumns = thirdRow.findElements(By.cssSelector("td"));
        System.out.println("Text din randul 3 coloana 1: " + thirdRowColumns.get(0).getText());
        System.out.println("Text din randul 3 coloana 2: " + thirdRowColumns.get(1).getText());

        driver.quit();
    }

    public static void testDynamicWebTable(){

        WebDriver driver = WebDriverManager.createChromeDriver();
        driver.get("http://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        //click details summary
        WebElement summary = driver.findElement(By.cssSelector("details summary"));
        summary.click();

        //manipulate caption text box
        WebElement caption = driver.findElement(By.id("caption"));
        //golim textul
        caption.clear();
        //introducem text
        caption.sendKeys("Text introdus de noi");


        //update table id
        WebElement tableId = driver.findElement(By.id("tableid"));
        tableId.clear();
        tableId.sendKeys("custom Id");

        //click refresh table button
        WebElement refreshTableButton = driver.findElement(By.id("refreshtable"));
        refreshTableButton.click();

        //look at the table caption text after refhres has been hit
        WebElement tableCaption = driver.findElement(By.cssSelector("#tablehere table caption"));
        System.out.println(tableCaption.getText());

        WebElement table = driver.findElement(By.cssSelector("#tablehere table"));
        //get attribute ID
        System.out.println(table.getAttribute("id"));


        driver.quit();

    }

    public static void main(String[] args) {
//        testWebTable();
        testDynamicWebTable();
        System.out.println("DEBUG");



    }

}
