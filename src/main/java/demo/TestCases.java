package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        //WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        //driver.navigate().to("https://leetcode.com/");
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        if(URL.contains("leetcode")){
            System.out.println("URL contains LeetCode in it");
        }else{
            System.out.println("URL doesnot contains LeetCode in it");
        }
        System.out.println("end Test case: testCase01");
    }


    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com/");

        WebElement questions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        questions.click();
        Thread.sleep(2000);

        String URL = driver.getCurrentUrl();
        if(URL.contains("problemset")){
            System.out.println("URL contains problemset in it");
        }else{
            System.out.println("URL doesnot contains problemset in it");
        }

        
        for(int i=1; i<6 ; i++){
            List<WebElement> questionLists = driver.findElements(By.xpath("//div[contains(@class,'odd:bg-layer-1')]//div[@class='truncate']"));
            String questionList =questionLists.get(i).getText();
            System.out.println("Question From List---- " + questionList);
            questionLists.get(i).click();
            Thread.sleep(2000);
            String title = driver.getTitle();
            System.out.println("Title of the Page ----" + title);
            String questionName = questionList.substring(3);
            if(title.contains(questionName)){
                System.out.println("Question Name matches the Title");
            }else{
                System.out.println("Question Name does not matches the Title");
            }
            driver.navigate().back();
            Thread.sleep(2000);
        }

        System.out.println("end Test case: testCase02");
    }


    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");
        
        WebElement questions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        questions.click();
        Thread.sleep(2000);
        
        WebElement twoSum = driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        twoSum.click();

        String URL = driver.getCurrentUrl();
        System.out.println("URL ----- " + URL);
        if(URL.contains("two-sum")){
            System.out.println("URL contains two-sum in it");
        }else{
            System.out.println("URL doesnot contains two-sum in it");
        }
        System.out.println("end Test case: testCase03");
    }


    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://leetcode.com/");
        
        WebElement questions = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        questions.click();
        Thread.sleep(2000);
        
        WebElement twoSum = driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        twoSum.click();

        driver.findElement(By.xpath("//div[@id='submissions_tab']")).click();
        // Actions actions = new Actions(driver);
        // actions.moveToElement(submit).perform();
        // Thread.sleep(2000);

        String URL = driver.getCurrentUrl();
        if(URL.contains("submissions")){
            System.out.println("URL contains submissions in it");
        }else{
            System.out.println("URL doesnot contains submissions in it");
        }
        WebElement text = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        String str = text.getText();
        System.out.println(str);
        
        if(text.isDisplayed()){
            System.out.println("Register or Sign In is displayed");
        }else{
            System.out.println("Register or Sign In is not displayed");
        }
  
        System.out.println("end Test case: testCase04");
    }

}
