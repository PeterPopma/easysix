mvn spring-boot:build-image
rem docker tag hostcommand:latest localhost:5000/hostcommand:latest
rem docker push localhost:5000/hostcommand:latest
k3d image import -c easysix-cluster hostcommand:latest
kubectl delete pods -l app=hostcommand
