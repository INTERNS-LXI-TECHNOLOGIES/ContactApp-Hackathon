
package com.demo.server.mydemo.model;



@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String passWord;
    private String role;
    
    @OneToOne
   private DomainUser duser;


}
