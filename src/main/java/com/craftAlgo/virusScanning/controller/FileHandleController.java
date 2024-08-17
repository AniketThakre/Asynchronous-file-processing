package com.craftAlgo.virusScanning.controller;

import com.craftAlgo.virusScanning.service.FileScanService;
import com.craftAlgo.virusScanning.utility.StatusHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class FileHandleController {

    private StatusHandler statusHandler;
    private FileScanService fileScanService;

    @Autowired
    public FileHandleController(FileScanService fileScanService, StatusHandler statusHandler){
        this.fileScanService = fileScanService;
        this.statusHandler = statusHandler;
    }


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws InterruptedException
    {
        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("It seems you have not provided the file to process. Kindly provide the file to process.");
        }
        //To generate the unique task id for each file processing
        String TaskId  = UUID.randomUUID().toString();
        //Setting status as pending for now
        statusHandler.getTaskStatus().put(TaskId,"Your file processing is in pending state. It will start processing once allocated.");
        // Started the function execution asyncronously
        fileScanService.scanFile(file,TaskId,statusHandler);
        // As the above execution is asyncronous we can provide the task id to user for status check
        return ResponseEntity.accepted().body("Task Id : " + TaskId);
    }
}
