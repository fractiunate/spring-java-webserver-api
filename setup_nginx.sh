sudo apt update
sudo apt install maven nginx

# Build Spring App & run in Background
mvn -DskipTests install

# kill processes on {PORT} and re-run spring app on that port
kill -9 $(lsof -t -i:8080)
nohup java -jar target/df-jspring-brewery-0.0.1-SNAPSHOT.jar &

# Creating Self-signed Certificates
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/ssl/private/nginx-selfsigned.key -out /etc/ssl/certs/nginx-selfsigned.crt

# Config Nginx
sudo service nginx start
sudo cp ./nginx_config /etc/nginx/sites-enabled/default
sudo service nginx restart
