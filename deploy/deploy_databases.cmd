helm install contact-db -f contact-db/values.yaml bitnami/postgresql
kubectl apply -f contact-db/flyway-job.yaml