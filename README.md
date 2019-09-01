# transactions


Initial commit: Wed, 29.08.2019

PreReqs:

    1) Create Kafka topic: 
    kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic transactions
    2) Create db schema (Oracle):
    
    spring.jpa.hibernate.ddl-auto=update -> it will automatically create db schema after a valid connection is provided in applcation.properties
    
    
 
 More details in readm.pptx
