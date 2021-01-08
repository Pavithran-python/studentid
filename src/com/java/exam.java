package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class exam {
    int studentId;
    String examType;
    int tamil;
    int english;
    int maths;
    int science;
    int social;
    private static Connection connect = null;
    private static Statement statement = null;
    public void examination(int p_studentId ,String p_examType ,int p_tamil ,int p_english ,int p_maths ,int p_science ,int p_social){
        studentId = p_studentId;
        examType = p_examType;
        tamil = p_tamil;
        english = p_english;
        maths = p_maths;
        science = p_science;
        social = p_social;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student", "pavithran1", "pavithran");
            //here sonoo is database name, root is username and password
            statement = connect.createStatement();
            statement.executeUpdate("insert into mark(studentId,examType,tamil,english,maths,science,social) values('"+studentId+"','"+examType+"','"+tamil+"','"+english+"','"+maths+"','"+science+"','"+social+"')");
        }
        catch (Exception e) {
            System.out.println("wrong");
            System.out.println(e);
        }
    }

}
