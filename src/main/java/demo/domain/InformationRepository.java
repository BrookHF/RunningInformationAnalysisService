package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by vagrant on 6/7/17.
 */
@RepositoryRestResource(path="Informations")
public interface InformationRepository extends JpaRepository<Information, Long>{

    List<Information> findByRunningId(@Param("runningId") String runningId);
}
