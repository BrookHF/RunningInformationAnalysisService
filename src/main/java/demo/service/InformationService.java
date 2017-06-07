package demo.service;

import demo.domain.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/7/17.
 */
public interface InformationService {
    List<Information> saveInformation(List<Information> information);

    void deleteAll();

    void deleteByRunningId(String runningId);

    Page<Information> findByRunningId(String runningId, Pageable pageable);
}
