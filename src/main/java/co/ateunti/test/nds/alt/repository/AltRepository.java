package co.ateunti.test.nds.alt.repository;

import co.ateunti.test.nds.domain.AltSample;
import co.ateunti.test.nds.domain.DataProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AltRepository extends CrudRepository<AltSample, Long> {


    @Query(nativeQuery = true, value = "select doc_number as doc, name from alt_sample where doc_number = :doc")
    Optional<DataProjection> findByDocNumber(String doc);
}
