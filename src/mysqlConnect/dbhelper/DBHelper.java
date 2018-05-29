package mysqlConnect.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    private static final String driver = "com.mysql.jdbc.Driver";

    /**
     * 如下是连接数据库的URL地址，
     * 其中，"jdbc:mysql://"   为固定写法
     * "localhost"是连接本机数据库时的写法，当不是连接本机数据库时，要写数据库所在计算机的IP地址。如：172.26.132.253
     * "fl"是数据库的名称，一定要根据自己的数据库更改。
     * "?useUnicode=true&characterEncoding=UTF-8" 指定编码格式，无需时可省略，
     * 即地址直接为："jdbc:mysql://localhost:3306/shopping"
     */
    private static final String url = "jdbc:mysql://localhost:3306/managerCourse?useUnicode=true&characterEncoding=UTF-8";
    private static final String username = "root";
    private static final String password = "fL13419908936,./";

    private static Connection conn = null;
    //静态代码负责加载驱动
    static {
        try {
            Class.forName(driver);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    //连接数据库函数
    public static Connection getConnection()throws Exception{
        if (conn==null)
        {
            conn = DriverManager.getConnection(url,username,password);
            return conn;
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection connection = DBHelper.getConnection();
            if(connection!=null)
            {
                System.out.println("数据库连接正常");
            }else{
                System.out.println("数据库连接失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
