package managerFrame.findMessageFrame;

import frame.LogIn;
import mysqlConnect.dababasesClass.Student;
import mysqlConnect.dababasesClass.Teacher;
import mysqlConnect.dbhelper.UseStudent;
import mysqlConnect.dbhelper.UseTeacher;

import javax.swing.*;

public class studentPersonalMessage extends JPanel {
    private int width;
    private int height;
    private int y = 200;

    private JTextField id;
    private JTextField name;
    private JTextField sex;
    private JTextField age;
    private JTextField birth;
    private JTextField clas;

    public studentPersonalMessage(int w, int h,String i) {
        width = w;
        height = h;

        setLayout(null);
        initPanel( i);

        JLabel labelId = new JLabel("ID:");
        JLabel labelName = new JLabel("姓名:");
        JLabel labelSex = new JLabel("性别:");
        JLabel labelAge = new JLabel("年龄:");
        JLabel labelBirth = new JLabel("出生日期:");
        JLabel labelClass = new JLabel("班级");

        add(labelId);
        add(labelName);
        add(labelSex);
        add(labelAge);
        add(labelBirth);
        add(labelClass);
        add(id);
        add(name);
        add(sex);
        add(age);
        add(birth);
        add(clas);


        labelId.setFont(LogIn.font);
        labelName.setFont(LogIn.font);
        labelSex.setFont(LogIn.font);
        labelAge.setFont(LogIn.font);
        labelBirth.setFont(LogIn.font);
        labelClass.setFont(LogIn.font);
        id.setFont(LogIn.font);
        name.setFont(LogIn.font);
        sex.setFont(LogIn.font);
        age.setFont(LogIn.font);
        birth.setFont(LogIn.font);
        clas.setFont(LogIn.font);

        int x = 35;
        labelId.setBounds(y, x, 100, 30);
        labelName.setBounds(y, x+50, 100, 30);
        labelSex.setBounds(y, x+50*2, 100, 30);
        labelAge.setBounds(y, x+50*3, 100, 30);
        labelBirth.setBounds(y, x+50*4, 100, 30);
        labelClass.setBounds(y, x+50*5, 100, 30);

        id.setBounds(y+180, x, 200, 30);
        name.setBounds(y+180, x+50, 200, 30);
        sex.setBounds(y+180, x+50*2, 200, 30);
        age.setBounds(y+180, x+50*3, 200, 30);
        birth.setBounds(y+180, x+50*4, 200, 30);
        clas.setBounds(y+180, x+50*5, 200, 30);
    }
    public studentPersonalMessage(int w, int h) {
        width = w;
        height = h;

        setLayout(null);
        initPanel("201001001");

        JLabel labelId = new JLabel("ID:");
        JLabel labelName = new JLabel("姓名:");
        JLabel labelSex = new JLabel("性别:");
        JLabel labelAge = new JLabel("年龄:");
        JLabel labelBirth = new JLabel("出生日期:");
        JLabel labelClass = new JLabel("班级");

        add(labelId);
        add(labelName);
        add(labelSex);
        add(labelAge);
        add(labelBirth);
        add(labelClass);
        add(id);
        add(name);
        add(sex);
        add(age);
        add(birth);
        add(clas);


        labelId.setFont(LogIn.font);
        labelName.setFont(LogIn.font);
        labelSex.setFont(LogIn.font);
        labelAge.setFont(LogIn.font);
        labelBirth.setFont(LogIn.font);
        labelClass.setFont(LogIn.font);
        id.setFont(LogIn.font);
        name.setFont(LogIn.font);
        sex.setFont(LogIn.font);
        age.setFont(LogIn.font);
        birth.setFont(LogIn.font);
        clas.setFont(LogIn.font);

        int x = 35;
        labelId.setBounds(y, x, 100, 30);
        labelName.setBounds(y, x+50, 100, 30);
        labelSex.setBounds(y, x+50*2, 100, 30);
        labelAge.setBounds(y, x+50*3, 100, 30);
        labelBirth.setBounds(y, x+50*4, 100, 30);
        labelClass.setBounds(y, x+50*5, 100, 30);

        id.setBounds(y+180, x, 200, 30);
        name.setBounds(y+180, x+50, 200, 30);
        sex.setBounds(y+180, x+50*2, 200, 30);
        age.setBounds(y+180, x+50*3, 200, 30);
        birth.setBounds(y+180, x+50*4, 200, 30);
        clas.setBounds(y+180, x+50*5, 200, 30);
    }
    public void setMessage(String i){
        System.out.println(i);
        UseStudent useStudent = new UseStudent();
        Student student = useStudent.getStudentById(i);

        id.setText(student.getId());
        name.setText(student.getName());
        sex.setText(student.getSex());
        age.setText(student.getAge());
        birth.setText(student.getBirthDay());
        clas.setText(student.getClass_id());
    }

    private void initPanel(String i) {

        UseStudent useStudent = new UseStudent();
        Student student = useStudent.getStudentById(i);
        id = new JTextField(student.getId());
        name = new JTextField(student.getName());
        sex = new JTextField(student.getSex());
        age = new JTextField(student.getAge());
        birth = new JTextField(student.getBirthDay());
        clas = new JTextField(student.getClass_id());

        id.setEditable(false);
        setEditable( false);
    }


    public void setEditable(boolean b) {
        name.setEditable(b);
        sex.setEditable(b);
        age.setEditable(b);
        birth.setEditable(b);
        clas.setEditable(b);
    }


}
