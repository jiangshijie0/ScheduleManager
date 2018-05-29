package managerFrame.modifyMessage;

import frame.LogIn;

import javax.swing.*;

public class AddClass extends JPanel {
    private int x = 180;
    private int WIDTH;
    private int HEIGHT;
    private JLabel className;
    private JTextField nameClass;
    public  AddClass(int w, int h){
        WIDTH = w;
        HEIGHT = h;
        initFrame();
        setLayout(null);

        add(className);
        add(nameClass);

        className.setFont(LogIn.font);
        nameClass.setFont(LogIn.font);

        className.setBounds(x,20,100,40);
        nameClass.setBounds(x+140,20,300,40);
    }

    private void initFrame(){
        className = new JLabel("班级名称");
        nameClass = new JTextField();
    }
}
