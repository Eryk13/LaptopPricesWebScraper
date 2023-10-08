package org.eryk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LaptopWebScraper_RTVEuroAGD extends LaptopWebScraper {
    @Override
    public List<Laptop> getLaptopDeals() {

        this.driver.get("https://www.euro.com.pl/laptopy-i-netbooki,f8.bhtml");

        //accept cookies
        WebElement el = null;
        while(el == null) {
            try {
                el = driver.findElement(By.id("onetrust-accept-btn-handler"));
                el.click();
            }
            catch(NoSuchElementException ignored) {}
            catch(Exception ignored) {}
        }
        //load all laptops offer on page
        WebElement loadMoreElements = null;
        do{
            try{
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait for offers to load
                loadMoreElements = driver.findElement(By.className("list-load-more__button"));
                loadMoreElements.click();
            }
            catch(Exception ignored) {
                loadMoreElements = null;
            }
        }while(loadMoreElements != null);

        //get all laptop offers
        List<WebElement> elements = driver.findElements(By.className("box-medium"));


        //parse WebElement to Laptop
        ArrayList<Laptop> laptops = new ArrayList<>();
        for(WebElement item : elements) {
            try{
                String title = item.findElement(By.className("box-medium__title")).getText();
                String link = item.findElement(By.className("box-medium__link")).getAttribute("href");
                String priceText = item.findElement(By.className("price-template__large--total")).getText();
                priceText = priceText.replace(" ", "");

                int price = 0;
                price = Integer.parseInt(priceText);

                Laptop laptop = new Laptop(title, price, link);
                laptops.add(laptop);
            }
            catch(Exception ignored){
            }
        }
        return laptops;
    }

    @Override
    public List<Laptop> getLaptops(String str) {
        return null;
    }
}
