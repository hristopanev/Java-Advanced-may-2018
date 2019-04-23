package cardealer.web.controller;


import cardealer.domain.dtos.CarImportRootDTO;
import cardealer.domain.dtos.CustomerImportRootDTO;
import cardealer.domain.dtos.PartImportRootDTO;
import cardealer.domain.dtos.SupplierImportRootDTO;
import cardealer.service.CarService;
import cardealer.service.CustomerService;
import cardealer.service.PartService;
import cardealer.service.SupplierService;
import cardealer.util.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Controller
public class ImportController {

    private final static String SUPPLIERS_XML_FILE_PATH = "D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\CarDealer\\src\\main\\resources\\files\\suppliers.xml";
    private final static String PARTS_XML_FILE_PATH = "D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\CarDealer\\src\\main\\resources\\files\\parts.xml";
    private final static String CARS_XML_FILE_PATH = "D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\CarDealer\\src\\main\\resources\\files\\cars.xml";
    private final static String CUSTOMERS_XML_FILE_PATH = "D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\CarDealer\\src\\main\\resources\\files\\customers.xml";

    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final XmlParser xmlParser;

    @Autowired
    public ImportController(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, XmlParser xmlParser) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.xmlParser = xmlParser;
    }

    public String importSuppliers() throws JAXBException, FileNotFoundException {
        SupplierImportRootDTO supplierImportRootDTO = this.xmlParser
                .parseXml(SupplierImportRootDTO.class, SUPPLIERS_XML_FILE_PATH);

        this.supplierService.importSuppliers(supplierImportRootDTO);

        return "Imported suppliers";
    }

    public String importParts() throws JAXBException, FileNotFoundException {
        PartImportRootDTO partImportRootDTO = this.xmlParser
                .parseXml(PartImportRootDTO.class, PARTS_XML_FILE_PATH);

        this.partService.importParts(partImportRootDTO);

        return "Imported parts";
    }

    public String importCars() throws JAXBException, FileNotFoundException {
        CarImportRootDTO carImportRootDTO = this.xmlParser
                .parseXml(CarImportRootDTO.class, CARS_XML_FILE_PATH);

        this.carService.importCars(carImportRootDTO);

        return "Imported cars";
    }

    public String  importCustomers() throws JAXBException, FileNotFoundException {
        CustomerImportRootDTO customerImportRootDTO = this.xmlParser
                .parseXml(CustomerImportRootDTO.class, CUSTOMERS_XML_FILE_PATH);

        this.customerService.importCustomers(customerImportRootDTO);

        return "Import customers";
    }
}
