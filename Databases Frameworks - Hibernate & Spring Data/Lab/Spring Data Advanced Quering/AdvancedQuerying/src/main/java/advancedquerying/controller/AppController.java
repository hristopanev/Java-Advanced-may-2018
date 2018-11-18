package advancedquerying.controller;

import advancedquerying.service.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AppController implements CommandLineRunner {

    private final ShampooService shampooService;
    private final Scanner scanner;

    @Autowired
    public AppController(ShampooService shampooService, Scanner scanner) {
        this.shampooService = shampooService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

        /*String inputSize = this.scanner.nextLine();
        List<String> result = this.shampooService.selectShampoosBySize(inputSize);
        result.forEach(r -> System.out.println(r));*/



        /*List<String> lines = new ArrayList<>();
        while (true){
            String line = this.scanner.nextLine();
            if ("".equals(line)){
                break;
            }
            lines.add(line);
        }
        this.shampooService.selectShampoosByIngredients(lines).forEach(s-> System.out.println(s));*/


    }
}
