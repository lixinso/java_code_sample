import java.util.Random;


public class Case31 {

	final int  TOTAL_CARD = 52;
	final int SHUFFLE_TIMES = 20;
 	
	Random randomSeed;
	
	/*初始化一个有序的输入*/
	int[] initCards(){
		int [] cards = new int[TOTAL_CARD];	
		randomSeed = new Random();
		for(int i = 0 ; i < TOTAL_CARD ; i++){
			cards[i] = i;
		}
		return cards;
	}
	
	/*排序*/
	int[] shuffle(int[] cards){
		/*洗牌SHUFFLE_TIMES次*/
		for(int i = 0 ; i < SHUFFLE_TIMES; i++){
			int pos = randomSeed.nextInt(TOTAL_CARD);
			int temp = cards[i];
			cards[i] = cards[pos];
			cards[pos] = temp;
		}
		
		/*幺牌:确保第一长牌和最后一张牌不在原来的位置*/
		int randomHalf = randomSeed.nextInt(TOTAL_CARD-1);
		for(int i = 0 ; i < randomHalf; i++){
			int first = cards[0];
			for( int j = 1 ; j < TOTAL_CARD; j++){
				cards[j-1] = cards[j];
			}
			cards[TOTAL_CARD-1] = first;
		}
		return cards;
	}


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Case31 case31 = new Case31();
		int[] cards = case31.initCards();
		int[] shuffledCards = case31.shuffle(cards);
		
		for(int i = 0 ; i < shuffledCards.length; i++){
			System.out.print(shuffledCards[i] + " ");
		}
		System.out.println();
	}

}
