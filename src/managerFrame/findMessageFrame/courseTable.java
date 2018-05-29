package managerFrame.findMessageFrame;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class courseTable extends JPanel {

    private int width;
    private int height;
    private JTextField[][] course;
    private ArrayList labels;

    public courseTable(int w, int h) {
        width = w;
        height = h;
        setLayout(null);
        initFrame();


        for (int i = 0; i < 7; i++) {
            JLabel label = (JLabel) labels.get(i);
            add(label);
            label.setFont(new Font("宋体", 20, 20));
            label.setBounds(i * 90 + 130, 0, 50, 60);
        }
        for (int i = 7; i < labels.size(); i++) {
            JLabel label = (JLabel) labels.get(i);
            add(label);
            label.setFont(new Font("宋体", 15, 15));
            label.setBackground(Color.red);
            label.setBounds(40, (i - 7) * (height / 15) + 35, 50, 30);
        }
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < course[i].length; j++) {
                JTextField textField =  course[i][j];
                add(textField);
                textField.setFont(new Font("宋体", 15, 15));
                textField.setBounds(i * 90 + 130, j * (height / 15) + 40, 50, 25);
            }
        }
    }

    private void initFrame() {
        labels = new ArrayList<JLabel>();
        course = new JTextField[7][10];
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < course[i].length; j++) {
                course[i][j] = new JTextField(""+i);
                course[i][j].setText(""+(i*j));
            }
        }


        JLabel label1 = new JLabel("周一");
        JLabel label2 = new JLabel("周二");
        JLabel label3 = new JLabel("周三");
        JLabel label4 = new JLabel("周四");
        JLabel label5 = new JLabel("周五");
        JLabel label6 = new JLabel("周六");
        JLabel label7 = new JLabel("周日");

        JLabel jLabel1 = new JLabel("第一节");
        JLabel jLabel2 = new JLabel("第二节");
        JLabel jLabel3 = new JLabel("第三节");
        JLabel jLabel4 = new JLabel("第四节");
        JLabel jLabel5 = new JLabel("第五节");
        JLabel jLabel6 = new JLabel("第六节");
        JLabel jLabel7 = new JLabel("第七节");
        JLabel jLabel8 = new JLabel("第八节");
        JLabel jLabel9 = new JLabel("第九节");
        JLabel jLabel10 = new JLabel("第十节");

        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(label7);
        labels.add(jLabel1);
        labels.add(jLabel2);
        labels.add(jLabel3);
        labels.add(jLabel4);
        labels.add(jLabel5);
        labels.add(jLabel6);
        labels.add(jLabel7);
        labels.add(jLabel8);
        labels.add(jLabel9);
        labels.add(jLabel10);
    }

}
