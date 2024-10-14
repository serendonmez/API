package pojos;

public class PojoHeroKuAppResponseBody {



    /*

                "bookingid": 3155,
                "booking": {
     */


    //1 tüm variable lari private olustur

    private int bookingid;
    private PojoHeroKuAppRequestBody booking;

    // 2 setter ve getter methodlari olustur

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHeroKuAppRequestBody getBooking() {
        return booking;
    }

    public void setBooking(PojoHeroKuAppRequestBody booking) {
        this.booking = booking;
    }


    //3 tüm parametreleri iceren Cons olustur

    public PojoHeroKuAppResponseBody(int bookingid, PojoHeroKuAppRequestBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }


    //4 parametresiz cons olustur

    public PojoHeroKuAppResponseBody() {
    }


    // 5 toString methodu olustur


    @Override
    public String toString() {
        return "PojoHeroKuAppResponseBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
