package com.tactfactory.asynchronism;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AsynchronismClass extends Thread implements AsynchronismClassExposure, Runnable, CustomRunnable1, CustomRunnable2 {

	private List<AsynchronismClassExposure> runnables = new ArrayList<AsynchronismClassExposure>();
	private Integer myInteger;

	@Override
	public Integer getInt() {
		return this.myInteger;
	}
	
	public AsynchronismClass(Integer myInteger) {
		super();
		this.myInteger = myInteger;
	}
	
	public void addRunnable(AsynchronismClassExposure runnable) {
		runnables.add(runnable);
	}

	@Override
	public void run() {
		doAction1(this.getInt());
		doAction2(this.getInt());
		for (AsynchronismClassExposure runnable : runnables) {
			runnable.run();
		}
	}

	@Override
	public void doAction2(Integer value) {
		System.out.println(value + " square " + value * value);
	}

	@Override
	public void doAction1(Integer value) {
		System.out.println(value + " factorial " + factorial(value));
	}
	
	public static BigInteger factorial(Integer number) {
	    BigInteger result = BigInteger.valueOf(1);

	    for (long factor = 2; factor <= number.longValue(); factor++) {
	        result = result.multiply(BigInteger.valueOf(factor));
	    }

	    return result;
	}
}
