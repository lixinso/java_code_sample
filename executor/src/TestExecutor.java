import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 *	http://www.iteye.com/topic/366591
 */

public class TestExecutor {
	static long counter = 0;
	public static void main(String args[]){
		
//		//Create Thread Pool
//		Executor executor = Executors.newFixedThreadPool(10);
//		Runnable task = new Runnable(){
//			public void run(){
//				counter ++;
//				System.out.println("Task Over" + counter);
//			}
//		};
//		executor.execute(task);
//		
//		executor = Executors.newScheduledThreadPool(10);
//		ScheduledExecutorService scheduler = (ScheduledExecutorService)executor;
//		scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);
//		
		
//		//ExecutorService Life Cycle
//		ExecutorService executorService = (ExecutorService)executor;
//		while(!executorService.isShutdown()){
//			try{
//				executorService.execute(task);
//			}catch(RejectedExecutionException ignored){
//				
//			}
//		}
//		executorService.shutdown();
		
//		//Callable,Future
//		Callable<Integer> func = new Callable<Integer>(){
//
//			@Override
//			public Integer call() throws Exception {
//				System.out.println("inside callable");
//				Thread.sleep(1000);
//				return new Integer(8);
//			}
//		};
//		FutureTask<Integer> futureTask = new FutureTask<Integer>(func);
//		Thread newThread = new Thread(futureTask);
//		newThread.start();
//		
//		try{
//			System.out.println("bloking here");
//			Integer result = futureTask.get();
//			System.out.println(result);
//		}catch(InterruptedException ignored){
//		}catch(ExecutionException ignored){
//		}
		
	}
}
