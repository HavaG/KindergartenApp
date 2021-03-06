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

import io.swagger.client.model.Comment;
import io.swagger.client.model.Image;
import io.swagger.client.model.KindergartenPoll;
import io.swagger.client.model.KindergartenUser;
import io.swagger.client.model.Like;
import io.swagger.client.model.Path;
import java.util.*;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class KindergartenPost {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("creator")
  private KindergartenUser creator = null;
  @SerializedName("content")
  private String content = null;
  @SerializedName("image")
  private Image image = null;
  @SerializedName("poll")
  private KindergartenPoll poll = null;
  @SerializedName("path")
  private List<Path> path = null;
  @SerializedName("likes")
  private List<Like> likes = null;
  @SerializedName("comments")
  private List<Comment> comments = null;
  @SerializedName("creationDate")
  private String creationDate = null;

  /**
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
  public KindergartenUser getCreator() {
    return creator;
  }
  public void setCreator(KindergartenUser creator) {
    this.creator = creator;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Image getImage() {
    return image;
  }
  public void setImage(Image image) {
    this.image = image;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public KindergartenPoll getPoll() {
    return poll;
  }
  public void setPoll(KindergartenPoll poll) {
    this.poll = poll;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<Path> getPath() {
    return path;
  }
  public void setPath(List<Path> path) {
    this.path = path;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<Like> getLikes() {
    return likes;
  }
  public void setLikes(List<Like> likes) {
    this.likes = likes;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<Comment> getComments() {
    return comments;
  }
  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
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
    KindergartenPost kindergartenPost = (KindergartenPost) o;
    return (this.id == null ? kindergartenPost.id == null : this.id.equals(kindergartenPost.id)) &&
        (this.creator == null ? kindergartenPost.creator == null : this.creator.equals(kindergartenPost.creator)) &&
        (this.content == null ? kindergartenPost.content == null : this.content.equals(kindergartenPost.content)) &&
        (this.image == null ? kindergartenPost.image == null : this.image.equals(kindergartenPost.image)) &&
        (this.poll == null ? kindergartenPost.poll == null : this.poll.equals(kindergartenPost.poll)) &&
        (this.path == null ? kindergartenPost.path == null : this.path.equals(kindergartenPost.path)) &&
        (this.likes == null ? kindergartenPost.likes == null : this.likes.equals(kindergartenPost.likes)) &&
        (this.comments == null ? kindergartenPost.comments == null : this.comments.equals(kindergartenPost.comments)) &&
        (this.creationDate == null ? kindergartenPost.creationDate == null : this.creationDate.equals(kindergartenPost.creationDate));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.creator == null ? 0: this.creator.hashCode());
    result = 31 * result + (this.content == null ? 0: this.content.hashCode());
    result = 31 * result + (this.image == null ? 0: this.image.hashCode());
    result = 31 * result + (this.poll == null ? 0: this.poll.hashCode());
    result = 31 * result + (this.path == null ? 0: this.path.hashCode());
    result = 31 * result + (this.likes == null ? 0: this.likes.hashCode());
    result = 31 * result + (this.comments == null ? 0: this.comments.hashCode());
    result = 31 * result + (this.creationDate == null ? 0: this.creationDate.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class KindergartenPost {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  creator: ").append(creator).append("\n");
    sb.append("  content: ").append(content).append("\n");
    sb.append("  image: ").append(image).append("\n");
    sb.append("  poll: ").append(poll).append("\n");
    sb.append("  path: ").append(path).append("\n");
    sb.append("  likes: ").append(likes).append("\n");
    sb.append("  comments: ").append(comments).append("\n");
    sb.append("  creationDate: ").append(creationDate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
