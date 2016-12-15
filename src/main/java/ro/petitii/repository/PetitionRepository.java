package ro.petitii.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.petitii.model.Petition;
import ro.petitii.model.User;

@Repository
public interface PetitionRepository extends DataTablesRepository<Petition,Long> {
    Page<Petition> findByResponsible(@Param("responsible") User user, Pageable p);
}