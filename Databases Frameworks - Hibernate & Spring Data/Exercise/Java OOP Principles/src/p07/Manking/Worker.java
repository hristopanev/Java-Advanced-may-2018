package p07.Manking;

public class Worker extends Human {



    private double weekSalary;
    private double hoursPerDay;

    public double getSalaryPerHour(){
        return this.getWeekSalary() / (7* getHoursPerDay());
    }

    public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
    }


    public double getWeekSalary() {
        return this.weekSalary;

    }

    public double getHoursPerDay() {
        return this.hoursPerDay;
    }


    public void setWeekSalary(double weekSalary) {

        if (weekSalary <= 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }else {

            this.weekSalary = weekSalary;
        }
    }

    public void setHoursPerDay(double hoursPerDay) {

        if (hoursPerDay <1 || hoursPerDay >12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }else {

            this.hoursPerDay = hoursPerDay;
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("First Name: ").append(this.getFirstName()).append(System.lineSeparator())
                .append("Last Name: ").append(this.getLastName()).append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.getHoursPerDay()))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", this.getSalaryPerHour()));

        return sb.toString();
    }
}
