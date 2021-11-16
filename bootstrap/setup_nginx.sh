sudo yum -y update
sudo amazon-linux-extras install -y java-openjdk11  nginx1

# Install Maven on AMZN-LINUX 2
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven

# kill processes on {PORT} and re-run spring app on that port
# TODO needs better solution: https://stackoverflow.com/questions/17385794/how-to-get-the-process-id-to-kill-a-nohup-process
kill -9 $(lsof -t -i:8080)

cd ../
# Set JAVA 11 for this project
java_11_path=$(update-alternatives --display java | grep 11 | head -n 1 | xargs)

    # is path already set to Java 11?
    if [[ ${java_11_path} == "link currently points to"* ]]; then 
        java_11_path=$(echo "${java_11_path%%* }")
        echo "INFO: ${java_11_path}"
    else
        java_11_path=$(echo "${java_11_path}" | sed -e 's/\s.*$//')
        sudo alternatives --set java $java_11_path
    fi;


# Build Spring App & run in Background
sudo mvn -DskipTests install
sudo nohup java -jar target/df-jspring-brewery-0.0.1-SNAPSHOT.jar &
cd bootstrap/

# Creating Self-signed Certificates
sudo mkdir -p /etc/ssl/private/ && sudo openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/ssl/private/nginx-selfsigned.key -out /etc/ssl/certs/nginx-selfsigned.crt -subj "/C=DE/ST=Bamberg/L=Bamberg/O=Fractiunate/OU=IT/CN=fractiunate.com"

# Config Nginx
sudo mv /etc/nginx /etc/nginx-backup #Backup Config

#sudo mkdir -p /etc/nginx/sites-enabled && sudo cp ./nginx_config /etc/nginx/sites-enabled/default

sudo mkdir -p /usr/local/nginx/logs/
sudo mkdir -p /etc/nginx/ && sudo cp nginx_config /etc/nginx/nginx.conf
sudo mkdir -p /etc/nginx/conf/ && sudo cp mime.types /etc/nginx/conf/mime.types
sudo mkdir -p /etc/nginx/snippets/ && sudo cp ./ssl-params.conf /etc/nginx/snippets/ssl-params.conf

sudo service nginx start

# Not Required on Amzn Linux 2
# sudo ufw allow 'Nginx Full'
# sudo ufw delete allow 'Nginx HTTP'
# sudo ufw status
# sudo service nginx restart
