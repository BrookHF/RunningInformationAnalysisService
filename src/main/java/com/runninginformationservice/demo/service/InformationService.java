package com.runninginformationservice.demo.service;

import com.runninginformationservice.demo.domain.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * Created by vagrant on 6/7/17.
 */
public interface InformationService{
    void saveInformation(Information information);

    void saveInformationList(List<Information> informationList);

    void deleteAll();

    void deleteByRunningId(String runningId);

}
