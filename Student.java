import java.util.*;
        
public class Student {
    
    public String name;
    public int age; 
    public String major;
    public ArrayList<String> activities;
    public char grade ;
    
   public Student(){
      name = "";
      age = 0;
      major= ""; 
      activities =new ArrayList<>();
      grade = 'A';
      
         
   }
   public Student(String n, int a, String m, ArrayList<String> act, char g){
       name = n;
       age = a;
       major= m;
       activities= act;
       sortActivities();
       grade = g;
       
          
   }
   
   public void setGrade(char g){
       grade = g;
   }
   
   public void setAge(int a)
   {
	   age = a;
   }
   
   public boolean compareTo(Student s){
       if (name.equals(s.name)&& age==s.age && major.equals(s.major) && grade==s.grade)
               return true;
       return false;
     
   }
   
   
   
   public void sortActivities(){
       for(int i=0; i<activities.size(); i++){
           String temp = activities.get(i);
           activities.remove(i);
           
           for (int j= 0; j<activities.size(); j++){
               if (temp.compareToIgnoreCase(activities.get(j)) <0 && j<activities.size()-1)
               {
                   activities.add(j,temp);
                   
                   break;
               }
               else if(temp.compareToIgnoreCase(activities.get(j)) >0||temp.compareToIgnoreCase(activities.get(j)) == 0)
               {
                   activities.add(j+1,temp);
                   
                   break;
               }
               
           }
       }
   }
           
   
   public void printStudent(){
       System.out.println("\nStudent: " + name+ " Age: " + age+ " Major: " + major+" Grade: " +grade+ "\nActivities: ");
       for(String a: activities)
       {
           System.out.print(a+", ");
       }
   }
}
