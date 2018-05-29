package mysqlConnect.dbhelper;

import mysqlConnect.dababasesClass.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UseStudent {
    // 数据库连接对象，注意：是导入“java.sql.Connection”此包下的连接对象。
    private static Connection conn = null;
    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;
    //结果集
    private static ResultSet rs = null;

    public  ArrayList getStudent(){
        ArrayList students;
        students = new ArrayList<Student>();
        try{
            conn = DBHelper.getConnection();
            pst = conn.prepareStatement("select * from student");
            rs = pst.executeQuery();

            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setClass_id(rs.getString(3));
                student.setBirthDay(rs.getString(4));
                //此处在补全了数据库的内容之后，应该加入性别和年龄，具体看怎么修改

                students.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
           closeSourse();
        }
        return students;
    }
    public  Student getStudentById(String id){

        Student student = new Student();

        try{
            conn = DBHelper.getConnection();
            pst = conn.prepareStatement("select * from student where id = '"+ id+"'");
            rs = pst.executeQuery();
            if(rs!=null){
                rs.next();
                student.setId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setClass_id(rs.getString(3));
                student.setBirthDay(rs.getString(4));
                Calendar now = Calendar.getInstance();
                //此处需要解析字符串修改年龄，此处仅仅 获取当前日期
                student.setAge(""+now.get(Calendar.YEAR));
                //完善数据库之后添加性别
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            closeSourse();
        }
        return student;
    }
    private void closeSourse(){
        try {
            if(rs!=null)
                rs.close();
            if(pst!=null)
                pst.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
