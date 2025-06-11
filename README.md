# Apache Kafka Setup on Windows (with Zookeeper)
**You have now set up a local Kafka environment, created a topic, and sent/received messages using producer and consumer terminals. Kafka is now ready to be integrated into your microservices or data streaming pipelines.**
This guide walks you through the process of downloading, installing, and running Apache Kafka and Zookeeper on a Windows environment using command-line tools.

---

**## 🧰 Prerequisites
- Java JDK 8 or later
- Git Bash or PowerShell (for running shell/batch scripts)
- [Download Kafka](https://kafka.apache.org/downloads#)  
  Select: **Kafka 3.9.1 with Scala 2.12**  
  File: `kafka_2.12-3.9.1.tgz`

---

## 📦 Step 1: Install Kafka

1. Download and extract Kafka:
   - Extract the `kafka_2.12-3.9.1.tgz` file to a folder like `C:\Users\<YourName>\kafka`.

2. Navigate to your Kafka folder:
   ```bash
   cd C:\Users\<YourName>\kafka
**Step 2: Start Kafka Environment**

3. Start Zookeeper
  ```bash
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

4. Start Kafka Broker
  ```bash
.\bin\windows\kafka-server-start.bat .\config\server.properties

5.**** 🛠️ Kafka Topic Operations**
  ```bash
.\bin\windows\kafka-topics.bat --create --topic topic-example --bootstrap-server localhost:9092

6.**✍️ Produce Events (Send messages)**
  ```bash
.\bin\windows\kafka-console-producer.bat --topic topic-example --bootstrap-server localhost:9092
>hello world
>demo1
>demo2
7.**📥 Consume Events (Read messages)**
  ```bash
.\bin\windows\kafka-console-consumer.bat --topic topic-example --from-beginning --bootstrap-server localhost:9092

**Expected output:**
hello world
demo1
demo2

**To run on Git Bash:**
  ```bash
./bin/zookeeper-server-start.sh config/zookeeper.properties
  ```bash
./bin/kafka-server-start.sh config/server.properties




