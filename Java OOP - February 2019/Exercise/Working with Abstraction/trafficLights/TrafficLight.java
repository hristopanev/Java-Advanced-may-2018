package trafficLights;

public class TrafficLight {
    private Lightstates state;

    public TrafficLight(Lightstates state){
        this.state = state;
    }

    public void update(){
        switch (this.state){
            case RED:
                this.state = Lightstates.GREEN;
                break;
            case GREEN:
                this.state = Lightstates.YELLOW;
                break;
            case YELLOW:
                this.state = Lightstates.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.state.toString();
    }
}
