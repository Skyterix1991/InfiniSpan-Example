package pl.skyterix.infinispan.utils;

import org.infinispan.client.hotrod.RemoteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheStorage {

    private final RemoteCache<String, Object> defaultCache;

    @Autowired
    public CacheStorage(RemoteCache<String, Object> defaultCache) {
        this.defaultCache = defaultCache;
    }

    public void putString(String key, String value) {
        defaultCache.put(key, value);
    }

    public String retrieveString(String key, String defaultValue) {
        return defaultCache.getOrDefault(key, defaultValue).toString();
    }

    public void putDouble(String key, double value) {
        defaultCache.put(key, value);
    }

    public double retrieveDouble(String key, double defaultValue) {
        return (double) defaultCache.getOrDefault(key, defaultValue);
    }

    public void putInteger(String key, int value) {
        defaultCache.put(key, value);
    }

    public int retrieveInteger(String key, int defaultValue) {
        return (int) defaultCache.getOrDefault(key, defaultValue);
    }

    public void putLong(String key, long value) {
        defaultCache.put(key, value);
    }

    public long retrieveLong(String key, long defaultValue) {
        return (long) defaultCache.getOrDefault(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        defaultCache.put(key, value);
    }

    public boolean retrieveBoolean(String key, boolean defaultValue) {
        return (boolean) defaultCache.getOrDefault(key, defaultValue);
    }

    public void put(String key, Object value) {
        defaultCache.put(key, value);
    }

    public Object retrieve(String key, Object defaultValue) {
        return defaultCache.getOrDefault(key, defaultValue);
    }
}
