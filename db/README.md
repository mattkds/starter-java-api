# 🐘 Local setup for PostgreSQL instance with Docker
The following steps permits to launch a local environment and a local postgreSQL Database corresponding to this project

For a first installation or for a complete reinstallation of the mount database, don't forget to delete the local postgres-data folder in this repository

If there is an existing instance of database running, stop and delete the existing containers

```
docker container ls 
```
Stop the containers

```
docker stop $(docker container ls -q)
```

Delete the containers

```
docker rm $(docker volume ls -q)
```
Delete the corresponding volume if the needs be
```
docker volume rm $(docker volume ls -q)
```
Start the database
```
docker-compose up -d
```

## Data Modeling
<div align="center">
<br>
<img src="./assets/sakila.png" alt="mld">
<br>
<br>
</div>
