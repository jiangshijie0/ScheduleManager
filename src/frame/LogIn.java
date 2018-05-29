//登录界面


package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import managerFrame.managerMainFrame.ManagerMainFrame;
import mysqlConnect.dababasesClass.User;
import mysqlConnect.dbhelper.UseUser;

public class LogIn extends JFrame {
    public static Font font = new Font("宋体", 20, 20);

    private static int FRAME_WIDTH = 400;
    private static int FRAME_HEIGHT = 300;

    private JTextField userName;
    private JTextField passWord;

    private JLabel username;
    private JLabel password;

    private JButton signUp;
    private JButton logIn;




    public LogIn(String frameName) {

        setLayout(null);
        setBounds(50, 100, FRAME_WIDTH, FRAME_HEIGHT);
        setTitle(frameName);

        initLogIn();

        setResizable(false);

        add(username);
        add(userName);
        add(password);
        add(passWord);

        add(signUp);
        add(logIn);



        username.setBounds(40, 20, 60, 60);
        userName.setBounds(110, 35, 220, 30);
        password.setBounds(40, 80, 60, 60);
        passWord.setBounds(110, 95, 220, 30);
        signUp.setBounds(60, 170, 80, 40);
        logIn.setBounds(260, 170, 80, 40);


        username.setFont(font);
        userName.setFont(font);
        password.setFont(font);
        passWord.setFont(font);
        signUp.setFont(font);
        logIn.setFont(font);

        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加注册响应事件
            }
        });

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加登录响应事件

                String username = userName.getText();
                String userpassword = passWord.getText();
                System.out.println(username+" "+userpassword+"\n");

                UseUser useUser = new UseUser();
                User user = useUser.getUserById(username);

                System.out.println(user.getId()+" "+user.getPasswwd()+" "+user.getFlag());

                if (user.getPasswwd() .equals(userpassword) ) {
                    if ( user.getFlag().equals("t")) {
                        userFrame userFrame = new userFrame("教师", username);
                        userFrame.setVisible(true);
                        System.out.println("12");
                    } else if (user.getFlag() .equals("s")) {
                        userFrame userFrame = new userFrame("学生", username);
                        userFrame.setVisible(true);
                    } else if (user.getFlag() .equals("m")) {
                        ManagerMainFrame managerMainFrame = new ManagerMainFrame("管理员");
                        managerMainFrame.setVisible(true);
                    }else {

                    }
                } else {

                }

                setVisible(false);


            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initLogIn() {
        signUp = new JButton("注册");
        logIn = new JButton("登录");
        userName = new JTextField();
        passWord = new JTextField();
        username = new JLabel("账户:");
        password = new JLabel("密码:");
    }


}
