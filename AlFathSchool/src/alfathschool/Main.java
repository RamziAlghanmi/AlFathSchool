/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfathschool;

import java.util.Scanner;

/**
 *
 * @author رمزي الغانمي
 */
//public class AlFathSchool {

    /**
     * @param args the command line arguments
     */
   
public class Main {
   static Scanner in =new Scanner (System .in );
   
   static void cleanScreen(){
       System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
               + "\n" );
            
              
   
            }// clean Screen method end
   
   static void choose (){
            System.out.println(" Enter the number 1 to add new students : ");
            System.out.println(" Enter the number 2 to add the degree : ");
            System.out.println(" Enter the number 3 to search : ");
            System.out.println(" Enter the number 4 to change the name and degrees : ");
            System.out.println(" Enter the number 5 reOrder by Average : ");
            System.out.println(" Enter 0 to exit : ");
        }// choose method 
   
   static void printChoose(){
            System.out.println("The name is found \n------------------------------ ");
            System.out.println(" Enter the number 1 print information's the student : ");
            System.out.println(" Enter the number 2 print degrees' the student : ");
            System.out.println(" Enter the number 0 to Exit : ");
   
   
          }//print choose method
   
   static void searchChoose(){
            
            System.out.println(" Enter the number 1 to search by The name : ");
            System.out.println(" Enter the number 2 to seearch by Class: ");
            //System.out.println(" Enter the number 0 to Exit : ");
   
   
          }//print choose method
   
   static Class [] addClass(Class[] ClassInformation){
       int number_courses;
       for (int i = 0; i < ClassInformation.length; i++) {
           ClassInformation[i]=new Class();
            System.out.println(" Enter name the Debartment : "+(i+1));
               ClassInformation[i].nameClass=in.next();
                 cleanScreen();
            System.out.println(" How many courses in the Debartment "+ClassInformation[i].nameClass+" ?");
                number_courses=in.nextInt();
                    cleanScreen();
              ClassInformation[i].subject=new String[number_courses];
            System.out.println(" There are [ "+number_courses+" ] Courses :\n"
                     + "  Please ! \n    Enter the names for all them :");
               for (int j = 0;  j < number_courses; j++) {
                      ClassInformation[i].subject[j]=in.next();
                 }
               
               cleanScreen();
            System.out.println(" \nThe Debartment "
                    + ""+ClassInformation[i].nameClass+""
                    + " have been adding successfully! "
                    + "\n---------------------------------------------------");    
         }
       return ClassInformation;
    }// ent add Class method
   
   static Class [] addStudent(Class classInformation[],int indexClass){
     
    
        int numberStudents;
       
                     System.out.println(" How many students in this Debartment ?");
                     numberStudents=in.nextInt(); 
                        cleanScreen();
                   classInformation[indexClass].students=new Student[numberStudents];
                  // Student studentInformation[]=new Student[numberStudents];
     
                     for (int j = 0; j < numberStudents; j++) {
                         classInformation[indexClass].students[j]=new Student();
                        //studentInformation[j]=new Student();
                     System.out.println(" Enter name the student : "+(j+1));
                        classInformation[indexClass].students[j].nameStudent=in.next();
                            cleanScreen();
                      System.out.println(" Enter address the student : "+(j+1));
                        classInformation[indexClass].students[j].address=in.next();
                            cleanScreen();
                            System.out.println(" Enter academic number the student : "+(j+1));
                        classInformation[indexClass].students[j].academicNumber=in.next();
                            cleanScreen();
                            int numberSubject=classInformation[indexClass].subject.length;
                        classInformation[indexClass].students[j].degree=new int[numberSubject];
                        for (int i = 0; i <classInformation[indexClass].subject.length ; i++) {
                             classInformation[indexClass].students[j].degree[i]=0;
                         }
 
                        classInformation[indexClass].students[j].theClass=classInformation[indexClass].nameClass;
                            cleanScreen();
                    System.out.println(" \nThe student "
                    + ""+classInformation[indexClass].students[j].nameStudent+""
                    + " have been adding successfully! "
                    + "\n---------------------------------------------------\n\n");    
                         
                     }
                 
                
                return classInformation;
        
            }// end addStudent method
   
   static int searchByName(Class [] searchInformation, int indexName){  
       int index=-1;
     
            String name=in.next(); 
                cleanScreen();
      int size=searchInformation[indexName].students.length;
       // for (int i = 0; i < searchInformation.length; i++) 
            for (int j = 0; j <size ; j++) {
                if(searchInformation[indexName].students[j].nameStudent.equalsIgnoreCase(name)){
                 index=j;
                 break;
                }
            }
        return index;
                
      }// searchByName method
   
   static int  searchByClass(Class [] classInforma,int indexClass){  
    
     String Class =in.next();
       cleanScreen();
       for (int i = 0; i <classInforma.length; i++) 
          if(classInforma[i].nameClass.equalsIgnoreCase(Class)) {
              indexClass=i;
        break;
          }
       
         return indexClass;
       }//search by clasws method
   
   static Class[] addDegree(Class [] degreeInformation,int indexName,int indexClass){
     int size;
       String Class,name;
  
               size=degreeInformation[indexClass].subject.length;
               degreeInformation[indexClass].students[indexName].sum=0;
                       
                 degreeInformation[indexClass].students[indexName].degree=new int[size] ;
              
               for (int t = 0; t < size; t++) {
                       System.out.println(" The degree for "+degreeInformation[indexClass].subject[t]+" = ");
                        degreeInformation[indexClass].students[indexName].degree[t]=in.nextInt();
                            cleanScreen();
                        if(degreeInformation[indexClass].students[indexName].degree[t]>=0&&degreeInformation[indexClass].students[indexName].degree[t]<=100)
                        degreeInformation[indexClass].students[indexName].sum+=degreeInformation[indexClass].students[indexName].degree[t];
                        else{
                            System.out.println(" Sorry:\n The Degree have to between[ 0_100 ]\n"
                                    + "Pleas : Enter a true degree :\n----------------------------- ");
                            t--;
                        }
                      }
                            degreeInformation[indexClass].students[indexName].average= degreeInformation[indexClass].students[indexName].sum/size;
                           
                 
             return degreeInformation;
        }// end add degree method
   
   static void printByName(Class name[],int index,int ind){
  
               System.out.println(" name the student:"+name[ind].students[index].nameStudent);
                System.out.println("class the student:"+name[ind].students[index].theClass);
               System.out.println(" Address the student:"+name[ind].students[index].address);
               System.out.println(" Academic Number the student:"+name[ind].students[index].academicNumber+"\n"
                       + "=================================================================\n\n");
                
     
    
         
          }// student print method
   
   static void printDegree(Class name[],int index,int ind){
     System.out.println("---------------------------------------------------"
             + "\n name the student:"+name[ind].students[index].nameStudent);
       System.out.println("____________________________________________________\n"
               + "    The Subject    |    The Degree            \n"
                        + "____________________________________________________");   
      for (int i = 0; i < name[ind].subject.length; i++) {
                    System.out.println("    "+ name[ind].subject[i]+"     |     "+name[ind].students[index].degree[i]+"  \n"
                        + "----------------------------------------------------");
                }
      System.out.print(" The Sum = "+ name[ind].students[index].sum);
      System.out.println("       The Average = "+ name[ind].students[index].average);
     
      System.out.println(" \n\n");
    }// print degree method 
  
   static void printByClass(Class[] ClassData,int index){
       // for (int i = 0; i <ClassData.length; i++) {
              System.out.println("\n\n\n"
                      + "_____________________________________________________\n"
                      + " name the class:"+ClassData[index].nameClass+"\n"
                      + "___________________________________________________\n"
                      + "");
              for (int j = 0; j < ClassData[index].students.length; j++) {
               
               System.out.println(" name the student:"+ClassData[index].students[j].nameStudent);
                System.out.println("          The Average :"+ClassData[index].students[j].average+"\n"
                       + "============================================================\n");
                  
              }
        
         
              
          }// student print method
   
   static Class [] change ( Class[] change, int indexName, int indexClass){
      int size=change[indexClass].subject.length;
       System.out.println(" Enter The new name : ");
        String newName=in.next();
               change[indexClass].students[indexName].nameStudent=newName;
         System.out.println(" The name has been changing successfully!\n"
                 + "---------------------------------------------------\n\n");

        addDegree(change, indexName, indexClass);
          System.out.println(" The degrees have been changing successfully!\n"
                  + "------------------------------------------\n\n");

                          
          return change;
   }// chang method 
   
   static Class [] reOrder (Class [] order,int indexClass){
      Student tt=new Student ();
       for (int i = 0; i <order[indexClass].students.length; i++) {
           for (int j = i+1; j <order[indexClass].students.length; j++) {
             if(order[indexClass].students[i].average<order[indexClass].students[j].average){
              tt=order[indexClass].students[i];
             order[indexClass].students[i]=order[indexClass].students[j];
               order[indexClass].students[j]=tt;
             }  
           }
 
       }
       System.out.println(" The reOrder Done\n"
               + "----------------------------------------\n\n ");
   return order;
       }// reOrder method 
   
   public static void main(String[] args) {
        System.out.println(" How many Debartment in your college ? ");
                
            int number_Classes=in.nextInt();
                cleanScreen();
            Class ClassInformation[]=new Class[number_Classes];
           //  Class ClassInform=new Class();
          //  Student studentInformation=new Student();
            Class[] addClass = addClass(ClassInformation);
           String choose = null, printChoose,searchChoose;
          int indexName,indexClass;

         ;
  //int indexName=-1;
    do{ 
      try{
       indexName=-1;
       indexClass=-1;
        choose();
     choose =in.next();
       cleanScreen();
         
        switch(choose){
               case "1":
                    System.out.println(" Enter the Debartment"
                    + " that you want to add New Students for it ");
             indexClass=searchByClass(ClassInformation,indexClass);
               cleanScreen();
             if(indexClass!=-1){
                     Class[] addStudent = addStudent(ClassInformation,indexClass);
                  
                    }else 
                         System.out.println("Sorry:\n    The class is not found!\n"
                                 + "---------------------------------------\n");
                        
                     break;
                   
               case "2":
                  
                    System.out.println(" Enter the Debartmenty "
                      + "that you want to add thge degree  for it's Students : ");
                        indexClass =searchByClass(ClassInformation, indexClass);
                        if(indexClass!=-1){
                           if(ClassInformation[indexClass].students!=null){
                             System.out.println(" Enter the name that you want to add the degree for him :");
                              indexName=searchByName(ClassInformation,indexClass);
                              if(indexName!=-1){
                                Class[] degreeInformation= addDegree(ClassInformation,indexName,indexClass);
                                System.out.println(" \nThe degree  have been adding successfully for the student :   "
                                     + ""+degreeInformation[indexClass].students[indexName].nameStudent+""
                                     + ""
                                     + "\n---------------------------------------------------\n\n");    
                              
                              } else
                                  System.out.println("Sorry:\n   The name is not found!\n"
                                      + "------------------------------------\n");
                           }else 
                                System.out.println(" There isn't any name in this deparetment\n"
                                        + "-------------------------------------------------\n\n");
                           }else 
                         System.out.println("Sorry:\n    The class is not found!\n"
                                 + "---------------------------------------\n");
                       
                  break;
                  
            case "3":
                    searchChoose();
                       searchChoose=in.next();
                         switch(searchChoose){
                             
                             case "1":
                                        System.out.println(" Enter the class that you want to reseach : ");
                                             indexClass=searchByClass(ClassInformation,indexClass);
                                            if( indexClass!=-1){
                                           if(ClassInformation[indexClass].students!=null){
                         
                                                 System.out.println(" Enter the name that you want to reseach : ");
                                               indexName =searchByName(ClassInformation,indexClass);
                                             if(indexName!=-1){
                                                 do{
                                                 printChoose();  
                                                   printChoose = in.next();
                                                    cleanScreen();
                                                switch(printChoose){
                                                    case "1":
                                                     printByName(ClassInformation,indexName, indexClass);
                                                    break;
                                                    case "2":
                                                          printDegree(ClassInformation,indexName, indexClass);
                                                      break;
                                                    case "0":
                                                        break;
                                                    default:
                                                        System.out.println("Pleas: \n   Enter a true operation \n"
                                                                                    + "----------------------------------------------");
                                                        }//print choose switch 
                                                 }while (!printChoose.equalsIgnoreCase("0"));
                                                 } else
                                                     System.out.println("Sorry:\n    The name is not found!\n"
                                                             + "------------------------------------\n");
                                              }else 
                                                    System.out.println(" There isn't any name in this deparetment\n"
                                                      + "-------------------------------------------------\n\n");
                       
                                            } else 
                                                 System.out.println("Sorry:\n    The class is not found!"
                                                         + "\n---------------------------------------\n");

                                         break;
                            case "2":
                                
                                            System.out.println(" Enter the class that you want to reseach : ");
                                             indexClass=searchByClass(ClassInformation,indexClass);
                                           if(indexClass!=-1){
                                            if(ClassInformation[indexClass].students!=null){
                                              printByClass(ClassInformation, indexClass);
                                             }else 
                                                 System.out.println(" There isn't any name in this deparetment\n"
                                                      + "-------------------------------------------------\n\n");
                       
                                           }else 
                                                System.out.println(" The name is not found!");
                                           break;
                             }// switch search choose
                        break;
              case "4":
                  System.out.println(" Enter the class that you want to change it's data : ");
                        indexClass=searchByClass(ClassInformation,indexClass);
                       if( indexClass!=-1){
                             if(ClassInformation[indexClass].students!=null){
                         

                        System.out.println(" Enter the name that you want to change it's degrees : ");
                               
                             indexName=searchByName(ClassInformation, indexClass);
                            if( indexClass!=-1){
                            change(addClass,indexName,indexClass);
                            }else
                               System.out.println(" The name is not found!\n"
                                       + "----------------------------------\n");
                        }else 
                            System.out.println(" There isn't any name in this deparetment\n"
                                 + "-------------------------------------------------\n\n");

                       }else 
                        System.out.println(" The class is not found!\n"
                                + "------------------------------------\n");
   
                    break;
                    
            case "5":
                  System.out.println(" Enter the class that you want to change it's data : ");
                        indexClass=searchByClass(ClassInformation,indexClass);
                       if( indexClass!=-1){
                         if(ClassInformation[indexClass].students!=null){
                         

                       
                           reOrder(addClass,indexClass);
                   
                      }else 
                            System.out.println(" There isn't any name in this deparetment\n"
                                 + "-------------------------------------------------\n\n");

                       }else 
                        System.out.println(" The class is not found!\n"
                                + "------------------------------------\n");
     
                    break;    
                          
            case "0": 
                    System.out.println("       God_Bye       ");
                 break;
              
            default:
                   System.out.println(" Pleas:   Enter a true operation : \n"
                           + "------------------------------------------------\n");
                   break;
        }// switch choose  
      }catch(Exception e){
          System.out.println(" An error input! \n--------------------------\n");
      }
   }while(!choose.equalsIgnoreCase("0"));
          
           
    }
    
}
