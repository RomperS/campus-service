package com.olo.campusservice.domain.port.inbound.campus_resource;

import com.olo.campusservice.domain.model.CampusResource;

public interface CreateCampusResourcePort {
    CampusResource create(CampusResource campusResource);
}
