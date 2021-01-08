package com.student;
import com.java.annualt;
import com.java.halfyearlyt;
import com.java.quartelyt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.lang.Class.forName;

public class student {
    String name;
    int studentClass;
    int age;
    int height;
    int weight;
    String bloodGroup;
    /*quartelyt mark_quartely;
    halfyearlyt mark_halfyearly;
    annualt mark_annual;*/
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    public void createStudent(String p_name,int p_class,int p_age,int p_height,int p_weight,String p_bloodgroup) throws ClassNotFoundException {
        name = p_name;
        studentClass = p_class;
        age = p_age;
        height = p_height;
        weight = p_weight;
        bloodGroup = p_bloodgroup;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student", "pavithran1", "pavithran");
            //here sonoo is database name, root is username and password
            statement = connect.createStatement();
            statement.executeUpdate("insert into student(studentClass,name,age,height,weight,bloodgroup) values('"+studentClass+"','"+name+"','"+age+"','"+height+"','"+weight+"','"+bloodGroup+"')");
            resultSet = statement.executeQuery("SELECT * FROM student ORDER BY ID DESC LIMIT 1" );
            while(resultSet.next()){
                System.out.println(name + " ID number is " +resultSet.getInt(1));
                }
        }
        catch (Exception e) {
            System.out.println("wrong");
            System.out.println(e);
        }
    }
    /*public void set_objects(quartelyt a, halfyearlyt b, annualt c){
        this.mark_quartely = a;
        this.mark_halfyearly = b;
        this.mark_annual = c;
    }
    public quartelyt getQuartelyt(){
        return mark_quartely;
    }
    public halfyearlyt getHalfyearlyt(){
        return mark_halfyearly;
    }
    public annualt getAnnualt(){
        return mark_annual;
    }
    public String readName() {
        return name;
    }
    public int readStudentClass() {
        return studentClass;
    }
    public int readAge(){
        return age;
    }
    public int readHeight(){
        return height;
    }
    public int readWeight(){
        return weight;
    }
    public String readBloodGroup(){
        return bloodGroup;
    }*/
}
/* public class student {
    String name;
    int age;
    int height;
    int weight;
    quartely mark_quartely;
    halfyearly mark_halfyearly;
    annual mark_annual;
    String bloodGroup;
    public void createStudent(String p_name,int p_age,int p_height,int p_weight,String p_bloodgroup){
        name = p_name;
        age = p_age;
        height = p_height;
        weight = p_weight;
        bloodGroup = p_bloodgroup;
        mark_quartely = new quartely();
        mark_halfyearly = new halfyearly();
        mark_annual = new annual();
    }
    public quartely getQuartely(){
        return mark_quartely;
    }
    public halfyearly getHalfyearly(){
        return mark_halfyearly;
    }
    public annual getAnnual(){
        return mark_annual;
    }
    public String readName() {
        return name;
    }
    public int readAge(){
        return age;
    }
    public int readHeight(){
        return height;
    }
    public int readWeight(){
        return weight;
    }
    public String readBloodGroup(){
        return bloodGroup;
    }
}

 */