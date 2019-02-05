package com.esperluette.nice.repository;

import com.esperluette.nice.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(" select l from Location l " +
            " where ?1 LIKE l.name")
    Location findByName(String name);

    @Query(" select l from Location l, Location_LocationType lt " +
            " where lt.location.id = l.id " +
            "and lt.locationType In ?1 " +
            "and (disabled_access = true or l.disabled_access = disabled_access)")
    List<Location> findByType(List<String> types, boolean disabled_access);
}
