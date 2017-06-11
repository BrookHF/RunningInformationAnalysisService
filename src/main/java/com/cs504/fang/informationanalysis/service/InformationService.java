package com.cs504.fang.informationanalysis.service;


import com.cs504.fang.informationanalysis.domain.HealthLevel;
import com.cs504.fang.informationanalysis.domain.Information;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InformationService {

    void saveInformation(Information information);

    void saveInformationList(List<Information> informationList);

    Page<HealthLevel> getHealthList(int pageNumber);

    void deleteByRunningId(String runningId);

    void deleteAll();

//    Page<Information> findByRunningId(String runningId, Pageable pageable);
}
