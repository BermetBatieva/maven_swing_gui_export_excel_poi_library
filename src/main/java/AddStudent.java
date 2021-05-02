
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class AddStudent extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JTextField ageField;
    private JButton btnNewButton;
    private JButton btnDelButton;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddStudent frame = new AddStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public AddStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Добаление студента");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Имя");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Фамилия");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("кол-во родителей");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Город");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel age = new JLabel("Возраст");
        age.setFont(new Font("Tahoma", Font.PLAIN, 20));
        age.setBounds(542, 245, 99, 24);
        contentPane.add(age);

        JLabel lblMobileNumber = new JLabel("Номер телефона");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        ageField = new JTextField();
        ageField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        ageField.setBounds(707, 235, 228, 50);
        contentPane.add(ageField);

        btnNewButton = new JButton("Добавить");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String age = ageField.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Введите действительный номер " +
                            "мобильного телефона");
                }

                try {
                    Connection connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/ui_university",
                            "User", "12345");

                    String query = "INSERT INTO student  values('" + firstName + "','" + lastName + "','" + userName + "','" +
                            age + "','" + emailId + "','" + mobileNumber + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "Это уже существует");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                                "Добро пожаловать, " + msg + "добавлен в список студентов!");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);


        btnDelButton = new JButton("Удалить");
        btnDelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String firstName = firstname.getText();
            String lastName = lastname.getText();


            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ui_university",
                        "User", "12345");
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE from student where first_name =? and last_name =?");
                preparedStatement.setString(1,firstName);
                preparedStatement.setString(2,lastName);
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(btnDelButton,
                            "Данный студент удален!");

                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    });
        btnDelButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnDelButton.setBounds(120, 447, 259, 74);
        contentPane.add(btnDelButton);



        btnNewButton = new JButton("Назад");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(670, 447, 259, 74);


        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                        dispose();
                        UserHome ah = new UserHome();
                        ah.setTitle("Welcome");
                        ah.setVisible(true);
            }
        });
        contentPane.add(btnNewButton);
    }
}