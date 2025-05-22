REM CALL mvn -f api-gateway-spring-cloud/pom.xml spring-boot:build-image
CALL mvn -f contactquery/pom.xml spring-boot:build-image
CALL mvn -f contactcommand/pom.xml spring-boot:build-image
CALL mvn -f domainquery/pom.xml spring-boot:build-image
CALL mvn -f domaincommand/pom.xml spring-boot:build-image
CALL mvn -f domaintransfer/pom.xml spring-boot:build-image
CALL mvn -f eppconverter/pom.xml spring-boot:build-image
CALL mvn -f hostquery/pom.xml spring-boot:build-image 
CALL mvn -f hostcommand/pom.xml spring-boot:build-image 
CALL mvn -f organizationquery/pom.xml spring-boot:build-image 
CALL mvn -f organizationcommand/pom.xml spring-boot:build-image
