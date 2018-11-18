package usersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import usersystem.services.AlbumServices;
import usersystem.services.PictureServices;
import usersystem.services.TownServices;
import usersystem.services.UserServices;


@Controller
public class UserController implements CommandLineRunner {

    private final UserServices userServices;
    private final TownServices townServices;
    private final AlbumServices albumServices;
    private final PictureServices pictureServices;

    @Autowired
    public UserController(UserServices userServices, TownServices townServices, AlbumServices albumServices, PictureServices pictureServices) {
        this.userServices = userServices;
        this.townServices = townServices;
        this.albumServices = albumServices;
        this.pictureServices = pictureServices;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userServices.seedUsers();
        this.townServices.seedTown();
        this.albumServices.seedAlbums();
        this.pictureServices.seedPictures();

    }
}
