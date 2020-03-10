package com.accenture.be.business;

import com.accenture.be.entity.Flower;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerBusinessServiceImpl implements FlowerBusinessService {

    @Override
    public List<Flower> findByName(String name) {
        return null;
    }

    @Override
    public List<Flower> findByPrice(Double minPrice, Double maxPrice) {
        return null;
    }

    @Override
    public void addToBasket(Flower flower, Integer number) {

    }

    @Override
    public Flower deleteFromBasket(Flower flower) {
        return null;
    }
}
