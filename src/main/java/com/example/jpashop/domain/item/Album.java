package com.example.jpashop.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@DiscriminatorValue("A") // 싱글테이블이니까 구분하는 방법

public class Album extends Item {

    private String artist;
    private String etc;

}
