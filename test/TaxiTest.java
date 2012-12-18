import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaxiTest {
    public static final int Free_Mile = 2;
    public static final int Day_Qi_Bu_Price = 6;
    public static final int Day_Dan_Jia = 2;
    public static final int Night_Qi_Bu_Price = 7;
    public static final int Night_Dan_Jia = 3;
    public static final Time NightTime = Time.valueOf("22:00:00");
    public static final Time DayTime = Time.valueOf("08:00:00");

    Taxi taxi;
    private int mile;

    @Before
    public void setup() {
        taxi = new Taxi();
    }

    @Test
    public void should_price_be_qi_bu_when_mile_is_1() {
        mile = 1;
        assertThat(taxi.price(DayTime, mile), is(Day_Qi_Bu_Price));
    }

    @Test
    public void should_price_be_qi_bu_when_mile_is_2() {
        mile = 2;
        assertThat(taxi.price(DayTime, mile), is(Day_Qi_Bu_Price));
    }

    @Test
    public void should_price_be_qi_bu_and_taxi_fee_when_mile_more_than_2() {
        mile = 4;
        assertThat(taxi.price(DayTime, mile), is(Day_Qi_Bu_Price + (mile - Free_Mile) * Day_Dan_Jia));
    }

    @Test
    public void should_price_be_night_qi_bu_when_time_between_22_to_6_and_mile_less_than_2() {
        mile = 1;
        assertThat(taxi.price(NightTime, mile), is(Night_Qi_Bu_Price));
    }

    @Test
    public void should_price_be_night_qi_bu_and_night_taxi_fee_when_time_between_22_to_6_and_mile_more_than_2() {
        mile = 4;
        assertThat(taxi.price(NightTime, mile), is(Night_Qi_Bu_Price + (mile - Free_Mile) * Night_Dan_Jia));
    }
}
