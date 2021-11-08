sudo apt update
sudo apt install maven nginx



# kill processes on {PORT} and re-run spring app on that port
# TODO needs better solution: https://stackoverflow.com/questions/17385794/how-to-get-the-process-id-to-kill-a-nohup-process
kill -9 $(lsof -t -i:8080)

# Build Spring App & run in Background
mvn -DskipTests install
nohup java -jar target/df-jspring-brewery-0.0.1-SNAPSHOT.jar &

# Creating Self-signed Certificates
sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/ssl/private/nginx-selfsigned.key -out /etc/ssl/certs/nginx-selfsigned.crt

# Config Nginx
sudo service nginx start
sudo cp ./nginx_config /etc/nginx/sites-enabled/default
sudo cp ./ssl-params.conf /etc/nginx/snippets/ssl-params.conf

sudo ufw allow 'Nginx Full'
sudo ufw delete allow 'Nginx HTTP'
sudo ufw status


sudo service nginx restart
