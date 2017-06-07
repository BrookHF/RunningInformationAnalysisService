package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vagrant on 6/7/17.
 */
@JsonInclude
@Data
@Entity
public class Information {

    private String runningId;
    private Double latitude;
    private Double longitude;
    private Double runningDistance;
    private Double totalRunningTime;
    private Double heartRate;
    private Date Timestamp;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "userName", column = @Column(name = "userInfo_userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userInfo_address"))
    })
    private UserInfo userInfo;



}
