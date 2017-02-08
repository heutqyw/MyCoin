package example.entity;

/**
 company 企业
 Name：名称
 Number：账户余额
 ID：企业 ID
 */
public class Company {
    private String id;
    private String name;
    private long number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
