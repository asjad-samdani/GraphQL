# GraphQL CRUD Operations with Spring Boot

This project demonstrates how to implement CRUD (Create, Read, Update, Delete) operations using **GraphQL** with **Spring Boot**. The application provides APIs for interacting with an example entity, enabling efficient and flexible data queries.

## Features

- **GraphQL Integration**: Enables seamless interaction with APIs through GraphQL queries and mutations.
- **CRUD Operations**: Perform Create, Read, Update, and Delete operations for the example entity.
- **Spring Boot**: Ensures a lightweight and production-ready application.
- **Scalable API**: Designed to extend functionality easily.

---

## Technologies Used

- **Java** (JDK 17 or higher)
- **Spring Boot** (v2.7+)
- **GraphQL Java Tools**
- **H2 Database** (or any other database for development and testing)
- **Maven**

---

## Prerequisites

Before running this application, ensure you have the following installed:

- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Postman](https://www.postman.com/) or any other GraphQL client for testing.

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/your-repository-name.git
   cd your-repository-name
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the GraphQL Playground:
   Visit `http://localhost:8080/graphql` in your browser or GraphQL client.

---

## GraphQL Schema

### Example Entity
```graphql
type ExampleEntity {
    id: ID!
    name: String!
    description: String
    createdAt: String
    updatedAt: String
}
```

### Queries
- Fetch a single entity:
  ```graphql
  query {
      getEntityById(id: "1") {
          id
          name
          description
      }
  }
  ```

- Fetch all entities:
  ```graphql
  query {
      getAllEntities {
          id
          name
          description
      }
  }
  ```

### Mutations
- Create a new entity:
  ```graphql
  mutation {
      createEntity(input: {name: "Sample", description: "Example Description"}) {
          id
          name
          description
      }
  }
  ```

- Update an existing entity:
  ```graphql
  mutation {
      updateEntity(id: "1", input: {name: "Updated Sample", description: "Updated Description"}) {
          id
          name
          description
      }
  }
  ```

- Delete an entity:
  ```graphql
  mutation {
      deleteEntity(id: "1")
  }
  ```

---

## API Documentation

### Endpoints

- **GraphQL Endpoint**: `http://localhost:8080/graphql`
- **GraphiQL UI**: `http://localhost:8080/graphiql` (if enabled)

---

## Contributing

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Open a pull request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [GraphQL Java](https://www.graphql-java.com/)

---

### Project Description for GitHub

This Spring Boot project implements CRUD operations using GraphQL. It allows users to interact with an example entity through flexible and efficient GraphQL APIs. The project is built with scalability and best practices in mind, leveraging GraphQL's powerful querying capabilities for modern API development. It serves as an excellent starting point for developers exploring GraphQL with Spring Boot.
