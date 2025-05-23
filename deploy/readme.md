This is a microservices implementation of a Domain Registry System.
It uses a REST api for handling requests (EPP protocol could be supported by a separate EPP<->REST module) 

Usage:
- build the containers with mvn spring-boot:build-image
- create a local kubernetes cluster:
   * k3d cluster create easysix-cluster --api-port 6443 -p "8081:80@loadbalancer" --agents 0
   * minikube -p easysix-cluster start
- make the containers available to the new cluster

  option 1:
  - create a local registry: docker run -d -p 5000:5000 --restart=always --name local-registry registry:latest
  - push your images to the registry: 
  docker tag [image]:latest localhost:5000/[image]:latest
  docker push localhost:5000/[image]:latest

  option 2:
  - 

- Apply all the .yml from the k8s directories.

- minikube start / k3d cluster start easysix-cluster
- minikube service spring-cloud-gateway --url

- in another window, or rest client, request the uri output bij minikube, appended by for example /domain/domain/peter.nl
- See api-mapping for a list of API endpoints.


create cluster:

k3d cluster delete easysix-cluster
k3d cluster create easysix-cluster -p "8081:80@loadbalancer" --agents 0 --volume C:\k3d-storage\contactdb:/mnt/data/contactdb --volume C:\k3d-storage\hostdb:/mnt/data/hostdb --volume C:\k3d-storage\organizationdb:/mnt/data/organizationdb --volume C:\k3d-storage\domaindb:/mnt/data/domaindb
k3d cluster stop easysix-cluster   
kubectl delete pv --all --grace-period=0 --force
k3d cluster start easysix-cluster   
k3d image import -c easysix-cluster api-gateway:latest
kubectl get pods -n kube-system
kubectl logs -n kube-system traefik-64f55bb67d-wv4v2
kubectl exec -it pod/domaintransfer-68cf9d8cb5-8nwzm -- printenv
