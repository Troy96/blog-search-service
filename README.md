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
- We are assuming there would be no tags having multiple parent tags 
- Authentication and authorization mechanisms can be implemented to secure the endpoint if required.
