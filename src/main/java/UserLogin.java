import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("INAI.KG");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);


        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Почта");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Пароль");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Войти");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 73);


        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/ui_university",
                            "User", "12345");
                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select email, psw from user_table where email=? and psw=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        UserHome ah = new UserHome(userName);
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "Успешно вошли в систему!");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Неверный логин или пароль!");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        contentPane.add(btnNewButton);



//
//        btnRegButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String userName = textField.getText();
//                String password = passwordField.getText();
//                try {
//                    Connection connection = (Connection) DriverManager.getConnection(
//                            "jdbc:mysql://localhost:3306/ui_university",
//                            "User", "12345");
//                    String query = "INSERT INTO student  values('" + userName + "','" + password + "')";
//
//                    Statement sta = connection.createStatement();
//                    int x = sta.executeUpdate(query);
//                    if (x == 0) {
//                        JOptionPane.showMessageDialog(btnNewButton, "Это уже существует");
//                    } else {
//                        JOptionPane.showMessageDialog(btnNewButton,
//                                 "Вы зарегистрированы!");
//                    }
//                    connection.close();
//                } catch (Exception exception) {
//                    exception.printStackTrace();
//                }
//            }
//        });
//
//        contentPane.add(btnNewButton);
//
//        label = new JLabel("");
//        label.setBounds(0, 0, 1008, 562);
//        contentPane.add(label);
    }
}