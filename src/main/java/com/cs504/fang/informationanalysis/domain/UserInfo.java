package com.cs504.fang.informationanalysis.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {

//    @Id
//    @GeneratedValue
//    private Long id;

    private final String username;
    private String address;

    public UserInfo() {
        this.username = "";
    }

    public UserInfo(String username) {
        this.username = username;
    }

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}