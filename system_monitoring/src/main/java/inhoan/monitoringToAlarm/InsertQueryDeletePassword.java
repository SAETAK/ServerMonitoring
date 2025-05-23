package inhoan.monitoringToAlarm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQueryDeletePassword {
	private final String mariadbUrl = "jdbc:mariadb://localhost:3306/server_monitoring";
	private final String mariadbUser = "root";
	private final String mariadbPassword = "password";

	public void insert(float cpu, int mem, int disk, String timestamp) {
		String insertQuery = "INSERT IGNORE INTO server_stats (cpu_usage, mem_usage, disk_usage, timestamp) VALUES (?, ?, ?, ?)";

		try (
		      Connection conn = DriverManager.getConnection(mariadbUrl, mariadbUser, mariadbPassword);
		      PreparedStatement pstmt = conn.prepareStatement(insertQuery)
		    ) {
			pstmt.setFloat(1, cpu);
			pstmt.setInt(2, mem);
			pstmt.setInt(3, disk);
			pstmt.setString(4, timestamp);
			pstmt.executeUpdate();
			
		    } catch (SQLException exception) {
			    exception.printStackTrace();
		    }
	}
}

