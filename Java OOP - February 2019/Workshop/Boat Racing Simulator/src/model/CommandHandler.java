package model;

import exeption.DuplicateModelException;

public class CommandHandler {

    private final ApplicationController appController;

    CommandHandler() {
        this.appController = new ApplicationController();
    }



    public void handle(String[] split) throws DuplicateModelException {
        String result = "";
        switch (split[0]) {
            case "CreateBoatEngine":
                result = createBoatEngine(split);
                break;

            case "CreateRowBoat":
                createRowBoat(split);
                break;
        }

        if (!result.isEmpty()) System.out.println(result);
    }

    private void createRowBoat(String[] split) {
        String model = split[1];
        double weight = Double.parseDouble(split[2]);
        int oars = Integer.parseInt(split[3]);
        this.appController.createRowBoat(
                model,
                weight,
                oars
        );
    }

    private String createBoatEngine(String[] args) throws DuplicateModelException {
        String model = args[1];
        int horsepower = Integer.parseInt(args[2]);
        int displacement = Integer.parseInt(args[3]);
        String type = args[4];

        this.appController.createEngine(
                model,
                horsepower,
                displacement,
                type
        );

        return String.format("Engine model %s" +
                        " with %d HP " +
                        "and displacement %d cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

}
