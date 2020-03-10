package com.accenture.be.business;

import com.accenture.be.entity.Flower;

import java.util.List;

public interface FlowerBusinessService {
    List<Flower> findByName(String name);
    List<Flower> findByPrice(Double minPrice, Double maxPrice);
    void addToBasket(Flower flower, Integer number);
    Flower deleteFromBasket(Flower flower);//?
}
