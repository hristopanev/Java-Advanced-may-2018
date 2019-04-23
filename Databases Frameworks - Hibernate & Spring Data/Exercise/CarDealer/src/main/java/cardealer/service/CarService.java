package cardealer.service;

import cardealer.domain.dtos.CarImportRootDTO;
import cardealer.domain.dtos.view.CarExportRootDTO;

public interface CarService {

    void importCars(CarImportRootDTO carImportRootDTO);

    CarExportRootDTO exportCars();
}
