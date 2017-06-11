package com.cs504.fang.informationanalysis.rest;


import com.cs504.fang.informationanalysis.domain.HealthLevel;
import com.cs504.fang.informationanalysis.domain.Information;
import com.cs504.fang.informationanalysis.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class InformationController {

    private InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;

    }

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Information> information) {
        this.informationService.saveInformationList(information);
    }

    @RequestMapping(value = "/health/{pageNumber}", method = RequestMethod.GET)
    public Page<HealthLevel> getList(@PathVariable int pageNumber) {
        return informationService.getHealthList(pageNumber);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.POST)
    public void purge() {
        this.informationService.deleteAll();
    }

    @RequestMapping(value = "/delete/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId) {
        this.informationService.deleteByRunningId(runningId);
    }


//    @RequestMapping(value = "/running/runningId/{runningId}", method = RequestMethod.GET)
//    public Page<Information> findByRunningId(@PathVariable String runningId, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
//        return this.informationService.findByRunningId(runningId, new PageRequest(page, size));
//    }



}
