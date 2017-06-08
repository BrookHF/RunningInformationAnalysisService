package demo.service.impl;

import demo.domain.Information;
import demo.domain.InformationRepository;
import demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/7/17.
 */
public class InformationServiceImpl implements InformationService{

    private InformationRepository informationRepository;

    @Autowired
    public InformationServiceImpl(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public List<Information> saveInformation(List<Information> informations) {
        return informationRepository.save(informations);
    }

    @Override
    public void deleteAll() {
        informationRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        informationRepository.delete(informationRepository.findByRunningId(runningId));
    }

    @Override
    public Page<Information> findByRunningId(String runningId, Pageable pageable) {
        return null;
    }
}
