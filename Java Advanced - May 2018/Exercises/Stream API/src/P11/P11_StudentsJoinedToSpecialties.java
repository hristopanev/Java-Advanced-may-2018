package P11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//TODO
public class P11_StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialty> studentSpecialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        String line;
        while (true) {
            if ("Stzdents".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String specialTyNameFirst = tokens[0];
            String specialTyNameSecond = tokens[1];
            String facultyNumber = tokens[2];

            StudentSpecialty studentSpecialty = new StudentSpecialty(
                    specialTyNameFirst + " " + specialTyNameSecond, facultyNumber);

            studentSpecialties.add(studentSpecialty);
        }


        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[]  tokens= line.split(" ");

            String facultyNumber = tokens[0];
            String studentFirstName = tokens[1];
            String studentLastName = tokens[2];

            Student student = new Student(
                    studentFirstName + " " + studentLastName, facultyNumber);

            students.add(student);
        }

        students.sort(Comparator.comparing(Student::getFacultyNumber));
        List<String> joint = new ArrayList<>();



        studentSpecialties.stream()
                .flatMap(sp ->
                        students.stream().filter(student -> {
                    if (sp.getFacultyNumber()
                            .equals(student.getFacultyNumber())){
                        System.out.println((String.format("%s %s %s",
                                student.getStudentName(),
                                student.getFacultyNumber(),
                                sp.getSpecialtyName())));


                    }
                    return sp
                            .getFacultyNumber()
                            .equals(student.getFacultyNumber());
                }));



    }
}

class StudentSpecialty {
    String specialtyName;
    String facultyNumber;

    public String getSpecialtyName() {
        return specialtyName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }
}


class Student{
    String facultyNumber;
    String studentName;

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student(String facultyNumber, String studentName) {
        this.facultyNumber = facultyNumber;
        this.studentName = studentName;
    }
}
