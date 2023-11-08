package com.contact.contactApp.model;   
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_domain_id",referencedColumnName = "infoId")
    private UserInfo userInfo;
    
   public UserDTO getUserDTO(){
      UserDTO userDTO = new UserDTO();
      userDTO.setPhoneNumber(this.phoneNumber);
      userDTO.setUserName(this.name);
      return userDTO;
   }
    
}


