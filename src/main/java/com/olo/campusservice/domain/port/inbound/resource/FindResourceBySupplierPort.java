package com.olo.campusservice.domain.port.inbound.resource;

import com.olo.campusservice.domain.model.Resource;

public interface FindResourceBySupplierPort {
    Resource findBySupplier(String supplier);
}