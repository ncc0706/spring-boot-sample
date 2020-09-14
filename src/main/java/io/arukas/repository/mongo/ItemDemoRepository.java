package io.arukas.repository.mongo;

import io.arukas.domain.ItemDemo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA. <br/>
 *
 * @author niuyuxian <br/>
 * @date 2020/09/14 20:38 <br/>
 * @email ncc0706@gmail.com <br/>
 */
@Repository
public interface ItemDemoRepository extends MongoRepository<ItemDemo, String> {
}
