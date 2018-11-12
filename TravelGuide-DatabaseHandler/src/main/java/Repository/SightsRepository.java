package Repository;

import Model.Sight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SightsRepository extends JpaRepository<Sight, UUID> {

    List<Sight> findByCity_CityId(UUID cityId);
}
