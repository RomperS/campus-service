package com.olo.campusservice.application.service;

import com.olo.campusservice.application.usecase.campus.CreateCampusImpl;
import com.olo.campusservice.application.usecase.campus.DeleteCampusImpl;
import com.olo.campusservice.application.usecase.campus.ModifyCampusShiftImpl;
import com.olo.campusservice.domain.command.CampusShiftCommand;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;
import com.olo.campusservice.domain.port.inbound.campus.CreateCampusPort;
import com.olo.campusservice.domain.port.inbound.campus.FindAllCampusPort;
import com.olo.campusservice.domain.port.inbound.campus.FindCampusByShiftPort;
import com.olo.campusservice.domain.port.inbound.campus.ModifyCampusShiftPort;
import com.olo.campusservice.domain.port.inbound.campus_resource.DeleteCampusResourcePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CampusService implements CreateCampusPort, DeleteCampusResourcePort, FindAllCampusPort, FindCampusByShiftPort, ModifyCampusShiftPort {

    private final CreateCampusImpl createCampusImpl;
    private final DeleteCampusImpl deleteCampusImpl;
    private final FindAllCampusPort findAllCampusImpl;
    private final FindCampusByShiftPort findCampusByShiftPort;
    private final ModifyCampusShiftImpl modifyCampusShiftImpl;

    @Override
    public Campus create(Campus campus) {
        return createCampusImpl.create(campus);
    }

    @Override
    public void delete(Long id) {
        deleteCampusImpl.delete(id);
    }

    @Override
    public List<Campus> FindAllCampus() {
        return findAllCampusImpl.FindAllCampus();
    }

    @Override
    public List<Campus> findByShift(Shift shift) {
        return findCampusByShiftPort.findByShift(shift);
    }

    @Override
    public Campus modifyCampusShift(CampusShiftCommand command) {
        return modifyCampusShiftImpl.modifyCampusShift(command);
    }
}
