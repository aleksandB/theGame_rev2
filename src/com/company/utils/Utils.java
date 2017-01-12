package com.company.utils;

import java.sql.*;

import com.company.data.Team;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.postgresql.Driver;

import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by user on 29.11.2016.
 */
public class Utils {




    public static void main(String[] args) {
        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");


        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;
        Statement stmt = null;


        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/worldteams", "postgres",
                    "123");


            connection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT name FROM teams;" );
            while ( rs.next() ) {
                String name = rs.getString("name");
                System.out.println( "ID = " + name );

                System.out.println();
            }
            rs.close();
            stmt.close();
            connection.close();


//add items in table
            /*
            stmt = connection.createStatement();
            InputStream ExcelFileToRead = new FileInputStream("D:/Java/theGame/book1.xls");
            HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
            HSSFSheet sheet=wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext())
            {
                row=(HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                String stm = "INSERT INTO teams(id, name, zone, rank, score_1, score_2, score_3, score_4, champ, gold, silver," +
                        " bronze, force_goal, force_def, force_demi, force_att) VALUES(" + (int)row.getCell(0).getNumericCellValue()+"," +"\'"+ row.getCell(1).getStringCellValue() +"\'" +
                        "," +"\'" + row.getCell(2).getStringCellValue()+"\'" +
                        "," + (int)row.getCell(3).getNumericCellValue()+ "," + (int)row.getCell(4).getNumericCellValue()+ "," + (int)row.getCell(5).getNumericCellValue()+
                        "," + (int)row.getCell(6).getNumericCellValue()+ "," + (int)row.getCell(7).getNumericCellValue() + "," + (int)row.getCell(8).getNumericCellValue() +
                "," + (int)row.getCell(9).getNumericCellValue() + "," + (int)row.getCell(10).getNumericCellValue() +"," + (int)row.getCell(11).getNumericCellValue() +
                        "," + row.getCell(12) + "," + row.getCell(13) + "," + row.getCell(14) + "," + row.getCell(15) + ")";
                System.out.println(stm);
                stmt.executeUpdate(stm);
                System.out.println();
            }
*/




        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }


    }


}