CALL mvn -f api-gateway/pom.xml spring-boot:build-image
CALL mvn -f contactcreate/pom.xml spring-boot:build-image
CALL mvn -f contactdelete/pom.xml spring-boot:build-image
CALL mvn -f contactinfo/pom.xml spring-boot:build-image
CALL mvn -f contactupdate/pom.xml spring-boot:build-image
CALL mvn -f domaincreate/pom.xml spring-boot:build-image
CALL mvn -f domaindelete/pom.xml spring-boot:build-image
CALL mvn -f domaininfo/pom.xml spring-boot:build-image 
CALL mvn -f domainupdate/pom.xml spring-boot:build-image 

k3d image import -c easysix-cluster api-gateway:latest
k3d image import -c easysix-cluster contactinfo:latest
k3d image import -c easysix-cluster contactcreate:latest
k3d image import -c easysix-cluster contactupdate:latest
k3d image import -c easysix-cluster contactdelete:latest
k3d image import -c easysix-cluster domaininfo:latest
k3d image import -c easysix-cluster domaincreate:latest
k3d image import -c easysix-cluster domainupdate:latest
k3d image import -c easysix-cluster domaindelete:latest
