package io.github.zhenbianshu.minirpc.config;

import lombok.Data;

import java.util.List;

/**
 * @author zbs
 * @date 2019/9/29
 */
@Data
public class RefererConfig<T> {
    private String id;

    private Class<T> interfaceName;

    private T ref;

    private RegistryConfig registryConfig;

    private List<MethodConfig> methods;

    private String directUrl;
}