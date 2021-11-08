sudo yum -y update
sudo amazon-linux-extras install -y java-openjdk11  nginx1.12

# Install Maven on AMZN-LINUX 2
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven

# kill processes on {PORT} and re-run spring app on that port
# TODO needs better solution: https://stackoverflow.com/questions/17385794/how-to-get-the-process-id-to-kill-a-nohup-process
kill -9 $(lsof -t -i:8080)

cd ../
# Build Spring App & run in Background
sudo  mvn -DskipTests install
sudo nohup java -jar target/df-jspring-brewery-0.0.1-SNAPSHOT.jar &
cd bootstrap/

# Creating Self-signed Certificates
sudo mkdir -p /etc/ssl/private/ && sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/ssl/private/nginx-selfsigned.key -out /etc/ssl/certs/nginx-selfsigned.crt -subj "/C=DE/ST=Bamberg/L=Bamberg/O=Fractiunate/OU=IT/CN=fractiunate.com"

# Config Nginx
mv /etc/nginx /etc/nginx-backup #Backup Config
sudo service nginx start
sudo mkdir -p /etc/nginx/sites-enabled && cp ./nginx_config /etc/nginx/sites-enabled/default
sudo mkdir -p /etc/nginx/snippets/ && cp ./ssl-params.conf /etc/nginx/snippets/ssl-params.conf

# Not Required on Amzn Linux 2
# sudo ufw allow 'Nginx Full'
# sudo ufw delete allow 'Nginx HTTP'
# sudo ufw status


sudo service nginx restart
