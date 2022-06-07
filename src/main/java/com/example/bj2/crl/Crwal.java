package com.example.bj2.crl;

import com.example.bj2.domain.Steam;
import com.example.bj2.dto.SteamDTO;
import com.example.bj2.mapper.SteamMapper;
import com.example.bj2.service.SteamService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor

public class Crwal {


    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe"; // 드라이버 경로
    public static void main(String[] args) throws Exception {

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);


        ChromeOptions options = new ChromeOptions();
        // 브라우저 보이지 않기
//        options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);
        for (int j = 0; j < 2; j++) {

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


                }
            }catch (NoSuchElementException se){

            }
        }
    }
}
