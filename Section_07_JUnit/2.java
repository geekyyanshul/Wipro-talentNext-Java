import static org.junit.Assert.assertArrayEquals;
	
	import java.util.Arrays;
	
	public class TestSort {
	
		public static void main(String[] args) {
			int a[] = {4,5,3,2};
			int b[] = {5,4,3,2};
			
			//assertArrayEquals(a,b);
			Arrays.sort(a);
			Arrays.sort(b);
			assertArrayEquals(a,b);
			System.out.print("Sorted array are equal");
		}
		
	
	}
