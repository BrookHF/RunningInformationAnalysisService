package com.cs504.fang.informationanalysis.domain;

/**
 * Created by vagrant on 6/10/17.
 */
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
    private HealthLevel healthLevel;

    public HealthLevel() {

    }
}
