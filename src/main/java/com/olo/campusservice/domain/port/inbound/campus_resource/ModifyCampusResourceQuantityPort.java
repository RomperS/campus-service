package com.olo.campusservice.domain.port.inbound.campus_resource;

import com.olo.campusservice.domain.command.ModifyQuantityCommand;
import com.olo.campusservice.domain.model.CampusResource;

public interface ModifyCampusResourceQuantityPort {
    CampusResource modifyQuantity(ModifyQuantityCommand command);
}
