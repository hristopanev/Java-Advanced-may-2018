package usersystem.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersystem.repository.AlbumRepository;


@Service
public class AlbumServicesImpl implements AlbumServices {

    private final AlbumRepository albumRepository;


    @Autowired
    public AlbumServicesImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public void seedAlbums() {

    }
}
