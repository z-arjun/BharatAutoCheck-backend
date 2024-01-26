package com.myapp.VahanEssentials.service;

import com.myapp.VahanEssentials.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<String> signup(User user) ;
}
