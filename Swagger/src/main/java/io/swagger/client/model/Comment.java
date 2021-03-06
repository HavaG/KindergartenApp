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

import io.swagger.client.model.KindergartenUser;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Comment {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("creator")
  private KindergartenUser creator = null;
  @SerializedName("content")
  private String content = null;
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
  @ApiModelProperty(required = true, value = "")
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
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
    Comment comment = (Comment) o;
    return (this.id == null ? comment.id == null : this.id.equals(comment.id)) &&
        (this.creator == null ? comment.creator == null : this.creator.equals(comment.creator)) &&
        (this.content == null ? comment.content == null : this.content.equals(comment.content)) &&
        (this.creationDate == null ? comment.creationDate == null : this.creationDate.equals(comment.creationDate));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.creator == null ? 0: this.creator.hashCode());
    result = 31 * result + (this.content == null ? 0: this.content.hashCode());
    result = 31 * result + (this.creationDate == null ? 0: this.creationDate.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comment {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  creator: ").append(creator).append("\n");
    sb.append("  content: ").append(content).append("\n");
    sb.append("  creationDate: ").append(creationDate).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
