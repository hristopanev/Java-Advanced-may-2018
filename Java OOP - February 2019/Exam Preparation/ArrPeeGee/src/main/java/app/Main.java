package app;

import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.engine.EngineImpl;
import app.factory.ActionFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ActionFactory actionFactory = new ActionFactoryImpl();

//        Battlefield battleField = new BattlefieldImplementation();
//
//        Engine engine = new EngineImpl(writer, reader, battleField);
//
//        engine.run();

    }
}
