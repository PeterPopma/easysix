mvn spring-boot:build-image
rem docker tag organizationcommand:latest localhost:5000/organizationcommand:latest
rem docker push localhost:5000/organizationcommand:latest
k3d image import -c easysix-cluster organizationcommand:latest
kubectl delete pods -l app=organizationcommand
