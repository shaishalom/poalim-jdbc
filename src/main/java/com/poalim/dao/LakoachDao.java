package com.poalim.dao;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poalim.bean.LakoachTnuaaVO;
import com.poalim.utils.SqlUtils;
import com.poalim.utils.Utils;

public class LakoachDao {

	public List<LakoachTnuaaVO> fetchLakoachAccounts(Long lakoachId) throws ClassNotFoundException {

		
		String firstdateInMonth = Utils.getFirstDateInCurMonthAndYear();
		String lastdateInMonth = Utils.getLastDateInCurMonthAndYear();
	
		int result = 0;
		String sql = "Select sum(amount) amount,esek,ccno,lakoach.id id, lakoach.name name " + " From lakoach,tnuot  "
				+ " Where lakoach.id = tnuot.id  " + "and tnuot.transaction_date >= ? and tnuot.transaction_date <= ? ";
				if (lakoachId!=null) {
					sql= sql + " and lakoach.id = ? ";
				}
							
				sql= sql+ " Group by esek,ccno,lakoach.id, lakoach.name ";

		Class.forName("org.h2.Driver");
		createTablesForIniit();

		LakoachTnuaaVO lakoachTnuaaVO = null;
		List<LakoachTnuaaVO> lakoachTnuaaList = new ArrayList<LakoachTnuaaVO>(); 
		
		try (Connection connection = DriverManager.getConnection("jdbc:h2:file:C:/temp/lakoachTnuot;MV_STORE=FALSE",
				"sa", "");

				// Step 2:Create a statement using connection object
				PreparedStatement ps = connection.prepareStatement(sql)){
				ps.setString(1, firstdateInMonth);
				ps.setString(2, lastdateInMonth);
				if (lakoachId!=null) {
					ps.setLong(3, lakoachId);
				}
				
//				) {
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				double amount = rs.getDouble("amount");
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String ccno = rs.getString("ccno");
				String esek = rs.getString("esek");

				lakoachTnuaaVO = new LakoachTnuaaVO(id, name, amount, esek, ccno);
				lakoachTnuaaList.add(lakoachTnuaaVO);

			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// process sql exception
			printSQLException(e);
		} finally {

		}
		return lakoachTnuaaList;
	}

	public void createTablesForIniit() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:file:C:/temp/lakoachTnuot;MV_STORE=FALSE", "sa", "");

			URL url = this.getClass().getClassLoader().getResource("data.sql");
			File inputFile = new File(url.toURI());
			
			//File inputFile = new File("C:/temp/data.sql");
			SqlUtils.executeSqlScript(con, inputFile);
			con.close();
			System.out.println("tables are created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}