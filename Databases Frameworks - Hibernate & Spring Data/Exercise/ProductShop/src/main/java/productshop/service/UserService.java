package productshop.service;

import productshop.domain.dtos.UserSeedDTO;
import productshop.domain.dtos.views.UserWithSoldItemDTO;
import productshop.domain.entities.User;

import java.util.List;

public interface UserService {

    void seedUsers(UserSeedDTO[] userSeedDTOS);

    List<UserWithSoldItemDTO> getAllBySellContainsProductBuyer();
}
