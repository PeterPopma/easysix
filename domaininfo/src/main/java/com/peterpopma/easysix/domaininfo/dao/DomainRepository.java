package nl.sidn.drs.domaininfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DomainRepository extends JpaRepository<nl.sidn.drs.model.DrpDomeinnaam, Long> {
    Optional<nl.sidn.drs.model.DrpDomeinnaam> findByNaam();
}
