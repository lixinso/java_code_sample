import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class ConcurrentCalculator2 {
	
	private ExecutorService exec;
	private int cpuCoreNumber;
	//private List<Future<Long>> tasks = new ArrayList<Future<Long>>();
	private CompletionService<Long> completionService;
	
	
	class SumCalculator implements Callable<Long>{
		private int[] numbers;
		private int start;
		private int end;
		
		public SumCalculator(int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}

		@Override
		public Long call() throws Exception {
			Long sum = 0l;
			for(int i = start; i < end; i++){
				sum += numbers[i];
			}
			return sum;
		}
	}
	
	public ConcurrentCalculator2(){
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		exec = Executors.newFixedThreadPool(cpuCoreNumber);
		completionService = new ExecutorCompletionService<Long>(exec);
	}
	
	public Long sum(final int[] numbers){
		for(int i = 0 ; i < cpuCoreNumber ; i++){
			int increment = numbers.length/cpuCoreNumber + 1;
			int start = increment*i;
			int end = increment * i + increment;
			if(end > numbers.length)
				end = numbers.length;
			SumCalculator subCalc = new SumCalculator(numbers, start, end);
			//FutureTask<Long> task = new FutureTask<Long>(subCalc);
			//tasks.add(task);
			//if(!exec.isShutdown()){
			//	exec.submit(task);
			//}
			if(!exec.isShutdown()){
				completionService.submit(subCalc);
			}
		}
		return getResult();
	}
	
	public Long getResult(){
		Long result = 0l;
//		for(Future<Long> task : tasks){
//			try{
//				Long subSum = task.get();
//				result +=subSum;
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			}
//		}
		for(int i = 0 ; i < cpuCoreNumber; i++){
			try{
				Long subSum = completionService.take().get();
				result += subSum;
			}catch(InterruptedException e){
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void close(){
		exec.shutdown();
	}
	
	public static void main(String args[]){
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,10,11 };
		ConcurrentCalculator2 calc = new ConcurrentCalculator2();
		Long sum = calc.sum(numbers);
		System.out.println(sum);
		calc.close();
	}
}
