package com.example.apiRest.controller;

import com.example.apiRest.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticationController {

    @PostMapping
    public ResponseEntity<?> autenticate(@RequestBody @Valid LoginDTO loginDTO) {
        System.out.println(loginDTO.getEmail());
        System.out.println(loginDTO.getPassword());

        return ResponseEntity.ok().build();
    }
}
