package org.eryk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LaptopWebScraper_Komputronik extends LaptopWebScraper{
    @Override
    public List<Laptop> getLaptopDeals() {
        this.driver.get("https://www.komputronik.pl/category/5022/laptopy.html?plabel%5B%5D=promo-price&filter=1&showBuyActiveOnly=1");

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

        //get laptops
        List<WebElement> elements = new ArrayList<>();
        ArrayList<Laptop> laptops = new ArrayList<>();


        int page =2;
        boolean run = true;
        do{
            try{
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                elements = driver.findElements(By.cssSelector(".tests-product-entry"));
                if(elements.isEmpty()){
                    run = false;
                }
                for(WebElement item : elements) {
                    try{
                        String title = item.findElement(By.tagName("h2")).getText();
                        String link = item.findElement((By.cssSelector(".button-a"))).getAttribute("href");
                        String priceText = item.findElement(By.cssSelector(".text-3xl.font-bold.leading-8")).getText();
                        priceText = priceText.replace(" ", "").replace("zł", "");

                        int price = Integer.parseInt(priceText);

                        Laptop laptop = new Laptop(title, price, link);
                        laptops.add(laptop);
                    }
                    catch(Exception ignored){
                        System.out.println(ignored);
                    }
                }
                elements.clear();
                driver.get("https://www.komputronik.pl/category/5022/laptopy.html?plabel%5B%5D=promo-price&filter=1&showBuyActiveOnly=1&p="+ page);
                page++;
            }
            catch(Exception e){
                run = false;
            }
        }while(run);

        return laptops;
    }

    @Override
    public List<Laptop> getLaptops(String str) {
        return null;
    }
}
