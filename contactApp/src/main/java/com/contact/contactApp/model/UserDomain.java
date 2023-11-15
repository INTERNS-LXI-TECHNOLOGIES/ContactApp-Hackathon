package com.contact.contactApp.model;   
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name must not be empty")
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_domain_id",referencedColumnName = "infoId")
    private UserInfo userInfo;
    
    public UserDomain(UserInfo userInfo){
        this.userInfo=userInfo;
    }
   public UserDTO getUserDTO(){
      UserDTO userDTO = new UserDTO();
      userDTO.setPhoneNumber(this.phoneNumber);
      userDTO.setUserName(this.name);
      return userDTO;
   }
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getPhoneNumber() {
    return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}
public UserInfo getUserInfo() {
    return userInfo;
}
public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
}
    
}


