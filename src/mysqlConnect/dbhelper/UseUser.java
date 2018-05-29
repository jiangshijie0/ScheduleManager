package mysqlConnect.dbhelper;

import mysqlConnect.dababasesClass.User;
import mysqlConnect.dababasesClass.cals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseUser {
    // 数据库连接对象，注意：是导入“java.sql.Connection”此包下的连接对象。
    private static Connection conn = null;
    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;
    //结果集
    private static ResultSet rs = null;

    public User getUserById(String id){

        User user = new User();

        try{
            conn = DBHelper.getConnection();
            pst = conn.prepareStatement("select * from users where id = '"+id+"'");
            rs = pst.executeQuery();
            if(rs!=null){
                rs.next();
                user.setId(rs.getString(1));
                user.setPasswwd(rs.getString(2));
                user.setFlag(rs.getString(3));
                //补全数据库之后添加性别
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                if(rs!=null)
                    rs.close();
                if(pst!=null)
                    pst.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return user;
    }

}
