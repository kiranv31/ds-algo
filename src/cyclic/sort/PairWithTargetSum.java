package cyclic.sort;

public class PairWithTargetSum {
	
	public static void main(String[] args) {
		int[] result = PairWithTargetSum.searchVol1(new int[] { 1, 2, 3, 4, 6 }, 6);
	    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	    result = PairWithTargetSum.searchVol2(new int[] { 2, 5, 9, 11 }, 11);
	    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	}

	private static int[] searchVol1(int[] arr, int k) {
		int pointer1 = 0, pointer2= arr.length;
		int [] result = new int[pointer2];
		while(pointer1 < pointer2) {
			int sum = arr[pointer1] + arr[pointer2];
			if(sum == k) {
				
			}
		}
		return null;
	}

	private static int[] searchVol2(int[] arr, int k) {
		
		return null;
	}

}
