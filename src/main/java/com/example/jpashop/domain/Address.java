package com.example.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // JPA 내장타입으로 내가 지정함
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

}
