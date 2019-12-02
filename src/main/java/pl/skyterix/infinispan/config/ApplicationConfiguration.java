package pl.skyterix.infinispan.config;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.commons.configuration.BasicConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @Qualifier("defaultCache")
    public RemoteCache<String, Object> defaultCache(RemoteCacheManager cacheManager) {
        return cacheManager.administration().getOrCreateCache("default", (BasicConfiguration) null);
    }

}
