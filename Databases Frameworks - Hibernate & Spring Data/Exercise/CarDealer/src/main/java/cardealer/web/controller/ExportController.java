package cardealer.web.controller;

import cardealer.domain.dtos.view.CarExportRootDTO;
import cardealer.service.CarService;
import cardealer.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;

@Controller
public class ExportController {

    private final CarService carService;
    private final XmlParser xmlParser;

    @Autowired
    public ExportController(CarService carService, XmlParser xmlParser) {
        this.carService = carService;
        this.xmlParser = xmlParser;
    }

    public String exportCars() throws JAXBException {

        CarExportRootDTO carExportRootDTO = this.carService.exportCars();

        this.xmlParser.exportToExl(carExportRootDTO, CarExportRootDTO.class, "D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\CarDealer\\src\\main\\resources\\files\\output\\cars-and-parts.xml");
        return null;
    }
}
