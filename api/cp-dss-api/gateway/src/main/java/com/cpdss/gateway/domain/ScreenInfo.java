/* Licensed under Apache-2.0 */
package com.cpdss.gateway.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Dto for screen information */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenInfo {

  private Long id;
  private String name;
  private String languageKey;
  private boolean add;
  private boolean edit;
  private boolean delete;
  private boolean view;
  private Long moduleId;
  List<ScreenInfo> childs;
  private RoleScreen roleScreen;
  private boolean isAddVisible;
  private boolean isEditVisible;
  private boolean isDeleteVisible;
  private boolean isViewVisible;
  

  public ScreenInfo(
      Long id,
      String name,
      String languageKey,
      boolean add,
      boolean edit,
      boolean delete,
      boolean view) {
    super();
    this.id = id;
    this.name = name;
    this.languageKey = languageKey;
    this.add = add;
    this.edit = edit;
    this.delete = delete;
    this.view = view;
  }

}
