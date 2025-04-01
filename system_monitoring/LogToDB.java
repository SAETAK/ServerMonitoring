import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogToDB {
	public static void main(String[] args) {
		String mariadbUrl = "jdbc:mariadb://localgost:3306/server_monitoring";
		String mariadbUser = "root";
		String mariadbPassword = "57878";
		String logFile = "/root/server_monitoring/log/sys_monitor.log";
	}
}
