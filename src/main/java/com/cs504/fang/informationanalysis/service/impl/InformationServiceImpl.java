package com.cs504.fang.informationanalysis.service.impl;


import com.cs504.fang.informationanalysis.domain.HealthLevel;
import com.cs504.fang.informationanalysis.domain.Information;
import com.cs504.fang.informationanalysis.domain.InformationRepository;
import com.cs504.fang.informationanalysis.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void getList(List<HealthLevel> healthLevels) {

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
