# DefaultApi

All URIs are relative to *http://kindergarten.westeurope.cloudapp.azure.com/api/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addChildToGroup**](DefaultApi.md#addChildToGroup) | **POST** /group/{groupId}/addChild | adds a child
[**addNoteToChild**](DefaultApi.md#addNoteToChild) | **POST** /child/{childId}/addNote | adds a note
[**addUserToGroup**](DefaultApi.md#addUserToGroup) | **POST** /group/{groupId}/addUser | adds a user
[**commentOnPost**](DefaultApi.md#commentOnPost) | **POST** /post/{postId}/comment | makes a comment
[**createGroup**](DefaultApi.md#createGroup) | **POST** /createGroup | create a group
[**createPost**](DefaultApi.md#createPost) | **POST** /group/{groupId}/createPost | create a post
[**createUser**](DefaultApi.md#createUser) | **POST** /createUser | create a user
[**deleteGroup**](DefaultApi.md#deleteGroup) | **POST** /group/{groupId}/deleteGroup | deletes the group
[**editChild**](DefaultApi.md#editChild) | **POST** /child/{childId}/edit | edit a child
[**editPost**](DefaultApi.md#editPost) | **POST** /post/{postId}/edit | edits the post
[**editPresenceOfChild**](DefaultApi.md#editPresenceOfChild) | **POST** /child/{childId}/editPresence | edit a child&#39;s presence
[**getChild**](DefaultApi.md#getChild) | **GET** /child/{childId} | Gets a child
[**getGroup**](DefaultApi.md#getGroup) | **GET** /group/{groupId} | Gets a group
[**getGroups**](DefaultApi.md#getGroups) | **GET** /getGroups | gets the groups
[**getMessagesFromUser**](DefaultApi.md#getMessagesFromUser) | **GET** /user/{userId}/getMessages | get messages
[**getNotesOfChild**](DefaultApi.md#getNotesOfChild) | **GET** /child/{childId}/getNotes | get all notes
[**getPost**](DefaultApi.md#getPost) | **GET** /post/{postId} | Gets a post
[**getUser**](DefaultApi.md#getUser) | **GET** /user/{userId} | Gets a user
[**likePost**](DefaultApi.md#likePost) | **POST** /post/{postId}/like | makes a like
[**removeChildFromGroup**](DefaultApi.md#removeChildFromGroup) | **POST** /group/{groupId}/removeChild | removes a child
[**removeUserFromGroup**](DefaultApi.md#removeUserFromGroup) | **POST** /group/{groupId}/removeUser | removes a user
[**sendMessageToUser**](DefaultApi.md#sendMessageToUser) | **POST** /user/{userId}/sendMessage | send a message
[**vote**](DefaultApi.md#vote) | **POST** /post/{postId}/vote | makes a vote


<a name="addChildToGroup"></a>
# **addChildToGroup**
> addChildToGroup(groupId, child)

adds a child

adds a child to the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Child child = new Child(); // Child | The child to create and add
try {
    apiInstance.addChildToGroup(groupId, child);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addChildToGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **child** | [**Child**](Child.md)| The child to create and add |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="addNoteToChild"></a>
# **addNoteToChild**
> addNoteToChild(childId, note)

adds a note

adds a note to the child

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
String note = "note_example"; // String | The text of the note to add
try {
    apiInstance.addNoteToChild(childId, note);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addNoteToChild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **childId** | **Integer**| The id of the child |
 **note** | **String**| The text of the note to add |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: Not defined

<a name="addUserToGroup"></a>
# **addUserToGroup**
> addUserToGroup(groupId, userId)

adds a user

adds a user to the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer userId = 56; // Integer | The Id of the user to add
try {
    apiInstance.addUserToGroup(groupId, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addUserToGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **userId** | **Integer**| The Id of the user to add |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="commentOnPost"></a>
# **commentOnPost**
> commentOnPost(postId, comment)

makes a comment

makes a comment on the post

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer postId = 56; // Integer | The id of the post
String comment = "comment_example"; // String | The text of the comment
try {
    apiInstance.commentOnPost(postId, comment);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#commentOnPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | **Integer**| The id of the post |
 **comment** | **String**| The text of the comment |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="createGroup"></a>
# **createGroup**
> Integer createGroup(name)

create a group

creates a group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
String name = "name_example"; // String | The name of the group
try {
    Integer result = apiInstance.createGroup(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the group |

### Return type

**Integer**

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="createPost"></a>
# **createPost**
> Integer createPost(groupId, post)

create a post

create a post inside a group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Post post = new Post(); // Post | The post to create
try {
    Integer result = apiInstance.createPost(groupId, post);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **post** | [**Post**](Post.md)| The post to create | [optional]

### Return type

**Integer**

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createUser"></a>
# **createUser**
> Integer createUser(user)

create a user

creates a user

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
User user = new User(); // User | The user
try {
    Integer result = apiInstance.createUser(user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**User**](User.md)| The user |

### Return type

**Integer**

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteGroup"></a>
# **deleteGroup**
> deleteGroup(groupId)

deletes the group

deletes the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
try {
    apiInstance.deleteGroup(groupId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#deleteGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="editChild"></a>
# **editChild**
> editChild(childId, child)

edit a child

edit a child

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
KindergartenChild child = new KindergartenChild(); // KindergartenChild | The modified Child object
try {
    apiInstance.editChild(childId, child);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#editChild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **childId** | **Integer**| The id of the child |
 **child** | [**KindergartenChild**](KindergartenChild.md)| The modified Child object |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="editPost"></a>
# **editPost**
> editPost(postId, post)

edits the post

edites the text of the post

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer postId = 56; // Integer | The id of the post
Post1 post = new Post1(); // Post1 | The edited post
try {
    apiInstance.editPost(postId, post);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#editPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | **Integer**| The id of the post |
 **post** | [**Post1**](Post1.md)| The edited post |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="editPresenceOfChild"></a>
# **editPresenceOfChild**
> editPresenceOfChild(childId, presence)

edit a child&#39;s presence

edit a child&#39;s presence

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
Presence presence = new Presence(); // Presence | The presence object.
try {
    apiInstance.editPresenceOfChild(childId, presence);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#editPresenceOfChild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **childId** | **Integer**| The id of the child |
 **presence** | [**Presence**](Presence.md)| The presence object. |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getChild"></a>
# **getChild**
> KindergartenChild getChild(childId)

Gets a child

Gets a child

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
try {
    KindergartenChild result = apiInstance.getChild(childId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getChild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **childId** | **Integer**| The id of the child |

### Return type

[**KindergartenChild**](KindergartenChild.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroup"></a>
# **getGroup**
> Group getGroup(groupId)

Gets a group

Gets a group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
try {
    Group result = apiInstance.getGroup(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |

### Return type

[**Group**](Group.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getGroups"></a>
# **getGroups**
> List&lt;Group&gt; getGroups()

gets the groups

gets the groups of the user

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
try {
    List<Group> result = apiInstance.getGroups();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getGroups");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Group&gt;**](Group.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMessagesFromUser"></a>
# **getMessagesFromUser**
> List&lt;Message&gt; getMessagesFromUser(userId)

get messages

get messages from user

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer userId = 56; // Integer | The id of the user
try {
    List<Message> result = apiInstance.getMessagesFromUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMessagesFromUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |

### Return type

[**List&lt;Message&gt;**](Message.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNotesOfChild"></a>
# **getNotesOfChild**
> List&lt;Note&gt; getNotesOfChild(childId)

get all notes

get all notes from a child

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
try {
    List<Note> result = apiInstance.getNotesOfChild(childId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getNotesOfChild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **childId** | **Integer**| The id of the child |

### Return type

[**List&lt;Note&gt;**](Note.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPost"></a>
# **getPost**
> KindergartenPost getPost(postId)

Gets a post

Gets a post of the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer postId = 56; // Integer | The id of the post
try {
    KindergartenPost result = apiInstance.getPost(postId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | **Integer**| The id of the post |

### Return type

[**KindergartenPost**](KindergartenPost.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUser"></a>
# **getUser**
> KindergartenUser getUser(userId)

Gets a user

Gets a user by their id

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer userId = 56; // Integer | The id of the parent
try {
    KindergartenUser result = apiInstance.getUser(userId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the parent |

### Return type

[**KindergartenUser**](KindergartenUser.md)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="likePost"></a>
# **likePost**
> Boolean likePost(postId)

makes a like

makes or removes a like on the post

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer postId = 56; // Integer | The id of the post
try {
    Boolean result = apiInstance.likePost(postId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#likePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | **Integer**| The id of the post |

### Return type

**Boolean**

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="removeChildFromGroup"></a>
# **removeChildFromGroup**
> removeChildFromGroup(groupId, childId)

removes a child

removes a child from the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer childId = 56; // Integer | The id of the child to remove from the gorup
try {
    apiInstance.removeChildFromGroup(groupId, childId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#removeChildFromGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **childId** | **Integer**| The id of the child to remove from the gorup | [optional]

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="removeUserFromGroup"></a>
# **removeUserFromGroup**
> removeUserFromGroup(groupId, userId)

removes a user

removes a user from the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer userId = 56; // Integer | The id of the user to remove
try {
    apiInstance.removeUserFromGroup(groupId, userId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#removeUserFromGroup");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **userId** | **Integer**| The id of the user to remove | [optional]

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="sendMessageToUser"></a>
# **sendMessageToUser**
> sendMessageToUser(userId, message)

send a message

Send a message to a user

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer userId = 56; // Integer | The id of the user
String message = "message_example"; // String | The message to send
try {
    apiInstance.sendMessageToUser(userId, message);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sendMessageToUser");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Integer**| The id of the user |
 **message** | **String**| The message to send |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="vote"></a>
# **vote**
> vote(postId, option)

makes a vote

makes a vote on a poll inside a post

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer postId = 56; // Integer | The id of the post
Integer option = 56; // Integer | The vote to submit
try {
    apiInstance.vote(postId, option);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#vote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | **Integer**| The id of the post |
 **option** | **Integer**| The vote to submit |

### Return type

null (empty response body)

### Authorization

[OauthSecurity](../README.md#OauthSecurity)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

