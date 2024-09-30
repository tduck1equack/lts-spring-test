package lts.exam1.interfaces.services;

import lts.exam1.models.Student;

import java.util.List;

public interface StudentServiceInterface {
    public List<Student> allStudent();
    public Student addStudent(Student student);
    public Student editStudent(Student student);
    public Student removeStudent(Integer studentId);
}
