package managerFrame.managerMainFrame;

import frame.LogIn;
import managerFrame.findMessageFrame.classPersonalMessage;
import managerFrame.findMessageFrame.courseTable;
import managerFrame.findMessageFrame.studentPersonalMessage;
import managerFrame.findMessageFrame.teacherPersonalMessage;
import mysqlConnect.dababasesClass.Student;
import mysqlConnect.dababasesClass.Teacher;
import mysqlConnect.dbhelper.UseClass;
import mysqlConnect.dbhelper.UseStudent;
import mysqlConnect.dbhelper.UseTeacher;
import mysqlConnect.dababasesClass.cals;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ManagerFrameFindMessage extends JPanel {

    private int width;
    private int height;
    private JComboBox choice1;
    private JComboBox choice2;
    private JComboBox choice3;
    private JButton sure;
    private JPanel panelTeacherMessage;
    private JPanel panelStudentMessage;
    private JPanel panelClassMessage;
    private JPanel panelCourseTable;
    private JButton editable;
    private JButton editablesure;

    public ManagerFrameFindMessage(int w, int h) {

        width = w;
        height = h;
        setLayout(null);
        initFrame();

        JLabel label1 = new JLabel("请选择：");
        add(label1);
        label1.setFont(LogIn.font);
        label1.setBounds(20, 10, 80, 40);
        JLabel label2 = new JLabel("请选择：");
        add(label2);
        label2.setFont(LogIn.font);
        label2.setBounds(220, 10, 80, 40);
        JLabel label3 = new JLabel("请选择：");
        add(label3);
        label3.setFont(LogIn.font);
        label3.setBounds(450, 10, 80, 40);


        add(choice1);
        add(choice2);
        add(choice3);
        add(sure);
        add(panelTeacherMessage);
        add(panelStudentMessage);
        add(panelClassMessage);
        add(panelCourseTable);
        add(editable);
        add(editablesure);

        choice1.setFont(LogIn.font);
        choice2.setFont(LogIn.font);
        choice3.setFont(LogIn.font);
        sure.setFont(LogIn.font);
        editable.setFont(LogIn.font);
        editablesure.setFont(LogIn.font);

        choice1.setBounds(100, 10, 80, 40);
        choice2.setBounds(300, 10, 120, 40);
        choice3.setBounds(520, 10, 120, 40);
        sure.setBounds(680, 10, 100, 40);
        editablesure.setBounds(120, height - 120, 120, 40);
        editable.setBounds(500, height - 120, 120, 40);

        panelTeacherMessage.setBounds(0, 50, width, height - 200);
        panelTeacherMessage.setVisible(true);

        panelStudentMessage.setBounds(0, 50, width, height - 200);
        panelStudentMessage.setVisible(false);

        panelClassMessage.setBounds(0, 50, width, height - 200);
        panelClassMessage.setVisible(false);

        panelCourseTable.setBounds(0, 50, width, height - 200);
        panelCourseTable.setVisible(false);

    }

    private void initFrame() {
        choice1             = new JComboBox();
        choice2             = new JComboBox();
        choice3             = new JComboBox();
        sure                = new JButton("查询");
        editable            = new JButton("编辑");
        editablesure        = new JButton("确认保存");
        panelTeacherMessage = new teacherPersonalMessage(width, height - 80,"20000001");
        panelStudentMessage = new studentPersonalMessage(width, height - 80);
        panelClassMessage   = new classPersonalMessage(width, height - 80);
        panelCourseTable    = new courseTable(width, height - 80);

        initialComBox1();//初始化choice1
        initialComBox2("教师");
        initialComBox3("教师");

        //选择框1的切换事件
        choice1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                initialComBox2((String) choice1.getSelectedItem());
                initialComBox3((String) choice1.getSelectedItem());
            }
        });
        //选择框2的切换事件
        choice2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        choice3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            }
        });

        //点击确定按钮的事件
        sure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((String) choice1.getSelectedItem()) == "学生") {
                    if (((String) choice2.getSelectedItem()) == "学生信息") {
                        panelStudentMessage.setVisible(true);
                        panelTeacherMessage.setVisible(false);
                        panelClassMessage.setVisible(false);
                        panelCourseTable.setVisible(false);
                        ((studentPersonalMessage)panelStudentMessage).setMessage(((String) choice3.getSelectedItem()));

                    } else if (((String) choice2.getSelectedItem()) == "学生课表") {
                        panelStudentMessage.setVisible(false);
                        panelTeacherMessage.setVisible(false);
                        panelClassMessage.setVisible(false);
                        panelCourseTable.setVisible(true);
                    }
                } else if (((String) choice1.getSelectedItem()) == "教师") {
                    if (((String) choice2.getSelectedItem()) == "教师信息") {
                        panelStudentMessage.setVisible(false);
                        panelTeacherMessage.setVisible(true);
                        panelClassMessage.setVisible(false);
                        panelCourseTable.setVisible(false);
                        ((teacherPersonalMessage)panelTeacherMessage).setMessage(((String) choice3.getSelectedItem()));
                    }else if (((String) choice2.getSelectedItem()) == "教师课表") {
                        panelStudentMessage.setVisible(false);
                        panelTeacherMessage.setVisible(false);
                        panelClassMessage.setVisible(false);
                        panelCourseTable.setVisible(true);
                    }
                } else if (((String) choice1.getSelectedItem()) == "班级") {
                    if (((String) choice2.getSelectedItem()) == "班级信息") {
                        panelStudentMessage.setVisible(false);
                        panelTeacherMessage.setVisible(false);
                        panelClassMessage.setVisible(true);
                        panelCourseTable.setVisible(false);
                        ((classPersonalMessage)panelClassMessage).setMessage(((String) choice3.getSelectedItem()));

                    }
                    else if  (((String) choice2.getSelectedItem()) == "班级课表") {
                        panelStudentMessage.setVisible(false);
                        panelTeacherMessage.setVisible(false);
                        panelClassMessage.setVisible(false);
                        panelCourseTable.setVisible(true);
                    }
                }
            }
        });
        //修改信息的按钮事件
        editable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((String) choice1.getSelectedItem()) == "学生") {
                    if (((String) choice2.getSelectedItem()) == "学生信息") {
                        ((studentPersonalMessage) panelStudentMessage).setEditable(true);
                    }
                } else if (((String) choice1.getSelectedItem()) == "教师") {
                    if (((String) choice2.getSelectedItem()) == "教师信息") {
                        ((teacherPersonalMessage) panelTeacherMessage).setEditable(true);
                    }
                }
            }
        });
        editablesure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((String) choice1.getSelectedItem()) == "学生") {
                    if (((String) choice2.getSelectedItem()) == "学生信息") {
                        ((studentPersonalMessage) panelStudentMessage).setEditable(false);
                    }
                } else if (((String) choice1.getSelectedItem()) == "教师") {
                    if (((String) choice2.getSelectedItem()) == "教师信息") {
                        ((teacherPersonalMessage) panelTeacherMessage).setEditable(false);
                    }
                }
            }
        });
    }

    private void initialComBox1() {
        choice1.addItem("教师");
        choice1.addItem("学生");
        choice1.addItem("班级");

    }

    private void initialComBox2(String s1) {
        choice2.removeAllItems();
        if (s1 == "教师") {
            choice2.addItem("教师信息");
            choice2.addItem("教师课表");
        } else if (s1 == "学生") {
            choice2.addItem("学生信息");
            choice2.addItem("学生课表");
        } else if (s1 == "班级") {
            choice2.addItem("班级信息");
            choice2.addItem("班级课表");
        }
    }
    private void initialComBox3(String s1) {
        choice3.removeAllItems();
        if (s1 == "教师") {

            UseTeacher useTeacher = new UseTeacher();
            ArrayList<Teacher> teaches =useTeacher.getTeacher();
            for(int i =  0 ; i<teaches.size();i++) {
                choice3.addItem(teaches.get(i).getId());
            }
        } else if (s1 == "学生") {
            UseStudent useStudent = new UseStudent();
            ArrayList students = useStudent.getStudent();
            for(int i =  0 ; i<students.size();i++) {
                choice3.addItem(((Student)students.get(i)).getId());
            }
        } else if (s1 == "班级") {
            UseClass useStudent = new UseClass();
            ArrayList students = useStudent.getAllClass();
            for(int i =  0 ; i<students.size();i++) {
                choice3.addItem(((cals)students.get(i)).getId());
            }
        }
    }
}
