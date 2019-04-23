package cardealer.service;


import cardealer.domain.dtos.CarImportDTO;
import cardealer.domain.dtos.CarImportRootDTO;
import cardealer.domain.dtos.view.CarExportDTO;
import cardealer.domain.dtos.view.CarExportRootDTO;
import cardealer.domain.dtos.view.PartExportDTO;
import cardealer.domain.dtos.view.PartExportRootDTO;
import cardealer.domain.entities.Car;
import cardealer.domain.entities.Part;
import cardealer.repository.CarRepository;
import cardealer.repository.PartRepository;
import cardealer.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public CarExportRootDTO exportCars() {
        List<Car> carEntities = this.carRepository.findAll();

        List<CarExportDTO> carExportDTOS = new ArrayList<>();

        for (Car carEntity : carEntities) {
            CarExportDTO carExportDTO = this.modelMapper.map(carEntity, CarExportDTO.class);


            List<PartExportDTO> partExportDTOS = new ArrayList<>();

            for (Part part : carEntity.getParts()) {
                PartExportDTO partExportDTO = this.modelMapper.map(part, PartExportDTO.class);

                partExportDTOS.add(partExportDTO);
            }

            PartExportRootDTO partExportRootDTO = new PartExportRootDTO();
            partExportRootDTO.setPartExportDTOS(partExportDTOS);
            carExportDTO.setPartExportRootDTO(partExportRootDTO);

            carExportDTOS.add(carExportDTO);
        }

        CarExportRootDTO carExportRootDTO = new CarExportRootDTO();
        carExportRootDTO.setCarExportDTOS(carExportDTOS);

        return carExportRootDTO;
    }


    @Override
    public void importCars(CarImportRootDTO carImportRootDTO) {
        for (CarImportDTO carImportDTO : carImportRootDTO.getCarImportDTOS()) {
            if (!this.validationUtil.isValid(carImportDTO)) {
                System.out.println("something went wrong.");

                continue;
            }
            Car carEntity = this.modelMapper.map(carImportDTO, Car.class);
            carEntity.setParts(this.getRandomParts());

            this.carRepository.saveAndFlush(carEntity);
        }
    }


    private List<Part> getRandomParts() {
        List<Part> parts = new ArrayList<>();
        Random random = new Random();

        List<Part> partsEntities = this.partRepository.findAll();

        int length = random.nextInt(10) + 10;

        for (int i = 0; i < length; i++) {
            int partIndex = random.nextInt((int) (this.partRepository.count() - 1)) + 1;

            parts.add(partsEntities.get(partIndex));
        }

        return parts;
    }
}
