package com.olo.campusservice.application.service;

import com.olo.campusservice.application.usecase.resource.*;
import com.olo.campusservice.domain.model.Resource;
import com.olo.campusservice.domain.port.inbound.resource.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ResourceService implements CreateResourcePort, DeleteResourcePort, FindAllResourcePort, FindResourceByIdPort, FindResourceByNamePort, FindResourceBySupplierPort, UpdateResourcePort {

    private final CreateResourceImpl createResourceImpl;
    private final DeleteResourceImpl deleteResourceImpl;
    private final FindAllResourceImpl findAllResourceImpl;
    private final FindResourceByIdImpl findResourceByIdImpl;
    private final FindResourceByNameImpl findResourceByNameImpl;
    private final FindResourceBySupplierImpl findResourceBySupplierImpl;
    private final UpdateResourceImpl updateResourceImpl;


    @Override
    public Resource create(Resource resource) {
        return createResourceImpl.create(resource);
    }

    @Override
    public void delete(Long id) {
        deleteResourceImpl.delete(id);
    }

    @Override
    public List<Resource> findAll() {
        return findAllResourceImpl.findAll();
    }

    @Override
    public Resource findById(Long id) {
        return findResourceByIdImpl.findById(id);
    }

    @Override
    public List<Resource> findByName(String name) {
        return findResourceByNameImpl.findByName(name);
    }

    @Override
    public List<Resource> findBySupplier(String supplier) {
        return findResourceBySupplierImpl.findBySupplier(supplier);
    }

    @Override
    public Resource update(Resource resource) {
        return updateResourceImpl.update(resource);
    }
}
