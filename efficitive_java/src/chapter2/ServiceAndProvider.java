package chapter2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ServiceAndProvider
 * @Description 结合函数型接口和lambda 表达式完成服务接口，提供接口，服务提供者接口
 * @Author zc-cris
 * @Version 1.0
 **/
public class ServiceAndProvider {
    public static void main(String[] args) {

        // register service by provider
        ServiceAndProviderUtil.registerDefult(() -> () -> System.out.println("age"));
        ServiceAndProviderUtil.registerProvider("name", () -> () -> System.out.println("cris"));

        // get service instance
        Service defaultService = ServiceAndProviderUtil.getDefaultService();
        Service name = ServiceAndProviderUtil.getService("name");

        // call service
        defaultService.func();
        name.func();
    }

}

@FunctionalInterface
interface Service {
    /**
     * @return void
     * @Author zc-cris
     * @Description service function
     * @Param []
     **/
    void func();
}

@FunctionalInterface
interface Provider {
    /**
     * @return chapter2.Service
     * @Author zc-cris
     * @Description provide service instance
     * @Param []
     **/
    Service provide();
}

/**
 * @Author zc-cris
 * @Description the util to provide service instance registration and acquisition
 * @Param
 * @return
 **/
class ServiceAndProviderUtil {
    private ServiceAndProviderUtil() {
    }

    private static final ConcurrentHashMap<String, Provider> PROVIDERS = new ConcurrentHashMap<>();
    private static final String DEFAULT_KEY = "default";


    /**
     * @return void
     * @Author zc-cris
     * @Description the registration of default provider
     * @Param [provider]
     **/
    public static void registerDefult(Provider provider) {
        PROVIDERS.put(DEFAULT_KEY, provider);
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description the registration of provider
     * @Param [key, provider]
     **/
    public static void registerProvider(String key, Provider provider) {
        PROVIDERS.put(key, provider);
    }

    /**
     * @return chapter2.Service
     * @Author zc-cris
     * @Description get the default service instance
     * @Param []
     **/
    public static Service getDefaultService() {
        return getService(DEFAULT_KEY);
    }

    /**
     * @return chapter2.Service
     * @Author zc-cris
     * @Description get the specified service instance
     * @Param [key]
     **/
    public static Service getService(String key) {
        Service provide = PROVIDERS.get(key).provide();
        if (provide == null) {
            throw new IllegalArgumentException("no provider registered with the service named: " + key);
        }
        return provide;
    }

}
