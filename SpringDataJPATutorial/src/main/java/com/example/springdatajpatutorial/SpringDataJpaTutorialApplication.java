package com.example.springdatajpatutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJpaTutorialApplication {

    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("Hoang","Minh",30799.0, Collections.singletonList("project 1,project 2")));
        employees.add(new Employee("Ninh","Van",40199.0, Collections.singletonList("project 2,project 3")));
        employees.add(new Employee("Minh","Duc",10599.0, Collections.singletonList("project 4,project 5")));
    }


    public static void main(String[] args) {
//        SpringApplication.run(SpringDataJpaTutorialApplication.class, args);

        Stream.of(employees);

        //  foreach
        employees.forEach(System.out::println);

        //  map
        //  collect

        /* Hàm Map là một phương thúc trong lớp stream đại diện cho khái niệm lập trình hàm.
        Nói một cách đơn giản, map() được sử dụng để chuyển đổi một đối tượng thành một đối tượng khác
        bằng cách áp dụng một hàm
        */

        /*
        Phương thức collect() làm một trong những phương thức xử lý tiêu biểu của interface Stream. Khi phương thức này
        được gọi thì việc filter hay mapping ở ví dụ dưới đây mới thực sự được thực hiện
         */

        Set<Employee> increasedSal =
        employees.stream().map(employee -> new Employee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary() * 1.10,
                employee.getProject()
        )).collect(Collectors.toSet());
        System.out.println("=================================================================");
        System.out.println(increasedSal);

        //  filter <Lọc>

        List<Employee> filterEmployee =
        employees.stream()
                .filter(employee -> employee.getSalary() > 30000.0)
                .map(employee -> new Employee(
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary() *1.10,
                        employee.getProject()
                ))
                .collect(Collectors.toList());

        System.out.println(filterEmployee);

        //  findFirst()
        /*
        Phương thức findFirst() tìm phần tử đầu tiên trong stream. Vì vậy, chúng ta sử dụng phương pháp này khi
        chúng ta đặc biệt muốn phần từ đầu tiên từ một chuỗi
         */

        //  findAny()
        /*
        Phương thức findAny() cho phép chúng ta tìm bất kì phần tử nào từ stream. Chúng ta sử dụng nó khi chúng ta đang
        tìm kiếm một yếu tố không chú đến thứ tự gặp phải
         */

        System.out.println("=================================================================");
        Employee firstEmployee =
                employees.stream()
                        .filter(employee -> employee.getSalary() > 30000.0)
                        .map(employee -> new Employee(
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary() *1.10,
                                employee.getProject()
                        ))
                        .findFirst()
                        .orElse(null);
        System.out.println(firstEmployee);

        //  flatMap

        /*
        Dùng phương thức flatMap() chúng ta có thể chuyển đổi đối tượng stream của những đối tượng List, Set or Array
        thành đối tượng stream của những đối tượng đơn giản hơn
         */
        System.out.println("=================================================================");
        String projects =
                        employees.stream()
                                .map(Employee::getProject)
                                .flatMap(Collection::stream)
                                .collect(Collectors.joining(","));
        System.out.println(projects);

        System.out.println("=================================================================");
        //  short Circuit operations
        /*
        Limit : là kích thước tối đa của các phần tử trong stream, luồng không thể chứa các phần tử lớn hơn maxsize
         */
        List<Employee> shortCircuit = employees.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(shortCircuit);

        //  Finite Data
        System.out.println("=================================================================");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //  sorting
        System.out.println("=================================================================");



    }
}
