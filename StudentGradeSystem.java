import java.util.Scanner;

class StudentGradeSystem {

    public static void main(String[] args) {
        StudentGradeSystem obj = new StudentGradeSystem();
        obj.studentDetails();
    }

    void studentDetails() {
        String Name;
        long RollNo;
        byte Java, Python, C;
        short Total;
        float Percentage;

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Student Name: ");
        Name = sc.nextLine();
        
        System.out.print("Enter Roll Number: ");
        RollNo = sc.nextLong();
        
        System.out.print("Enter Java Marks: ");
        Java = sc.nextByte();
        
        System.out.print("Enter Python Marks: ");
        Python = sc.nextByte();   
        
        System.out.print("Enter C Marks: ");
        C = sc.nextByte();

        // Calculate marks and percentage
        Total = (short) (Java + Python + C);
        Percentage = (Total / 300.0f) * 100;    
        
        System.out.println("\n--- Student Report Card ---");
        System.out.println("Student Name: " + Name);
        System.out.println("Roll Number : " + RollNo);
        System.out.println("Total Marks : " + Total + " / 300");
        System.out.println("Percentage  : " + Percentage + "%");

        // Grade calculation logic
        if (Percentage > 90) {
            System.out.println("Grade       : A");
        } 
        else if (Percentage > 80) {
            System.out.println("Grade       : B");
        } 
        else if (Percentage > 70) {
            System.out.println("Grade       : C");
        } 
        else if (Percentage > 60) {
            System.out.println("Grade       : D");
        } 
        else if (Percentage > 50) {
            System.out.println("Grade       : E");
        } 
        else {
            System.out.println("Grade       : F (Fail)");
        }

        sc.close(); // Clean up scanner resource leak
    }
}

