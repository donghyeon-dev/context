package com.autocat.context.controller;

import brave.Tracer;
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

    @GetMapping("/span-id")
    public String getSpanId(){
        log.info("getSpanId() Start");

        String spanId = trace.currentSpan().context().spanIdString();
        log.info("trace.spanId={}",spanId);
        log.info("trace.traceId={}", trace.currentSpan().context().traceIdString());

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
