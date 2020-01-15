package com.rackroom.cpi.dbtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbtestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DbtestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
      Connection con = null;
      PreparedStatement pst = null;
      ResultSet rs = null;
      
      try {

          con = DataSource.getConnection();
          pst = con.prepareStatement("SELECT * FROM Cars");
          rs = pst.executeQuery();

          while (rs.next()) {

              System.out.format("%d %s %d %n", rs.getInt(1), rs.getString(2), 
                      rs.getInt(3));
          }

      } catch (SQLException ex) {


          System.err.println(ex.getMessage());

      } finally {

          try {
          
              if (rs != null) {
                  rs.close();
              }
              
              if (pst != null) {
                  pst.close();
              }
              
              if (con != null) {
                  con.close();
              }
              
              

          } catch (SQLException ex) {

              System.err.println(ex.getMessage());
          }
      }
	}

}
