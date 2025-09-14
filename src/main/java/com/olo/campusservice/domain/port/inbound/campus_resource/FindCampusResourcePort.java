package com.olo.campusservice.domain.port.inbound.campus_resource;

import com.olo.campusservice.domain.command.SearchCampusResourceCommand;
import com.olo.campusservice.domain.model.CampusResource;

import java.util.List;

public interface FindCampusResourcePort {
    List<CampusResource> find(SearchCampusResourceCommand command);
}
