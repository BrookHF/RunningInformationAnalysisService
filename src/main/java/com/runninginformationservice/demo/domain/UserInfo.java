package com.runninginformationservice.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by vagrant on 6/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {


    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    public UserInfo() {
    }

    public UserInfo(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
