package com.vote.core.dao.entity;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table( name = "t_user", schema = "voices")
public class User implements UserDetails {

  @Id
  private UUID uuid;

  @Column(name = "dt_create")
  private OffsetDateTime dtCreate;

  @Version
  @Column(name = "dt_update")
  private OffsetDateTime dtUpdate;

  @Column(name = "identification_number")
  private String identificationNumber;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(schema = "voices", name = "t_user_roles",
      joinColumns = { @JoinColumn(name = "user_uuid", referencedColumnName = "uuid")},
      inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id")})

  private Set<Role> roles;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_status")
  private UserStatus userStatus;

  @Column(name = "passport_number")
  private String passportNumber;

  @Column(name = "account_non_expired")
  private boolean accountNonExpired;

  @Column(name = "account_non_locked")
  private boolean accountNonLocked;

  @Column(name = "credentials_non_expired")
  private boolean credentialsNonExpired;

  @Column(name = "enabled")
  private boolean enabled;

  public User() {
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles();
  }

  @Override
  public String getPassword() {
    return this.passportNumber;
  }

  @Override
  public String getUsername() {
    return this.identificationNumber;
  }

  @Override
  public boolean isAccountNonExpired() {
    return this.accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return this.accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return this.credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return this.enabled;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public OffsetDateTime getDtCreate() {
    return dtCreate;
  }

  public void setDtCreate(OffsetDateTime dtCreate) {
    this.dtCreate = dtCreate;
  }

  public OffsetDateTime getDtUpdate() {
    return dtUpdate;
  }

  public void setDtUpdate(OffsetDateTime dtUpdate) {
    this.dtUpdate = dtUpdate;
  }

  public void setIdentificationNumber(String identificationNumber) {
    this.identificationNumber = identificationNumber;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public UserStatus getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(UserStatus userStatus) {
    this.userStatus = userStatus;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

}
