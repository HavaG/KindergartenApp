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
import io.swagger.client.model.Note;
import io.swagger.client.model.Presence;
import java.util.*;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class KindergartenChild {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("parent")
  private KindergartenUser parent = null;
  @SerializedName("presences")
  private List<Presence> presences = null;
  @SerializedName("notes")
  private List<Note> notes = null;

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
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public KindergartenUser getParent() {
    return parent;
  }
  public void setParent(KindergartenUser parent) {
    this.parent = parent;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<Presence> getPresences() {
    return presences;
  }
  public void setPresences(List<Presence> presences) {
    this.presences = presences;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public List<Note> getNotes() {
    return notes;
  }
  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KindergartenChild kindergartenChild = (KindergartenChild) o;
    return (this.id == null ? kindergartenChild.id == null : this.id.equals(kindergartenChild.id)) &&
        (this.name == null ? kindergartenChild.name == null : this.name.equals(kindergartenChild.name)) &&
        (this.parent == null ? kindergartenChild.parent == null : this.parent.equals(kindergartenChild.parent)) &&
        (this.presences == null ? kindergartenChild.presences == null : this.presences.equals(kindergartenChild.presences)) &&
        (this.notes == null ? kindergartenChild.notes == null : this.notes.equals(kindergartenChild.notes));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.name == null ? 0: this.name.hashCode());
    result = 31 * result + (this.parent == null ? 0: this.parent.hashCode());
    result = 31 * result + (this.presences == null ? 0: this.presences.hashCode());
    result = 31 * result + (this.notes == null ? 0: this.notes.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class KindergartenChild {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  parent: ").append(parent).append("\n");
    sb.append("  presences: ").append(presences).append("\n");
    sb.append("  notes: ").append(notes).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
