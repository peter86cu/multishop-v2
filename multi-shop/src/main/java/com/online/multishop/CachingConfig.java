package com.online.multishop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching
@Configuration
public class CachingConfig {
 
	@Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = new ArrayList<>();

        // Configura la caché "statusTerminalUser" con TTL de 24 horas
        caches.add(new CaffeineCache("statusTerminalUser",
                Caffeine.newBuilder()
                        .expireAfterWrite(24, TimeUnit.HOURS) // TTL de 24 horas
                        .maximumSize(1000) // Opcional: limitar el tamaño de la caché
                        .build()));

        // Configura las demás cachés sin TTL específico
        String[] otherCaches = {"tipoProducto", "monedas", "productos", "marcas", "modelos", "dptoPais", "categorias","productosRelacionados", "cambioMoneda"};
        for (String cacheName : otherCaches) {
            caches.add(new CaffeineCache(cacheName, Caffeine.newBuilder().build()));
        }

        cacheManager.setCaches(caches);
        return cacheManager;
    }
}