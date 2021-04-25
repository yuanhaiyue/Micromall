package com.example.micromall.service;


import com.example.micromall.Vo.CarouselVo;
import com.example.micromall.entity.Carousel;
import com.example.micromall.entity.CarouselImage;
import com.example.micromall.repository.CarouselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author 14760
 */
@Service
public class CarouselService {
    final CarouselRepository carouselRepository;

    public CarouselService(CarouselRepository carouselRepository) {
        this.carouselRepository = carouselRepository;
    }


    public Set<CarouselVo> select(){
        Optional<Carousel> optional =carouselRepository.findById(1);
        if (!optional.isPresent()){
            throw new RuntimeException("轮播图为空");
        }
        Carousel carousel=optional.get();
        Set<CarouselImage> carouselImages=carousel.getCarouselImages();
        return CarouselUtils.transformation(carousel, carouselImages);
    }

    private static class CarouselUtils{
        public static Set<CarouselVo> transformation(Carousel carousel,Set<CarouselImage> carouselImages){
            Set<CarouselVo> carouselVos=new HashSet<>();
            for (CarouselImage image:carouselImages){
                CarouselVo carouselVo=new CarouselVo();
                carouselVo.setId(carousel.getId());
                carouselVo.setImg(carousel.getImg()+image.getPath());
                carouselVos.add(carouselVo);
            }
            return carouselVos;
        }
    }



}
