package com.myapp.VahanEssentials.controller;

import com.descope.client.DescopeClient;
import com.descope.enums.DeliveryMethod;
import com.descope.exception.DescopeException;
import com.descope.model.user.User;
import com.descope.sdk.auth.OTPService;
import com.myapp.VahanEssentials.config.DescopeConfig;
import com.myapp.VahanEssentials.model.SignUpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final DescopeConfig descopeConfig; // Assuming you have a DeScopeClient bean configured

    @Autowired
    public AuthenticationController(DescopeConfig descopeConfig) {
        this.descopeConfig = descopeConfig;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        User user = User.builder()
                .name(signUpRequest.getName())
                .phone(signUpRequest.getPhone())
                .email(signUpRequest.getEmail())
                .build();
        OTPService otps = descopeConfig.descopeClient().getAuthenticationServices().getOtpService();
        try {
            String maskedAddress = otps.signUp(DeliveryMethod.SMS, signUpRequest.getPhone(), user);
            return ResponseEntity.ok().body("Signup successful, verification otp sent to: " + maskedAddress);
        } catch (DescopeException de) {
            // Handle the error appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Signup failed");
        }
    }
    // Define SignUpRequest class based on your needs
}
