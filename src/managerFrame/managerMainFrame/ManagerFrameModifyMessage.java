package managerFrame.managerMainFrame;

import frame.LogIn;
import managerFrame.modifyMessage.AddClass;
import managerFrame.modifyMessage.AddStudents;
import managerFrame.modifyMessage.AddTeachers;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ManagerFrameModifyMessage extends JPanel {
    private int WIDTH;
    private int HEIGHT;
    private JComboBox choice;
    private JButton sure;
    private JButton cancel;
    private AddTeachers addTeacher;
    private AddStudents addStudent;
    private AddClass addClass;

    public ManagerFrameModifyMessage(int w, int h) {
        WIDTH   = w;
        HEIGHT  = h;
        setLayout(null);
        initFrame();

        JLabel label = new JLabel("请选择:");

        add(label);
        add(choice);
        add(sure);
        add(cancel);
        add(addTeacher);
        add(addStudent);
        add(addClass);

        label.setFont(LogIn.font);
        choice.setFont(LogIn.font);
        sure.setFont(LogIn.font);
        cancel.setFont(LogIn.font);


        label.setBounds(200,20,100,40);
        choice.setBounds(360,20,240,40);
        sure.setBounds(200,460,80,40);
        cancel.setBounds(520,460,80,40);

        addTeacher.setBounds(0,60,800,400);
        addTeacher.setVisible(true);

        addStudent.setBounds(0,60,800,400);
        addStudent.setVisible(false);

        addClass.setBounds(0,60,800,400);
        addClass.setVisible(false);
    }
    private void initFrame(){
        choice = new JComboBox();
        sure = new JButton("确定");
        cancel = new JButton("取消");

        addTeacher = new AddTeachers(WIDTH,HEIGHT-160);
        addStudent = new AddStudents(WIDTH,HEIGHT-160);
        addClass = new AddClass(WIDTH,HEIGHT-160);

        initialComBox();

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String result = (String) choice.getSelectedItem();
                if(result=="添加班级"){
                    addTeacher.setVisible(false);
                    addStudent.setVisible(false);
                    addClass.setVisible(true);

                }else if(result=="添加老师"){
                    addTeacher.setVisible(true);
                    addStudent.setVisible(false);
                    addClass.setVisible(false);

                }else if(result=="添加学生"){
                    addTeacher.setVisible(false);
                    addStudent.setVisible(true);
                    addClass.setVisible(false);
                }
            }
        });

    }
    private void initialComBox(){
        choice.addItem("添加老师");
        choice.addItem("添加班级");
        choice.addItem("添加学生");
    }

}
