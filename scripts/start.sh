#! /bin/bash

base_dir=$(dirname $0)

cd $base_dir/../

mvn clean package -DskipTests -Pdev;

java -jar $base_dir/../target/kafka-consumer-1.0-SNAPSHOT-shade.jar
