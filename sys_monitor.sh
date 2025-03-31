#날짜
TIMESTAMP=$(date "+%Y-%m-%d %H:%M:%S")

#리소스 데이터 수집
CPU_USAGE=$(top -bn1 | grep "Cpu(s)" | awk '{ printf "%.1f", $2 + $4 }')
MEM_USAGE=$(free -m | awk 'NR==2{ printf "%s", $3 }')
DISK_USAGE=$(df -h / | awk 'NR==2{ printf "%s", $5}' | sed 's/%//')

#로그 기록
echo "$TIMESTAMP, CPU: $CPU_USAGE%, MEM: $MEM_USAGE MiB, DISK: $DISK_USAGE%" >> /root/server_monitoring/log/sys_monitor.log
