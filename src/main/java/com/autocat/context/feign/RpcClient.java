package com.autocat.context.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="RPC", url="localhost:8080")
public interface RpcClient {

    @GetMapping("/rpc/async")
    public String runAsync();

}
