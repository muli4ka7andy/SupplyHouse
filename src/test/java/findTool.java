import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.opera.OperaDriver;


import java.util.concurrent.TimeUnit;

public class findTool {
         @Test
        public void findTool() {
            System.setProperty("webdriver.opera.driver", "/Users/Андрей/operadriver_win64/operadriver_win64/operadriver.exe");
            OperaDriver operaDriver = new OperaDriver();
            operaDriver.get("https://www.supplyhouse.com/Boiler-Parts-Finder-Tool");
            operaDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            operaDriver.manage().window().maximize();
            operaDriver.findElement(By.xpath("//*[@id=\"model-number\"]")).sendKeys("AT082410C");
            operaDriver.findElement(By.xpath("//*[@id=\"boiler-model-number-search\"]/button")).submit();
            String element = operaDriver.findElement(By.xpath("//*[@id=\"search-result-message\"]/p/span")).getText();
            Assert.assertEquals("Search Result displays model \"AT082410C\" entered", "Search Result displays model " +element+ " entered");

            operaDriver.quit();
        }
}
