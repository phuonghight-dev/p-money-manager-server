package com.example.moneymanagerbe.security;

import com.example.moneymanagerbe.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrincipal implements UserDetails {

  private final String id;

  private final String fullName;

  @JsonIgnore
  private final String email;

  @JsonIgnore
  private String password;

  private final Collection<? extends GrantedAuthority> authorities;

  public UserPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    this(null, null, username, password, authorities);
  }

  public UserPrincipal(String id, String fullName, String email, String password,
                       Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.password = password;

    if (authorities == null) {
      this.authorities = null;
    } else {
      this.authorities = new ArrayList<>(authorities);
    }
  }

  public static UserPrincipal create(User user) {
    List<GrantedAuthority> authorities = new LinkedList<>();
    authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
    return new UserPrincipal(user.getId(), user.getFullName(),
        user.getEmail(), user.getPassword(), authorities);
  }

  public String getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities == null ? null : new ArrayList<>(authorities);
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    UserPrincipal that = (UserPrincipal) object;
    return Objects.equals(id, that.id);
  }

  public int hashCode() {
    return Objects.hash(id);
  }

}
