import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchSt extends JFrame implements ActionListener {

    JLabel lb, lb1, lb2, lb3, lb4, lb5,lb6;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6;
    JButton btn;

    SearchSt() {

        super("Fetching Student Information");
        lb5 = new JLabel("Введите имя:");
        lb5.setBounds(20, 20, 100, 20);
        tf5 = new JTextField(20);
        tf5.setBounds(130, 20, 200, 20);
        btn = new JButton("Submit");
        btn.setBounds(50, 50, 100, 20);
        btn.addActionListener(this);
        lb = new JLabel("Поиск студента по имени");
        lb.setBounds(30, 80, 450, 30);
        lb.setForeground(Color.blue);
        lb.setFont(new Font("Serif", Font.BOLD, 20));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        lb1 = new JLabel("Имя:");
        lb1.setBounds(20, 120, 100, 20);
        tf1 = new JTextField(50);
        tf1.setBounds(130, 120, 200, 20);
        lb2 = new JLabel("Фамилия:");
        lb2.setBounds(20, 150, 100, 20);
        tf2 = new JTextField(100);
        tf2.setBounds(130, 150, 200, 20);
        lb3 = new JLabel("Город:");
        lb3.setBounds(20, 180, 100, 20);
        tf3 = new JTextField(50);
        tf3.setBounds(130, 180, 200, 20);
        lb4 = new JLabel("Возраст:");
        lb4.setBounds(20, 210, 100, 20);
        tf4 = new JTextField(50);
        tf4.setBounds(130, 210, 100, 20);

        lb6 = new JLabel("Кол-во родителей:");
        lb6.setBounds(20, 240, 100, 20);
        tf6 = new JTextField(50);
        tf6.setBounds(130, 240, 100, 20);
        setLayout(null);

        add(lb5);
        add(tf5);
        add(btn);
        add(lb);
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);
        add(lb4);
        add(tf4);
        add(lb6);
        add(tf6);


        tf1.setEditable(false);
        tf2.setEditable(false);
        tf3.setEditable(false);
        tf4.setEditable(false);
        tf6.setEditable(false);



    }
    public void actionPerformed(ActionEvent e) {
        try {
            String str = tf5.getText();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ui_university",
                    "User", "12345");
            PreparedStatement st = con.prepareStatement("select * from student where first_name=?");
            st.setString(1, str);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String s = rs.getString(1);
                String s1 = rs.getString(2);
                String s2 = rs.getString(3);
                String s3 = rs.getString(4);
                String s4 = rs.getString(5);

                tf1.setText(s);
                tf2.setText(s1);
                tf3.setText(s2);
                tf4.setText(s3);
                tf6.setText(s4);
            } else {
                JOptionPane.showMessageDialog(null, "Не найдено!");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String args[]) {
        new SearchSt();
    }
}
