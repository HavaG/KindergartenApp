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
        Child child = new Child(); // Child | The child to create and add
        try {
            apiInstance.addChildToGroup(groupId, child);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#addChildToGroup");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://kindergarten.westeurope.cloudapp.azure.com/api/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**addChildToGroup**](docs/DefaultApi.md#addChildToGroup) | **POST** /group/{groupId}/addChild | adds a child
*DefaultApi* | [**addNoteToChild**](docs/DefaultApi.md#addNoteToChild) | **POST** /child/{childId}/addNote | adds a note
*DefaultApi* | [**addUserToGroup**](docs/DefaultApi.md#addUserToGroup) | **POST** /group/{groupId}/addUser | adds a user
*DefaultApi* | [**commentOnPost**](docs/DefaultApi.md#commentOnPost) | **POST** /post/{postId}/comment | makes a comment
*DefaultApi* | [**createGroup**](docs/DefaultApi.md#createGroup) | **POST** /createGroup | create a group
*DefaultApi* | [**createPost**](docs/DefaultApi.md#createPost) | **POST** /group/{groupId}/createPost | create a post
*DefaultApi* | [**createUser**](docs/DefaultApi.md#createUser) | **POST** /createUser | create a user
*DefaultApi* | [**deleteGroup**](docs/DefaultApi.md#deleteGroup) | **POST** /group/{groupId}/deleteGroup | deletes the group
*DefaultApi* | [**editChild**](docs/DefaultApi.md#editChild) | **POST** /child/{childId}/edit | edit a child
*DefaultApi* | [**editPost**](docs/DefaultApi.md#editPost) | **POST** /post/{postId}/edit | edits the post
*DefaultApi* | [**editPresenceOfChild**](docs/DefaultApi.md#editPresenceOfChild) | **POST** /child/{childId}/editPresence | edit a child&#39;s presence
*DefaultApi* | [**getChild**](docs/DefaultApi.md#getChild) | **GET** /child/{childId} | Gets a child
*DefaultApi* | [**getGroup**](docs/DefaultApi.md#getGroup) | **GET** /group/{groupId} | Gets a group
*DefaultApi* | [**getGroups**](docs/DefaultApi.md#getGroups) | **GET** /getGroups | gets the groups
*DefaultApi* | [**getMessagesFromUser**](docs/DefaultApi.md#getMessagesFromUser) | **GET** /user/{userId}/getMessages | get messages
*DefaultApi* | [**getNotesOfChild**](docs/DefaultApi.md#getNotesOfChild) | **GET** /child/{childId}/getNotes | get all notes
*DefaultApi* | [**getPost**](docs/DefaultApi.md#getPost) | **GET** /post/{postId} | Gets a post
*DefaultApi* | [**getUser**](docs/DefaultApi.md#getUser) | **GET** /user/{userId} | Gets a user
*DefaultApi* | [**likePost**](docs/DefaultApi.md#likePost) | **GET** /post/{postId}/like | makes a like
*DefaultApi* | [**removeChildFromGroup**](docs/DefaultApi.md#removeChildFromGroup) | **POST** /group/{groupId}/removeChild | removes a child
*DefaultApi* | [**removeUserFromGroup**](docs/DefaultApi.md#removeUserFromGroup) | **POST** /group/{groupId}/removeUser | removes a user
*DefaultApi* | [**sendMessageToUser**](docs/DefaultApi.md#sendMessageToUser) | **POST** /user/{userId}/sendMessage | send a message
*DefaultApi* | [**vote**](docs/DefaultApi.md#vote) | **POST** /post/{postId}/vote | makes a vote


## Documentation for Models

 - [Child](docs/Child.md)
 - [Comment](docs/Comment.md)
 - [Group](docs/Group.md)
 - [GroupgroupIdcreatePostPath](docs/GroupgroupIdcreatePostPath.md)
 - [GroupgroupIdcreatePostPoll](docs/GroupgroupIdcreatePostPoll.md)
 - [Image](docs/Image.md)
 - [KindergartenChild](docs/KindergartenChild.md)
 - [KindergartenPoll](docs/KindergartenPoll.md)
 - [KindergartenPost](docs/KindergartenPost.md)
 - [KindergartenUser](docs/KindergartenUser.md)
 - [Like](docs/Like.md)
 - [Message](docs/Message.md)
 - [Note](docs/Note.md)
 - [Post](docs/Post.md)
 - [Post1](docs/Post1.md)
 - [PostpostIdeditPath](docs/PostpostIdeditPath.md)
 - [Presence](docs/Presence.md)
 - [Role](docs/Role.md)
 - [User](docs/User.md)
 - [Vote](docs/Vote.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### OauthSecurity

- **Type**: OAuth
- **Flow**: accessCode
- **Authorization URL**: http://kindergarten.westeurope.cloudapp.azure.com:3000/oauth/authorise
- **Scopes**: 
  - admin: Admin scope
  - teacher: Teacher scope
  - parent: Parent scope


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

dev@kindergarten.com

