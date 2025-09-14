package com.olo.campusservice.domain.port.inbound.campus;

import com.olo.campusservice.domain.model.Campus;

import java.util.List;

public interface FindAllCampusPort {
    List<Campus> FindAllCampus();
}