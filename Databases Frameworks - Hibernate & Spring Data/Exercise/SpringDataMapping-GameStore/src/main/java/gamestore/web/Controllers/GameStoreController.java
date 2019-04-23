package gamestore.web.Controllers;

import gamestore.domain.dtos.UserLoginDTO;
import gamestore.domain.dtos.UserLogoutDTO;
import gamestore.domain.dtos.UserRegisterDTO;
import gamestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class GameStoreController implements CommandLineRunner {

    private String loggedInUser;

    private final UserService userService;

    @Autowired
    public GameStoreController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String inputLine = scanner.nextLine();

            String[] inputParams = inputLine.split("\\|");
            switch (inputParams[0]){
                case "RegisterUser":

                    UserRegisterDTO userRegisterDTO = new UserRegisterDTO(
                            inputParams[1], inputParams[2], inputParams[3], inputParams[4]);
                    System.out.println(this.userService.registerUser(userRegisterDTO));

                    break;
                case "LoginUser":

                    if (this.loggedInUser == null) {
                        UserLoginDTO userLoginDTO = new UserLoginDTO(inputParams[1], inputParams[2]);
                        String loginResult = this.userService.loginUser(userLoginDTO);

                        if (loginResult.contains("Successfully logged in")){
                           this.loggedInUser = userLoginDTO.getEmail();
                        }
                        System.out.println(loginResult);
                    }else {
                        System.out.println("Session is taken");
                    }


                    break;
                case "Logout":

                    if(this.loggedInUser == null){
                        System.out.println("Cannot log out. No user was logged in.");
                    }else {
                        String logoutResult = this.userService.logoutUser(new UserLogoutDTO(this.loggedInUser));
                        System.out.println(logoutResult);

                        this.loggedInUser = null;
                    }

                    break;
                case "AddGame":

                    if (this.loggedInUser != null && this.userService.isAdmin(this.loggedInUser)){


                    }else {
                        System.out.println("Cannot log out. No user was logged in.");
                    }
                    break;
            }
        }
    }
}
