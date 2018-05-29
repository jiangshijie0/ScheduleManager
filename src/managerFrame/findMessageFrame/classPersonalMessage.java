package managerFrame.findMessageFrame;

import frame.LogIn;
import mysqlConnect.dababasesClass.Student;
import mysqlConnect.dbhelper.UseClass;
import mysqlConnect.dababasesClass.cals;

import javax.swing.*;
import java.util.ArrayList;

public class classPersonalMessage extends JPanel {
    private int width;
    private int height;
    private ArrayList students;
    private JTextField name;
    private JList classStudent;
    private JScrollPane scrollPane;

    public classPersonalMessage(int w, int h) {
        width = w;
        height = h;
        System.out.println(w+" "+h);

        setLayout(null);
        initFrame();


        JLabel labelName = new JLabel("班级名称:");
        add(labelName);
        labelName.setFont(LogIn.font);
        labelName.setBounds(120, 30, 100, 30);

        add(name);
        name.setFont(LogIn.font);
        name.setBounds(300, 30, 300, 30);


        scrollPane.setViewportView(classStudent);
        classStudent.setFont(LogIn.font);

        add(scrollPane);
        scrollPane.setBounds(120, 80, 560, 280);
    }

    public void setMessage(String i){
        UseClass useClass = new UseClass();
        cals classe = useClass.getClassById(i);
        students = useClass.getStudents(i);
        name.setText(classe.getId());
        initData();
    }
    private void initFrame() {
        students = new ArrayList<Integer>();
        name = new JTextField();
        classStudent = new JList<Integer>();
        scrollPane = new JScrollPane();
        initData();
    }

    public void initData() {
        ArrayList<String> studentIdAndName = new ArrayList<>();
        for(int i = 0 ; i<students.size();i++)
        {
            studentIdAndName.add(((Student)students.get(i)).getId()+
                    "            "+((Student)students.get(i)).getName());
        }

        classStudent.setListData(studentIdAndName.toArray());
    }

}
