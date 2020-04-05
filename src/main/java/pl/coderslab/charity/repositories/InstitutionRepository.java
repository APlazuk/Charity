package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entities.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    Institution findInstitutionById(Long id);

    @Modifying
    @Query(value = "DELETE FROM institution WHERE id = ?;", nativeQuery = true)
    void deleteInstitutionById(Long id);
}
