package pojos;

public class PojoHeroKuAppRequestBody {


    /*

             {
                            "firstname": "Ahmet",
                            "lastname": "Bulut",
                            "totalprice": 500,
                            "depositpaid": false,
                            "bookingdates": {
                                                "checkin": "2021-06-01",
                                                "checkout": "2021-06-10"
                                             },
                            "additionalneeds": "wi-fi"
                            }
     */


    //1- Tüm variable lari private olarak olustur
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private PojoHeroKuAppBookingDates  bookingdates;
    private String additionalneeds;


     //2 tüm Variablellar icin gette rve setter methodlari olustur

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public PojoHeroKuAppBookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(PojoHeroKuAppBookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }


    //3 tüm parametreleri iceren bir Constructor olusutr

    public PojoHeroKuAppRequestBody(String firstname, String lastname, int totalprice, boolean depositpaid, PojoHeroKuAppBookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    // default constructor yerine manuel parametresiz constrcutor olustur

    public PojoHeroKuAppRequestBody() {
    }


    // toString methodu olutur


    @Override
    public String toString() {
        return "PojoHeroKuAppRequestBody{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
