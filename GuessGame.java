package java_practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessGame {
    private JFrame frame;
    private JLabel lb1,lb2,lb3;
    private JTextField tf1;
    private JButton btn1,btn2,btn3;

     public GuessGame(){
         Random ran=new Random();
         int ans=ran.nextInt(100);
         // 建立 JFrame 物件，同時設定標題
         frame=new JFrame("猜數字遊戲");
         // 設定佈局
         frame.setLayout(null);
         // 建立標籤
         lb1=new JLabel("請輸入0-100的數字: ");
         // 設定絕對座標
         lb1.setBounds(5,5,200,20);

         frame.add(lb1);// 將元件加入版面

         // 建立文字框
         tf1=new JTextField();
         // 設定絕對座標
         tf1.setBounds(107,5,100,20);

         frame.add(tf1);// 將元件加入版面

         // 建立"確認"按鈕
         btn1=new JButton("送出");
         // 設定絕對座標
         btn1.setBounds(5,37,100,20);
         frame.add(btn1);// 將元件加入版面
         btn1.addActionListener(new ActionListener() {// 註冊事件，使用匿名類別的匿名物件
             // 處理觸發的事件
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     if (Integer.parseInt(tf1.getText()) == ans) {
                         lb2.setText("BINGO! 答對了");
                     } else {
                         lb2.setText("猜錯了!");
                     }
                 }catch (Exception ex){
                     // JOptionPane 可以輕鬆彈出一個標準對話框
                     JOptionPane.showMessageDialog(null,"請輸入數字", "輸入錯誤", JOptionPane.ERROR_MESSAGE);
                 }
             }
         });

         // 建立"清除"按鈕
         btn2=new JButton("清除");
         btn2.setBounds(107,37,100,20);// 設定絕對座標
         frame.add(btn2);// 將元件加入版面
         btn2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 tf1.setText(""); // 將文字框清除
                 lb2.setText(""); // 將 lb2 標籤清除
             }
         });

         // 建立"點我看答案"按鈕
         btn3=new JButton("ㄟ過來一下，操你媽的過來一下 點我看答案");
         btn3.setBounds(5,70,300,20);
         frame.add(btn3);
         btn3.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) { // 註冊事件，使用匿名類別的匿名物件
                    // 處理觸發的事件
                 lb3.setText("答案是 "+ans);
             }
         });

         // 建立標籤
         lb2=new JLabel("");
         lb2.setBounds(220,5,100,20);// 設定絕對座標
         frame.add(lb2);// 將元件加入版面

         // 設定版面大小
         frame.setSize(350,150);
         // 顯示視窗
         frame.setVisible(true);

         // 建立標籤
         lb3=new JLabel("");
         lb3.setBounds(5,100,200,40);
         frame.add(lb3);

         // 設定版面大小
         frame.setSize(350,200);
         // 顯示視窗
         frame.setVisible(true);

         String path="OIP.jpg";
         frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Guess.class.getResource(path)));

         frame.setLocationRelativeTo(null);
         // JFrame 關閉視窗的設定，有這一行才能結束程式
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
