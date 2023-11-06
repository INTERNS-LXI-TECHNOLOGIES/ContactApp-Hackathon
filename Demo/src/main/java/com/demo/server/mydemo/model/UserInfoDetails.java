package com.demo.server.mydemo.model;


public class UserInfoUserDetails implements UserDetails{
    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(User userinfo){
        userName=userinfo.getUserName();
        password=userinfo.getPassWord();
        authorities=Arrays.stream(userinfo.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

    }

    public UserInfoUserDetails(org.springframework.boot.autoconfigure.security.SecurityProperties.User user) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      System.out.println("User Authorities: " + authorities);
       return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
      return userName;
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

    
    
}

