//Dailytasks.java
import java.util.Arrays;

public class DailyTasks {
	
	public String  doStringConcat (String s1,String s2) {
		return s1+" "+s2;
	}
	public int[] sortValues(int arr[]) {
			Arrays.sort(arr);
			return arr;
	}
	public boolean checkPresence(String str,String a) {
		return str.contains(a);
	}

}


//TestStringConcat.java
package com.wipro.test;
import static org.junit.Assert.assertEquals;
import com.wipro.task.DailyTasks;
public class TestStringConcat {
	public static void main(String[] arg) {
		DailyTasks st = new DailyTasks();
		 assertEquals("Hello World",st.doStringConcat("Hello","World"));
		System.out.println("Successfull");
	}
}
