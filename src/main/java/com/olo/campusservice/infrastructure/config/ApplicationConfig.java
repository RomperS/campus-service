package com.olo.campusservice.infrastructure.config;

import com.olo.campusservice.application.service.CampusResourceService;
import com.olo.campusservice.application.service.CampusService;
import com.olo.campusservice.application.service.ClassroomService;
import com.olo.campusservice.application.service.ResourceService;
import com.olo.campusservice.application.usecase.campus.*;
import com.olo.campusservice.application.usecase.campus_resource.CreateCampusResourceImpl;
import com.olo.campusservice.application.usecase.campus_resource.DeleteCampusResourceImpl;
import com.olo.campusservice.application.usecase.campus_resource.FindCampusResourceImpl;
import com.olo.campusservice.application.usecase.campus_resource.ModifyCampusResourceQuantityImpl;
import com.olo.campusservice.application.usecase.classroom.CreateClassroomImpl;
import com.olo.campusservice.application.usecase.classroom.DeleteClassroomImpl;
import com.olo.campusservice.application.usecase.classroom.FindClassroomImpl;
import com.olo.campusservice.application.usecase.classroom.UpdateClassroomImpl;
import com.olo.campusservice.application.usecase.resource.*;
import com.olo.campusservice.domain.port.outbound.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CampusResourceService campusResourceService(CampusRepository campusRepository, ResourceRepository resourceRepository, CampusResourceRepository campusResourceRepository) {
        return new CampusResourceService(
                new CreateCampusResourceImpl(campusResourceRepository, resourceRepository, campusRepository),
                new DeleteCampusResourceImpl(campusResourceRepository),
                new FindCampusResourceImpl(campusResourceRepository),
                new ModifyCampusResourceQuantityImpl(campusResourceRepository)
        );
    }

    @Bean
    public ResourceService resourceService(ResourceRepository resourceRepository) {
        return new ResourceService(
                new CreateResourceImpl(resourceRepository),
                new DeleteResourceImpl(resourceRepository),
                new FindAllResourceImpl(resourceRepository),
                new FindResourceByIdImpl(resourceRepository),
                new FindResourceByNameImpl(resourceRepository),
                new FindResourceBySupplierImpl(resourceRepository),
                new UpdateResourceImpl(resourceRepository)
        );
    }

    @Bean
    public CampusService campusService(CampusRepository campusRepository, KafkaServicePort kafkaServicePort) {
        return new CampusService(
                new CreateCampusImpl(campusRepository, kafkaServicePort),
                new DeleteCampusImpl(campusRepository, kafkaServicePort),
                new FindAllCampusImpl(campusRepository),
                new FindCampusByShiftImpl(campusRepository),
                new ModifyCampusShiftImpl(campusRepository, kafkaServicePort)
        );
    }

    @Bean
    public ClassroomService classroomService(ClassroomRepository classroomRepository, CampusRepository campusRepository, KafkaServicePort kafkaServicePort) {
        return new ClassroomService(
                new CreateClassroomImpl(classroomRepository, campusRepository, kafkaServicePort),
                new DeleteClassroomImpl(classroomRepository, kafkaServicePort),
                new FindClassroomImpl(classroomRepository, campusRepository),
                new UpdateClassroomImpl(classroomRepository, kafkaServicePort)
        );
    }
}