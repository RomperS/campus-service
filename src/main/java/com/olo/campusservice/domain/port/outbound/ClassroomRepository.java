package com.olo.campusservice.domain.port.outbound;

import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepository {
    boolean existsByIdentifierInCampus(String identifier, Campus campus);

    Classroom save(Classroom classroom);

    List<Classroom> findAll();
    Optional<Classroom> findById(Long id);
    List<Classroom> findByIdentifier(String identifier);
    List<Classroom> findByCampus();

    void deleteById(Long id);
}
