package it.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Die HSQLDB Datenbank kann �ber eine mitgelieferte Client-Software angeschaut werden. 
 * Einfach org.hsqldb.util.DatabaseManagerSwing aus der hsqldb.jar ausf�hren.
 * 
 * @author Grauschleier
 *
 */
public class HSqlDbConnection {
	public static void main(String[] args) throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:hsqldb:file:testdb", "SA", "");
		PreparedStatement ps = c.prepareStatement("CREATE TABLE mytable ( myfield VARCHAR(20) );");
		ps.executeUpdate();
		c.close();
	}
}
