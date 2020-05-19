package com.service.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.service.configuration.RateLimiterCache;
import com.service.models.RateCounter;

public class RequestInterceptor extends HandlerInterceptorAdapter{
	
	@Value("${rateLimiter.enabled}")
	private boolean enableRateLimiter;
	
	@Value("${rateLimiter.timeSlot}")	
	private int timeSlot;
	
	@Value("${rateLimiter.limit}")	
	private int limit;
	
	@Autowired
	private RateLimiterCache cache;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(!enableRateLimiter) return true;
		
		Integer userId = request.getIntHeader("user_id");
		if(userId == -1) return true;
		
		RateCounter counter = cache.getCounter(userId);
		int count = counter.getCount();
		long timeDiff = System.currentTimeMillis()-counter.getTimestamp().getTime();
		if(timeDiff < timeSlot*1000  && count <= limit) {
			counter.setCount(count+1);
			return true;
		}
		
		response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
		return false;
	}


	public void testSetUp(boolean enableRateLimiter,int timeSlot,int limit) {
		this.enableRateLimiter = enableRateLimiter;
		this.timeSlot = timeSlot;
		this.limit = limit;

	}
	
}