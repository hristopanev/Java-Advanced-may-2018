package usersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersystem.repository.PictureRepository;

@Service
public class PictureServicesImpl  implements PictureServices{

    private final PictureRepository pictureRepository;

    @Autowired
    public PictureServicesImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public void seedPictures() {

    }
}
