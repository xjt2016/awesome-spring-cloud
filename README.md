```shell
scp root@xjt2016.top:/root/elasticsearch-7.0.0-linux-x86_64.tar.gz /Users/xjt2016/Documents/
ServerBootstrap

java -jar /Users/xjt2016/Documents/github/awesome-spring-cloud/awesome-cloud-eureka-server/target/awesome-cloud-eureka-server-1.0-SNAPSHOT.jar --server.port=8761 -Xms64m -Xmx64m

java -jar /Users/xjt2016/Documents/github/awesome-spring-cloud/awesome-cloud-eureka-client/target/awesome-cloud-eureka-client-1.0-SNAPSHOT.jar --server.port=8762 -Xms64m -Xmx64m

java -jar /Users/xjt2016/Documents/github/awesome-spring-cloud/awesome-cloud-eureka-client/target/awesome-cloud-eureka-client-1.0-SNAPSHOT.jar --server.port=8763 -Xms64m -Xmx64m

```


## git multi remote

git remote add github https://github.com/xjt2016/awesome-spring-cloud.git

git push -u github master