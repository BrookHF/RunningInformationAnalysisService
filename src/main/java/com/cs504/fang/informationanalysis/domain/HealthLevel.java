package com.cs504.fang.informationanalysis.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by vagrant on 6/10/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class HealthLevel {

    public enum HealthWarningLevel {
        HIGH, NORMAL, LOW
    }

    private final String runningId;
    private double totalRunningTime;
    private int heartRate;
    private long userId;
    private String userName;
    private String userAddress;
    private HealthWarningLevel healthWarningLevel;

    @JsonCreator
    public HealthLevel(String runningId) {
        this.runningId = runningId;
    }
}
