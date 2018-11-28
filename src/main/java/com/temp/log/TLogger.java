package com.temp.log;

import org.springframework.util.StopWatch;
import org.springframework.core.Ordered;
import org.aspectj.lang.ProceedingJoinPoint;

public class TLogger implements Ordered {
	private int order;
	
	public int getOrder() {
		// TODO Auto-generated method stub
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	public Object profile(ProceedingJoinPoint call) throws Throwable {
        Object returnValue;
        StopWatch clock = new StopWatch(getClass().getName());
        try {
            clock.start(call.toShortString());
            returnValue = call.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint() + " === > TARGET " + call.getTarget());
        }
        
        return returnValue;
    }

}
