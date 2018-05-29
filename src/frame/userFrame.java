package frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import managerFrame.findMessageFrame.*;

public class userFrame extends JFrame {

    private static int FRAME_WIDTH = 800;
    private static int FRAME_HEIGHT = 600;

    private JButton personMessage;
    private JButton course;

    private JPanel personalPanel;
    private courseTable coursePanel;


    public userFrame(String name, String userName) {
        setTitle(name);
        setLayout(null);
        setResizable(false);
        setBounds(50, 50, FRAME_WIDTH, FRAME_HEIGHT);

        System.out.println(name+" "+userName);
        initFrame(name, userName);

        add(personMessage);
        add(course);
        add(personalPanel);
        add(coursePanel);

        personMessage.setBounds(260, 20, 120, 40);
        course.setBounds(410, 20, 120, 40);

        personMessage.setFont(LogIn.font);
        course.setFont(LogIn.font);

        coursePanel.setBounds(0, 100, 800, 500);
        personalPanel.setBounds(0, 100, 800, 500);

        personalPanel.setVisible(false);
        coursePanel.setVisible(true);

        personMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coursePanel.setVisible(false);
                personalPanel.setVisible(true);
            }
        });

        course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coursePanel.setVisible(true);
                personalPanel.setVisible(false);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initFrame(String name, String userName) {
        personMessage = new JButton("个人信息");
        course = new JButton("课程信息");
        coursePanel = new courseTable(800, 400);
        if (name == "教师")
            personalPanel = new teacherPersonalMessage(800, 400, userName);
        else if (name == "学生")
            personalPanel = new studentPersonalMessage(800, 400, userName);
    }

    public static void main(String[] args) {
        userFrame userFrame = new userFrame("教师", "20000001");
        userFrame.setVisible(true);
    }
}
