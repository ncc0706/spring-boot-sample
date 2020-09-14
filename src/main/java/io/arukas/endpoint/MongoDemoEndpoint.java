package io.arukas.endpoint;

import com.github.javafaker.Faker;
import io.arukas.domain.ItemDemo;
import io.arukas.repository.mongo.ItemDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author niuyuxian <br/>
 * @date 2020/09/14 21:22 <br/>
 * @email ncc0706@gmail.com <br/>
 */
@RestController
public class MongoDemoEndpoint {

    @Autowired
    private ItemDemoRepository itemDemoRepository;

    @Autowired
    private Faker faker;

    @GetMapping("mongo/item")
    public ItemDemo saveItem() {

        ItemDemo itemDemo = new ItemDemo();
        Map<String, Object> details = Map.of(
                "pid", UUID.randomUUID().toString().replace("-", ""),
                "username", "mongodb",
                "version", faker.number().randomNumber(),
                "jdk", System.getProperty("java.version"),
                "languages", List.of("Java", "Kotlin", "Scala"),
                ".net", "C#"
        );
        // 默认3个句子
        itemDemo.setDesc(faker.lorem().paragraph());
        itemDemo.setDetails(details);
        itemDemo.setCreateAt(LocalDateTime.now());
        itemDemo.setUpdateAt(LocalDateTime.now());
        return itemDemoRepository.insert(itemDemo);
    }

    //    http://127.0.0.1:8080/mongo/page?size=2&page=2
    @GetMapping("mongo/page")
    public Page<ItemDemo> page(Pageable pageable) {
        return itemDemoRepository.findAll(pageable);
    }

    @GetMapping("mongo/item/{id}")
    public ItemDemo itemDemo(@PathVariable(name = "id") String id) {
        return itemDemoRepository.findById(id).orElse(new ItemDemo());
    }

    @GetMapping("mongo/item/delete")
    public void deleteItem(String id) {
        itemDemoRepository.deleteById(id);
    }

    @GetMapping("mongo/item/update/{id}")
    public ItemDemo update(@PathVariable(name = "id") String id, String remark) {
        ItemDemo itemDemo = itemDemoRepository.findById(id).orElse(new ItemDemo());
        itemDemo.setDesc(remark);
        itemDemo.setUpdateAt(LocalDateTime.now());
        return itemDemoRepository.save(itemDemo);
    }

    /**
     * 注意这里的数据类型 version 不用用错了
     *
     * @param version
     * @return
     */
    @GetMapping("mongo/queryItem")
    public ItemDemo queryItem(Long version) {
        ItemDemo itemDemo = new ItemDemo();
        itemDemo.setDetails(Map.of("version", version));
        return itemDemoRepository.findOne(Example.of(itemDemo)).orElse(new ItemDemo());
    }
}
