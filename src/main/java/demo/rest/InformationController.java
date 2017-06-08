package demo.rest;

import demo.domain.Information;
import demo.service.InformationService;
import demo.domain.InformationRepository;
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

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Information> informationList) {
        this.informationService.saveInformation(informationList);
    }
}
