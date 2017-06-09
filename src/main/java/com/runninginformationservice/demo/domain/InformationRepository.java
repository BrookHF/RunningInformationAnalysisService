package com.runninginformationservice.demo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by vagrant on 6/7/17.
 */
@RepositoryRestResource(path="/information")
public interface InformationRepository extends PagingAndSortingRepository<Information, String> {

    List<Information> findByRunningId(@Param("/runningId") String runningId);
}
