package pojos;

public class PojoHeroKuAppBookingDates {

    /*
     "bookingdates": {
                                                "checkin": "2021-06-01",
                                                "checkout": "2021-06-10"
     */


    // 1- tum variablelari private olarak olustur
    String checkin;
    String checkout;



    //2- tum variable lar icin getter setter methodlari olustur

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    //3 tum parametreleri kullanarak bir constructor olustur

    public PojoHeroKuAppBookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }


    //4 default constructor yerine manuel olarak parametresiz constructor olsutur

    public PojoHeroKuAppBookingDates() {
    }


    //5 toString methodu olustur


    @Override
    public String toString() {
        return "PojoHeroKuAppBookingDates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
