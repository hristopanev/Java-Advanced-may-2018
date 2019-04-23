package cardealer.service;

import cardealer.domain.dtos.SupplierImportRootDTO;

public interface SupplierService {

    void importSuppliers(SupplierImportRootDTO supplierImportRootDTO);
}
