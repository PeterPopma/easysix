mvn spring-boot:build-image
rem docker tag domaincommand:latest localhost:5000/domaincommand:latest
rem docker push localhost:5000/domaincommand:latest
k3d image import -c easysix-cluster domaincommand:latest
kubectl delete pods -l app=domaincommand
