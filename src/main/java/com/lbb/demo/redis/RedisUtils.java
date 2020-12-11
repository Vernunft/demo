package com.lbb.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;

/**
 * @author lbb
 * @date 2020/12/8 3:17 下午
 */
@Component
@Slf4j
public class RedisUtils {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key     缓存key
     * @param timeout 失效时间（秒）
     * @return
     */
    public boolean expire(String key, long timeout) {
        try {
            if (timeout > 0) {
                return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("指定缓存失效时间失败，", e);
            return false;
        }
    }

    /**
     * 获取失效时间
     *
     * @param key 缓存key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断是否有指定缓存
     *
     * @param key 缓存key
     * @return
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error("获取失效时间失败，", e);
            return false;
        }
    }

    /**
     * 删除指定缓存
     *
     * @param key 缓存key
     */
    public void del(String... key) {
        try {
            redisTemplate.delete(CollectionUtils.arrayToList(key));
        } catch (Exception e) {
            log.error("删除指定缓存失败，", e);
        }
    }

    // string

    /**
     * 普通缓存key获取
     *
     * @param key 缓存key
     * @return
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置键值
     *
     * @param key 键
     * @param value 值
     * @return
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("设置键值失败，", e);
            return false;
        }
    }

    /**
     * 设置键值，带失效时间
     * @param key 键
     * @param value 值
     * @param expire 失效时间（秒）
     * @return
     */
    public boolean setWithExpire(String key, Object value, long expire) {
        try {
            redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            log.error("设置键值失败，", e);
            return false;
        }
    }

    /**
     * 递增
     * @param key 键
     * @param delta 递增值
     * @return
     */
    public long inc(String key, long delta) {
        try {
            return redisTemplate.opsForValue().increment(key, delta);
        } catch (Exception e) {
            log.error("设置键增长失败，", e);
            return 0;
        }
    }

    /**
     * 递减
     * @param key 键
     * @param delta 递减值
     * @return
     */
    public long desc(String key, long delta) {
        try {
            return redisTemplate.opsForValue().decrement(key, -delta);
        } catch (Exception e) {
            log.error("设置键递减失败，", e);
            return 0;
        }
    }

    // hash

    /**
     * 获取hash
     * @param key 键
     * @param item 项
     * @return
     */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }








}
