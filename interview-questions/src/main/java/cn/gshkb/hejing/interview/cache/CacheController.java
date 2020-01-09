package cn.gshkb.hejing.interview.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cache")
public class CacheController {

    @RequestMapping("listCustomers")
    @Cacheable( value = "listCustomers" , key = "#length", sync = true)
    public List<Customer> listCustomers(Long length){
        List<Customer> customers = new ArrayList<>();
        for(int i=1; i <= length ; i ++){
            Customer customer = new Customer(i, "zhuyu"+i, 20 + i, false);
            customers.add(customer);
        }
        return customers;
    }

    // 以第一个参数为key进行缓存
    @Cacheable(value="users", key="#p0")
    public Long find(Long id) {
        return id;
    }
    // 以User中的id值为key进行缓存
    @Cacheable(value="users", key="#user.id")
    public User find(User user) {
        return user;
    }
    // 以User中的id值为key，且 condition 条件满足则缓存
    @Cacheable(value="users", key="#user.id", condition="#user.id%2==0")
    public User findbyID(User user) {
        return user;
    }
    // allEntries表示是否需要清除缓存中的所有元素。默认为false，当allEntries为true时，清除所有的元素
    @CacheEvict(value="user", allEntries=true)
    public void delete(Integer id) {
        System.out.println(id);
    }

}
