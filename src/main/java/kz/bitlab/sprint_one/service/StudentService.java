package kz.bitlab.sprint_one.service;

import kz.bitlab.sprint_one.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private static final List<Student> students = new ArrayList<>();
    private static Long id = 1L;

    static {
        students.add(new Student(id++, "Ilyas", "Zhuanyshev", 88, "B"));
        students.add(new Student(id++, "Serik", "Erikov", 91, "A"));
        students.add(new Student(id++, "Erik", "Serikov", 65, "C"));
        students.add(new Student(id++, "Nurzhan", "Bolatov", 48, "F"));
        students.add(new Student(id++, "Patrick", "Zuckerberg", 100, "A"));
    }

    public static List<Student> findAll() {
        return students;
    }

    public static void create(Student student) {
        students.add(student);
    }
}
