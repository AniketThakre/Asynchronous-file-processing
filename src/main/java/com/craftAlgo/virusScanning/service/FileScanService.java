package com.craftAlgo.virusScanning.service;

import com.craftAlgo.virusScanning.utility.StatusHandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileScanService {


    @Async
    public void scanFile(MultipartFile file, String TaskId, StatusHandler statusHandler) throws InterruptedException {

        Thread.sleep(10000);
        statusHandler.getTaskStatus().put(TaskId,"In progress");
        Thread.sleep(20000);
        statusHandler.getTaskStatus().put(TaskId,"Completed");
        statusHandler.setFinalResult("Here is the result..");
    }
}
