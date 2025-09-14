package com.olo.campusservice.domain.port.outbound;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;

import java.util.List;
import java.util.Optional;

public interface CampusRepository {
    boolean existsByName(String name);

    Campus save(Campus campus);

    List<Campus> findAll();
    Optional<Campus> findById(Long id);
    Optional<Campus> findByShift(Shift shift);

    void delete(Long id);
}
