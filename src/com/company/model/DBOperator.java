package com.company.model;

import com.company.data.Team;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBOperator {

   private Connection connection = null;
   private  Statement stmt = null;


    public DBOperator() {
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


        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/worldteams", "postgres",
                    "123");


            connection.setAutoCommit(false);
            setConnection(connection);
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            setStmt(stmt);

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

    private Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    private Statement getStmt() {
        return stmt;
    }

    private void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public void closeDB(){
        try {
            getStmt().close();
            getConnection().close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List getInfoFromDB() {
        try {
            List<Team> teams = new ArrayList<>();
            ResultSet rs = getStmt().executeQuery("SELECT * FROM teams;");

            while (rs.next()) {
                Team team = new Team();
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
                team.setZone(rs.getString("zone"));
                team.setRank(rs.getDouble("rank"));
                team.setChamp(rs.getInt("champ"));
                team.setGold(rs.getInt("gold"));
                team.setSilver( rs.getInt("silver"));
                team.setBronze(rs.getInt("bronze"));
                team.setForce_goal(rs.getDouble("force_goal"));
                team.setForce_def(rs.getDouble("force_def"));
                team.setForce_demi( rs.getDouble("force_demi"));
                team.setForce_att(rs.getDouble("force_att"));
                System.out.println(rs.getInt("id") + " :: " +
                                   rs.getString("name") + " :: " +
                                   rs.getString("zone") + " :: " +
                                   rs.getDouble("rank") + " :: " +
                                   rs.getInt("champ") + " :: " +
                                   rs.getInt("gold") + " :: " +
                                   rs.getInt("silver") + " :: " +
                                   rs.getInt("bronze") + " :: " +
                                   rs.getDouble("force_goal") + " :: " +
                                   rs.getDouble("force_def") + " :: " +
                                   rs.getDouble("force_demi") + " :: " +
                                   rs.getDouble("force_att") + " :: ");
                teams.add(team);
            }

            rs.close();
            getStmt().close();
            return teams;

        } catch (SQLException e) {

        }
        return null;
    }

    public void sendInfoToDB(List<Team> teams){

        try {
            getConnection().setAutoCommit(false);
            stmt = getConnection().createStatement();
            for(Team tm : teams) {
                String sql = "UPDATE teams set rank = " + tm.getRank() + "," +
                        "champ = " + tm.getChamp()+"," +
                        "gold = " + tm.getGold()+"," +
                        "silver = " + tm.getSilver()+"," +
                        "bronze = " + tm.getBronze()+"," +
                        "force_goal = " + tm.getForce_goal()+"," +
                        "force_def = "+ tm.getForce_def() +"," +
                        "force_demi = "+tm.getForce_demi() + "," +
                        "force_att = "+ tm.getForce_att() + " where ID="+ tm.getId() +";";
                stmt.executeUpdate(sql);

            }
            getConnection().commit();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void restartInfoInDB(List<Team> teams){

        try {
            getConnection().setAutoCommit(false);
            stmt = getConnection().createStatement();
            for(Team tm : teams) {
                String sql = "UPDATE teams set rank = 1.0 ," +
                        "champ = 0," +
                        "gold = 0," +
                        "silver = 0," +
                        "bronze = 0," +
                        "force_goal = 1.0," +
                        "force_def = 1.0 ," +
                        "force_demi = 1.0 ," +
                        "force_att = 1.0  where ID="+ tm.getId() +";";
                stmt.executeUpdate(sql);

            }
            getConnection().commit();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}






/*
            ResultSet rs = stmt.executeQuery( "SELECT name FROM teams;" );
            while ( rs.next() ) {
                String name = rs.getString("name");
                System.out.println( "ID = " + name );

                System.out.println();
            }
            rs.close();
             stmt.close();
            connection.close();

*/



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

                String stm = "INSERT INTO teams(id, name, zone, rank, champ, gold, silver," +
                        " bronze, force_goal, force_def, force_demi, force_att, number) VALUES(" + (int)row.getCell(0).getNumericCellValue()+"," +"\'"+ row.getCell(1).getStringCellValue() +"\'" +
                        "," +"\'" + row.getCell(2).getStringCellValue()+"\'" +
                        "," + (int)row.getCell(3).getNumericCellValue()+ "," + (int)row.getCell(4).getNumericCellValue() +
                "," + (int)row.getCell(5).getNumericCellValue() + "," + (int)row.getCell(6).getNumericCellValue() +"," + (int)row.getCell(7).getNumericCellValue() +
                        "," + row.getCell(8) + "," + row.getCell(9) + "," + row.getCell(10) + "," + row.getCell(11) + "," + (int)row.getCell(12).getNumericCellValue() + ");";

                System.out.println(stm);
                stmt.executeUpdate(stm);

            }
            stmt.close();
            connection.commit();
            connection.close();
*/




