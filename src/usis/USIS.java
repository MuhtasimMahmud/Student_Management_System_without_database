package usis;

import java.util.ArrayList;
import java.util.Scanner;

import users.*;
import sections.*;

public class USIS {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> student_list = new ArrayList<>();
        ArrayList<Enrolled_Students> enrolled_students_list = new ArrayList<>();

        int logout = 0;

        while(true){

            if(logout == 0){
                System.out.println("1. Register as a student");
                System.out.println("2. Login as a student");
                System.out.println("3. Login as a faculty");
                System.out.println("Please choose one option");
            }

            if(logout == 1){
                System.out.println("4. Log out");
                System.out.println("Press 4 to logout.");
            }



            int choose_option = sc.nextInt();

            if(choose_option == 1){
                //logut => 0
                //Register as a student

                System.out.print("Name : ");
                String name = sc.next();

                System.out.print("Student ID : ");
                String id = sc.next();

                System.out.print("Email : ");
                String email = sc.next();

                System.out.print("Password : ");
                String password = sc.next();

                Student student = new Student(name, id, email, password);
                student_list.add(student);

                System.out.println("\n\n");

                logout = 0;

            }
            else if(choose_option == 2){
                // logout => 1
                // Login as a student

                System.out.print("Email : ");
                String given_email = sc.next();

                System.out.print("Password : ");
                String given_password = sc.next();

                int access = 0;
                String name = "";
                String id = "";

                for(int i=0; i<student_list.size(); i++){
                    Student s = student_list.get(i);

                    if(s.getEmail().equals(given_email) && s.getPassword().equals(given_password)){
                        name = s.getName();
                        id = s.getId();
                        access = 1;
                        break;
                    }
                }

                if(access == 1){
                    //logout => 1
                    System.out.println("1. Section-01   Sunday: 12:30 pm 1:00 pm  " + Section01.getSeats());
                    System.out.println("2. Section-02   Sunday: 2:30  pm 4:00 pm  " + Section02.getSeats());
                    System.out.print("Choose one : ");

                    int choosen_section = sc.nextInt();

                    if(choosen_section == 1){
                        Section01.setSeats(Section01.getSeats() - 1);
                        Enrolled_Students enrolled_student = new Enrolled_Students(name, id, 01);
                        enrolled_students_list.add(enrolled_student);
                    }
                    else if(choosen_section == 2){
                        Section02.setSeats(Section02.getSeats() - 1);
                        Enrolled_Students enrolled_student = new Enrolled_Students(name, id, 02);
                        enrolled_students_list.add(enrolled_student);
                    }
                    else{
                        System.out.println("Please give a valid section number.");
                    }

                    logout = 1;
                }
                else{
                    System.out.println("This email is not registered or the credentials is not right.");
                    logout = 0;
                    continue;
                }
            }
            else if(choose_option == 3){
                //logout => 1
                // login as a faculty

                System.out.print("Faculty Name : ");
                String faculty_name = sc.next();

                System.out.print("Faculty password : ");
                String faculty_password = sc.next();



                if(faculty_name.equals(Faculty.getName()) && faculty_password.equals(Faculty.getPassword())){


                    while (true){
                        System.out.println("1. Section-01   Sunday: 12:30 pm 1:00 pm  " + Section01.getSeats());
                        System.out.println("2. Section-02   Sunday: 2:30  pm 4:00 pm  " + Section02.getSeats());
                        System.out.print("Choose one : ");

                        int choose_section = sc.nextInt();

                        System.out.println("Name          "+ "         SID ");

                        if(choose_section == 1){

                            for(int i=0; i<enrolled_students_list.size(); i++){
                                Enrolled_Students enrolled_student = enrolled_students_list.get(i);
                                if( enrolled_student.getSection() == 1 ){
                                    System.out.println(enrolled_student.getName() + "            "+ enrolled_student.getId());
                                }
                            }
                        }
                        else if(choose_section == 2){

                            for(int i=0; i<enrolled_students_list.size(); i++){
                                Enrolled_Students enrolled_student = enrolled_students_list.get(i);
                                if( enrolled_student.getSection() == 2 ){
                                    System.out.println(enrolled_student.getName() + "          " + enrolled_student.getId());
                                }
                            }
                        }

                        System.out.println("want to choose another section?");
                        System.out.println("1. Yes          2. NO");
                        int option = sc.nextInt();
                        if(option == 1){
                            continue;
                        }
                        else if(option == 2){
                            break;
                        }
                    }

                    logout = 1;
                }
                else{
                    System.out.println("Please give me a valid faculty name and password.");
                    logout = 0;
                }
            }
            else if(choose_option == 4){
                //logout => 0
                logout = 0;
                continue;
            }
            else
                System.out.println("PLease choose a valid option");



        }

    }
}
