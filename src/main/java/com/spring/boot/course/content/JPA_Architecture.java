package com.spring.boot.course.content;

public class JPA_Architecture {

    // JPA (Java Persistence API) Architecture Overview
    /*

        JPA (Java Persistence API) is a specification in Java that provides a standard for
        managing relational data in Java applications. It abstracts the interaction with
        databases and simplifies CRUD operations (Create, Read, Update, Delete) for
        Java developers by providing an object-relational mapping (ORM) layer.
        JPA allows Java objects (entities) to be mapped to database tables, and
        it automates many of the database interactions.

        The JPA architecture defines how to persist data from Java objects to a
        relational database in an object-oriented way.

        Core Components of JPA Architecture:
        1. Entity:
            ==> An entity is a Java class that is mapped to a table in a relational database.
            ==> Each instance of the entity class represents a row in the database table.
            ==> @Entity annotation is used to define an entity class in JPA.
        Example:
            @Entity
            public class User {
                @Id
                private Long id;

                private String name;

                private int age;

                // getters and setters
            }
        2. Entity Manager (EM):
            ==> The Entity Manager is the primary interface for interacting with
                the persistence context.
            ==> It provides methods to perform CRUD operations on entities,
                like persist(), find(), merge(), and remove().
            ==> It also allows managing the persistence context, which is the set of entities
                that are being managed by JPA during a particular session or transaction.

        EntityManager is responsible for the following:
            CRUD operations: Creating, reading, updating, and deleting entity objects.
            Transactions: Managing the lifecycle of the database transaction.
            Querying: Using JPQL (Java Persistence Query Language) to query entities in a database.

        Example:
            @PersistenceContext
            private EntityManager entityManager;

            public User getUser(Long id) {
                return entityManager.find(User.class, id);  // Find a user by ID
            }
        3. Persistence Context:
                The Persistence Context is a set of entity instances that are managed by
                the EntityManager. It tracks changes to entities and is responsible for
                synchronizing those changes to the underlying database.

                The persistence context is typically transaction-scoped. This means that
                the context is active within a transaction and is cleared once the transaction
                ends.

                Changes made to entities within the persistence context (e.g., modifying fields
                of an entity) are automatically detected and will be synchronized with the
                database when the transaction is committed.
        4. Persistence Unit:
              A Persistence Unit is a set of configuration settings that define how JPA
              interacts with the underlying database. These settings are defined in a
              persistence.xml file.

              This file includes configurations like:
                    The database connection URL
                    The JDBC driver
                    The database dialect
                    The list of entity classes
                    The transaction type

             Example of persistence.xml

                <persistence version="2.0">
                    <persistence-unit name="myPU">
                        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
                        <class>com.example.User</class>
                        <properties>
                            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
                            <property name="hibernate.hbm2ddl.auto" value="update"/>
                        </properties>
                    </persistence-unit>
                </persistence>

        5. JPA Query Language (JPQL):
              JPQL is a query language used to query entities in JPA.
              It is similar to SQL but operates on entity objects rather than tables.

              JPQL allows you to write queries that interact with Java objects,
              making it easier to manipulate and retrieve entities based on their
              object-oriented representation.

              Example JPQL:
                TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.age > :age", User.class);
                query.setParameter("age", 30);
                List<User> result = query.getResultList();

        6. Transaction Management:
              JPA supports both container-managed and application-managed transactions.
              In container-managed transactions, the transaction management is handled by
              the container (e.g., a Java EE application server).
              In application-managed transactions, the developer manually manages the
              transaction lifecycle.

              Transactions are important in JPA to ensure that operations are atomic.
              When multiple operations are performed within a transaction, JPA ensures
              that they are either all committed or none.

        7. JPA Providers:
              * JPA is a specification and requires an implementation.
              * Some of the popular JPA providers are:
                  Hibernate (most commonly used)
                  EclipseLink
                  OpenJPA
              * The JPA provider is responsible for the actual implementation of the
                persistence logic (e.g., mapping objects to database tables, generating
                SQL, managing transactions).

         8. Annotations:
              JPA uses several annotations for defining entity mapping and other
              aspects of the persistence layer.
              Some of the key annotations include:
                  @Entity:
                       Marks a class as a JPA entity.
                   @Id:
                       Specifies the primary key of the entity.
                   @GeneratedValue:
                       Defines how the primary key is generated.
                   @ManyToOne, @OneToMany, @ManyToMany, @OneToOne:
                       Defines relationships between entities.
                   @Column:
                       Maps a field to a column in the database.
                   @Transient:
                       Specifies that a field is not persisted in the database.
                   @JoinColumn:
                       Defines a column for joining an entity in a relationship.

         9. JPA Architecture Diagram:
            Here’s a simplified architecture of JPA:

  +------------------+
  |   Entity Class   |  ---> Represents a Java class mapped to a database table
  +------------------+
        |
  +------------------+
  | EntityManager    |  ---> Manages the entity lifecycle and interactions with the database
  +------------------+
        |
  +-------------------+
  | PersistenceContext|  ---> Manages the entity instances and synchronizes changes with the DB
  +-------------------+
        |
  +-------------------+
  | Persistence Unit  |  ---> Defined in persistence.xml with database and entity configurations
  +-------------------+
        |
  +-------------------+
  | JPA Provider      |  ---> e.g., Hibernate, EclipseLink, OpenJPA (the implementation)
  +-------------------+

  Key Advantages of JPA:
        Simplified Database Interaction:
            JPA abstracts away the boilerplate SQL code and simplifies database access.
        Database Independence:
            JPA allows you to switch between different database systems
            (like MySQL, Postgres SQL, etc.) without changing the application logic.
        Object-Oriented Mapping:
            Allows you to work with Java objects and eliminates the need to manually handle SQL.
        Declarative Transaction Management:
            You can handle transactions declaratively through annotations or configuration,
            reducing boilerplate code.

    */
}
