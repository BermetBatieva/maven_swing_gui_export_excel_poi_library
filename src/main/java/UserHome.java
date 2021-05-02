import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class UserHome extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

  UserHome(){

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(450, 190, 2000, 1200);
      setResizable(false);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      JButton btnNewButton = new JButton("Выход");
      btnNewButton.setForeground(new Color(0, 0, 0));
      btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
      btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
      btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
              if (a == JOptionPane.YES_OPTION) {
                  dispose();
                  UserLogin obj = new UserLogin();
                  obj.setTitle("Student-Login");
                  obj.setVisible(true);
              }
              dispose();
              UserLogin obj = new UserLogin();

              obj.setTitle("Student-Login");
              obj.setVisible(true);

          }
      });
      btnNewButton.setBounds(247, 200, 500, 50);//247, 200, 500, 50
      contentPane.add(btnNewButton);

      JButton addStudent = new JButton("добавить или удалить студента");
      addStudent.setForeground(new Color(0, 0, 0));
      addStudent.setBackground(UIManager.getColor("Button.disabledForeground"));
      addStudent.setFont(new Font("Times New Roman", Font.PLAIN, 20));
      addStudent.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              AddStudent obj = new AddStudent();
              obj.setTitle("Student-Add");
              obj.setVisible(true);
          }
      });
      addStudent.setBounds(247, 280, 500, 50);
      contentPane.add(addStudent);


      JButton SearchStudent = new JButton("поиск студента");
      SearchStudent.setForeground(new Color(0, 0, 0));
      SearchStudent.setBackground(UIManager.getColor("Button.disabledForeground"));
      SearchStudent.setFont(new Font("Times New Roman", Font.PLAIN, 20));
      SearchStudent.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              int a = JOptionPane.showConfirmDialog(SearchStudent,
                      "Хотите найти студента?");
              if (a == JOptionPane.YES_OPTION) {
                  SearchSt obj = new SearchSt();
                  obj.setTitle("Search-St");
                  obj.setVisible(true);
              }
              SearchSt obj = new SearchSt();
              obj.setTitle("Search-St");
              obj.setVisible(true);

          }
      });
      SearchStudent.setBounds(247, 360, 500, 50);
      contentPane.add(SearchStudent);







      JButton QueryBtn = new JButton("Студенты с регионов");
      QueryBtn.setForeground(new Color(0, 0, 0));
      QueryBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
      QueryBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
      QueryBtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              int a = JOptionPane.showConfirmDialog(QueryBtn,
                      "Хотите получить список студентов?");

              if (a == JOptionPane.YES_OPTION) {

                  FetchData obj = new FetchData();
                  obj.setTitle("Query-Data");
                  obj.setVisible(true);
              }

              FetchData obj = new FetchData();
              obj.setTitle("Query-Data");
              obj.setVisible(true);

          }
      });
      QueryBtn.setBounds(247, 440, 500, 50);
      contentPane.add(QueryBtn);



      JButton ageBtn = new JButton("Совершеннолетние студенты");
      ageBtn.setForeground(new Color(0, 0, 0));
      ageBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
      ageBtn .setFont(new Font("Times New Roman", Font.PLAIN, 20));
      ageBtn .addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              int a = JOptionPane.showConfirmDialog(ageBtn,
                      "Хотите получить список студентов?");

              if (a == JOptionPane.YES_OPTION) {

                  Form obj = new Form();
                  obj.setTitle("Form");
                  obj.setVisible(true);
              }

              Form  obj = new Form();
              obj.setTitle("Form");
              obj.setVisible(true);

          }
      });
      ageBtn .setBounds(247, 520, 500, 50);
      contentPane.add(ageBtn);





      JButton PArBtn = new JButton("Один родитель");
      PArBtn.setForeground(new Color(0, 0, 0));
      PArBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
      PArBtn .setFont(new Font("Times New Roman", Font.PLAIN, 20));
      PArBtn .addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              int a = JOptionPane.showConfirmDialog(PArBtn,
                      "Хотите получить список студентов?");

              if (a == JOptionPane.YES_OPTION) {

                  OneParent obj = new OneParent ();
                  obj.setTitle("one-parent");
                  obj.setVisible(true);
              }

              OneParent  obj = new OneParent ();
              obj.setTitle("one-parent");
              obj.setVisible(true);

          }
      });
      PArBtn.setBounds(247, 580, 500, 40);
      contentPane.add(PArBtn);
  }
    public UserHome(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 2000, 1200);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnNewButton = new JButton("Выход");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
                dispose();
                UserLogin obj = new UserLogin();

                obj.setTitle("Student-Login");
                obj.setVisible(true);

            }
        });
        btnNewButton.setBounds(247, 200, 500, 50);
        contentPane.add(btnNewButton);

        JButton addStudent = new JButton("добавить или удалить студента");
        addStudent.setForeground(new Color(0, 0, 0));
        addStudent.setBackground(UIManager.getColor("Button.disabledForeground"));
        addStudent.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    AddStudent obj = new AddStudent();
                    obj.setTitle("Student-Add");
                    obj.setVisible(true);
            }
        });
        addStudent.setBounds(247, 280, 500, 50);
        contentPane.add(addStudent);


        JButton SearchStudent = new JButton("поиск студента");
        SearchStudent.setForeground(new Color(0, 0, 0));
        SearchStudent.setBackground(UIManager.getColor("Button.disabledForeground"));
        SearchStudent.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        SearchStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(SearchStudent,
                        "Хотите найти студента?");
                if (a == JOptionPane.YES_OPTION) {
                    SearchSt obj = new SearchSt();
                    obj.setTitle("Search-St");
                    obj.setVisible(true);
                }
                SearchSt obj = new SearchSt();
                obj.setTitle("Search-St");
                obj.setVisible(true);

            }
        });
        SearchStudent.setBounds(247, 360, 500, 50);
        contentPane.add(SearchStudent);







        JButton QueryBtn = new JButton("Студенты с регионов");
        QueryBtn.setForeground(new Color(0, 0, 0));
        QueryBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
        QueryBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        QueryBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(QueryBtn,
                        "Хотите получить список студентов?");

                if (a == JOptionPane.YES_OPTION) {

                    FetchData obj = new FetchData();
                    obj.setTitle("Query-Data");
                    obj.setVisible(true);
                }

                FetchData obj = new FetchData();
                obj.setTitle("Query-Data");
                obj.setVisible(true);

            }
        });
        QueryBtn.setBounds(247, 440, 500, 50);
        contentPane.add(QueryBtn);



        JButton ageBtn = new JButton("Совершеннолетние студенты");
        ageBtn.setForeground(new Color(0, 0, 0));
        ageBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
        ageBtn .setFont(new Font("Times New Roman", Font.PLAIN, 20));
        ageBtn .addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(ageBtn,
                        "Хотите получить список студентов?");

                if (a == JOptionPane.YES_OPTION) {

                    Form  obj = new Form ();
                    obj.setTitle("Form");
                    obj.setVisible(true);
                }

                Form  obj = new Form ();
                obj.setTitle("Form");
                obj.setVisible(true);

            }
        });
        ageBtn .setBounds(247, 520, 500, 50);
        contentPane.add(ageBtn);

        JButton PArBtn = new JButton("Один родитель");
        PArBtn.setForeground(new Color(0, 0, 0));
        PArBtn.setBackground(UIManager.getColor("Button.disabledForeground"));
        PArBtn .setFont(new Font("Times New Roman", Font.PLAIN, 20));
        PArBtn .addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(PArBtn,
                        "Хотите получить список студентов?");

                if (a == JOptionPane.YES_OPTION) {

                    OneParent obj = new OneParent ();
                    obj.setTitle("Query-Data");
                    obj.setVisible(true);
                }

                OneParent  obj = new OneParent ();
                obj.setTitle("Query-Data");
                obj.setVisible(true);

            }
        });
        PArBtn .setBounds(247, 580, 500, 40);
        contentPane.add(PArBtn);








        JButton button = new JButton("изменить пароль\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes);
                bo.setTitle("Change Password");
                bo.setVisible(true);

            }
        });
        button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        button.setBounds(247, 120, 500, 50);//247, 120, 500, 50
        contentPane.add(button);


    }


}