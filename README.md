# Centriz Dashboard
---
The application is a dashboard where they can be displayed graphically and ordered the information collected.

## Required software
1. Maven 10.10.5 
2. Bower 1.7.7
3. Java 1.8
4. Postgres
5. Heroku toolbet

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

---
#### [www.Pernix-Solutions.com](http://www.pernix-solutions.com)
