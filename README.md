# Course Certification Project
This Java project focuses on managing course certifications through the implementation of various design patterns. This project's primary objective lies in efficiently managing courses and their associated certifications using design patterns in Java. It allows for flexible manipulation and handling of certifications through the implemented patterns.
## Contents
- Project Structure
- Features
- How to Use
- Contributors
## Project Structure 
The project is organized into the following packages:
- Adapter Pattern: The AdapterCertification facilitates the combining of certification interfaces to assign unique identification numbers to certificates. In the provided code, the AdapterCertification file in the Adapter package serves this purpose by connecting different certification interfaces.
- Decorator Pattern: The Decorator package includes classes (BaseResume, Name, Surname) implementing the decorator pattern. These classes augment resumes with additional information like names, surnames, and certifications. For instance, DecoratorCertification enhances resumes with certification details.
- Factory Pattern: The Factory package demonstrates factory implementations (DesignerFactory, DeveloperFactory) creating professionals based on specified skills. For example, the DesignerFactory creates video or photo designers, while the DeveloperFactory generates Java or Python developers.
- Observer Pattern: The Observer package employs the observer pattern (Editor class) for handling events and notifications related to developers and designers.
- Strategy Pattern: Strategies for applying skills (Skill interface, PythonDeveloper, VideoDesigner) are defined in the Strategy package. The CertificationContext class manages certification creation based on specified skills.
- Database: The Database package is used to manage database interactions for user information, including user
accounts and root user. It ensures the security and integrity of user data.
### Adapter 
- Combining Certification Contexts: It iterates through multiple CertificationContext instances, extracting skills and descriptions to create a comprehensive certification profile.
- Unified Certification Handling: Provides methods to retrieve certification details (getCertificationDetails()) and display or process them (getCertification()).
- Ensuring Uniqueness: Facilitates the assignment of unique identification numbers or other specific characteristics to certifications for efficient management, such as unique identifiers for GitHub.
##### Methods
- getCertificationDetails(): Combines all skills and descriptions from different certification contexts into a unified format for easy retrieval.
- getCertification(): Similar to getCertificationDetails(), but tailored for output or processing, like displaying information or performing specific actions related to the certifications.
### Decorator
#### BaseResume Class
- Represents a basic implementation of a resume.
- Provides a default getResume() method returning "Your resume\n".
- Includes methods (getConcrete() and getRes()) required by the Resume interface.
#### DecorCertification Class
- Acts as a decorator that enhances a resume by adding certification details. Accepts a Certification object and a Resume object to incorporate certification information into the resume.
- Overrides getResume() to append certification details to the existing resume content.
#### Name and Surname Classes
- Implement additional decorators to include the person's name and surname in the resume, respectively.
- Modify the resume content by appending the name or surname to the existing resume information.
#### Resume Interface
- Defines the methods (getResume(), getConcrete(), getRes()) necessary for decorators to extend or modify resume behavior.
### Factory 
#### DesignerFactory Class
- Extends ProfessionalFactory and implements the createSkill() method.
- Generates skill objects related to design, such as VideoDesigner and PhotoDesigner, based on the provided skill parameter.
#### DeveloperFactory Class
- Also extends ProfessionalFactory and overrides the createSkill() method.
- Produces skill objects associated with software development, like JavaDeveloper and PythonDeveloper, depending on the input skill parameter.
#### ProfessionalFactory Abstract Class
- Defines the abstract method createSkill(), which must be implemented by concrete factory classes.
- Serves as a blueprint for creating different types of skills across specific domains.
### Observer 
#### Editor Class
- Represents the entity that triggers events.
- Contains a reference to an EventManager instance and provides a method (addRes()) to notify events.
#### EmailNotificationListener and PhoneNotificationListener Classes
- Implement the EventListener interface to listen for specific events and perform respective actions (like sending emails or saving logs).
- EventListener Interface
- Defines the method (update()) that every listener should implement to react to events.
#### EventManager Class
- Manages event subscriptions and handles event notification to appropriate listeners.
- Maintains a mapping of event types to lists of listeners interested in those events.
- Utilizes a database connection (DbConnectionSingleton) to update user subscriptions upon event subscription.
### Singleton 
#### DbConnectionSingleton Class
- Implements the Singleton pattern by providing a private constructor and a static method getInstance() to access the single instance of the class.
- Manages a Connection object (connection) and a Statement object (statement) for executing SQL queries.
- Utilizes lazy initialization to establish the database connection upon the first request for the instance.
- Implements the initializeConnection() method to set up the PostgreSQL database connection.
### Strategy 
#### Certification Interface
- Declares methods (getCertificationDetails(), getCertification()) to retrieve and display certification details.
- Represents a strategy for handling certification information.
#### CertificationContext Class
- Implements the Certification interface and encapsulates a collection of skills and a description of the certification context.
- Provides methods (getCertificationDetails(), getCertification()) to retrieve and output details about the certification context.
#### Skill Interface
- Declares a method (applySkill()) that each skill class must implement to specify its particular skill.
#### Skill Implementations
Classes like JavaDeveloper, PhotoDesigner, PythonDeveloper, and VideoDesigner implement the Skill interface to define specific skills and their application details.
### Database 
The database plays a pivotal role in managing user data, subscriptions, notifications, and skill certifications.
- User Data: The users table stores user information like names, surnames, subscriptions, and related data.
- Notifications Management: There's likely a table managing notifications, linking user subscriptions to specific events and notification methods (such as email or logs).
- Skills and Certifications: The system stores skill and certification data linked to users, potentially using structures akin to the CertificationContext class.
## How to Use
1. Clone the Repository: git clone <repository_url>
2. Compile and Run: Compile and run the project to create and manage certifications and the course using the provided strategies and providers.

## Features
### Certification Management
- Adapter Pattern: Utilizes AdapterCertification to merge certification interfaces for assigning unique identification numbers to certificates.
- Decorator Pattern: Enhances resumes (BaseResume, Name, Surname) with additional information, including names, surnames, and certifications.
- Factory Pattern: Employs factory implementations (DesignerFactory, DeveloperFactory) to create professionals based on specific skills, such as video or photo designers and Java or Python developers.
- Observer Pattern: Manages events and notifications related to developers and designers through the Editor class.
- Strategy Pattern: Facilitates skill application (Skill interface, PythonDeveloper, VideoDesigner) and certification creation based on specified skills using CertificationContext.
### User Interaction
- Input Handling: Allows users to input descriptions and select professionals (developers/designers) along with their respective skills.
- Resume Augmentation: Enables users to add names, surnames, and certifications to resumes via user input methods.
- Database Interaction: Utilizes a singleton database connection (DbConnectionSingleton) to store user information, ensuring efficient database interaction.
### Functionality Expansion
- Scalability: The project's design patterns facilitate easy expansion and addition of new certifications, skills, or professional types.
- Flexibility: Provides flexibility in managing courses and certifications, allowing modifications and enhancements.

## Contributors
- Dosmurat Balzhan(https://github.com/bbxx77)
- Bayazitova Kamila(https://github.com/erishyyy)
