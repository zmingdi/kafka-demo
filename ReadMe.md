# kafka consumer group 
## Kafka config

1. start up zookeeper
    1. sh bin/zookeeper-xxxx.sh config/zookeeper.properties
    
2. replicate config/server.properties 
    1. copy server.properties and create server-1.properties,server-2.properties
    2. update properties setting
        1. listeners: PLAINTEXT://10.32.26.20:9090 (set to different values for each instance)
        2. log.dir = tmp-0/kafka.log (set to tmp-1/tmp-2/ for different instances)
        3. broker.id = broker.0(broker.1,broker.2)
        4. advertised.listeners = PLAINTEXT://10.32.26.20:9090 (set to different values for each instance, for public network access)
3. start kafka servers
    1. sh bin/kafka-server-start.sh config/server(-1).properties 
4. create topic 
    1. sh bin/kafka-topic.sh
    2. --bootstrap-server 10.32.26.20:9090,10.32.26.20:9091,10.32.26.20:9092 
    3. --topic test-topic
    4. --create
    5. -partitions 3 (partitions to store the topic data, partition selection done by zookeeper/kafka borker cluster)
    6. replication-factor 2 (replications for each partiion)
5. start up producer
    1. sh bin/kafka-console-producer.sh ---bootstrap-server n1,n2,n3 --topic test-topic

6. update consumer group config and create group
    1. bootstrap-server = n1,n2,n3
    2. group-id=test-group
7. start up consumer group 
    1.sh bin/kafka-console-consumer.sh --bootstrap-server n1,n2,n3 --topic --consumer-config config/consumer.properties

--------------
## Kafka Springboot Integration
### create producer and consumer group    
1. This application is to create a consumer group, with consumer the message from producer once, not a broadcast message. 
To use broadcasting, just connect kafka as a consumer without group setting.
8. create springboot application and import kafka dependencies.
9. create startup configurations with different server.port param:
    1. -Dserver.port=8080
    2. -Dserver.port=8081
    