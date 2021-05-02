import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Vector;

class FetchData extends JFrame{
    ResultSet rs;
    FetchData(){
        final Vector columnNames = new Vector();
        final Vector data = new Vector();
        JButton button=new JButton("Export");
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ui_university",
                    "User", "12345");
            Statement st = con.createStatement();
            rs= st.executeQuery("select * from student where city!='Бишкек'");
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement( md.getColumnName(i) );
            }
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement( rs.getObject(i) );
                }
                data.addElement( row );
            }
        }
        catch(Exception e){}
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel1.add(scrollPane);
        panel2.add(button);
        panel.add(panel1);
        panel.add(panel2);
        add(panel);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                try{
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/ui_university",
                            "User", "12345");
                    Statement st = con.createStatement();
                    rs= st.executeQuery("select * from student where city!='Бишкек'");
                    HSSFWorkbook wb = new HSSFWorkbook();
                    HSSFSheet sheet = wb.createSheet("Excel Sheet");
                    HSSFRow rowhead = sheet.createRow((short)0);
                    rowhead.createCell((short) 0).setCellValue(" first name");
                    rowhead.createCell((short) 1).setCellValue(" lastname");
                    rowhead.createCell((short) 2).setCellValue(" city");
                    rowhead.createCell((short) 3).setCellValue(" age");
                    int index=1;
                    while(rs.next()){
                        HSSFRow row = sheet.createRow((short)index);
                        row.createCell((short) 0).setCellValue(rs.getString(1));
                        row.createCell((short) 1).setCellValue(rs.getString(2));
                        row.createCell((short) 2).setCellValue(rs.getString(3));
                        row.createCell((short) 3).setCellValue(rs.getString(4));
                        index++;
                    }
                    FileOutputStream fileOut = new FileOutputStream("C:\\Users\\99655\\Hello.xls");
                    wb.write(fileOut);
                    fileOut.close();
                    Runtime rt = Runtime.getRuntime();
                    rt.exec("cmd.exe /C start C:\\Users\\99655\\Hello.xls");
                }
                catch(Exception e){}
            }
        });
    }
}
class JTableToExcelFetchData{
    public static void main(String arg[])
    {
        try
        {
            FetchData frame=new FetchData();
            frame.setSize(450,200);
            frame.setVisible(true);
        }
        catch(Exception e)
        {}
    }
}
