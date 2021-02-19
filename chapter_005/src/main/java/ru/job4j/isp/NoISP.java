package ru.job4j.isp;

import java.sql.Date;

public class NoISP {
    interface Transport {
        public void gas();
        public void stop();
        public void takeoff();
        public void landing();
    }

    interface ShopFood {
        public void sellKGMeat();
        public void sellVolumeMilk();
    }

    interface Ticket {
        public int getSeat();
        public Date getTimeArrive();
        public Date getTimeDeparture();
        public String getPassenger();
        public boolean getCargo();
        public float getBaggage();
    }
}
