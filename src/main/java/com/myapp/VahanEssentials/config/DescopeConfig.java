package com.myapp.VahanEssentials.config;

import com.descope.client.Config;
import com.descope.client.DescopeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DescopeConfig {

    @Bean
    public DescopeClient descopeClient() {
        return new DescopeClient(Config.builder().projectId("P2d2yxCXuMcXngkV7SBXPBtc5JTu").build());
    }
}
