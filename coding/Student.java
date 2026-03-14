public class Student {
    static String schoolName = "ABC Public School"; // static variable

    String studentName; // instance variable


    void displayInfo() {  // non-static method
        System.out.println("Student: " + studentName);

        // ✅ Option 1: Access directly (recommended)
        System.out.println("School: " + schoolName);

        // ✅ Option 2: Access using class name (best practice)
        System.out.println("School: " + Student.schoolName);
    }
    String name = "non static variable";

    static void display(Student obj) {
        System.out.println(obj.name);
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.studentName = "Neelam";
        s1.displayInfo();
        display(s1);

    }
}
