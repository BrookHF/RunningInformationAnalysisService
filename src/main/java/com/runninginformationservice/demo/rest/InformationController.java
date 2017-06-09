package com.runninginformationservice.demo.rest;

import com.runninginformationservice.demo.domain.Information;
import com.runninginformationservice.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/7/17.
 */
@RestController
public class InformationController{

    private InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @RequestMapping(value = "/bulk/upload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Information> informationList) {
        this.informationService.saveInformationList(informationList);
    }


}
