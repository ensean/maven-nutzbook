package me.lyx.nutzbook;

import me.lyx.nutzbook.bean.User;
import me.lyx.nutzbook.service.RedisService;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;

import static org.nutz.dao.util.Pojos.log;

/**
 * Created by liyx on 16-11-5.
 */
public class MainSetup implements Setup {

    public void init(NutConfig conf) {
        Ioc ioc = conf.getIoc();
        Dao dao = ioc.get(Dao.class);
        Daos.createTablesInPackage(dao, "me.lyx.nutzbook", false);
        // 初始化默认根用户
        if (dao.count(User.class) == 0) {
            User user = new User();
            user.setName("admin");
            user.setPassword("123456");
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            dao.insert(user);
        }

        RedisService redis = ioc.get(RedisService.class);
        redis.set("hi", "liyx ");
        log.debug("redis say again : "  + redis.get("hi"));
    }

    public void destroy(NutConfig conf) {
    }
}
