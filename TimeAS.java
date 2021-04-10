
package ua.kpi.comsys.iv8222;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TimeAS {
    int hours;
    int minutes;
    int seconds;

    public TimeAS(LocalTime finaltime3) {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public TimeAS(int hou, int min, int sec) {
        if (hou >= 0 && hou <= 23) {
            this.hours = hou;
        } else {
            System.err.println("The hours are set incorrectly");
        }

        if (min >= 0 && min <= 59) {
            this.minutes = min;
        } else {
            System.err.println("The minutes are set incorrectly");
        }

        if (sec >= 0 && sec <= 59) {
            this.seconds = sec;
        } else {
            System.err.println("The seconds are set incorrectly");
        }

    }

    public TimeAS(Date hou, Date min, Date sec) {
        this.hours = Integer.valueOf(String.valueOf(hou));
        this.minutes = Integer.valueOf(String.valueOf(min));
        this.seconds = Integer.valueOf(String.valueOf(sec));
    }

    public String getTime() {
        String data = new String();
        String h_n = new String();
        List<Integer> hours_list1 = Arrays.asList(0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        List<Integer> hours_list2 = Arrays.asList(12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        if (hours_list1.contains(this.hours)) {
            data = this.hours + ":" + this.minutes + ":" + this.seconds + " AM";
        }
        if (hours_list1.contains(this.hours)) {
            if (this.hours == 0) {
                h_n = "12";
            }
            data = h_n + ":" + this.minutes + ":" + this.seconds + " AM";
        }

        if (hours_list2.contains(this.hours)) {
            if (this.hours == 12) {
                h_n = "12";
            }

            if (this.hours == 13) {
                h_n = "1";
            }

            if (this.hours == 14) {
                h_n = "2";
            }

            if (this.hours == 15) {
                h_n = "3";
            }

            if (this.hours == 16) {
                h_n = "4";
            }

            if (this.hours == 17) {
                h_n = "5";
            }

            if (this.hours == 18) {
                h_n = "6";
            }

            if (this.hours == 19) {
                h_n = "7";
            }

            if (this.hours == 20) {
                h_n = "8";
            }

            if (this.hours == 21) {
                h_n = "9";
            }

            if (this.hours == 22) {
                h_n = "10";
            }

            if (this.hours == 23) {
                h_n = "11";
            }

            if (this.hours == 24) {
                h_n = "12";
            }

            data = h_n + ":" + this.minutes + ":" + this.seconds + " PM";
        }

        return data;
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public static TimeAS supp(TimeAS a, TimeAS b) {
        int h1 = a.getHours();
        int m1 = a.getMinutes();
        int s1 = a.getSeconds();
        int h2 = b.getHours();
        int m2 = b.getMinutes();
        int s2 = b.getSeconds();
        LocalTime Firsttime = LocalTime.of(h1, m1, s1);
        LocalTime Finaltime1 = Firsttime.plusHours(Long.parseLong(String.valueOf(h2)));
        LocalTime Finaltime2 = Finaltime1.plusMinutes(Long.parseLong(String.valueOf(m2)));
        LocalTime Finaltime3 = Finaltime2.plusSeconds(Long.parseLong(String.valueOf(s2)));
        return new TimeAS(Finaltime3);
    }

    public TimeAS supp(TimeAS second) {
        return supp(this, second);
    }

    public static TimeAS sub(TimeAS a, TimeAS b) {
        int h1 = a.getHours();
        int m1 = a.getMinutes();
        int s1 = a.getSeconds();
        int h2 = b.getHours();
        int m2 = b.getMinutes();
        int s2 = b.getSeconds();
        LocalTime Firsttime = LocalTime.of(h1, m1, s1);
        LocalTime Finaltime1 = Firsttime.minusHours(Long.parseLong(String.valueOf(h2)));
        LocalTime Finaltime2 = Finaltime1.minusMinutes(Long.parseLong(String.valueOf(m2)));
        LocalTime Finaltime3 = Finaltime2.minusSeconds(Long.parseLong(String.valueOf(s2)));
        return new TimeAS(Finaltime3);
    }

    public TimeAS sub(TimeAS second) {
        return sub(this, second);
    }

    public static void main(String[] args) {
        TimeAS a = new TimeAS(10, 12, 13);
        TimeAS b = new TimeAS(3, 7, 12);
        TimeAS time11 = new TimeAS(0, 0, 0);
        TimeAS time22 = new TimeAS(12, 0, 0);
        System.out.println("T1 " + time11.getTime());
        System.out.println("T2 " + time22.getTime());
        TimeAS time1 = new TimeAS(23, 59, 59);
        TimeAS time2 = new TimeAS(12, 0, 1);
        TimeAS time3 = new TimeAS(0, 0, 0);
        TimeAS time4 = new TimeAS(0, 0, 1);
        TimeAS time1plus2 = time1.supp(time2);
        TimeAS time3minus4 = time3.sub(time4);
        //System.out.println("T1 + T2 = " + time1plus2);
        //System.out.println("T3 - T4 = " + time3minus4);
    }
}
