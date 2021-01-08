package com.java;
import com.annual.annual;
import com.halfyearly.halfyearly;
import com.quartely.quartely;
import com.student.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    public static void main(String[] args) throws ClassNotFoundException {
        int option;
        Scanner input = new Scanner(System.in);
        ArrayList<student> array = new ArrayList<>();
        do {
            System.out.println("Select the option : \n\t1 for create_student \n\t2 for read_all_student_detail \n\t3 for create_marklist \n\t4 for read_student_mark \n\t5 for exit");
            option = input.nextInt();
            switch (option){
                case 1:
                    student objCStudent = new student();
                    System.out.println("Enter the name");
                    String name = input.next();
                    System.out.println("Enter the " + name + " class");
                    int studentClass = input.nextInt();
                    System.out.println("Enter the " + name + " age");
                    int age = input.nextInt();
                    System.out.println("Enter the " + name + " height");
                    int height = input.nextInt();
                    System.out.println("Enter the " + name + " weight");
                    int weight = input.nextInt();
                    System.out.println("Enter the " + name + " blood group");
                    String bloodGroup = input.next();
                    /*System.out.println("Enter the Quartely tamil mark");
                    int q_Tamil = input.nextInt();
                    System.out.println("Enter the Quartely English mark");
                    int q_English = input.nextInt();
                    System.out.println("Enter the Quartely Maths mark");
                    int q_Maths = input.nextInt();
                    System.out.println("Enter the Quartely Science mark");
                    int q_science = input.nextInt();
                    System.out.println("Enter the Quartely Social mark");
                    int q_Social = input.nextInt();
                    System.out.println("Enter the Halfyearly tamil mark");
                    int h_Tamil = input.nextInt();
                    System.out.println("Enter the Halfyearly English mark");
                    int h_English = input.nextInt();
                    System.out.println("Enter the Halfyearly Maths mark");
                    int h_Maths = input.nextInt();
                    System.out.println("Enter the Halfyearly Science mark");
                    int h_science = input.nextInt();
                    System.out.println("Enter the Halfyearly Social mark");
                    int h_Social = input.nextInt();
                    System.out.println("Enter the Annual tamil mark");
                    int a_Tamil = input.nextInt();
                    System.out.println("Enter the Annual English mark");
                    int a_English = input.nextInt();
                    System.out.println("Enter the Annual Maths mark");
                    int a_Maths = input.nextInt();
                    System.out.println("Enter the Annual Science mark");
                    int a_science = input.nextInt();
                    System.out.println("Enter the Annual Social mark");
                    int a_Social = input.nextInt();*/
                    objCStudent.createStudent(name,studentClass,age,height,weight,bloodGroup);
                    /*quartely mark1 = objCStudent.getQuartely();
                    halfyearly mark2 = objCStudent.getHalfyearly();
                    annual mark3 = objCStudent.getAnnual();
                    mark1.createMark(q_Tamil,q_English,q_Maths,q_science,q_Social);
                    mark2.createMark(h_Tamil,h_English,h_Maths,h_science,h_Social);
                    mark3.createMark(a_Tamil,a_English,a_Maths,a_science,a_Social);*/
                    /*quartelyt mark1 = new quartelyt(q_Tamil,q_English,q_Maths,q_science,q_Social);
                    halfyearlyt mark2 = new halfyearlyt(h_Tamil,h_English,h_Maths,h_science,h_Social);
                    annualt mark3 = new annualt(a_Tamil,a_English,a_Maths,a_science,a_Social);
                    objCStudent.set_objects(mark1, mark2, mark3);
                    array.add(objCStudent);*/
                    break;
                case 2:
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connect = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/student", "pavithran1", "pavithran");
                        //here sonoo is database name, root is username and password
                        statement = connect.createStatement();
                        resultSet = statement.executeQuery("select * from student");
                        if (resultSet.next()){
                            do{
                                int studentId = resultSet.getInt(1);
                                int studentCls = resultSet.getInt(2);
                                String name_student = resultSet.getString(3);
                                int age_student = resultSet.getInt(4);
                                int height_student = resultSet.getInt(5);
                                int weight_student = resultSet.getInt(6);
                                String bloodgroup_student = resultSet.getString(7);
                                System.out.println("studentId : " + studentId + " , studentClass : " + studentCls + " , name : " + name_student + " , age : " + age_student + " , height : " + height_student + " , weight : " + weight_student + " , bloodgroup : " + bloodgroup_student);
                            }while (resultSet.next());
                        }
                        else{
                            System.out.println("there is no data found");
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    exam mark = new exam();
                    int condition = 0;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connect = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/student", "pavithran1", "pavithran");
                        //here sonoo is database name, root is username and password
                        statement = connect.createStatement();
                        System.out.println("Enter the student ID:");
                        do{
                            int studentId = input.nextInt();
                            resultSet = statement.executeQuery("select count(*) from student where Id = " + studentId );
                            while(resultSet.next()) {
                                if (resultSet.getInt(1) == 0) {
                                    System.out.println("This ID (" + studentId +") is Invalid" );
                                    System.out.println("Enter the valid ID");
                                }
                                else{
                                    condition = 1;
                                    int examType;
                                    String examine;
                                    do{
                                        System.out.println("Select the Examination : \n\t1 for Quartely \n\t2 for Halfyearly \n\t3 for Annual \n\t4 for Back");
                                        examType = input.nextInt();
                                        if (examType<4 && examType>0){
                                            if (examType==1){
                                                examine = "Quartely";
                                                System.out.println("Quartely Examination Marklist");
                                            }
                                            else if (examType == 2){
                                                examine = "Halfyearly";
                                                System.out.println("Halfyearly Examination Marklist");
                                            }
                                            else {
                                                examine = "Annual";
                                                System.out.println("Annual Examination Marklist");
                                            }
                                            System.out.println("Enter the Tamil mark");
                                            int tamil = input.nextInt();
                                            System.out.println("Enter the English mark");
                                            int english = input.nextInt();
                                            System.out.println("Enter the Maths mark");
                                            int maths = input.nextInt();
                                            System.out.println("Enter the Science mark");
                                            int science = input.nextInt();
                                            System.out.println("Enter the Social mark");
                                            int social = input.nextInt();
                                            mark.examination(studentId , examine , tamil , english , maths , science , social);
                                        }
                                        else if(examType != 4){
                                            System.out.println("please select the correct option");
                                        }
                                    }while(examType != 4);
                                }
                            }
                        }while (condition != 1);
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    int studentDetail;
                    System.out.println("Enter the student Id");
                    int studentId = input.nextInt();
                    do {
                        System.out.println("Select the option : \n\t1 for student detail \n\t2 for student mark for all exam \n\t3 for student mark for particular exam \n\t4 for Back");
                        studentDetail = input.nextInt();
                        if (studentDetail<4 && studentDetail>0) {
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                connect = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/student", "pavithran1", "pavithran");
                                //here sonoo is database name, root is username and password
                                statement = connect.createStatement();
                                if (studentDetail == 1) {
                                    resultSet = statement.executeQuery("select * from student where id = " + studentId);
                                    while (resultSet.next()) {
                                        int studentCls = resultSet.getInt(2);
                                        String name_student = resultSet.getString(3);
                                        int age_student = resultSet.getInt(4);
                                        int height_student = resultSet.getInt(5);
                                        int weight_student = resultSet.getInt(6);
                                        String bloodgroup_student = resultSet.getString(7);
                                        System.out.println("studentId : " + studentId + " , studentClass : " + studentCls + " , name : " + name_student + " , age : " + age_student + " , height : " + height_student + " , weight : " + weight_student + " , bloodgroup : " + bloodgroup_student);
                                    }
                                }
                                else if (studentDetail == 2) {
                                    resultSet = statement.executeQuery("select * from mark where studentId = " + studentId);
                                    while (resultSet.next()) {
                                        String exam = resultSet.getString(2);
                                        int tamil = resultSet.getInt(3);
                                        int english = resultSet.getInt(4);
                                        int maths = resultSet.getInt(5);
                                        int science = resultSet.getInt(6);
                                        int social = resultSet.getInt(7);
                                        System.out.println("studentId : " + studentId + " , examtype : " + exam + " , tamil : " + tamil + " , english : " + english + " , maths : " + maths + " , science : " + science + " , social : " + social);
                                    }
                                }
                                else {
                                    String examtype;
                                    System.out.println("Select the Examination : \n\t1 for Quartely \n\t2 for Halfyearly \n\t3 for Annual");
                                    do {
                                        int exam = input.nextInt();
                                        if (exam == 1){
                                            examtype = "Quartely";
                                        }
                                        else if (exam == 2){
                                            examtype = "Halfyearly";
                                        }
                                        else if (exam == 3){
                                            examtype = "Annual";
                                        }
                                        else{
                                            examtype = "wrong";
                                            System.out.println("please select the correct option : \n\t1 for Quartely \n\t2 for Halfyearly \n\t3 for Annual");
                                        }
                                    } while (!examtype.equals("Quartely") && !examtype.equals("Halfyearly") && !examtype.equals("Annual"));
                                    resultSet = statement.executeQuery("select * from mark where studentId = '" + studentId + "'and examType = '" + examtype + "'");
                                    if (resultSet.next()){
                                        do  {
                                            int tamil = resultSet.getInt(3);
                                            int english = resultSet.getInt(4);
                                            int maths = resultSet.getInt(5);
                                            int science = resultSet.getInt(6);
                                            int social = resultSet.getInt(7);
                                            System.out.println("studentId : " + studentId + " , examtype : " + examtype + " , tamil : " + tamil + " , english : " + english + " , maths : " + maths + " , science : " + science + " , social : " + social);
                                        }while(resultSet.next());
                                    }
                                    else{
                                        System.out.println("There is no data for Id : " + studentId + " in " + examtype + "");
                                    }

                                }
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                        else if (studentDetail != 4){
                            System.out.println("please select the correct option");
                        }
                    }while(studentDetail != 4);
                    /*for (int i = 0 ; i < array.size() ; i++){
                        System.out.println(array.get(i));
                        student getStudent = array.get(i);
                        quartelyt obj1 = getStudent.getQuartelyt();
                        halfyearlyt obj2 = getStudent.getHalfyearlyt();
                        annualt obj3 = getStudent.getAnnualt();
                        System.out.println(getStudent.readName());
                        System.out.println(getStudent.readStudentClass());
                        System.out.println(getStudent.readAge());
                        System.out.println(getStudent.readHeight());
                        System.out.println(getStudent.readWeight());
                        System.out.println(getStudent.readBloodGroup());
                        System.out.println("MarkList");
                        System.out.println("Quartely");
                        System.out.println(obj1.readTamil());
                        System.out.println(obj1.readEnglish());
                        System.out.println(obj1.readMaths());
                        System.out.println(obj1.readScience());
                        System.out.println(obj1.readSocial());
                        System.out.println("HalfYearly");
                        System.out.println(obj2.readTamil());
                        System.out.println(obj2.readEnglish());
                        System.out.println(obj2.readMaths());
                        System.out.println(obj2.readScience());
                        System.out.println(obj2.readSocial());
                        System.out.println("Annual");
                        System.out.println(obj3.readTamil());
                        System.out.println(obj3.readEnglish());
                        System.out.println(obj3.readMaths());
                        System.out.println(obj3.readScience());
                        System.out.println(obj3.readSocial());
                    }*/
                    break;
                case 5:
                    break;
                default:
                    System.out.println("enter the correct option");
                    break;
            }
        }while(option!=5);
    }
}