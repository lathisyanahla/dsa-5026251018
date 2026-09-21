package lw01.unguided;

public class ProjectorRental extends Rental{
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    public int calculateCharge() {
        int days = getDays();
        int cost = 0;
        if(days <= 3){
            cost = days * 60000;
        }
        else{
            cost = (3 * 60000) + ((days - 3) * 45000);
        }
        cost += 20000;
        return cost;
    }

    public String label() {
        return "Projector";
    }
}
