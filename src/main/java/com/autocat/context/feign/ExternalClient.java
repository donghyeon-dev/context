package com.autocat.context.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="ETC", url="https://www.naver.com/")
public interface ExternalClient {

    @GetMapping("/search")
    public String getSearchResult();

}
