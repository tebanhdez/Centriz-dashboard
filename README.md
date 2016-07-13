# Centriz Dashboard
---
The application is a dashboard where they can be displayed graphically and ordered the information collected.

## Required software
1. Maven 10.10.5 
x
2. Bower 1.7.7
3. Java 1.8
4. Postgres 9.5
5. Heroku toolbet

## Setup the Development Environment
  
### Fix Permissions in Config Files
sudo chown -R $USER:$GROUP ~/.npm
sudo chown -R $USER:$GROUP ~/.config

### Install Node & npm

sudo apt-get purge nodejs npm
sudo apt-get autoremove
curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash -
sudo apt-get install -y nodejs

m@Narasimha:~$ node -v
v6.3.0

m@Narasimha:~$ npm -v
3.10.3

### Run Client
cd centriz-dashboard-web-client/
npm install
bower install
gulp serve


# Setup

## Create database in postgres
`CREATE DATABASE centriz;`

## Create user
`CREATE USER centriz PASSWORD 'centriz';`

## Set privileges
`GRANT ALL PRIVILEGES ON DATABASE centriz to centriz;`

## Change database owner
`ALTER DATABASE centriz OWNER TO centriz;`

## Build the project
### Compile java project
Open the terminal  
Go to the project folder `cd path/to/Centriz-dashboard`  
Execute `mvn clean install`

### Add AngularJS dependencies
Go to webapp folder `cd path/to/Centriz-dashboard/src/main`  
Execute `npm install`  
Execute `bower install`  

# Run the application
## Run in unix systems
Excecute `heroku local`  
Open your browser and go to http://localhost:5000

## Run in windows
Excecute `heroku local web -f Procfile.windows`  
Open your browser and go to http://localhost:5000

---
#### [www.Pernix-Solutions.com](http://www.pernix-solutions.com)


