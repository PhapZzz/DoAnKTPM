package test;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateRangeConverter {
    public String[] convertDateRangeToStringArray(String startDate, String endDate) {
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        LocalDate start = Date.valueOf(startDate).toLocalDate();
        LocalDate end = Date.valueOf(endDate).toLocalDate();

        while (!start.isAfter(end)) {
            dateList.add(formatter.format(Date.valueOf(start)));
            start = start.plusDays(1);
        }

        return dateList.toArray(new String[0]);
    }
    
    public static String convertDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    public static void main(String[] args) {
    	Date sqlDate = Date.valueOf("2024-09-30");
    	System.out.println(convertDateToString(sqlDate));
    }
}
