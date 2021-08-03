mvn clean install -Dmaven.test.skip=true
docker-compose down
docker-compose up -d --build
docker cp D:\GitHub\activemq\override\jetty-realm.properties activemq_activemq_1:/opt/apache-activemq-5.15.6/conf/jetty-realm.properties