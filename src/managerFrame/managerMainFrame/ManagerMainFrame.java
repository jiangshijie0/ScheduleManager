package managerFrame.managerMainFrame;

import frame.LogIn;
import mysqlConnect.dababasesClass.Teacher;
import mysqlConnect.dbhelper.UseTeacher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagerMainFrame extends JFrame {
     private static int WIDTH = 800;
     private static int HEIGHT = 600;

     private JToolBar    menuBar;
     private JButton       message;
     private JButton       modifyInformation;

     private ManagerFrameFindMessage      panelFindMessage;
     private ManagerFrameModifyMessage    panelModifyMessage;

     public ManagerMainFrame(String name){
          setTitle(name);
          setLayout(null);
          initFrame();
          setResizable(false);
          setBounds(50,50,WIDTH,HEIGHT);

          add(menuBar);
          add(panelFindMessage);
          add(panelModifyMessage);

          menuBar.setBounds(0,0,WIDTH,40);
          panelFindMessage.setBounds(0,40,WIDTH,HEIGHT-40);
          panelModifyMessage.setBounds(0,40,WIDTH,HEIGHT-40);

          panelModifyMessage.setVisible(false);
          panelFindMessage.setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     private void initFrame(){
          menuBar             = new JToolBar();
          message             = new JButton("查询信息");
          modifyInformation   = new JButton("修改信息");
          panelFindMessage    = new ManagerFrameFindMessage(WIDTH,HEIGHT-40);
          panelModifyMessage  = new ManagerFrameModifyMessage(WIDTH,HEIGHT-40);

          message.setFont(LogIn.font);
          modifyInformation.setFont(LogIn.font);

          menuBar.add(message);
          menuBar.add(modifyInformation);

          //点击查询信息的响应
          message.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    panelFindMessage.setVisible(true);
                    panelModifyMessage.setVisible(false);
               }
          });

          //点击修改信息的响应
          modifyInformation.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    panelModifyMessage.setVisible(true);
                    panelFindMessage.setVisible(false);
               }
          });
     }

     public static void main(String[] args) {
          ManagerMainFrame managerMainFrame = new ManagerMainFrame("管理员");
          managerMainFrame.setVisible(true);
     }
}
