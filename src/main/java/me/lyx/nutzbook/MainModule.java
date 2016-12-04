package me.lyx.nutzbook;

import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * Created by liyx on 16-11-5.
 */
@SetupBy(value=MainSetup.class)
@Modules(scanPackage=true)
@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/","custom/",
        "*anno", "me.lyx.nutzbook",
        "*tx", // 事务拦截 aop
        "*async"})
public class MainModule {
}
