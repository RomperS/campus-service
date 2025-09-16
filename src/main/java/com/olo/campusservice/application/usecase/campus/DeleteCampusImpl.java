package com.olo.campusservice.application.usecase.campus;

import com.olo.campusservice.domain.command.kafka.PublishDeleteCommand;
import com.olo.campusservice.domain.port.inbound.campus.DeleteCampusPort;
import com.olo.campusservice.domain.port.outbound.CampusRepository;
import com.olo.campusservice.domain.port.outbound.KafkaServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCampusImpl implements DeleteCampusPort {

    private final CampusRepository campusRepository;
    private final KafkaServicePort kafkaServicePort;

    @Override
    public void delete(Long id) {
        campusRepository.delete(id);
        sendModify(id);
    }

    private void sendModify(Long id){
        String object = "Campus:Delete";
        PublishDeleteCommand command = new PublishDeleteCommand(
                id,
                "Campus"
        );

        kafkaServicePort.publishDelete(command);
    }
}
