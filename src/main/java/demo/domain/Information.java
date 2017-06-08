package demo.domain;

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
public class Information {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "userName", column = @Column(name = "userInfo_userName")),
            @AttributeOverride(name = "address", column = @Column(name = "userInfo_address"))
    })
    private UserInfo userInfo;

    private String runningId;
    private Double latitude;
    private Double longitude;
    private Double runningDistance;
    private Double totalRunningTime;
    private Double heartRate;
    private Date Timestamp;

    @JsonCreator
    public Information(@JsonProperty("runningId") String runningId) {
        this.userInfo = new UserInfo(runningId);
    }
}
