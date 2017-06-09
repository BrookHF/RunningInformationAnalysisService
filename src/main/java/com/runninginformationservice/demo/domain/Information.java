package com.runninginformationservice.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vagrant on 6/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name="runningInformation")
public class Information {

    @Id
    private String runningId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "userId")),
            @AttributeOverride(name = "name", column = @Column(name = "userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userAddress"))
    })
    private UserInfo userInfo;


    private Double latitude;
    private Double longitude;
    private Double runningDistance;
    private Double totalRunningTime;
    private Double heartRate;
    private Date Timestamp;

    @JsonCreator
    public Information(@JsonProperty("runningId") String runningId) {
        this.userInfo = new UserInfo();
    }
}
