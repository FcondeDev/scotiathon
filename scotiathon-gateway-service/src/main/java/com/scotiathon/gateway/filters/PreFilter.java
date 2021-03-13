package com.scotiathon.gateway.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.java.Log;

@Component
@Log
public class PreFilter extends ZuulFilter {

	@Autowired
	ObjectMapper mapper;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		log.info("---- inicio de la peticion----");
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();

		log.info(String.format("%s request enrutada a : %s", request.getMethod(), request.getRequestURL()));
		Long initialTime = System.currentTimeMillis();
		request.setAttribute("initialTime", initialTime);
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
