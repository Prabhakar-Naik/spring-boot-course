package com.spring.boot.course.content;

public class SpringBootKafka {

    // What is KAFKA ?

    /*
        Apache Kafka is an open-source distributed event streaming platform designed
        to handle high-throughput, low-latency data streams.

        Kafka is a distributed event streaming platform primarily used for building
        real-time data pipelines and streaming applications. It allows you to publish,
        subscribe to, store, and process streams of records (messages or events) in a
        fault-tolerant, scalable, and high-throughput manner.

        Kafka is designed to handle data that is constantly being generated and needs
        to be processed as it comes in, without delays.

        Here are some key aspects of Kafka:

        Messaging System:
        Kafka works as a publish-subscribe messaging system, allowing
        applications to communicate by producing and consuming messages (or events).

        Event Streaming:
        Kafka is designed to handle streams of data, meaning it can
        process events in real-time as they occur.

        Topics and Partitions:
        In Kafka, data is categorized into topics, and each
        topic can be further divided into partitions for scalability and performance.
        Producers publish messages to a topic, and consumers read from it.

        Durability:
        Kafka retains messages for a configurable period, even after they’ve been
        consumed, which allows consumers to process the same messages at different times.

        Scalability:
        Kafka can handle large volumes of data and scale horizontally by
        adding more brokers to the cluster.

        Kafka is widely used in scenarios like log aggregation, real-time analytics,
        monitoring, and stream processing applications. It is highly adopted in modern
        architectures like microservices and event-driven systems.

    */

    // Process of Kafka
    /*
    Key Concepts:
        Apache Kafka is a distributed streaming platform designed to handle the ingestion,
        processing, and delivery of high-volume, real-time data streams.

        Producers: Applications that publish data to Kafka topics.
        Topics: Categorized streams of records within Kafka.
                Each message is assigned to a specific topic
        Partitions: Each topic is divided into partitions, which are ordered sequences
                    of records. This allows for high throughput and parallel processing.
        Brokers: Servers that store and process data within a Kafka cluster.
        Consumers: Applications that subscribe to topics and consume the published data
        Consumers Groups: Groups of consumers that share a subscription to a topic.
                  Each message in a partition is typically delivered to only one
                  consumer within a consumer group, ensuring that messages are
                  processed only once.

     Key Features:
        High Throughput: Kafka can handle massive volumes of data streams with
                         extremely high throughput
        Scalability: Kafka clusters can be easily scaled horizontally by adding
                     more brokers to the cluster
        Fault Tolerance: Data is replicated across multiple brokers, ensuring high
                         availability and fault tolerance.
        Durability: Messages are persisted to disk, ensuring data durability even
                    in case of broker failures.
        Ordered Delivery: Messages within a partition are delivered to consumers in
                          the order they were produced.
        Low Latency: Kafka provides very low latency for message delivery, making it
                     suitable for real-time applications.
     Use Cases:
        Real-time data pipelines: Building data pipelines to ingest and process data
                                  from various sources (e.g., sensor data, website logs,
                                  social media feeds) in real-time
        Stream processing: Performing real-time data analysis and transformations,
                           such as filtering, aggregation, and windowing.
        Message queuing: Handling asynchronous communication between different
                         applications and services.
        Log aggregation and monitoring: Collecting and analyzing log data from distributed
                                        systems.
        Website activity tracking: Tracking user activity on websites in real-time for
                                   personalization and analytics.


    */
}
