package com.myapp.VahanEssentials.model;

import com.descope.enums.DeliveryMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyOtpRequest {
    private String loginId;
    // Getters and Setters

    private String code;

    public String getLoginId() { return loginId; }
    public void setLoginId(String loginId) { this.loginId = loginId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}

