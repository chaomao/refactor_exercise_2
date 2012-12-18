import java.sql.Time;

public class Taxi {
    private static final int Free_Mile = 2;
    private static final int Day_Qi_Bu_Price = 6;
    private static final int Day_Dan_Jia = 2;
    private static final int Night_Dan_Jia = 3;
    private static final int Night_Qi_Bu_Price = 7;
    private static final int Day_Time_Start = 6;
    private static final int Day_Time_End = 22;

    public int price(Time time, int mile) {
        int qiBuPrice;
        if (time.getHours() >= Day_Time_Start && time.getHours() < Day_Time_End) {
            qiBuPrice = Day_Qi_Bu_Price;
        } else {
            qiBuPrice = Night_Qi_Bu_Price;
        }

        int travelPrice;

        if (mile <= Free_Mile) {
            travelPrice = 0;
        } else {
            if (time.getHours() >= Day_Time_Start && time.getHours() < Day_Time_End) {
                travelPrice = (mile - Free_Mile) * Day_Dan_Jia;
            } else {
                travelPrice = (mile - Free_Mile) * Night_Dan_Jia;
            }
        }
        return qiBuPrice + travelPrice;
    }

}
