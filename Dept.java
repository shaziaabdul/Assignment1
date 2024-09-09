package com.shazia.Assessment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dept {
 static void run() throws ClassNotFoundException, SQLException, IOException {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","Shazia");
			Statement stmt = con.createStatement();
	   System.out.println("back");
	   String sql="SELECT * FROM department";
	      ResultSet rs=stmt.executeQuery(sql);

	XSSFWorkbook workbook=new XSSFWorkbook();
    XSSFSheet sheet=workbook.createSheet("Department Data");
    XSSFRow row=(XSSFRow)sheet.createRow(0);
    
    XSSFCell cell0= row.createCell(0); 
    cell0.setCellValue("DepartmentId");
    
   XSSFCell cell1=(XSSFCell) row.createCell(1); 
    cell1.setCellValue("DepartmentName");
    
         int r=1;
    
    while(rs.next())
   {
   	int    Dept_Id =  rs.getInt(1);
   	String DeptName= rs.getString(2);
   	     row = sheet.createRow(r++);

     ((XSSFCell) row.createCell(0)).setCellValue(Dept_Id);
      ((XSSFCell) row.createCell(1)).setCellValue(DeptName);
   }
    FileOutputStream fos = new FileOutputStream("department.xlsx");
    
    workbook.write(fos);
    workbook.close();
    fos.close();
    
       con.close();
       System.out.println("over");
          
}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		run();
	}
}




