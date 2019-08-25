# Google Analytic like Backend System

## Architecture

[Micro Service] —>[FluentD] —> [Data Lake: Apache Kafka] —>[ETL processing: Apache Flink]—> [Data Warehouse: Cassandra] ―>[User Application]
file:///Users/xuxiaoshuang/git/SoftwareEngineerChallenge/Q2/design.png

### Micro Service
Use a micro service like a dockerized application in Kubernetes cluster to let paypay users send their requests.

#FluentD
Use FluentD to process large number of events from the micro service, sending them into Apache Kafka.

### Data Lake: Apache Kafka
To process all of the raw data. The data from client will be send to Apache Kafka.

### ETL Processing: Apache Flink
Use Apache Flink to consume raw data from Kafka. 	
Then Apache Link perform streaming ETL processing to load transformed data to data warehouse.

### Data Warehouse: Cassandra
Apache Cassandra can be used as a data warehouse to accept the transformed data. It can be processed well for high volume data with minimum downtime.

### User Application
Have a web application to send user data to application layer.