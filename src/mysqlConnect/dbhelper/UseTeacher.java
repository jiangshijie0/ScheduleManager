package mysqlConnect.dbhelper;

import mysqlConnect.dababasesClass.Student;
import mysqlConnect.dababasesClass.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UseTeacher {
        // 数据库连接对象，注意：是导入“java.sql.Connection”此包下的连接对象。
        private static Connection conn = null;
        // PreparedStatement对象用来执行SQL语句
        private static PreparedStatement pst = null;
        //结果集
        private static ResultSet rs = null;

        public ArrayList<Teacher> getTeacher(){
            ArrayList<Teacher> teachers;
            teachers = new ArrayList<>();
            try{
                conn = DBHelper.getConnection();
                pst = conn.prepareStatement("select * from teachers");
                rs = pst.executeQuery();

                while(rs.next()){
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getString(1));
                    teacher.setName(rs.getString(2));
                    teacher.setSalary(Double.parseDouble(rs.getString(3)));
                    //此处在补全了数据库的内容之后，应该加入性别，具体看怎么修改
                    teachers.add(teacher);
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //关闭资源
               closeSourse();
            }
            return teachers;
        }
    public  Teacher getTeacherById(String id){

        Teacher teacher = new Teacher();

        try{
            conn = DBHelper.getConnection();
            String sql = "select * from teachers where id = '"+id+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs!=null){
                rs.next();
                teacher.setId(rs.getString(1));
                teacher.setName(rs.getString(2));
                teacher.setSalary(Double.parseDouble(rs.getString(3)));
                //补全数据库之后添加性别
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            closeSourse();
        }
        return teacher;
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



    public static void main(String[] args) {
        UseTeacher useTeacher = new UseTeacher();

    }
    }


