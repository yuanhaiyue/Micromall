package com.example.micromall.controller;

import com.example.micromall.entity.Carousel;
import com.example.micromall.service.CarouselService;
import com.example.micromall.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 14760
 */
@RequestMapping("/carousel")
@RestController
public class CarouselController {
    final CarouselService carouselService;


    public CarouselController(CarouselService carouselService) {
        this.carouselService = carouselService;
    }

    @GetMapping("/list")
    public JSONResult selectAll(){
        return JSONResult.ok(carouselService.select());
    }



}
