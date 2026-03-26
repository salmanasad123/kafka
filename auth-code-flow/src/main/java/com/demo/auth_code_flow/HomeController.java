package com.demo.auth_code_flow;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Flow kuch aisa hota hai:
 * User tumhari app pe aata hai
 * App bolti hai:
 * 👉 "jao login karo Keycloak pe"
 * User login karta hai (username/password)
 * Keycloak bolta hai:
 * 👉 "ok, ye banda valid hai"
 * Phir Keycloak redirect karta hai back tumhari app pe (redirect-uri)
 * Saath mein authorization code deta hai
 * Tumhari app us code ko use karke access token leti hai
 * Phir us token se Google Drive / APIs call karti hai
 */

@RestController
public class HomeController {

    // whenever a user logged in, its details are being stored in the class called OAuth2AuthenticationToken.
    @GetMapping("/")
    public String home(OAuth2AuthenticationToken oAuth2AuthenticationToken){
        return "Welcome " + oAuth2AuthenticationToken.getPrincipal().getAttribute("name") + " , " +
                oAuth2AuthenticationToken.getPrincipal().getAttribute("email");
    }
}
