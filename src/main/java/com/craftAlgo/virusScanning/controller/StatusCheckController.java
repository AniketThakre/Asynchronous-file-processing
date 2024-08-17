package com.craftAlgo.virusScanning.controller;

import com.craftAlgo.virusScanning.utility.StatusHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusCheckController {

    private StatusHandler statusHandler;

    @Autowired
    public StatusCheckController(StatusHandler statusHandler){
        this.statusHandler = statusHandler;
    }
    @GetMapping("/check/{taskId}")
    public ResponseEntity<String> checkStatus(@PathVariable String taskId){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(statusHandler.getTaskStatus().getOrDefault(taskId,"Status not available for the task id.."));
    }
}
