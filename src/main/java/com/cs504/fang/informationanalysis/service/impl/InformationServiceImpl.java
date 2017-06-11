package com.cs504.fang.informationanalysis.service.impl;


import com.cs504.fang.informationanalysis.domain.HealthLevel;
import com.cs504.fang.informationanalysis.domain.Information;
import com.cs504.fang.informationanalysis.domain.InformationRepository;
import com.cs504.fang.informationanalysis.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    private InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public void saveInformation(Information information) {
        information.setHeartRate((int)(Math.random()*140 + 60));
        this.informationRepository.save(information);
    }

    @Override
    public void saveInformationList(List<Information> informationList) {
        for(Information information : informationList) {
            saveInformation(information);
        }
    }

    @Override
    public Page<HealthLevel> getHealthList(int pageNumber) {
        Page<Information> informationPage = informationRepository.getAllByIdExistsOrderByHeartRateDesc(new PageRequest(pageNumber, 2));
        // convert information to requested JSON response
        Page<HealthLevel> healthLevelPage = informationPage.map(new Converter<Information, HealthLevel>() {
            @Override
            public HealthLevel convert(Information information) {
                HealthLevel healthLevel = new HealthLevel();

                healthLevel.setRunningId(information.getRunningId());
                healthLevel.setTotalRunningTime(information.getTotalRunningTime());
                healthLevel.setHeartRate(information.getHeartRate());
                healthLevel.setUserId(information.getId());
                healthLevel.setUserName(information.getUserInfo().getUsername());
                healthLevel.setUserAddress(information.getUserInfo().getAddress());
                if(healthLevel.getHeartRate() <= 75) {
                    healthLevel.setHealthWarningLevel(HealthLevel.HealthWarningLevel.LOW);
                } else if (healthLevel.getHeartRate() <= 120) {
                    healthLevel.setHealthWarningLevel(HealthLevel.HealthWarningLevel.NORMAL);
                } else {
                    healthLevel.setHealthWarningLevel(HealthLevel.HealthWarningLevel.HIGH);
                }

                return healthLevel;
            }
        });
        return healthLevelPage;
    }

    @Override
    public void deleteByRunningId(String runningId) {
        informationRepository.delete(informationRepository.findByRunningId(runningId));
    }

    @Override
    public void deleteAll() {
        informationRepository.deleteAll();
    }


//    @Override
//    public Page<Information> findByRunningId(String runningId, Pageable pageable) {
//        return locationRepository.findByUserInfoRunningId(runningId, pageable);
//    }
}
