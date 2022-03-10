
package comparedate;

import java.util.Date;

public class CompareDate {

    public static void main(String[] args) {
        Validation date = new Validation();

        Date firstdate = date.CheckDate("Please enter the first date: ", "MMM/dd/yyyy");

        Date seconddate = date.CheckDate("Please enter the second date: ", "dd/MM/yyyy");

        if (firstdate.compareTo(seconddate) > 0) {
            System.out.println("Date1 is after Date2");
        } else if (firstdate.compareTo(seconddate) < 0) {
            System.out.println("Date1 is before Date2");
        } else {
            System.out.println("Date1 is equal to Date2");
        }
    }
    
}
