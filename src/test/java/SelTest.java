import com.example.bj2.domain.Steam;
import com.example.bj2.service.SteamService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SelTest {
    @Autowired
   private SteamService steamService;
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe"; // 드라이버 경로

    @Test
    public void selTest() throws Exception {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);


        ChromeOptions options = new ChromeOptions();
        // 브라우저 보이지 않기
//        options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);
        for (int j = 0; j < 21; j++) {

            driver.get(String.format("https://store.steampowered.com/specials/#p=%d&tab=TopSellers", j));
            driver.navigate().refresh();
            Thread.sleep(1000);
            try {
                for (int i = 1; i < 16; i++) {
                    String title = driver.findElement(By.xpath(String.format("//*[@id=\"TopSellersRows\"]/a[%d]/div[3]/div[1]", i))).getText();
                    String link = driver.findElement(By.xpath(String.format("//*[@id=\"TopSellersRows\"]/a[%d]", i))).getAttribute("href");
                    String img = driver.findElement(By.xpath(String.format("//*[@id=\"TopSellersRows\"]/a[%d]/div[1]/img", i))).getAttribute("src");

                    String originalPrice = driver.findElement(By.xpath(String.format("//*[@id=\"TopSellersRows\"]/a[%d]/div[2]/div[2]/div[1]", i))).getText();
                    String salePrice = driver.findElement(By.xpath(String.format("//*[@id=\"TopSellersRows\"]/a[%d]/div[2]/div[2]/div[2]", i))).getText();
                    String salePercent = driver.findElement(By.xpath(String.format("//*[@id=\"TopSellersRows\"]/a[%d]/div[2]/div[1]", i))).getText();

                    log.info(title);
                    log.info(link);
                    log.info(img);
                    log.info(originalPrice);
                    log.info(salePrice);
                    log.info(salePercent);

                Steam steam =Steam.builder()
                        .title(title)
                        .image(img)
                        .link(link)
                        .original_price(originalPrice)
                        .sale_price(salePrice)
                        .sale_percent(salePercent).build();
                steamService.insert(steam);

                }
            }catch (NoSuchElementException se){

            }
        }
    }
}
