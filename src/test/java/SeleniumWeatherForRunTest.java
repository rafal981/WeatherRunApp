import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumWeatherForRunTest {
    public double temp;
    public double wind;
    public double raining;
    public String thermal;
    public double humi;
    private WebDriver driver;

    @BeforeMethod
    public void BeforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver.navigate().to("https://www.twojapogoda.pl/prognoza-polska/mazowieckie-warszawa/");
    }
    @Test
    public void Test() {

        driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();
        driver.findElement(By.xpath("(//a[@class='btn-more'])[1]")).click();

        WebElement temperature = driver.findElement(By.xpath("(//span[@class='json-temp-sensed'])[7]"));
        String tempText = temperature.getText();
        this.temp = Double.parseDouble(tempText);
        System.out.println(temp);

        WebElement windSpeed = driver.findElement(By.xpath("(//span[@class='json-wind-speed'])[8]"));
        String windSpeedText = windSpeed.getText();
        String cleanedWindSpeedText = windSpeedText.replace(" km/h", "");
        this.wind = Double.parseDouble(cleanedWindSpeedText);
        System.out.println(wind);

        WebElement rainingAmount = driver.findElement(By.xpath("(//span[@class='json-raining-amount'])[6]"));
        String rainingAmountText = rainingAmount.getText();
        String cleanRainingAmountText = rainingAmountText.replace("mm / 1h", "").replace(",", ".");
        this.raining = Double.parseDouble(cleanRainingAmountText);
        System.out.println(raining);

        WebElement thermals = driver.findElement(By.xpath("(//span[@class='json-thermals'])[6]"));
        this.thermal = thermals.getText();
        System.out.println(thermal);

        WebElement humidity = driver.findElement(By.xpath("(//span[@class='json-humidity'])[6]"));
        String humidityText = humidity.getText();
        String cleanHumidityText = humidityText.replace("%", "");
        this.humi = Double.parseDouble(cleanHumidityText);
        System.out.println(humi);
    }

        @AfterMethod
        public void afterMethod() {
            driver.close();
            driver.quit();
        }
}


