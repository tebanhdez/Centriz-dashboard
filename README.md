![enter image description here](http://www.ppc-essentials.com/wp-content/uploads/2014/03/Analytics-Dashboard-700x300.jpg)

Centriz Dashboard
===================
A dashboard is "an easy to read, often single page, real-time user interface, showing a graphical presentation of the current status (snapshot) and historical trends of an organization’s or computer appliances key performance indicators to enable instantaneous and informed decisions to be made at a glance.

# Required software
1. Java 1.8
2. Maven 3.3.3
3. Node 6.3.0
4. NPM 3.10
5. Bower 1.7.7
6. PostgreSql 9.5

#Setup the Linux Development Environment

## Purge the Environment
    sudo apt-get purge nodejs npm
    sudo chown -R $USER:$GROUP ~/.npm
    sudo chown -R $USER:$GROUP ~/.config
    sudo apt-get autoremove

## Install Node & NPM
    curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -
    sudo apt-get install -y nodejs

## Setup Database
    CREATE DATABASE centriz;
    CREATE USER centriz PASSWORD 'centriz';
    GRANT ALL PRIVILEGES ON DATABASE centriz to centriz;
    ALTER DATABASE centriz OWNER TO centriz;
# Run the application
## Run Services

    mvn tomcat7:run
>**Note:**
>- The service output is accessible at this URL: [http://localhost:8080/centriz-dashboard-web-service/rest/v1/metric/20160101/20161231](http://localhost:8080/centriz-dashboard-web-service/rest/v1/metric/20160101/20161231)

## Run Client

    cd centriz-dashboard-web-client/
    npm install
    bower install
    gulp serve

---
[www.Pernix-Solutions.com](http://www.pernix-solutions.com)


