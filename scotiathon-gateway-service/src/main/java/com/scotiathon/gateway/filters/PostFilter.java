package com.scotiathon.gateway.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.java.Log;

@Component
@Log
public class PostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		Long initialTime = (Long) request.getAttribute("initialTime");
		Long finalTime = System.currentTimeMillis();
		Long finalRequestTime = finalTime - initialTime;
		log.info(String.format("tiempo total de la peticion en segundos : %s", finalRequestTime.doubleValue() / 1000));
		log.info("---- fin de la peticion----");
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
