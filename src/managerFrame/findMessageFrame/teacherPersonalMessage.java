package managerFrame.findMessageFrame;

import frame.LogIn;
import mysqlConnect.dababasesClass.Teacher;
import mysqlConnect.dbhelper.UseTeacher;

import javax.swing.*;

public class teacherPersonalMessage extends JPanel {
    private int width;
    private int height;

    private int x = 200;

    private JTextField id;
    private JTextField name;
    private JTextField sex;
    private JTextField salary;

    public teacherPersonalMessage(int w, int h,String i) {
        width = w;
        height = h;


        initPanel(i);
        setLayout(null);

        JLabel labelId = new JLabel("ID:");
        JLabel labelName = new JLabel("姓名:");
        JLabel labelSex = new JLabel("性别:");
        JLabel labelSalary = new JLabel("工资:");

        add(labelId);
        add(labelName);
        add(labelSex);
        add(labelSalary);
        add(id);
        add(name);
        add(sex);
        add(salary);


        labelId.setFont(LogIn.font);
        labelName.setFont(LogIn.font);
        labelSex.setFont(LogIn.font);
        labelSalary.setFont(LogIn.font);
        id.setFont(LogIn.font);
        name.setFont(LogIn.font);
        sex.setFont(LogIn.font);
        salary.setFont(LogIn.font);

        labelId.setBounds(x, 60, 100, 30);
        labelName.setBounds(x, 130, 100, 30);
        labelSex.setBounds(x, 200, 100, 30);
        labelSalary.setBounds(x, 270, 100, 30);
        name.setBounds(x+180, 130, 200, 30);
        id.setBounds(x+180, 60, 200, 30);
        sex.setBounds(x+180, 200, 200, 30);
        salary.setBounds(x+180, 270, 200, 30);

    }
    public teacherPersonalMessage(int w, int h) {
        width = w;
        height = h;

        initPanel("1");
        setLayout(null);

        JLabel labelId = new JLabel("ID:");
        JLabel labelName = new JLabel("姓名:");
        JLabel labelSex = new JLabel("性别:");
        JLabel labelSalary = new JLabel("工资:");

        add(labelId);
        add(labelName);
        add(labelSex);
        add(labelSalary);
        add(id);
        add(name);
        add(sex);
        add(salary);


        labelId.setFont(LogIn.font);
        labelName.setFont(LogIn.font);
        labelSex.setFont(LogIn.font);
        labelSalary.setFont(LogIn.font);
        id.setFont(LogIn.font);
        name.setFont(LogIn.font);
        sex.setFont(LogIn.font);
        salary.setFont(LogIn.font);

        labelId.setBounds(x, 60, 100, 30);
        labelName.setBounds(x, 130, 100, 30);
        labelSex.setBounds(x, 200, 100, 30);
        labelSalary.setBounds(x, 270, 100, 30);
        name.setBounds(x+180, 130, 200, 30);
        id.setBounds(x+180, 60, 200, 30);
        sex.setBounds(x+180, 200, 200, 30);
        salary.setBounds(x+180, 270, 200, 30);

    }

    public void setMessage(String i){
        System.out.println(i);
        UseTeacher useTeacher = new UseTeacher();
        Teacher teacher = useTeacher.getTeacherById(i);

        id.setText(teacher.getId());
        name.setText(teacher.getName());
        sex.setText(teacher.getSex());
        salary.setText(String.valueOf(teacher.getSalary()));
    }

    public void initPanel(String i) {
        UseTeacher useTeacher = new UseTeacher();
        Teacher teacher = useTeacher.getTeacherById(i);

        id = new JTextField(teacher.getId());
        name = new JTextField(teacher.getName());
        sex = new JTextField(teacher.getSex());
        salary = new JTextField(""+teacher.getSalary());

        id.setEditable(false);

        setEditable(false);
    }

    public void setEditable(boolean b){
        name.setEditable(b);
        sex.setEditable(b);
        salary.setEditable(b);
    }

}
