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

import io.swagger.client.model.GroupgroupIdcreatePostPath;
import io.swagger.client.model.GroupgroupIdcreatePostPoll;
import java.util.*;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Post {
  
  @SerializedName("content")
  private String content = null;
  @SerializedName("poll")
  private GroupgroupIdcreatePostPoll poll = null;
  @SerializedName("image")
  private String image = null;
  @SerializedName("path")
  private List<GroupgroupIdcreatePostPath> path = null;

  /**
   * The text of the post
   **/
  @ApiModelProperty(required = true, value = "The text of the post")
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public GroupgroupIdcreatePostPoll getPoll() {
    return poll;
  }
  public void setPoll(Poll poll) {
    this.poll = poll;
  }

  /**
   * the url of the image
   **/
  @ApiModelProperty(value = "the url of the image")
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public List<GroupgroupIdcreatePostPath> getPath() {
    return path;
  }
  public void setPath(List<GroupgroupIdcreatePostPath> path) {
    this.path = path;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Post post = (Post) o;
    return (this.content == null ? post.content == null : this.content.equals(post.content)) &&
        (this.poll == null ? post.poll == null : this.poll.equals(post.poll)) &&
        (this.image == null ? post.image == null : this.image.equals(post.image)) &&
        (this.path == null ? post.path == null : this.path.equals(post.path));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.content == null ? 0: this.content.hashCode());
    result = 31 * result + (this.poll == null ? 0: this.poll.hashCode());
    result = 31 * result + (this.image == null ? 0: this.image.hashCode());
    result = 31 * result + (this.path == null ? 0: this.path.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Post {\n");
    
    sb.append("  content: ").append(content).append("\n");
    sb.append("  poll: ").append(poll).append("\n");
    sb.append("  image: ").append(image).append("\n");
    sb.append("  path: ").append(path).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
