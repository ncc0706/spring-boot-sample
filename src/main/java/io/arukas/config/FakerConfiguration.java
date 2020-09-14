package io.arukas.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author niuyuxian <br/>
 * @date 2020/09/14 21:14 <br/>
 * @email ncc0706@gmail.com <br/>
 */
@Configuration
public class FakerConfiguration {
    @Bean
    public Faker faker() {
        return new Faker(Locale.CHINA);
    }
}
