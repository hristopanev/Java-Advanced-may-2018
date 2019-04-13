package panzer.entities.Vehicles;

import panzer.contracts.Part;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Revenger extends BaseVehicles {
    public Revenger(String model, double weight, BigDecimal price, int attack, int defence, int hitPoints) {
        super(model, weight, price.multiply(new BigDecimal(1.50)),
                (int) (attack * 2.5),
                (int) (defence * 0.50),
                (int) (hitPoints * 0.50));
    }

    @Override
    public String toString() {

        //{vehicleType} – {vehicleModel}
        //Total Weight: {	ght}
        //Total Price: {totalPrice}
        //Attack: {totalAttack}
        //Defense: {totalDefense}
        //HitPoints: {totalHitPoints}
        //Parts: {part1Model}, {part2Model}

        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(" - ").append(this.getModel()).append(System.lineSeparator());
        sb.append("Total Weight: ").append(this.getTotalWeight()).append(System.lineSeparator());
        sb.append("Total Price: ").append(this.getTotalPrice()).append(System.lineSeparator());
        sb.append("Attack ").append(this.getTotalAttack()).append(System.lineSeparator());
        sb.append("Defence ").append(this.getTotalDefense()).append(System.lineSeparator());
        sb.append("HitPoints: ").append(this.getTotalHitPoints()).append(System.lineSeparator());
        List<Part> toJoin=new ArrayList<>((Collection<? extends Part>) super.getParts());
        if(toJoin.size()==0){
            sb.append("Parts: None");
        }else{
            List<String> toJoin2=new ArrayList<>();
            for (int i = 0; i < toJoin.size(); i++) {
                toJoin2.add(toJoin.get(i).getModel());
            }
            sb.append("Parts: "+String.join(", ",toJoin2));
        }
        return sb.toString();
    }
}
