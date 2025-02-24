kubectl apply -f k8s
helm uninstall organization
helm install organization bitnami/postgresql -f values.yml

# one time 
docker pull flyway/flyway:10
k3d image import -c easysix-cluster flyway/flyway:10

# useful commands
$secret = kubectl get secret --namespace default organization-postgresql -o jsonpath="{.data.postgres-password}"
$decodedPassword = [System.Text.Encoding]::UTF8.GetString([System.Convert]::FromBase64String($secret))
$env:DOMAIN_POSTGRES_PASSWORD = $decodedPassword
kubectl delete secret organization-postgres-secret
kubectl create secret generic organization-postgres-secret --from-literal=organization-postgres-password=$env:DOMAIN_POSTGRES_PASSWORD
kubectl run organization-postgresql-client --rm --tty -i --restart='Never' --namespace default --image docker.io/bitnami/postgresql:16.4.0-debian-12-r0 --env="PGPASSWORD=$DOMAIN_POSTGRES_PASSWORD" --command -- psql --host registry-postgresql -U postgres -d postgres -p 5432
gci env:
kubectl port-forward --namespace default svc/organization-postgresql 54320:5432
