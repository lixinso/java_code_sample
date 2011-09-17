
public class Case33 {

	int[] filter(int[] input ){
		if(input == null)
			return null;
		
		int length = input.length;
		
		/*标记有没有找到*/
		int[] marker = new int[length];  
		/*临时结果*/
		int[] result = new int[length];
		/*找到的不重复的数的计数*/
		int resultCounter = 0;
		
		/*最后一次找到的Value的位置*/
		int lastCurValuePos = 0;
		
		boolean allMarked = false;
		
		while(!allMarked){
			int curValue = 0;
			boolean foundCurValue = false;
			
			/*从上次找到的最后一个元素的位置开始接着找*/
			for(int i = lastCurValuePos ; i < length; i++){
				/*没有找到，接着找*/
				if(!foundCurValue){
					if(marker[i] == 0){
						curValue = input[i];
						lastCurValuePos = i;
						foundCurValue = true;
					}
				}
				
				/*找到了，把该元素都标记起来*/
				if(foundCurValue){
					if(input[i] == curValue){
						marker[i] = 1;
					}
				}
			}
			
			if(foundCurValue){
				/*如果找到了，则加入到result中*/
				result[resultCounter++] = curValue;
			}else{
				allMarked = true;
			}
			
		}
		
		/*去掉空的*/
		int[] returnResult = new int[resultCounter];
		for(int i = 0 ;i < resultCounter ; i++)
			returnResult[i] = result[i];
		
		return returnResult;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Case33 case33 = new Case33();
		int[] input = {2,3,3,4,5,4,2,6};
		int[] result = case33.filter(input);
		for(int i = 0 ; i < result.length; i++){
			System.out.print(result[i]);
		}
		System.out.println();
	}

}
