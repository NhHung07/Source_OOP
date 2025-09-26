package Week2.QuanLySinhVien;

public class StudentManagement {
    private Student[] students = new Student[100];
    private int count = 0;

    /**
     *  tạo thêm 1 mảng lưu group đã được in rồi.
     */
    public String studentsByGroup() {
        String[] printedGroup =  new String[count];
        String result = "";
        int countGroup = 0;
        for (int i = 0; i < count; i++) {
            boolean check = false;
            for (int j = 0; j < countGroup; j++) {
                if (printedGroup[j].equals(students[i].getGroup())) {
                    check = true;
                }
            }
            if (!check) {
                printedGroup[countGroup] = students[i].getGroup();
                result += printedGroup[countGroup] + "\n";
                for (int k = 0; k < count; k++) {
                    if (students[k].getGroup().equals(printedGroup[countGroup])) {
                        result += students[k].getName() 
                                + " - " + students[k].getId()
                                + " - " + students[k].getGroup()
                                + " - " + students[k].getEmail() + "\n";
                    }
                }
                countGroup++;
            }
        }
        return result;
    }

    /**
     * add student.
     */
    public void addStudent(Student newStudent) {
        students[count] = newStudent;
        count++;
    }

    /**
     * remove student.
     */
    public void removeStudent(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[count] =  null;
                count--;
                break;
            }
        }
    }

    /**
     * check if two given students are of the same group.
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }
}
