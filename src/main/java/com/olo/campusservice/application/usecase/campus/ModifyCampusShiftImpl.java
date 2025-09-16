package com.olo.campusservice.application.usecase.campus;

import com.olo.campusservice.domain.command.CampusShiftCommand;
import com.olo.campusservice.domain.command.kafka.PublishShiftCommand;
import com.olo.campusservice.domain.exception.exists.CampusNotFoundException;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.model.enums.Shift;
import com.olo.campusservice.domain.port.inbound.campus.ModifyCampusShiftPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import com.olo.campusservice.domain.port.outbound.KafkaServicePort;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class ModifyCampusShiftImpl implements ModifyCampusShiftPort {

    private final CampusRepository campusRepository;
    private final KafkaServicePort kafkaServicePort;

    @Override
    public Campus modifyCampusShift(CampusShiftCommand command) {
        Campus campus = campusRepository.findById(command.id()).orElseThrow(() -> new CampusNotFoundException("Campus not found"));

        Set<Shift> shifts = campus.shifts();
        if (command.addShift()){
            shifts.add(command.shift());
        }else {
            shifts.remove(command.shift());
        }

        Campus newCampus = new Campus(
                campus.id(),
                campus.name(),
                campus.address(),
                shifts
        );

        Campus savedCampus = campusRepository.save(newCampus);

        sendModify(savedCampus.id(), command.shift());
        return savedCampus;
    }

    private void sendModify(Long id, Shift shift){
        PublishShiftCommand command = new PublishShiftCommand(
                id,
                shift
        );

        kafkaServicePort.publishRemoveShift(command);
    }
}
