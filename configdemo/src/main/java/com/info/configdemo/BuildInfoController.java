package com.info.configdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  // this is the bean I want to refresh so added this annotation
public class BuildInfoController {
    // inject values into the variables from external sources (property files, command line args,
    // system properties, environment variables)
    @Value("${build.id:default}")
    private String buildId;
    @Value("${build.version:default}")
    private String buildVersion;
    @Value("${build.name:default}")
    private String buildName;

    @GetMapping("/build-info")
    public String getBuildInfo(){
        return "Build ID: " + buildId + "\n" + "Build Version: " + buildVersion + "\n" +
                "Build Name: " + buildName;
    }
}
