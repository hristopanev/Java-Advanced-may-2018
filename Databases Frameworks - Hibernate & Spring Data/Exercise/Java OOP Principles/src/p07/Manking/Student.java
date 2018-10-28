package p07.Manking;

public class Student extends Human{

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    public void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10){
            throw new IllegalArgumentException("Invalid faculty number!");
        }else {

            this.facultyNumber = facultyNumber;
        }
    }

    @Override
    public void setLastName(String lastName) {
        if (lastName.length() <= 3){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }else {
            super.setLastName(lastName);
        }
    }

    @Override
    public String toString() {
        StringBuilder student = new StringBuilder();

        student.append("First Name: ").append(this.getFirstName()).append(System.lineSeparator())
                .append("Last Name: ").append(this.getLastName()).append(System.lineSeparator())
                .append("Faculty number: ").append(this.facultyNumber);

        return student.toString();
    }
}
