package com.autocat.context.controller;

import brave.Tracer;
import com.autocat.context.feign.ExternalClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/context")
@RequiredArgsConstructor
@Slf4j
public class ContextController {

    private final Tracer trace;
    private final ExternalClient externalClient;

    @GetMapping("/span-id")
    public String getSpanId() throws InterruptedException {
        log.info("getSpanId() Start");

        String spanId = trace.currentSpan().context().spanIdString();
        log.info("trace.spanId={}",spanId);
        log.info("trace.traceId={}", trace.currentSpan().context().traceIdString());

        Thread.sleep(2000);
        try {
            externalClient.getSearchResult();
        }catch(Exception e){
         log.warn("rpcClient.getSearchResult() got error");
         e.printStackTrace();
        }

        return spanId;
    };
    
    @GetMapping("/trace-id")
    public String getTraceId() {
        log.info("getTraceId() Start");

        String traceId = trace.currentSpan().context().traceIdString();
        log.info("trace.spanId={}", trace.currentSpan().context().spanIdString());
        log.info("trace.traceId={}", traceId);

        return traceId;
    };
}
