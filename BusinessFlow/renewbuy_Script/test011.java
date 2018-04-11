package renewbuy_Script;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

public class test011 {
	@Test
	public void test88() {
		YearMonth thisMonth    = YearMonth.now();
		YearMonth OneMonthAdd = thisMonth.plusMonths(1);
		
		DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM");
		
		String  test = OneMonthAdd.format(monthYearFormatter);
		System.out.println(test);
	}

}
