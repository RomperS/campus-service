package com.olo.campusservice.application.usecase.resource;

import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.port.inbound.resource.FindResourceBySupplierPort;
import com.olo.campusservice.domain.port.outbound.ResourceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindResourceBySupplierImpl implements FindResourceBySupplierPort {

    private final ResourceRepository resourceRepository;

    @Override
    public List<Resource> findBySupplier(String supplier) {
        return resourceRepository.findBySupplier(supplier);
    }
}
