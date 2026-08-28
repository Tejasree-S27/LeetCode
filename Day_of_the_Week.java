import java.time.LocalDate;
class Solution {
    public String dayOfTheWeek(int day,int month,int year) {
        String dayName=LocalDate.of(year,month,day).getDayOfWeek().toString();
        return dayName.substring(0,1)+dayName.substring(1).toLowerCase();
    }
}
