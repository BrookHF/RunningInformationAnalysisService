package com.cs504.fang.informationanalysis.domain;

import lombok.Data;

/**
 * Created by vagrant on 6/10/17.
 */
@Data
public class HealthLevel {

    public enum HealthWarningLevel {
        HIGH, NORMAL, LOW
    }

    private String runningId;
    private double totalRunningTime;
    private int heartRate;
    private long userId;
    private String userName;
    private String userAddress;
    private HealthWarningLevel healthWarningLevel;

    public HealthLevel() {

    }
}
