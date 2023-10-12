package org.eryk;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (Exception e) {
            e.printStackTrace();
        }
        LaptopWebScraper webScraper = new LaptopWebScraper_RTVEuroAGD();
        List<Laptop> laptops = webScraper.getLaptopDeals();
        webScraper.close();

        LaptopWebScraper webScraper2 = new LaptopWebScraper_Komputronik();
        List<Laptop> laptops2 = webScraper2.getLaptopDeals();
        webScraper.close();

        LaptopDTO laptopDto = new LaptopDTO();
        laptopDto.insert(laptops);
        laptopDto.insert(laptops2);


    }
}