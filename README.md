### Kotlin
StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9093")

### Bash

### List topics
./kafka-topics.sh --list --zookeeper zookeeper-1:2181

### Producing input is berichten
./kafka-console-producer.sh --topic berichten --broker-list localhost:9092

### Consuming output is mutaties
./kafka-console-consumer.sh --topic mutaties --bootstrap-server localhost:9092 --offset earliest --partition 0