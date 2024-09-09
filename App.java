package com.shazia.Assessment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Hello World!");
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","Shazia");
		Statement stmt = con.createStatement();
   System.out.println("hello");
   String sql="SELECT * FROM employee";
      ResultSet rs=stmt.executeQuery(sql);
      
     XSSFWorkbook workbook=new XSSFWorkbook();
     XSSFSheet sheet=workbook.createSheet("Employee Data");
     XSSFRow row=(XSSFRow)sheet.createRow(0);
     
     XSSFCell cell0= row.createCell(0); 
     cell0.setCellValue("EmployeeId");
     
    XSSFCell cell1=(XSSFCell) row.createCell(1); 
     cell1.setCellValue("firstName");
     
     XSSFCell cell2=(XSSFCell) row.createCell(2); 
     cell2.setCellValue("lastName");
     
     XSSFCell cell3=(XSSFCell) row.createCell(3); 
     cell3.setCellValue("email");
     
     XSSFCell cell4=(XSSFCell) row.createCell(4); 
     cell4.setCellValue("phoneNumber");
     
     XSSFCell cell5=(XSSFCell) row.createCell(5); 
     cell5.setCellValue("hireDate");
     
     XSSFCell cell6=(XSSFCell) row.createCell(6); 
     cell6.setCellValue("managerId");
     
     XSSFCell cell7=(XSSFCell) row.createCell(7); 
     cell7.setCellValue("salary");
     int r=1;
     
     while(rs.next())
     {
    	int    Emp_Id =  rs.getInt(1);
    	String firstName= rs.getString(2);
    	String lastName= rs.getString(3);
    	String email= rs.getString(4);
    	int    phone_no =  rs.getInt(5);
    	Date   hireDate=rs.getDate(6);
    	int    managerId =  rs.getInt(7);
        String salary= rs.getString(8);
        row = sheet.createRow(r++);
 
      
       ((XSSFCell) row.createCell(0)).setCellValue(Emp_Id);
       ((XSSFCell) row.createCell(1)).setCellValue(firstName);
       ((XSSFCell) row.createCell(2)).setCellValue(lastName);
       ((XSSFCell) row.createCell(3)).setCellValue(email);
       ((XSSFCell) row.createCell(4)).setCellValue(phone_no);
       ((XSSFCell) row.createCell(5)).setCellValue(hireDate);
       ((XSSFCell) row.createCell(6)).setCellValue(managerId);
       ((XSSFCell) row.createCell(7)).setCellValue(salary);
         }
     FileOutputStream fos = new FileOutputStream("employee.xlsx");
     
     workbook.write(fos);
     workbook.close();
     fos.close();
     
        con.close();
        System.out.println("Finish!!!");

     
     
 

    }
}
