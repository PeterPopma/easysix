mvn spring-boot:build-image
rem docker tag api-gateway:latest localhost:5000/api-gateway:latest
rem docker push localhost:5000/api-gateway:latest
k3d image import -c easysix-cluster api-gateway:latest
kubectl delete pods -l app=api-gateway
