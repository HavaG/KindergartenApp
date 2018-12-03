/**
 * Kindergarten API
 * This is the API for Kindergarten
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@kindergarten.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import io.swagger.client.model.KindergartenChild;
import io.swagger.client.model.KindergartenPost;
import io.swagger.client.model.KindergartenUser;
import io.swagger.client.model.Message;
import java.util.*;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Group {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("posts")
  private List<KindergartenPost> posts = null;
  @SerializedName("users")
  private List<KindergartenUser> users = null;
  @SerializedName("children")
  private List<KindergartenChild> children = null;
  @SerializedName("messages")
  private List<Message> messages = null;
  @SerializedName("creationDate")
  private String creationDate = null;

  /**
   * minimum: 1
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<KindergartenPost> getPosts() {
    return posts;
  }
  public void setPosts(List<KindergartenPost> posts) {
    this.posts = posts;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<KindergartenUser> getUsers() {
    return users;
  }
  public void setUsers(List<KindergartenUser> users) {
    this.users = users;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<KindergartenChild> getChildren() {
    return children;
  }
  public void setChildren(List<KindergartenChild> children) {
    this.children = children;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<Message> getMessages() {
    return messages;
  }
  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getCreationDate() {
    return creationDate;
  }
  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return (this.id == null ? group.id == null : this.id.equals(group.id)) &&
        (this.name == null ? group.name == null : this.name.equals(group.name)) &&
        (this.posts == null ? group.posts == null : this.posts.equals(group.posts)) &&
        (this.users == null ? group.users == null : this.users.equals(group.users)) &&
        (this.children == null ? group.children == null : this.children.equals(group.children)) &&
        (this.messages == null ? group.messages == null : this.messages.equals(group.messages)) &&
        (this.creationDate == null ? group.creationDate == null : this.creationDate.equals(group.creationDate));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.posts == null ? 0: this.posts.hashCode());
    result = 31 * result + (this.users == null ? 0: this.users.hashCode());
    result = 31 * result + (this.children == null ? 0: this.children.hashCode());
    result = 31 * result + (this.messages == null ? 0: this.messages.hashCode());
    result = 31 * result + (this.creationDate == null ? 0: this.creationDate.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  posts: ").append(posts).append("\n");
    sb.append("  users: ").append(users).append("\n");
    sb.append("  children: ").append(children).append("\n");
    sb.append("  messages: ").append(messages).append("\n");
    sb.append("  creationDate: ").append(creationDate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
