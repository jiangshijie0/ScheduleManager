package managerFrame.modifyMessage;

import frame.LogIn;

import javax.swing.*;

public class AddStudents extends JPanel {
    private int WIDTH;//800
    private int HEIGHT;//400
    private int x = 180;
    private JLabel id;
    private JLabel name;
    private JLabel sex;
    private JLabel age;
    private JLabel birth;
    private JLabel clas;
    private JTextField textFieldAge;
    private JTextField textFieldBirth;
    private JTextField textFieldClass;
    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldSex;

    //800*400的界面
    public AddStudents(int w, int h) {
        WIDTH = w;
        HEIGHT = h;
        setLayout(null);
        initFrame();

        add(id);
        add(name);
        add(sex);
        add(age);
        add(birth);
        add(clas);
        add(textFieldId);
        add(textFieldName);
        add(textFieldSex);
        add(textFieldAge);
        add(textFieldBirth);
        add(textFieldClass);

        id.setFont(LogIn.font);
        name.setFont(LogIn.font);
        sex.setFont(LogIn.font);
        age.setFont(LogIn.font);
        birth.setFont(LogIn.font);
        clas.setFont(LogIn.font);
        textFieldId.setFont(LogIn.font);
        textFieldName.setFont(LogIn.font);
        textFieldSex.setFont(LogIn.font);
        textFieldAge.setFont(LogIn.font);
        textFieldBirth.setFont(LogIn.font);
        textFieldClass.setFont(LogIn.font);

        id.setBounds(x,20,100,40);
        textFieldId.setBounds(x+140,20,300,40);
        name.setBounds(x,80,100,40);
        textFieldName.setBounds(x+140,80,300,40);
        sex.setBounds(x,140,100,40);
        textFieldSex.setBounds(x+140,140,300,40);
        age.setBounds(x,200,100,40);
        textFieldAge.setBounds(x+140,200,300,40);
        birth.setBounds(x,260,100,40);
        textFieldBirth.setBounds(x+140,260,300,40);
        clas.setBounds(x,320,100,40);
        textFieldClass.setBounds(x+140,320,300,40);

    }

    private void initFrame() {
        id = new JLabel("ID");
        name = new JLabel("姓名");
        sex = new JLabel("性别");
        age = new JLabel("年龄");
        birth = new JLabel("出生日期");
        clas = new JLabel("班级");

        textFieldId = new JTextField();
        textFieldName = new JTextField();
        textFieldSex = new JTextField();
        textFieldAge = new JTextField();
        textFieldBirth = new JTextField();
        textFieldClass = new JTextField();
    }
}
