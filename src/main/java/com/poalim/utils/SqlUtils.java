package com.poalim.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SqlUtils {

	public static void executeSqlScript(Connection conn, File inputFile) {

	    // Delimiter
	    String delimiter = ";";

	    // Create scanner
	    Scanner scanner;
	    try {
	        scanner = new Scanner(inputFile).useDelimiter(delimiter);
	    } catch (FileNotFoundException e1) {
	        e1.printStackTrace();
	        return;
	    }

	    // Loop through the SQL file statements 
	    Statement currentStatement = null;
	    while(scanner.hasNext()) {

	        // Get statement 
	        String rawStatement = scanner.next() + delimiter;
	        try {
	            // Execute statement
	            currentStatement = conn.createStatement();
	            currentStatement.execute(rawStatement);
	            System.out.println(rawStatement);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Release resources
	            if (currentStatement != null) {
	                try {
	                    currentStatement.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            currentStatement = null;
	        }
	    }
	scanner.close();
	}
}
