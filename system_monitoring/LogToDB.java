import java.io.*;
import java.sql.*;

public class LogToDB {
	public static void main(String[] args) {
		String mariadbUrl = "jdbc:mariadb://localgost:3306/server_monitoring";
		String mariadbUser = "root";
		String mariadbPassword = "57878";
		String logFile = "/root/server_monitoring/log/sys_monitor.log";
	}
}
