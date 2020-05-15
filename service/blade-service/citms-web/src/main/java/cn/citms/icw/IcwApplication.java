package cn.citms.icw;

import org.springblade.common.constant.CitmsAppConstant;
import org.springblade.core.cloud.feign.EnableBladeFeign;
import org.springblade.core.launch.BladeApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务启动器
 */
@SpringCloudApplication
@EnableZuulProxy
@EnableBladeFeign(basePackages = { "cn.citms"})
public class IcwApplication {

    public static void main(String[] args) {
        BladeApplication.run(CitmsAppConstant.APPLICATION_MBD_NAME, IcwApplication.class, args);
    }

}
