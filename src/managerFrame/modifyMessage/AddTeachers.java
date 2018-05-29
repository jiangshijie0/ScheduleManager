package managerFrame.modifyMessage;

import frame.LogIn;

import javax.swing.*;

public class AddTeachers extends JPanel {
    private int WIDTH;//800
    private int HEIGHT;//400
    private int x = 180;
    private JLabel id;
    private JLabel name;
    private JLabel sex;
    private JLabel salary;
    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldSex;
    private JTextField textFieldSalary;

    //800*400的界面
    public AddTeachers(int w, int h) {
        WIDTH = w;
        HEIGHT = h;
        setLayout(null);
        initFrame();

        add(id);
        add(name);
        add(sex);
        add(salary);
        add(textFieldId);
        add(textFieldName);
        add(textFieldSex);
        add(textFieldSalary);

        id.setFont(LogIn.font);
        name.setFont(LogIn.font);
        sex.setFont(LogIn.font);
        salary.setFont(LogIn.font);
        textFieldId.setFont(LogIn.font);
        textFieldName.setFont(LogIn.font);
        textFieldSex.setFont(LogIn.font);
        textFieldSalary.setFont(LogIn.font);

        id.setBounds(x, 20, 100, 40);
        textFieldId.setBounds(x+140, 20, 300, 40);
        name.setBounds(x, 80, 100, 40);
        textFieldName.setBounds(x+140, 80, 300, 40);
        sex.setBounds(x, 140, 100, 40);
        textFieldSex.setBounds(x+140, 140, 300, 40);
        salary.setBounds(x, 200, 100, 40);
        textFieldSalary.setBounds(x+140, 200, 300, 40);

    }

    private void initFrame() {
        id = new JLabel("ID");
        name = new JLabel("姓名");
        sex = new JLabel("性别");
        salary = new JLabel("工资");

        textFieldId = new JTextField();
        textFieldName = new JTextField();
        textFieldSalary = new JTextField();
        textFieldSex = new JTextField();
    }
}
