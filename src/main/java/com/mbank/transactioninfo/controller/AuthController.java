package com.mbank.transactioninfo.controller;

import com.mbank.transactioninfo.jwt.UsernameAndPasswordAuthenticationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {

    @PostMapping("login")
    public ResponseEntity<?>  login(@RequestBody UsernameAndPasswordAuthenticationRequest authRequest) throws Exception {

        return new ResponseEntity<>("Secured Endpoint invoked with JWT", HttpStatus.OK);

    }

    @PostMapping("secured")
    public ResponseEntity<?> secured() throws Exception {

       return new ResponseEntity<>("Secured Endpoint invoked with JWT", HttpStatus.OK);

    }


}
