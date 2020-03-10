package com.accenture.be.access;

import com.accenture.be.entity.Flower;

import java.util.List;

public interface FlowerDAO {
    List<Flower> getListFlowers();
    Flower save(Flower flower);
    Flower update(Flower flower);
    List<Flower> getByName(String name);
    List<Flower> getByPrice(Double minPrice,Double maxPrice);
}
