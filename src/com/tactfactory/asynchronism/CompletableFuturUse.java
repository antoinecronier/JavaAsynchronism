package com.tactfactory.asynchronism;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFuturUse {

	public static void futurExample1(){
		CompletableFuture.runAsync(() -> System.out.println("Run async in completable future " + Thread.currentThread()));
		CompletableFuture.supplyAsync(() -> 5);
	}
	
	public static void futurExample2(){
		CompletableFuture.supplyAsync(() -> 5)
		.thenApply(i -> i * 3)
		.thenAccept(i -> System.out.println("The result is " + i))
		.thenRun(() -> System.out.println("Finished."));
	}
	
	public static void futurExample3(){
		CompletableFuture.supplyAsync(() -> 5)
		.thenApply(i -> {
			return i = i/0;
		})
		.exceptionally(ex -> 
			{
				ex.printStackTrace();
				return 0;
			})
		.thenAccept(i -> System.out.println("The result is " + i));
	}
	
	public static String futurExample4(){
		try {
			return CompletableFuture.supplyAsync(() -> "Hello")
				.thenCompose(
						s -> CompletableFuture
							.supplyAsync(() -> s + "World")
								.thenCompose(
									b -> CompletableFuture
										.supplyAsync(() -> 
												{
													System.out.println(b + " from async");
													return b;
												}
											)
										)
							).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "";
		} catch (ExecutionException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static CompletableFuture<String> futurExample5(){
		CompletableFuture<String> completableFuture 
	      = new CompletableFuture<>();
	 
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(1000);
	        completableFuture.complete("Hello");
	        return null;
	    });
	 
	    return completableFuture;
	}
	
	public static void futurExample6(){
		futurExample5().thenCombine(futurExample5(), (s,u) -> {
			System.out.println(u);
			return s + " World";
		}).thenAccept(v -> System.out.println(v));
	}
	
	public static void futurExample7(){
		BiFunction<String,String,String> func = (s,u) -> {
			System.out.println(u);
			return s + " World";
		};
		
		Consumer<String> cons = v -> System.out.println(v);
		
		futurExample5().thenCombine(futurExample5(), func).thenAccept(cons);
	}
	
	public static void futurExample8(Integer value, Function<Integer,Integer> action){
		CompletableFuture.supplyAsync(() -> value)
		.thenApply(action)
		.thenAccept(i -> System.out.println("The result is " + i));
	}
	
	public static void futurExample9(){
		CompletableFuture<String> future1  
		  = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2  
		  = CompletableFuture.supplyAsync(() -> "Mrs");
		CompletableFuture<String> future3  
		  = CompletableFuture.supplyAsync(() -> "Robinson");
		 
		CompletableFuture<Void> combinedFuture 
		  = CompletableFuture.allOf(future1, future2, future3);
		 
		try {
			combinedFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		String combined = Stream.of(future1, future2, future3)
				  .map(CompletableFuture::join)
				  .collect(Collectors.joining(" "));
		
		System.out.println(combined);
	}
}
