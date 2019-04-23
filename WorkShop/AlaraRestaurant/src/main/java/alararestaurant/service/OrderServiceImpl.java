package alararestaurant.service;

import alararestaurant.repository.OrderRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import alararestaurant.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class OrderServiceImpl implements OrderService {

    private final static String ORDER_FILE_IMPORT_XML = System.getProperty("user.dir") + "/src/main/resources/files/orders.xml";

    private final OrderRepository orderRepository;
    private final XmlParser xmlParser;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, XmlParser xmlParser, FileUtil fileUtil, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.orderRepository = orderRepository;
        this.xmlParser = xmlParser;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean ordersAreImported() {
         return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {
       return this.fileUtil.readFile(ORDER_FILE_IMPORT_XML);
    }

    @Override
    public String importOrders() {
        // TODO : Implement me
        return null;
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        // TODO : Implement me
        return null;
    }
}
