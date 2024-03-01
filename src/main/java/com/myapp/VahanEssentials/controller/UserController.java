package com.myapp.VahanEssentials.controller;

import com.descope.enums.DeliveryMethod;
import com.descope.exception.DescopeException;
import com.descope.model.auth.AuthenticationInfo;
import com.descope.model.otp.SignUpRequest;
import com.descope.sdk.auth.OTPService;
import com.myapp.VahanEssentials.config.DescopeConfig;
import com.myapp.VahanEssentials.model.VerifyOtpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final DescopeConfig descopeConfig; // Assuming you have a DeScopeClient bean configured

    @Autowired
    public UserController(DescopeConfig descopeConfig) {
        this.descopeConfig = descopeConfig;
    }

    @PostMapping("/signupOtp")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        com.descope.model.user.User user = com.descope.model.user.User.builder()
                .phone(signUpRequest.getPhone())
                .email(signUpRequest.getEmail())
                .build();
        OTPService otps = descopeConfig.descopeClient().getAuthenticationServices().getOtpService();
        try {
            String maskedAddress = otps.signUpOrIn(DeliveryMethod.SMS, signUpRequest.getPhone());
            return ResponseEntity.ok().body("Signup successful, verification otp sent to: " + maskedAddress);
        } catch (DescopeException de) {
            // Handle the error appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Signup failed");
        }
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(@RequestBody VerifyOtpRequest request) {
        try {
            AuthenticationInfo info = descopeConfig.descopeClient().getAuthenticationServices().getOtpService().verifyCode(
                    DeliveryMethod.SMS,
                    request.getLoginId(),
                    request.getCode()
            );
            // Assuming success response includes releva    nt info
            return ResponseEntity.ok(info);
        } catch (Exception e) {
            // Handle the error appropriately
            // This could be returning a custom error response object with more details
            return ResponseEntity.badRequest().body("Verification failed: " + e.getMessage());
        }
    }
}
