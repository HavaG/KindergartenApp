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
public class Like {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("user")
  private KindergartenUser user = null;

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
  public KindergartenUser getUser() {
    return user;
  }
  public void setUser(KindergartenUser user) {
    this.user = user;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Like like = (Like) o;
    return (this.id == null ? like.id == null : this.id.equals(like.id)) &&
        (this.user == null ? like.user == null : this.user.equals(like.user));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.user == null ? 0: this.user.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Like {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  user: ").append(user).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
