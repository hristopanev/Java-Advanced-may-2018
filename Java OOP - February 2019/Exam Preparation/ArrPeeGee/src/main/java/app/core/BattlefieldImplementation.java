package app.core;

import app.contracts.*;
import app.models.participants.Warrior;
import app.constants.Texts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BattlefieldImplementation implements Battlefield {

    private Map<String, Targetable> participants;
    private List<Action> executedActions;
    private Writer writer;
    private ActionFactory actionFactory;
    private TargetableFactory targetableFactory;

    public BattlefieldImplementation(Writer writer, ActionFactory actionFactory) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.actionFactory = actionFactory;
        this.writer = writer;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        Action action;
        try {
             action = this.actionFactory.create(actionName, participantNames);

            List<Targetable> actionParticipants = new ArrayList<>();

            for (String name : participantNames){
                if (this.participants.containsKey(name)){
                    actionParticipants.add(this.participants.get(name));
                } else {
                    this.writer.writeLine(String.format(Texts.PARTICIPANT_NOT_PRESENT, name, actionName));
                    return;
                }
            }

            System.out.println(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            this.writer.writeLine(Texts.ACTION_DOES_NOT_EXIST);
        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)){
            System.out.println("Participant with that name already exists.");
            return;
        }

        Targetable targetable;

        switch (className) {
            case "Warrior":
                targetable = new Warrior();
                targetable.setName(name);
                this.participants.put(targetable.getName(), targetable);
                System.out.println(
                        String.format("%s %s entered the battlefield.",
                                targetable.getClass().getSimpleName(),
                                targetable.getName()));
                break;
            default:
                System.out.println("Participant class does not exist.");
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reportParticipants(){
        if (this.participants.size() < 1) {
            System.out.println("There are no participants on the battlefield.");
            return;
        }

        for (String name : this.participants.keySet()) {
            System.out.println(this.participants.get(name).toString());
            System.out.println("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions(){
        if (this.executedActions.size() < 1) {
            System.out.println("There are no actions on the battlefield.");
            return;
        }

        for (Action executedAction : executedActions) {
            System.out.println(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants(){
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (Targetable participant : this.participants.values()) {

            if (!participant.isAlive()){
                this.writer.writeLine(String.format(Texts.DEAD_PARTICIPANT, participant.getName()));
            }else {
                aliveParticipants.put(participant.getName(),participant);
            }
        }

        this.participants = aliveParticipants;
    }
}
