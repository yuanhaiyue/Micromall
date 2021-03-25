package com.example.micromall.service;


import com.example.micromall.entity.Carousel;
import com.example.micromall.repository.CarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 14760
 */
@Service
public class CarouselService {
    final CarouselRepository carouselRepository;

    public CarouselService(CarouselRepository carouselRepository) {
        this.carouselRepository = carouselRepository;
    }


    public List<Carousel> select(){
        return carouselRepository.findAll();
    }





}
