package io.arukas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author niuyuxian <br/>
 * @date 2020/09/14 20:27 <br/>
 * @email ncc0706@gmail.com <br/>
 */
@Data
@Document(collection = "items")
public class ItemDemo {

    @Id
    private String id;

    private Map<String, Object> details;

    @Field(name = "remark")
    private String desc;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime createAt;

    //  @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;
}
