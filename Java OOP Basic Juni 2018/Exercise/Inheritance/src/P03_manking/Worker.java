package P03_manking;

public class Worker extends Human {
    private static final String INVALID_WORKER_LASTNAME_FORMAT_EXCEPTION_MESSEGE =
            "Expected length more than 3 symbols!Argument: lastName";

    private static final String INVALID_WORKER_WEEK_SALARY_EXCEPTION_MESSEGE =
            "Expected value mismatch!Argument: weekSalary";

    private static final String INVALID_WORKER_WORKING_HOUR_EXCEPTION_MESSEGE =
            "Expected value mismatch!Argument: weekSalary";


    public static final int WORKING_DAY_PER_WEEK = 7;
    private double weekSalary;
    private double worksHoursPerDay;


    private double getSalaryPerHour() {
        double salaryPerHour = this.weekSalary / (this.worksHoursPerDay * WORKING_DAY_PER_WEEK);
            return salaryPerHour;
    }


    @Override
    public void setLastName(String lastName) {
        if (lastName.length() <= 3){
            throw new IllegalArgumentException(INVALID_WORKER_LASTNAME_FORMAT_EXCEPTION_MESSEGE);
        }else {
            super.setLastName(lastName);
        }
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10){
            throw new IllegalArgumentException(INVALID_WORKER_WEEK_SALARY_EXCEPTION_MESSEGE);
        }else {
            this.weekSalary = weekSalary;
        }
    }

    public void setWorksHoursPerDay(double worksHoursPerDay) {
        if (worksHoursPerDay < 1 || worksHoursPerDay > 12){
            throw new IllegalArgumentException(INVALID_WORKER_WORKING_HOUR_EXCEPTION_MESSEGE);
        }else {
            this.worksHoursPerDay = worksHoursPerDay;
        }
    }

    public Worker(String firstName, String lastName, double weekSalary, double worksHoursPerDay) {
        super(firstName, lastName);
        this.weekSalary = weekSalary;
        this.worksHoursPerDay = worksHoursPerDay;
    }

    @Override
    public String toString() {
        StringBuilder worker = new StringBuilder();
        worker.append(super.toString()).append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f", this.weekSalary))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", this.worksHoursPerDay))
                .append(System.lineSeparator())
                .append("Salary per hour ").append(String.format("%.2f", getSalaryPerHour()));


        return worker.toString();
    }
}
