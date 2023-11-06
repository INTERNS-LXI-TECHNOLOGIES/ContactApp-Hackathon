package com.demo.server.mydemo.service;


@Component
public class UserInfoUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userInfoRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userInfoRepo.findByUserName(username);
        

        if (!userInfo.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    
        return new UserInfoUserDetails(userInfo.get());
    }

     
    }
    


    

