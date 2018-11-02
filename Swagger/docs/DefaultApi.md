# DefaultApi

All URIs are relative to *https://virtserver.swaggerhub.com/KDT5/KDTBackend/1.0.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addChild**](DefaultApi.md#addChild) | **POST** /group/{groupId}/addChild | adds a child
[**addNote**](DefaultApi.md#addNote) | **POST** /child/{childId}/addNote | adds a note
[**addTeacher**](DefaultApi.md#addTeacher) | **POST** /group/{groupId}/addTeacher | adds a teacher
[**comment**](DefaultApi.md#comment) | **POST** /group/{groupId}/post/{postId}/comment | makes a comment
[**createChild**](DefaultApi.md#createChild) | **POST** /createChild | create a child
[**deleteGroup**](DefaultApi.md#deleteGroup) | **POST** /group/{groupId}/deleteGroup | deletes the group
[**edit**](DefaultApi.md#edit) | **POST** /group/{groupId}/post/{postId}/edit | edits the post
[**editChild**](DefaultApi.md#editChild) | **POST** /child/{childId}/edit | edit a child
[**editPresence**](DefaultApi.md#editPresence) | **POST** /child/{childId}/editPresence | edit a child&#39;s presence
[**getChild**](DefaultApi.md#getChild) | **GET** /child/{childId} | Gets a child
[**getChildren**](DefaultApi.md#getChildren) | **GET** /group/{groupId}/getChildren | Gets children
[**getGroup**](DefaultApi.md#getGroup) | **GET** /group/{groupId} | Gets a group
[**getMessage**](DefaultApi.md#getMessage) | **GET** /user/{parentId}/getMessages | get messages
[**getNotes**](DefaultApi.md#getNotes) | **GET** /child/{childId}/getNotes | get all notes
[**getParent**](DefaultApi.md#getParent) | **GET** /user/{parentId} | Gets a parent
[**getParents**](DefaultApi.md#getParents) | **GET** /group/{groupId}/getParents | Gets parents
[**getPost**](DefaultApi.md#getPost) | **GET** /group/{groupId}/post/{postId} | Gets a post
[**getPosts**](DefaultApi.md#getPosts) | **GET** /group/{groupId}/getPosts | Gets posts
[**getTeachers**](DefaultApi.md#getTeachers) | **GET** /group/{groupId}/getTeachers | Gets teachers
[**getUsers**](DefaultApi.md#getUsers) | **GET** /group/{groupId}/getUsers | Gets users
[**like**](DefaultApi.md#like) | **POST** /group/{groupId}/post/{postId}/like | makes a like
[**removeChild**](DefaultApi.md#removeChild) | **POST** /group/{groupId}/removeChild | removes a child
[**removeTeacher**](DefaultApi.md#removeTeacher) | **POST** /group/{groupId}/removeTeacher | removes a teacher
[**sendMessage**](DefaultApi.md#sendMessage) | **POST** /user/{parentId}/sendMessage | send a message
[**setParent**](DefaultApi.md#setParent) | **POST** /child/{childId}/setParent | set a child&#39;s parent
[**vote**](DefaultApi.md#vote) | **POST** /group/{groupId}/post/{postId}/vote | makes a vote


<a name="addChild"></a>
# **addChild**
> addChild(groupId, childId)

adds a child

adds a child to the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer childId = 56; // Integer | The id of the child to add
try {
    apiInstance.addChild(groupId, childId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addChild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **childId** | **Integer**| The id of the child to add |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="addNote"></a>
# **addNote**
> addNote(childId, noteId)

adds a note

adds a note to the child

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
Integer noteId = 56; // Integer | The Id of the note to add
try {
    apiInstance.addNote(childId, noteId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addNote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **childId** | **Integer**| The id of the child |
 **noteId** | **Integer**| The Id of the note to add |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="addTeacher"></a>
# **addTeacher**
> addTeacher(groupId, teacherId)

adds a teacher

adds a teacher to the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer teacherId = 56; // Integer | The Id of the teacher to add
try {
    apiInstance.addTeacher(groupId, teacherId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#addTeacher");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **teacherId** | **Integer**| The Id of the teacher to add |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="comment"></a>
# **comment**
> comment(groupId, postId, commentText)

makes a comment

makes a comment on the post

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer postId = 56; // Integer | The id of the post
String commentText = "commentText_example"; // String | The text of the comment
try {
    apiInstance.comment(groupId, postId, commentText);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#comment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **postId** | **Integer**| The id of the post |
 **commentText** | **String**| The text of the comment |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="createChild"></a>
# **createChild**
> createChild(child)

create a child

crete a child

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Child child = new Child(); // Child | A child object to create
try {
    apiInstance.createChild(child);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#createChild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **child** | [**Child**](Child.md)| A child object to create | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

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

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="edit"></a>
# **edit**
> edit(groupId, postId, content)

edits the post

edites the text of the post

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer postId = 56; // Integer | The id of the post
Post content = new Post(); // Post | The edited post
try {
    apiInstance.edit(groupId, postId, content);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#edit");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **postId** | **Integer**| The id of the post |
 **content** | [**Post**](Post.md)| The edited post |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: applicatoin/json
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
Child child = new Child(); // Child | The modified Child object
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
 **child** | [**Child**](Child.md)| The modified Child object |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="editPresence"></a>
# **editPresence**
> editPresence(childId, presence)

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
    apiInstance.editPresence(childId, presence);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#editPresence");
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

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="getChild"></a>
# **getChild**
> Child getChild(childId)

Gets a child

Gets a child

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
try {
    Child result = apiInstance.getChild(childId);
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

[**Child**](Child.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getChildren"></a>
# **getChildren**
> List&lt;Child&gt; getChildren(groupId)

Gets children

Gets a list of all the children of the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
try {
    List<Child> result = apiInstance.getChildren(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getChildren");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |

### Return type

[**List&lt;Child&gt;**](Child.md)

### Authorization

No authorization required

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

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMessage"></a>
# **getMessage**
> List&lt;Message&gt; getMessage(parentId)

get messages

get messages from user

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer parentId = 56; // Integer | The id of the parent
try {
    List<Message> result = apiInstance.getMessage(parentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parentId** | **Integer**| The id of the parent |

### Return type

[**List&lt;Message&gt;**](Message.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getNotes"></a>
# **getNotes**
> List&lt;Note&gt; getNotes(childId)

get all notes

get all notes from a child

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
try {
    List<Note> result = apiInstance.getNotes(childId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getNotes");
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

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getParent"></a>
# **getParent**
> User getParent(parentId)

Gets a parent

Gets a parent by id

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer parentId = 56; // Integer | The id of the parent
try {
    User result = apiInstance.getParent(parentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getParent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parentId** | **Integer**| The id of the parent |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getParents"></a>
# **getParents**
> List&lt;User&gt; getParents(groupId)

Gets parents

Gets a list of all the parents of children in the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
try {
    List<User> result = apiInstance.getParents(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getParents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPost"></a>
# **getPost**
> Post getPost(groupId, postId)

Gets a post

Gets a post of the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer postId = 56; // Integer | The id of the post
try {
    Post result = apiInstance.getPost(groupId, postId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **postId** | **Integer**| The id of the post |

### Return type

[**Post**](Post.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPosts"></a>
# **getPosts**
> List&lt;Post&gt; getPosts(groupId)

Gets posts

Gets a list of all the posts of the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
try {
    List<Post> result = apiInstance.getPosts(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getPosts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |

### Return type

[**List&lt;Post&gt;**](Post.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTeachers"></a>
# **getTeachers**
> List&lt;User&gt; getTeachers(groupId)

Gets teachers

Gets a list of all the teachers of the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
try {
    List<User> result = apiInstance.getTeachers(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getTeachers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsers"></a>
# **getUsers**
> List&lt;User&gt; getUsers(groupId)

Gets users

Gets a list of all the teachers and parents of the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
try {
    List<User> result = apiInstance.getUsers(groupId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getUsers");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |

### Return type

[**List&lt;User&gt;**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="like"></a>
# **like**
> like(groupId, postId)

makes a like

makes or removes a like on the post

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer postId = 56; // Integer | The id of the post
try {
    apiInstance.like(groupId, postId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#like");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **postId** | **Integer**| The id of the post |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeChild"></a>
# **removeChild**
> removeChild(groupId, child)

removes a child

removes a child from the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer child = 56; // Integer | The id of the child to remove from the gorup
try {
    apiInstance.removeChild(groupId, child);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#removeChild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **child** | **Integer**| The id of the child to remove from the gorup | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="removeTeacher"></a>
# **removeTeacher**
> removeTeacher(groupId, teacher)

removes a teacher

removes a teacher from the group

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer teacher = 56; // Integer | The id of the teacher to remove
try {
    apiInstance.removeTeacher(groupId, teacher);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#removeTeacher");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **teacher** | **Integer**| The id of the teacher to remove | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="sendMessage"></a>
# **sendMessage**
> sendMessage(parentId, message)

send a message

send a message

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer parentId = 56; // Integer | The id of the parent
Message message = new Message(); // Message | The message to send
try {
    apiInstance.sendMessage(parentId, message);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sendMessage");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parentId** | **Integer**| The id of the parent |
 **message** | [**Message**](Message.md)| The message to send |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="setParent"></a>
# **setParent**
> setParent(childId, parentId)

set a child&#39;s parent

set a child&#39;s parent

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer childId = 56; // Integer | The id of the child
Integer parentId = 56; // Integer | The id of the childs parent.
try {
    apiInstance.setParent(childId, parentId);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#setParent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **childId** | **Integer**| The id of the child |
 **parentId** | **Integer**| The id of the childs parent. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: Not defined

<a name="vote"></a>
# **vote**
> vote(groupId, postId, theVoteToSubmit)

makes a vote

makes a vote on a poll inside a post

### Example
```java
// Import classes:
//import io.swagger.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Integer groupId = 56; // Integer | The id of the group
Integer postId = 56; // Integer | The id of the post
Vote theVoteToSubmit = new Vote(); // Vote | The text of the comment
try {
    apiInstance.vote(groupId, postId, theVoteToSubmit);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#vote");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**| The id of the group |
 **postId** | **Integer**| The id of the post |
 **theVoteToSubmit** | [**Vote**](Vote.md)| The text of the comment |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

