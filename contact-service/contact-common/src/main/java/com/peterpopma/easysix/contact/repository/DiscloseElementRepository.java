ackage com.peterpopma.easysix.contactcommand.repository;

import com.peterpopma.easysix.contactcommand.entity.DiscloseElement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DiscloseElementRepository extends JpaRepository<DiscloseElement, UUID> {
    List<DiscloseElement> findByDiscloseId(UUID discloseId);
}