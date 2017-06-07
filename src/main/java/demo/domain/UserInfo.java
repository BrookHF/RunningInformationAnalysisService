package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by vagrant on 6/7/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {

    private String userName;
    private String address;

    public UserInfo() {

    }

    public UserInfo(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }
}
