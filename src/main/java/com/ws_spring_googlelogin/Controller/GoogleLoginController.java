package com.ws_spring_googlelogin.Controller;


import com.ws_spring_googlelogin.DTO.UserDetailsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@Slf4j
public class GoogleLoginController {

    @GetMapping("/")
    @CrossOrigin
    public UserDetailsDTO getData(OAuth2AuthenticationToken oAuth2AuthenticationToken){
        log.info("User Info===> " + oAuth2AuthenticationToken.getPrincipal());
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setEmail(oAuth2AuthenticationToken.getPrincipal().getAttribute("email"));
        userDetailsDTO.setUserName(oAuth2AuthenticationToken.getPrincipal().getAttribute("name"));
        userDetailsDTO.setProfilePicture(oAuth2AuthenticationToken.getPrincipal().getAttribute("picture"));
        return userDetailsDTO;
    }
}
