package com.tactfactory.asynchronism;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureExample extends FutureTask<Void> {

	public FutureExample(Callable<Void> arg0) {
		super(arg0);
	}

}
