package com.example.allon6webserver.Controllers;

import com.example.allon6webserver.DTO.EmailDTO;
import com.example.allon6webserver.Services.EmailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping(path="api/Emails")
public class EmailController {

    @Autowired
    EmailsService emailsService;

   
    @PostMapping()
    @ResponseBody()
    public ResponseEntity<?> PostEmail(@RequestBody EmailDTO userInfo){

        return new ResponseEntity<>(emailsService.SendContactInformation(userInfo), HttpStatus.CREATED);

    }
}
