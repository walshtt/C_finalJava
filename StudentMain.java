import java.util.*;
import java.util.List;


public class StudentMain {

    public static void main(String[] args) {
        
      XML_InputStudent read = new XML_InputStudent();
      ArrayList<Student> readConfig = read.readConfig("src/students.xml");
       
      GradeBook g = new GradeBook(readConfig); 
      Scanner in = new Scanner(System.in);
       
      g.get(0).printStudent();
      
      System.out.print("\n\n continue? press y \n");
      in.next();
      g.printGradeBook();
      
      System.out.print("\n\n continue? press y \n");
      in.next();
      g.sortByName();
      g.printGradeBook();
      
      System.out.print("\n\n continue? press y \n");
      in.next();
      g.sortByMajor();
      g.printGradeBook();
      
      System.out.print("\n\n continue? press y \n");
      in.next();
      g.removestudent(g.get(2));
      g.printGradeBook();
      
      System.out.print("\n\n continue? press y \n");
      in.next();
      ArrayList<String> act = new ArrayList<>();
      act.add("jumping");
      act.add("crushing goombas");
      act.add("rescuing princesses");
      act.add("being italian");
      Student mario = new Student("Mario",36, "Plumbing",act, 'A');
      g.addStudent(mario);
      g.printGradeBook();
      
      
    }
    
}
