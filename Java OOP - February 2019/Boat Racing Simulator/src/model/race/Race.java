package model.race;

import exeption.ArgumentException;
import exeption.DuplicateModelException;
import model.boat.Boat;
import model.boat.Motorboat;

import java.util.HashSet;
import java.util.Set;

public class Race {
    private double distance;
    private double windSpeed;
    private double currentSpeed;

    private Set<Boat> participants;
    private boolean allowMotorboats;

    public Race(double distance, double windSpeed, double currentSpeed, boolean allowMotorboats) {
        this.distance = distance;
        this.windSpeed = windSpeed;
        this.currentSpeed = currentSpeed;
        this.allowMotorboats = allowMotorboats;

        this.participants = new HashSet<>();
    }

    public void addParticipant(Boat newParticipant) throws DuplicateModelException, ArgumentException {
        if (!this.areMotorboatsAllowed() && newParticipant instanceof Motorboat){
            throw new ArgumentException();
        }


            boolean added = this.participants.add(newParticipant);

       if (!added) throw  new DuplicateModelException();
    }


    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Set<Boat> getParticipants() {
        return this.participants;
    }

    public void setParticipants(Set<Boat> participants) {
        this.participants = participants;
    }

    public boolean areMotorboatsAllowed() {
        return this.allowMotorboats;
    }

    public void setAllowMotorboats(boolean allowMotorboats) {
        this.allowMotorboats = allowMotorboats;
    }
}
