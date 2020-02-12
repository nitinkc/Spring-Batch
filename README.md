# Spring-Batch


On Windows
```shell script
docker run -d --name=mysql_learning --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" -v C:\data\mySql\docker_data:/var/lib/mysql -p=3306:3306 mysql
```

On Mac
```shell script
docker run -d --name=mysql_learning --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" -v /Users/nitin/Downloads/docker_data:/var/lib/mysql -p=3306:3306 mysql
```
