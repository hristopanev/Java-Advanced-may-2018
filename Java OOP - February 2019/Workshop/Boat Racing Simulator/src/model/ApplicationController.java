package model;

import exeption.DuplicateModelException;
import model.boat.Boat;
import model.boat.RowBoat;
import model.engine.Engine;
import model.engine.JetEngine;
import model.engine.SterndriveEngines;
import repository.BoatRepository;
import repository.EngineRepository;


public class ApplicationController {

    private static final String JET_ENGINE = "Jet";
    private EngineRepository engineRepository;
    private BoatRepository boatRepository;

    public ApplicationController() {
        this.engineRepository = new EngineRepository();
        this.boatRepository = new BoatRepository();
    }


    public void createEngine(String model, int horsepower, int displacement, String type) throws DuplicateModelException {

        Engine result = null;

        if (type.equals(JET_ENGINE)){
            result = new JetEngine(model, horsepower, displacement);
        }else {
            result = new SterndriveEngines(model, horsepower, displacement);
        }

        boolean saveResult = this.engineRepository.save(result);

        if (!saveResult){
            throw new DuplicateModelException();
        }

    }

    public void createRowBoat(String model, double weight, int oars) {
        Boat boat = new RowBoat(model, weight, oars);

        this.boatRepository.save(boat);
    }
}
