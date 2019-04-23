package cardealer.util;

import cardealer.domain.dtos.view.CarExportRootDTO;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <O> O parseXml(Class<O> objectClass, String path) throws JAXBException, FileNotFoundException;

    <O> void exportToExl (O object, Class<O> objectClass, String path) throws JAXBException;

    void exportToExl(CarExportRootDTO carExportRootDTO, Class<CarExportRootDTO> carExportRootDTOClass);
}
