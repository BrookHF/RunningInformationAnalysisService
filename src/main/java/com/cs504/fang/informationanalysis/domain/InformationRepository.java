package com.cs504.fang.informationanalysis.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path="locations")
public interface InformationRepository extends PagingAndSortingRepository<Information, Long> {

    @RestResource(path="customers")
    Page<Information> findByUserInfoUsername(@Param("username") String username, Pageable pageable);

    @RestResource(path="runningId")
    Information findByRunningId(@Param("runningId") String runningId);

    @RestResource(path="heartRateDesc")
    Page<Information> findAllByIdExistsOrderByHeartRateDesc(Pageable pageable);

}
