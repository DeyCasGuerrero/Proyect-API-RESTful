## Project Overview
This repository hosts a RESTful API created in Java, leveraging the Spring Boot framework. The purpose of this API is to serve as a foundation for integration into another project 
developed in React. Expect continuous updates as the project evolves.

#### Structure
- Controllers
The "Controllers" folder acts as the entry gate to our API. Here, you'll find classes responsible for handling incoming requests, facilitating communication with the core functionality.

- Repository and Service
Repository: In this folder, you'll find Java interfaces central to data access. They define the contract for interacting with the underlying data storage.

- Service: The "Service" folder contains additional Java interfaces that outline the business logic of the application. These interfaces act as a bridge between the controllers and the data layer.

- Model
The "Model" folder houses Java classes representing the data structure of the application. Traditionally, these classes would contain getters and setters. However, with the adoption of
Lombok, these boilerplate methods are automatically generated, resulting in cleaner and more concise code.

- ServiceImplementation
Classes in the "ServiceImplementation" folder implement the interfaces defined in the "Service" folder. These implementations bring the specified business logic to life and
contribute to the overall functionality of the API.

## Future Development
As the project progresses, updates will be made to enhance compatibility with the React-based project and address any evolving requirements.

Feel free to explore the different folders and reach out if you have any questions or need further clarification.
