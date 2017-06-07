package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by vagrant on 6/7/17.
 */
@RepositoryRestResource(path="Informations")
public interface InformationRepository extends JpaRepository<Information, String>{


}
