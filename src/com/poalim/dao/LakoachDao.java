package com.poalim.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.h2.jdbcx.JdbcDataSource;

//import org.h2.jdbcx.JdbcDataSource;

import com.poalim.bean.LakoachTnuaaVO;

public class LakoachDao {

	public List<LakoachTnuaaVO> fetchLakoachAccounts() throws ClassNotFoundException {

		int result = 0;
		String sql = "Select sum(amount) amount,esek,ccno,lakoach.id id, lakoach.name name " + " From lakoach,tnuot  "
				+ " Where lakoach.id = tnuot.id  " + " and tnuot.transaction_date >= '2020-09-01' "
				+ " Group by esek,ccno,lakoach.id, lakoach.name ";

		// Class.forName("com.mysql.jdbc.Driver");

		//JdbcDataSource ds = new JdbcDataSource();
		String url = "jdbc:h2:mem:";
		// ds.setURL("jdbc:h2:file:C:/temp/lakoachTnuot");
		// ds.setUser("sa");
		// ds.setPassword("sa");
//        try {
//            Connection conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }	

		LakoachTnuaaVO lakoachTnuaaVO = null;
		List<LakoachTnuaaVO> lakoachTnuaaList = new ArrayList<LakoachTnuaaVO>();
		try (Connection connection = DriverManager.getConnection(url);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			// preparedStatement.setString(1, "2020-09-01");

			// System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery(sql);

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
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			// process sql exception
			printSQLException(e);
		} finally {
			lakoachTnuaaVO = new LakoachTnuaaVO(1L, "shai", new Double(100.0), "stam1", "1234");
			lakoachTnuaaList.add(lakoachTnuaaVO);
			lakoachTnuaaVO = new LakoachTnuaaVO(2L, "shai2", new Double(200.0), "stam1", "1234");
			lakoachTnuaaList.add(lakoachTnuaaVO);

		}
		return lakoachTnuaaList;
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