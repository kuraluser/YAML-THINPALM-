/* Licensed under Apache-2.0 */
package com.cpdss.gateway.entity;

import com.cpdss.common.utils.EntityDoc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity for users information
 *
 * @author suhail.k
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users extends EntityDoc {

  @Column(name = "user_name", length = 100)
  private String username;

  @Column(name = "first_name", length = 100)
  private String firstName;

  @Column(name = "last_name", length = 100)
  private String lastName;

  @Column(name = "email", length = 200)
  private String email;

  @Column(name = "hint_question", length = 100)
  private String hintQuestion;

  @Column(name = "hint_answer", length = 100)
  private String hintAnswer;

  @Column(name = "last_attempted_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime lastAttemptedDate;

  @Column(name = "last_login_date", columnDefinition = "TIMESTAMP")
  private LocalDateTime lastLoginDate;

  @Column(name = "company_xid")
  private Long companyXId;

  @Column(name = "is_active")
  private boolean isActive;

  @Column(name = "branch_xid")
  private Long branchXId;

  @Column(name = "timezone_xid")
  private Long timezoneXId;

  @Column(name = "designation_xid")
  private Long designationXId;

  @Column(name = "session_time")
  private Long sessionTime;

  @Column(name = "profile_path", length = 500)
  private String profilePath;

  @Column(name = "token", columnDefinition = "TEXT")
  private String token;

  @Column(name = "login_time", columnDefinition = "TIMESTAMP")
  private LocalDate loginTime;

  @Column(name = "keycloak_id", length = 100)
  private String keycloakId;

  @OneToMany(
      mappedBy = "users",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER)
  private List<RoleUserMapping> roleUserMappings;

  @ManyToOne
  @JoinColumn(name = "role_xid")
  private Roles roles;
}
