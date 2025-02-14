package com.spring.boot.course.content;

public class SpringBootRedis {

    // What is Redis ?

    /*
        Redis is an open-source, in-memory data store that can be used as a cache,
        database, and message broker. It's known for its speed, reliability,
        and performance.

     How Redis works
        Redis stores data in memory instead of on a disk, which makes it faster.
        Redis supports complex data types like strings, hashes, lists, sets, and JSON.
        Redis has built-in replication and persistence capabilities.
        Redis offers built-in Lua scripting.

     Redis use cases
        Redis is used as a cache to improve application performance.
        Redis can be used as a database to store and manipulate data.
        Redis can be used as a message broker.

     Redis features
        Redis supports multiple levels of on-disk persistence.
        Redis offers high availability.
        Redis supports data replication.
        Redis supports atomic operations on data types.
        Redis supports bitfields, which can efficiently encode multiple counters in a string.

     Redis in the cloud
        Redis offers cloud services that include: High availability, Low latency,
        Data persistence and durability, Auto-tiring, and Built-in durability.

    */

    /*
        Install Redis on windows:
        follow the Redis official website: https://redis.io/
        documentation:  https://redis.io/docs/latest/operate/oss_and_stack/install/install-redis/install-redis-on-windows/

        Even though you can follow the below steps for easy understanding and installation

        ==> go to powershell --> run as Administrator
            > wsl --install
        ==> to check the version of wsl
            > wsl -l -v
        ==> To install Redis on ubuntu following steps

        If anything ask to continue or install the redis like [Y/N)
            Just pass it y

            1. curl -fsSL https://packages.redis.io/gpg | sudo gpg --dearmor -o /usr/share/keyrings/redis-archive-keyring.gpg

            2. echo "deb [signed-by=/usr/share/keyrings/redis-archive-keyring.gpg] https://packages.redis.io/deb $(lsb_release -cs) main" | sudo tee /etc/apt/sources.list.d/redis.list

            3. sudo apt-get update

            4. sudo apt-get install redis

        ==>  Lastly, start the Redis server like so:

            sudo service redis-server start

        ==> Connect to Redis
            Once Redis is running, you can test it by running redis-cli:

            redis-cli

        ==>  Test the connection with the ping command:
            ping

            Output :  PONG
            It's running.

        ==> To shutdown the wsl or ubuntu simple exit from the wsl like ctrl+c
                ○ wsl --shutdown

    */
}
