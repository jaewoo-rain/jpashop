package com.example.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable // JPA 내장타입으로 내가 지정함 (값 타입) -> 변경 불가
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // JPA에서 다른 기술을 사용해야 하기 위해 스펙상의 문제 때문에 기본 생성자가 필요함
    // 이때 다른 사람들이 사용할 것을 우려하여 protected로 만듬
    protected Address() {}

    public Address(String zipcode, String street, String city) {
        this.zipcode = zipcode;
        this.street = street;
        this.city = city;
    }
}
