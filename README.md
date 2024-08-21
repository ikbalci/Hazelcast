# Hazelcast vs Oracle Performance Test

This repository contains a Java project that demonstrates the performance of Hazelcast for caching and retrieving operations. The project uses Maven as a build tool and Hazelcast as the primary caching solution.

## Overview

The purpose of this project is to benchmark the performance of Hazelcast in comparison to traditional database operations. This is achieved by performing a series of insertions and selections on a Hazelcast map and comparing these times to similar operations in a SQL database.

## Prerequisites

- Java 11 or higher
- Maven
- Hazelcast 5.3.6

## How to Run

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project.
4. Execute `java -jar target/Hazelcast-1.0-SNAPSHOT.jar` to start the performance test.

## Performance Results

### SQL Database Performance

#### 20,000 Records

| Operation       | Time   | Screenshot |  Operation       | Time   | Screenshot |
|-----------------|--------|------------| -----------------|--------|------------|
| **Insertion**   | 1021 ms| ![SQL Developer Screenshot for 20,000 Insertions](src/main/resources/oracle-insertion-20k.png) | **Selection**   | 365 ms | ![SQL Developer Screenshot for 20,000 Selections](src/main/resources/oracle-selection-20k.png) |

#### 100,000 Records

| Operation       | Time   | Screenshot | Operation       | Time   | Screenshot |
|-----------------|--------|------------|-----------------|--------|------------|
| **Insertion**   | 5276 ms| ![SQL Developer Screenshot for 100,000 Insertions](src/main/resources/oracle-insertion-100k.png) | **Selection**   | 1803 ms| ![SQL Developer Screenshot for 100,000 Selections](src/main/resources/oracle-selection-100k.png) |


### Hazelcast Performance

| Operation       | Time                        | Screenshot                                  |
|-----------------|------------------------------|---------------------------------------------|
| **20k Performance** | 618 ms <br> 335 ms  | ![20,000 Insertion Screenshot](src/main/resources/hazelcast-performance-20k.png) |
| **100k Performance** | 1344 ms <br> 1179 ms  | ![100,000 Insertion Screenshot](src/main/resources/hazelcast-performance-100k.png) |



## Conclusion

The performance tests indicate that Hazelcast provides a significant improvement in speed for both insertion and selection operations compared to traditional SQL database operations. This demonstrates the effectiveness of Hazelcast as a caching solution for high-performance applications.
