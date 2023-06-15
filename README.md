# mvcjpathymleaf
This project using undertow instead tomcat

# Run Docker command
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=student_db mysql

# Install Maven Package
mvn clean install
mvn spring-boot:run

# handle setup issue with inteliJ
Try to reload the Maven configuration file