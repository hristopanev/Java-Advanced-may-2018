package panzer.entities.Vehicles;

import panzer.contracts.Part;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Vanguard extends BaseVehicles {
    public Vanguard(String model, double weight, BigDecimal price, int attack, int defence, int hitPoints) {
        super(model, weight * 2.0, price, (int) (attack * 0.75), (int) (defence * 1.50), (int) (hitPoints * 1.75));
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
        sb.append(" - ").append(super.getModel()).append(System.lineSeparator());
        sb.append("Total Weight: ").append(super.getTotalWeight()).append(System.lineSeparator());
        sb.append("Total Price: ").append(super.getTotalPrice()).append(System.lineSeparator());
        sb.append("Attack ").append(super.getTotalAttack()).append(System.lineSeparator());
        sb.append("Defence ").append(super.getTotalDefense()).append(System.lineSeparator());
        sb.append("HitPoints: ").append(super.getTotalHitPoints()).append(System.lineSeparator());
        List<Part> toJoin=new ArrayList<Part>((Collection<? extends Part>) super.getParts());
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
