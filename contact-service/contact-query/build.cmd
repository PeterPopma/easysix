mvn spring-boot:build-image
rem docker tag contactcommand:latest localhost:5000/contactcommand:latest
rem docker push localhost:5000/contactcommand:latest
k3d image import -c easysix-cluster contactcommand:latest
kubectl delete pods -l app=contactcommand
