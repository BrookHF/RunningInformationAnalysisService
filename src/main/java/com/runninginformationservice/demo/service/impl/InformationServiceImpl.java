package com.runninginformationservice.demo.service.impl;

import com.runninginformationservice.demo.domain.Information;
import com.runninginformationservice.demo.domain.InformationRepository;
import com.runninginformationservice.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/7/17.
 */
@Service
public class InformationServiceImpl implements InformationService{

    private InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public void saveInformation(Information information) {
        this.informationRepository.save(information);
    }

    @Override
    public void saveInformationList(List<Information> informationList) {
        this.informationRepository.save(informationList);
    }

    @Override
    public void deleteAll() {
        informationRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        informationRepository.delete(runningId);
    }

}
