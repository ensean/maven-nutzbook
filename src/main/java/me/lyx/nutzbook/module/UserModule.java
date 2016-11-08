package me.lyx.nutzbook.module;

/**
 * Created by liyx on 16-11-8.
 */
import me.lyx.nutzbook.bean.User;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;

@IocBean
@At("/user")
@Ok("json")
@Fail("http:500")
public class UserModule {

    @Inject
    protected Dao dao;

    @At
    public int count() {
        return dao.count(User.class);
    }

}
