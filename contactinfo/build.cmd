mvn spring-boot:build-image
rem docker tag contactinfo:latest localhost:5000/contactinfo:latest
rem docker push localhost:5000/contactinfo:latest
k3d image import -c easysix-cluster contactinfo:latest
kubectl delete pods -l app=contactinfo
