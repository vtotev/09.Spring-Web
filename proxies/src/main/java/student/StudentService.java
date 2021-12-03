package student;

import java.util.List;

public class StudentService implements StudentServiceIfc {

    @Cacheable("students")
    @Override
    public List<Student> getAllStudents() {
        System.out.println("Calculating students...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        return List.of(
                new Student("Pesho", 21),
                new Student("Anna", 18)
        );
    }
}
