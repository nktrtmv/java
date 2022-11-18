import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Group {
    private final int size;
    private final Student[] students;
    private final HashMap<Student, HashMap<Integer, Integer>> scoreSheet;

    public Group(int size){
        this.size = size;
        students = new Student[size];
        for (int i = 0; i < size; i++){
            students[i] = new Student(Main.names[i], Main.surnames[i]);
        }
        scoreSheet = new HashMap<>();
        for (Student student : students) {
            scoreSheet.put(student, new HashMap<>());
        }
    }

    void rateStudent(Student student, int seminar, int mark){
        for (int i = 0; i < size; i++){
            if (student == students[i]){
                scoreSheet.get(students[i]).put(seminar, mark);
                return;
            }
        }
    }


    public void printSheet(){
        System.out.println();
        for (Student student : students){
            System.out.print(student.name() + " " + student.surname() + " имеет оценки: \n");
            ArrayList<Integer> seminars = new ArrayList<>(scoreSheet.get(student).keySet());
            Collections.sort(seminars);
            for (Integer key : seminars){
                System.out.println("\t" + "за " + key + " семинар: " + scoreSheet.get(student).get(key));
            }
        }
    }

    public Student getStudent(String name, String surname){
        for (Student student : students) {
            if (student.name().equals(name) &&  student.surname().equals(surname)){
                return student;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
