package com.craftAlgo.virusScanning.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StatusHandler {
    private ConcurrentHashMap<String, String> taskStatus = new ConcurrentHashMap<>();

    private String finalResult;
}
