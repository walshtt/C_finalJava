import java.util.*;
public class GradeBook {
   
    private ArrayList<Student> gradeBook;
    
    public GradeBook(){
        gradeBook = new ArrayList<Student>();
    }
    
    public GradeBook(ArrayList<Student> students){
        gradeBook = students;
    }
    
    public void addStudent(Student s){
        gradeBook.add(s);
    }
    
    public void removestudent (Student s){
     
        if(gradeBook.contains(s) )
            gradeBook.remove(s);
        else
        {
            System.out.println("error student does not exist");
        }
       
    }
    
    public void sortByName(){
       for(int i=0; i<gradeBook.size()-1; i++){
           Student temp = gradeBook.get(i);
           gradeBook.remove(i);
           for (int j= 0; j<gradeBook.size(); j++){
               if (temp.name.compareToIgnoreCase(gradeBook.get(j).name) <0 && j<gradeBook.size()-1)
               {
                   gradeBook.add(temp);
                   
                   break;
               }
               else if(temp.name.compareToIgnoreCase(gradeBook.get(j).name) >0||temp.name.compareToIgnoreCase(gradeBook.get(j).name) == 0)
               {
                   gradeBook.add(j+1,temp);
                  
                   break;
               }
               
           }
       }
   }
     public void sortByMajor(){
       for(int i=0; i<gradeBook.size()-1; i++){
           Student temp = gradeBook.get(i);
           gradeBook.remove(i); 
           for (int j= 0; j<gradeBook.size(); j++){
               if (temp.major.compareToIgnoreCase(gradeBook.get(j).major) <0 && j<gradeBook.size()-1)
               {
                   gradeBook.add(temp);
                    
                   break;
               }
               else if(temp.major.compareToIgnoreCase(gradeBook.get(j).major) >0||temp.major.compareToIgnoreCase(gradeBook.get(j).major) == 0)
               {
                   gradeBook.add(j+1,temp);
                   
                   break;
               }
               
           }
       }
   }
     public Student get(int i){
    	 return gradeBook.get(i);
     }
     
     public void printGradeBook() {
    for (Student s: gradeBook){
        s.printStudent();
        System.out.println("\n");
    }
     }
     
}
