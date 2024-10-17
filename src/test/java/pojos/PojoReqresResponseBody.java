package pojos;

public class PojoReqresResponseBody {

    /*
     { "name": "John Doe", "job": "Manager" }.
     */

    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public PojoReqresResponseBody(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public PojoReqresResponseBody() {
    }

    @Override
    public String toString() {
        return "PojoReqresResponseBody{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
