# 1. Overview: 
> This README provides information about the Blog Service endpoint, including details about getting started, the database schema, ORM schema, endpoint details, and a sample request.

# 2. Database Schema: 
> The database schema for the service endpoint includes the following tables:

**blogs:** Contains information about the blogs, including blog ID, title, content, author ID, and creation date.

**tags:** Stores information about the tags associated with the blogs, including tag ID, tag name, and parent tag ID.

**blog_tags:** Acts as a many-to-many mapping table between blogs and tags, linking each blog to its associated tags.

# 3. ORM Schema: 
> The ORM (Object-Relational Mapping) schema corresponds to the Java model classes used to represent database entities:

**Blog:** Represents a blog post, including attributes such as ID, title, content, author, and creation date.

**Tag:** Represents a tag associated with a blog post, including attributes such as ID, name, and parent tag ID.

# 4. Endpoint Details: 
> The Blog Service endpoint exposes the following API:

**Endpoint:** `/api/blogs/search`

**HTTP Method:** GET

**Request Parameter:** tag (String): The name of the tag to search for.

**Response:** A JSON array containing the list of blogs matching the specified tag.

# 5. Sample Request: 
> To search for blogs by tag, send a GET request to the /api/blogs/search endpoint with the tag parameter set to the desired tag name. For example:

```GET /api/blogs/search?tag=technology```

# 6. Additional Notes:
- The Blog Service endpoint uses Spring Boot for building RESTful APIs and Hibernate ORM for database interaction.
- We are assuming there would be no tags having multiple parent tags.
- We have used VS Code as our IDE for development environment.
- Authentication and authorization mechanisms can be implemented to secure the endpoint if required.

# 7. Prerequisites
- Java Development Kit (JDK) version 11 or higher installed on your system.
- Gradle build tool installed on your system.
- Visual Studio Code (VS Code) installed on your system.

# 8. Getting Started
> To get started, follow these steps:

1. Clone the repository to your local machine:
   ```git clone https://github.com/Troy96/blog-search-service.git```

2. Open the project in IDE:
   ```
   cd blog-search-service
   code .
   ```
3. Install the following extensions in VS Code:
- Java Extension Pack: Provides essential tools for Java developers.
- Spring Boot Extension Pack: Provides tools for working with Spring Boot applications.

4. Ensure that your VS Code workspace settings are configured to use Java 11 (or higher). You can set this in the `.vscode/settings.json file:`
   ```json
   {
    "java.home": "/path/to/your/jdk",
    "java.configuration.runtimes": [
        {
            "name": "JavaSE-11",
            "path": "/path/to/your/jdk",
        }
    ]
    }
   ```
- Replace /path/to/your/jdk with the path to your JDK installation directory.

5. Build the project using Gradle:
   ```
   ./gradlew build
   ```
6. Run the application:
   ```
   ./gradlew bootRun
   ```
7. Once the application is running, you can access it at **http://localhost:8080** in your web browser. 
