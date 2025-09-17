package com.olo.campusservice.domain.port.outbound;

import com.olo.campusservice.domain.model.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceRepository {
    boolean existsByName(String name);

    Resource save(Resource resource);

    Optional<Resource> findById(Long id);

    List<Resource> findByName(String name);
    List<Resource> findAll();
    List<Resource> findBySupplier(String name);

    void delete(Long id);
}
