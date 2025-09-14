package com.olo.campusservice.domain.port.inbound.resource;

import com.olo.campusservice.domain.model.Resource;

public interface UpdateResourcePort {
    Resource update(Resource resource);
}