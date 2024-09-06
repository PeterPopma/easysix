mvn spring-boot:build-image
rem docker tag domaincreate:latest localhost:5000/domaincreate:latest
rem docker push localhost:5000/domaincreate:latest
k3d image import -c easysix-cluster domaincreate:latest
kubectl delete pods -l app=domaincreate
