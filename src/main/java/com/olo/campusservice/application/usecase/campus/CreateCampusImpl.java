package com.olo.campusservice.application.usecase.campus;

import com.olo.campusservice.domain.command.kafka.PublishCreateCampusCommand;
import com.olo.campusservice.domain.exception.exists.CampusNameTakenException;
import com.olo.campusservice.domain.model.Campus;
import com.olo.campusservice.domain.port.inbound.campus.CreateCampusPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import com.olo.campusservice.domain.port.outbound.KafkaServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCampusImpl implements CreateCampusPort {

    private final CampusRepository campusRepository;
    private final KafkaServicePort kafkaServicePort;

    @Override
    public Campus create(Campus campus) {
        if (campusRepository.existsByName(campus.name())){
            throw new CampusNameTakenException("Campus name is taken");
        }

        Campus newCampus = new Campus(
                null,
                campus.name(),
                campus.address(),
                campus.shifts()
        );

        Campus savedCampus = campusRepository.save(newCampus);

        sendCreate(savedCampus.id(), savedCampus.name());

        return savedCampus;
    }

    private void sendCreate(Long id, String name){
        PublishCreateCampusCommand command = new PublishCreateCampusCommand(
                id,
                name
        );

        kafkaServicePort.publishCreateCampus(command);
    }
}
