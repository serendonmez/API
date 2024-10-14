package pojos;

public class PojoJsonPlaceHolder {


    /*
    {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
        }
     */

    //1- tum variable lari private olarak olustur

    private String title;
    private String body;
    private int userId;
    private int id;

    //2- Tum variablelar icin getter ve setter methodlari olustur


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3 tum parametreleri kullanarak bir constructor olustur

    public PojoJsonPlaceHolder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }


    // 4- Default constructor yerine manuel olarak parametresiz bir constructor olusturalim

    public PojoJsonPlaceHolder() {
    }


    //5- toString methodu olusturalim


    @Override
    public String toString() {
        return "PojoJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
