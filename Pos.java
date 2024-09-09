package com.shazia.Assessment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Pos {
	static void start() throws SQLException, ClassNotFoundException, IOException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_details","root","Shazia");
	Statement stmt = con.createStatement();
System.out.println("success");
String sql="SELECT * FROM position";
  ResultSet rs=stmt.executeQuery(sql);

XSSFWorkbook workbook=new XSSFWorkbook();
XSSFSheet sheet=workbook.createSheet("Position Data");
XSSFRow row=(XSSFRow)sheet.createRow(0);

XSSFCell cell0= row.createCell(0); 
cell0.setCellValue("positionId");

XSSFCell cell1=(XSSFCell) row.createCell(1); 
cell1.setCellValue("title");

XSSFCell cell2=(XSSFCell) row.createCell(2); 
cell2.setCellValue("description");

int r=1;

while(rs.next())
{
int    Pos_Id =  rs.getInt(1);
String title= rs.getString(2);
String description= rs.getString(3);
       row = sheet.createRow(r++);

    ((XSSFCell) row.createCell(0)).setCellValue(Pos_Id);
    ((XSSFCell) row.createCell(1)).setCellValue(title);
    ((XSSFCell) row.createCell(2)).setCellValue(description);
}
FileOutputStream fos = new FileOutputStream("position.xlsx");

workbook.write(fos);
workbook.close();
fos.close();

            con.close();
          System.out.println("complete");
}

public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		start();
   }
}
