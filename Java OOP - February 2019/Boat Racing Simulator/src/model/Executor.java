package model;

import command.Command;
import command.Context;
import exeption.DuplicateModelException;

import java.util.Scanner;

public class Executor {
    private static final String END_COMMAND = "End";

    private final Scanner scanner;
    private final CommandHandler commandsHandler;


    Executor(){
        this.scanner = new Scanner(System.in);
        this.commandsHandler = new CommandHandler();
    }

    public void  execute() throws DuplicateModelException {
        String line = this.scanner.nextLine();
        Context context = new Context();

        while (!line.equals(END_COMMAND)){
//            this.commandsHandler.handle(line.split("\\\\"));

//            Command command = CommandFactory.create(line);
//            context.addCommand(command);

            line = this.scanner.nextLine();
        }

        context.execute();
    }
}
