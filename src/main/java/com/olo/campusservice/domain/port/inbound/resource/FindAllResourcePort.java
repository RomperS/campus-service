package com.olo.campusservice.domain.port.inbound.resource;

import com.olo.campusservice.domain.model.Resource;

import java.util.List;

public interface FindAllResourcePort {
    List<Resource> findAll();
}
