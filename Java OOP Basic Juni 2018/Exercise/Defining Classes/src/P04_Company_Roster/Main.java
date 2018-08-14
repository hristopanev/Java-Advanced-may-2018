package P04_Company_Roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfEmloyees = Integer.parseInt(reader.readLine());

        List<Employee> employees = new ArrayList<>();

        while (countOfEmloyees -- > 0){
            String[] tockens = reader.readLine().split("\\s+");


            String name = tockens[0];
            double salary = Double.parseDouble(tockens[1]);
            String positon = tockens[2];
            String department = tockens[3];
            Employee employee = null;


            switch (tockens.length){
                case 4:
                    employee = new Employee(name, salary, positon, department);
                break;
                case 5:
                    if (tockens[4].matches("\\d+")){
                        int age = Integer.parseInt(tockens[4]);
                        employee = new Employee(name, salary, positon, department, age);
                    }else {
                        String email = tockens[4];
                        employee = new Employee(name, salary, positon, department, email);
                    }
                    break;
                case 6:
                    String email = tockens[4];
                    int age = Integer.parseInt(tockens[5]);
                    employee = new Employee(name, salary, positon, department, email, age);
                    break;
            }

            employees.add(employee);
        }

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((e1, e2) ->
                        Double.compare(
                                e2.getValue().stream().mapToDouble(Employee::getSalary)
                                        .average().getAsDouble(),
                                e1.getValue().stream().mapToDouble(Employee::getSalary)
                                        .average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    StringBuilder result = new StringBuilder();
                    result.append(String.format("Highest Average Salary: %s", d.getKey()))
                            .append(System.lineSeparator());
                    d.getValue().stream()
                            //.sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(employee -> result.append(employee.toString()).append(System.lineSeparator()));
                    System.out.print(result.toString());
                });
    }
}
