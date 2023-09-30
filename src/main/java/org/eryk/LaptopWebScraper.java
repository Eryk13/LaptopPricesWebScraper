package org.eryk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public abstract class LaptopWebScraper {
    protected WebDriver driver;
    public LaptopWebScraper() {
        this.driver = new ChromeDriver();
    }
    public abstract List<Laptop> getLaptopDeals();
    public abstract List<Laptop> getLaptops(String str);
    public void close() {
        this.driver.quit();
    }

}
