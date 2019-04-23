package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.UserSeedDTO;
import productshop.domain.dtos.views.SoldProductDTO;
import productshop.domain.dtos.views.UserWithSoldItemDTO;
import productshop.domain.entities.Product;
import productshop.domain.entities.User;
import productshop.repository.UserRepository;
import productshop.util.ValidatorUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers(UserSeedDTO[] userSeedDTOS) {
        for (UserSeedDTO userSeedDto : userSeedDTOS) {
            if (!this.validatorUtil.isValid(userSeedDto)){
                this.validatorUtil.violations(userSeedDto)
                        .forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            User entity = this.modelMapper.map(userSeedDto, User.class);

            this.userRepository.saveAndFlush(entity);
        }
    }


    public List<UserWithSoldItemDTO> getAllBySellContainsProductBuyer(){
        List<User> sellerList = this.userRepository.getAllBySellContainsProductBuyer();

        List<UserWithSoldItemDTO> userWithSoldItemDTOS = new ArrayList<>();

        for (User user : sellerList) {
            List<SoldProductDTO> soldUser = new ArrayList<>();

            for (Product product : user.getSellerProducts()) {

                if (product.getBuyer() != null){
                    SoldProductDTO soldProductDTO = new SoldProductDTO(
                            product.getName(),
                            product.getPrice(),
                            product.getBuyer().getFirstName(),
                            product.getBuyer().getLastName());

                     soldUser.add(soldProductDTO);

                }
            }

            UserWithSoldItemDTO seller = this.modelMapper.map(user, UserWithSoldItemDTO.class);
            seller.setSoldProducts(soldUser);
            userWithSoldItemDTOS.add(seller);
        }

        return userWithSoldItemDTOS;
    }


}
