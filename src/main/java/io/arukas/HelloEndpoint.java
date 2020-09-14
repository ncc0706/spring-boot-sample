package io.arukas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author niuyuxian <br/>
 * @date 2020/09/14 12:57 <br/>
 * @email ncc0706@gmail.com <br/>
 */
@RestController
public class HelloEndpoint {

    @GetMapping("env")
    public Map<String, String> env() {

        String javaVersion = System.getProperty("java.version");
        String javaArch = System.getProperty("sun.arch.data.model");

        return Map.of("javaVesion", javaVersion, "javaArch", javaArch);
    }

}
