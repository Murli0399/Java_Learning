# **App - UserProfileManager**

## **Submission Instructions [Please note]**

## **Maximum Marks - 19**

| Sr. No. | Description | Marks |
| --- | --- | --- |
| 1 | Able to submit the app | 1 |
| 2 | Correct entity classes | 1 |
| 3 | Creating correct DAO-implemented classes | 1 |
| 4 | Correct implementation of addUser(User user) | 2 |
| 5 | Correct implementation of getUserById(int id) | 2 |
| 6 | Correct implementation of updateUser(User user) | 2 |
| 7 | Correct implementation of deleteUser(User user) | 2 |
| 8 | Correct implementation of addProfile(Profile profile) | 2 |
| 9 | Correct implementation of getProfileById(int id) | 2 |
| 10 | Correct implementation of updateProfile(Profile profile) | 2 |
| 11 | Correct implementation of deleteProfile(Profile profile) | 2 |
|  | Total | 19 |

### **Objective:**

Design and implement a database application using JPA Hibernate with an ORM approach. The application should establish a One-to-One relationship between two entity classes and utilize the DAO pattern for data access operations.

### Installation

- Download and unzip the boilerplate and follow the following steps to import it into your IDE.
- Open the IDE(STS) → File → Import → Maven → Existing Maven Projects (double click on it).
- Click on the Browse… button and select the project template → next → finish.

### Boilerplate folder structure

- Please ignore all files except the mentioned one to use.
- Do not change the given folder structure.

```java
UserProfileManager
		├───src
		│   ├───main
		│   │   ├───java
		│   │   │   │   Runner.java [Use]
		│   │   │   ├───dao
		│   │   │   │       UserDAO.java [Do not modify]
		│   │   │   │       ProfileDAO.java [Do not modify]
		│   │   │   │       UserDAOImpl.java [You need to create]
		│   │   │   │       ProfileDAOImpl.java [You need to create]
		│   │   │   ├───entities
		│   │   │   │       User.java [Use]
		│   │   │   │       Profile.java [Use]
		│   │   │   ├───exceptions
		│   │   │   │       UserException.java [Use]
		│   │   │   │       ProfileException.java [Use]
		│   │   │   └───utilities
		│   │   │           EMUtil.java [Use]
		│   │   └───resources
		│   │       └───META-INF
		│   │               persistence.xml [Use]
		│   └───test
		│       └───java
		│				TestCases.java [ignore]
		└───pom.xml [Do not modify]
```

# Problem Statement: -

### **Problem Description:**

You are tasked with developing a system for managing user and profile information. Each user should have a profile associated with them through a One-to-One relationship. Your goal is to design and implement the system using JPA Hibernate for database operations, the ORM (Object-Relational Mapping) approach, the DAO pattern for data access, and exception handling for error handling.

### **System Requirements:**

1. Define the following entity classes with the necessary attributes and annotations for JPA Hibernate:
    - **`User`**: Represents a user and contains attributes such as **`id`**, **`username`**, **`password`**, and a reference to the associated **`Profile`**.
    - **`Profile`**: Represents a user's profile and contains attributes such as **`id`**, **`firstName`**, **`lastName`**, and a reference to the associated **`User`**.
2. Establish a One-to-One relationship between the **`User`** and **`Profile`** entity classes. Each user should have only one profile, and each profile should be associated with only one user.
3. Implement the following DAO (Data Access Object) interfaces with the necessary methods for CRUD (Create, Read, Update, Delete) operations, including exception handling:
    - **`UserDAO`**: Defines methods for CRUD operations related to users.
        - **`void addUser(User user) throws UserException`**: Adds a new user to the database.
        - **`User getUserById(int id) throws UserException`**: Retrieves a user from the database based on the specified ID.
        - **`void updateUser(User user) throws UserException`**: Updates the details of an existing user in the database.
        - **`void deleteUser(User user) throws UserException`**: Deletes a user from the database.
    - **`ProfileDAO`**: Defines methods for CRUD operations related to profiles.
        - **`void addProfile(Profile profile) throws ProfileException`**: Adds a new profile to the database.
        - **`Profile getProfileById(int id) throws ProfileException`**: Retrieves a profile from the database based on the specified ID.
        - **`void updateProfile(Profile profile) throws ProfileException`**: Updates the details of an existing profile in the database.
        - **`void deleteProfile(Profile profile) throws ProfileException`**: Deletes a profile from the database.
4. Provide implementations for the DAO interfaces:
    1. Implement the **`UserDAO`** interface in the **`UserDAOImpl`** class. Use JPA Hibernate to perform CRUD operations on users. Handle exceptions related to user operations using the **`UserException`** class.
    2. Implement the **`ProfileDAO`** interface in the **`ProfileDAOImpl`** class. Use JPA Hibernate to perform CRUD operations on profiles. Handle exceptions related to profile operations using the **`ProfileException`** class.
5. Provide the following constructors in the respective implementation classes:
    - **`UserDAOImpl`**: Accepts an **`EntityManager`** parameter to initialize the **`entityManager`** attribute.
    - **`ProfileDAOImpl`**: Accepts an **`EntityManager`** parameter to initialize the **`entityManager`** attribute.
    
    **Note:** Ensure that the constructor signatures match the ones mentioned above.
    

### **Functionality to Implement:**

Your task is to implement the following functionality using JPA Hibernate, the ORM approach, and the DAO pattern:

1. Define the entity classes **`User`** and **`Profile`** with the necessary attributes, getters, setters, and annotations for JPA Hibernate.
    
    Use `int` data type for `id`.
    
    Required Constructor along with default:
    
    1. `public User(String username, String password, Profile profile)` 
    2. `public Profile(String firstName, String lastName, User user)`
2. Establish a One-to-One relationship between the **`User`** and **`Profile`** entity classes using appropriate JPA Hibernate annotations.
3. Implement the **`UserDAO`** interface and provide the actual implementation in the **`UserDAOImpl`** class. Use JPA Hibernate to perform CRUD operations on users.
4. Implement the **`ProfileDAO`** interface and provide the actual implementation in the **`ProfileDAOImpl`** class. Use JPA Hibernate to perform CRUD operations on profiles.

### **Constraints:**

- Use appropriate JPA Hibernate annotations (e.g., **`@Entity`**, **`@Table`**, **`@Id`**, **`@GeneratedValue`**, **`@OneToOne`**, **`@JoinColumn`**) for mapping relationships and defining primary keys.
- Implement exception handling by throwing and catching the appropriate exceptions (**`UserException`** and **`ProfileException`**) for error scenarios during data access operations.
- **Note: All implemented classes should have a default constructor.**

### Common instructions for pom.xml and persistence.xml

- Both pom.xml & persistence.xml files are given along with boilerplate code.
- Do not make any changes to the existing content of the **`pom.xml`** file.
- Configure the **`persistence.xml`** file with the necessary settings for your database connection.
- **Do not change the `persistence-unit` name.**

### Test your application’s methods on your local system.

- From the main method of the Runner class, you can test your application’s methods in your local system. can create an object if you want and call the methods.

### Check your application for a few sample test cases:

Steps to test your application:

- Run the maven project (refer to the below steps).
    - Right-click on the project → Run As → Maven test.
    refer to the image for more clarity: [**link**](https://drive.google.com/file/d/1jIr8BUPfdoJ-JB8oP2SBJTzJt7boUWZ5/view?usp=sharing)

### General guidelines

- The system on cp.masaischool.com may take between 1-20 minutes for responding.
- So, we request you to read the problem carefully and debug it before itself.
- We also request you not just submit it last minute.
- Try to keep one submission at a time.
- Use the template provided to write your code (Mandatory).