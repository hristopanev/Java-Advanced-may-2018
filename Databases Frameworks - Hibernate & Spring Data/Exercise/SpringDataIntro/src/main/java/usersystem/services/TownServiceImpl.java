package usersystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usersystem.repository.TownRepository;


@Service
public class TownServiceImpl implements TownServices {

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, TownRepository townRepository1) {
        this.townRepository = townRepository1;

    }


    @Override
    public void seedTown() {

    }
}
