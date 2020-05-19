package com.service.configuration;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.service.models.RateCounter;

@Component
public class RateLimiterCache {

	private LoadingCache<Integer, RateCounter> userIdCountMapping;
	private ConcurrentHashMap<Integer, RateCounter> mapping = new ConcurrentHashMap<>();

	@Value("${rateLimiter.limit}")
	private Integer rateLimit;

	@Value("${rateLimiter.timeSlot}")
	private int timeSlot;

	private CacheBuilder<Object, Object> configureAndGetCacheBuilder() {
		CacheBuilder builder = CacheBuilder.newBuilder();
		builder = builder.expireAfterAccess(timeSlot, TimeUnit.SECONDS);
		builder = builder.expireAfterWrite(timeSlot, TimeUnit.SECONDS);
		return builder;
	}

	@PostConstruct
	public void init() throws ExecutionException {
		userIdCountMapping = configureAndGetCacheBuilder().build(new CacheLoader<Integer, RateCounter>() {
			@Override
			public RateCounter load(Integer userId) {
				RateCounter counter = new RateCounter();
				counter.setCount(0);
				counter.setTimestamp(new Timestamp(System.currentTimeMillis()));
				return counter;
			}
		});
	}

	public RateCounter getCounter(Integer userId) {
		RateCounter rateCounter = null;
		try {
			rateCounter = userIdCountMapping.get(userId);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rateCounter;
	}

	public RateCounter getRateCounter(Integer userId) {
		RateCounter counter = mapping.get(userId);
		if (counter == null) {
			counter = new RateCounter();
			counter.setCount(1);
			counter.setTimestamp(new Timestamp(System.currentTimeMillis()));
			mapping.put(userId, counter);
		}
		return counter;
	}

	public void updateEntry(Integer userId) {
		RateCounter counter = new RateCounter();
		counter.setCount(1);
		counter.setTimestamp(new Timestamp(System.currentTimeMillis()));
		mapping.put(userId, counter);
	}

}
