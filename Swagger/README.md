# swagger-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-android-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.api.DefaultApi;

public class DefaultApiExample {

    public static void main(String[] args) {
        DefaultApi apiInstance = new DefaultApi();
        Integer groupId = 56; // Integer | The id of the group
        Integer childId = 56; // Integer | The id of the child to add
        try {
            apiInstance.addChild(groupId, childId);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#addChild");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://virtserver.swaggerhub.com/KDT5/KDTBackend/1.0.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**addChild**](docs/DefaultApi.md#addChild) | **POST** /group/{groupId}/addChild | adds a child
*DefaultApi* | [**addNote**](docs/DefaultApi.md#addNote) | **POST** /child/{childId}/addNote | adds a note
*DefaultApi* | [**addTeacher**](docs/DefaultApi.md#addTeacher) | **POST** /group/{groupId}/addTeacher | adds a teacher
*DefaultApi* | [**comment**](docs/DefaultApi.md#comment) | **POST** /group/{groupId}/post/{postId}/comment | makes a comment
*DefaultApi* | [**createChild**](docs/DefaultApi.md#createChild) | **POST** /createChild | create a child
*DefaultApi* | [**deleteGroup**](docs/DefaultApi.md#deleteGroup) | **POST** /group/{groupId}/deleteGroup | deletes the group
*DefaultApi* | [**edit**](docs/DefaultApi.md#edit) | **POST** /group/{groupId}/post/{postId}/edit | edits the post
*DefaultApi* | [**editChild**](docs/DefaultApi.md#editChild) | **POST** /child/{childId}/edit | edit a child
*DefaultApi* | [**editPresence**](docs/DefaultApi.md#editPresence) | **POST** /child/{childId}/editPresence | edit a child&#39;s presence
*DefaultApi* | [**getChild**](docs/DefaultApi.md#getChild) | **GET** /child/{childId} | Gets a child
*DefaultApi* | [**getChildren**](docs/DefaultApi.md#getChildren) | **GET** /group/{groupId}/getChildren | Gets children
*DefaultApi* | [**getGroup**](docs/DefaultApi.md#getGroup) | **GET** /group/{groupId} | Gets a group
*DefaultApi* | [**getMessage**](docs/DefaultApi.md#getMessage) | **GET** /user/{parentId}/getMessages | get messages
*DefaultApi* | [**getNotes**](docs/DefaultApi.md#getNotes) | **GET** /child/{childId}/getNotes | get all notes
*DefaultApi* | [**getParent**](docs/DefaultApi.md#getParent) | **GET** /user/{parentId} | Gets a parent
*DefaultApi* | [**getParents**](docs/DefaultApi.md#getParents) | **GET** /group/{groupId}/getParents | Gets parents
*DefaultApi* | [**getPost**](docs/DefaultApi.md#getPost) | **GET** /group/{groupId}/post/{postId} | Gets a post
*DefaultApi* | [**getPosts**](docs/DefaultApi.md#getPosts) | **GET** /group/{groupId}/getPosts | Gets posts
*DefaultApi* | [**getTeachers**](docs/DefaultApi.md#getTeachers) | **GET** /group/{groupId}/getTeachers | Gets teachers
*DefaultApi* | [**getUsers**](docs/DefaultApi.md#getUsers) | **GET** /group/{groupId}/getUsers | Gets users
*DefaultApi* | [**like**](docs/DefaultApi.md#like) | **POST** /group/{groupId}/post/{postId}/like | makes a like
*DefaultApi* | [**removeChild**](docs/DefaultApi.md#removeChild) | **POST** /group/{groupId}/removeChild | removes a child
*DefaultApi* | [**removeTeacher**](docs/DefaultApi.md#removeTeacher) | **POST** /group/{groupId}/removeTeacher | removes a teacher
*DefaultApi* | [**sendMessage**](docs/DefaultApi.md#sendMessage) | **POST** /user/{parentId}/sendMessage | send a message
*DefaultApi* | [**setParent**](docs/DefaultApi.md#setParent) | **POST** /child/{childId}/setParent | set a child&#39;s parent
*DefaultApi* | [**vote**](docs/DefaultApi.md#vote) | **POST** /group/{groupId}/post/{postId}/vote | makes a vote


## Documentation for Models

 - [Child](docs/Child.md)
 - [Comment](docs/Comment.md)
 - [Group](docs/Group.md)
 - [Image](docs/Image.md)
 - [Like](docs/Like.md)
 - [Message](docs/Message.md)
 - [Note](docs/Note.md)
 - [Poll](docs/Poll.md)
 - [Post](docs/Post.md)
 - [Presence](docs/Presence.md)
 - [Role](docs/Role.md)
 - [User](docs/User.md)
 - [Vote](docs/Vote.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

you@your-company.com

