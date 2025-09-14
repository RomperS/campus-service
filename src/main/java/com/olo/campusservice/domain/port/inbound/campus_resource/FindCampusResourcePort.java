package com.olo.campusservice.domain.port.inbound.campus_resource;

import com.olo.campusservice.domain.command.SearchCampusResourceCommand;
import com.olo.campusservice.domain.model.CampusResource;

public interface FindCampusResourcePort {
    CampusResource find(SearchCampusResourceCommand command);
}
