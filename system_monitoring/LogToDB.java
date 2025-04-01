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

		try (
			BufferedReader bufferedReader = new BufferedReader(new FileReader(logFile));
			Connection conn = DriverManager.getConnection(mariadbUrl, mariadbUser, mariadbPassword)
		    ) {
			String str;
			while ((str = bufferedReader.readLine()) != null) {
				String[] data = str.split(", ");
				
				//CPU 사용률 문자열로 자르기
				String cpuStr = data[1].split(": ")[1];
				cpuStr = cpuStr.replace("%", "");
				float cpuUsage = Float.parseFloat(cpuStr);

				//메모리 사용률 문자열로 자르기
				String memStr = data[2].split(": ")[1];
				memStr = memStr.replace(" MiB", "");
				int memUsage = Integer.parseInt(memStr);

				//Disk 사용률 문자열로 자르기
				String diskStr = data[3].split(": ")[1];
				diskStr = diskStr.replace("%", "");
				int diskUsage = Integer.parseInt(diskStr);

				//시간정보
				String timestamp = data[0];
			}
		    }
	}
}
