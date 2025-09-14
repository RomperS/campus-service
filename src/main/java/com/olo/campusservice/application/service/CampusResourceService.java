package com.olo.campusservice.application.service;

import com.olo.campusservice.application.usecase.campus_resource.*;
import com.olo.campusservice.domain.command.CampusResourceCommand;
import com.olo.campusservice.domain.command.ModifyQuantityCommand;
import com.olo.campusservice.domain.command.SearchCampusResourceCommand;
import com.olo.campusservice.domain.model.CampusResource;
import com.olo.campusservice.domain.port.inbound.campus_resource.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CampusResourceService implements CreateCampusResourcePort, DeleteCampusResourcePort, FindCampusResourcePort, ModifyCampusResourceQuantityPort {

    private final CreateCampusResourceImpl createCampusResourceImpl;
    private final DeleteCampusResourceImpl deleteCampusResourceImpl;
    private final FindCampusResourceImpl findCampusResourceImpl;
    private final ModifyCampusResourceQuantityImpl modifyCampusResourceQuantityImpl;


    @Override
    public CampusResource create(CampusResourceCommand command) {
        return createCampusResourceImpl.create(command);
    }

    @Override
    public void delete(Long id) {
        deleteCampusResourceImpl.delete(id);
    }

    @Override
    public List<CampusResource> find(SearchCampusResourceCommand command) {
        return findCampusResourceImpl.find(command);
    }

    @Override
    public CampusResource modifyQuantity(ModifyQuantityCommand command) {
        return modifyCampusResourceQuantityImpl.modifyQuantity(command);
    }
}
