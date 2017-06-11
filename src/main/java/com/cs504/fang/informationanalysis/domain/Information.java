package com.cs504.fang.informationanalysis.domain;


import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name="RUNNING_ANALYSIS")
public class Information {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    //@AttributeOverride(name = "id", column = @Column(name = "userId"))
    private final UserInfo userInfo;

    private String runningId;
    private Double latitude;
    private Double longitude;
    private Double runningDistance;
    private Double totalRunningTime;
    private Integer heartRate;
    private Date Timestamp;

    public Information() {
        this.userInfo = null;
    }

    @JsonCreator
    public Information(@Param("username") String username) {
        this.userInfo = new UserInfo(username);
    }

    public Information(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

//    public String getRunningId() {
//        return this.userInfo == null ? null : this.userInfo.getRunningId();
//    }

}
