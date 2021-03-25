package com.payrollManagementSystem.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView globalExceptionHandling(Exception e)
	{	e.printStackTrace();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorMsg", "We have encountered a problem. Please try again after some time.");
		modelAndView.setViewName("globalExceptionPage");
		return modelAndView;
	}

}
