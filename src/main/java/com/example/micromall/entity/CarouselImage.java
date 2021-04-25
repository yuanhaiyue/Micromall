package com.example.micromall.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author 14760
 */
@Setter
@Getter
@Entity(name = "carousel_image")
public class CarouselImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String path;

    @ManyToOne
    private Carousel carousel;




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarouselImage that = (CarouselImage) o;
        return Objects.equals(id, that.id) && Objects.equals(path, that.path) && Objects.equals(carousel, that.carousel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, carousel);
    }
}
