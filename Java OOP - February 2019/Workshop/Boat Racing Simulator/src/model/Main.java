package model;

import exeption.ArgumentException;
import exeption.DuplicateModelException;
import model.boat.Boat;
import model.boat.PowerBoat;
import model.boat.Yacht;
import model.engine.Engine;
import model.engine.JetEngine;
import model.race.Race;

public class Main {
    public static void main(String[] args) throws DuplicateModelException, ArgumentException {
        Executor executor = new Executor();
        executor.execute();

//        Race race = new Race(1.0, 1.0, 1.0, true);
//
//        Engine engine =  new JetEngine("model", 123, 1200);
//        Boat racer1 = new Yacht("Yacht", 12, engine, 123);
//        Boat racer2 = new PowerBoat("Yacht", 12, engine, engine);
//
//        race.addParticipant(racer1);
//        race.addParticipant(racer2);

    }
}
