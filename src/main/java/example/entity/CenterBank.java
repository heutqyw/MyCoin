package example.entity;

/**
 centerBank 中央银行
 Name：名称
 TotalNumber：发行货币总数额
 RestNumber：账户余额
 ID：ID固定为 0
 */
public class CenterBank {
    private String id="0";
    private String name;
    private long totalNumber;
    private long restNumber;

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

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public long getRestNumber() {
        return restNumber;
    }

    public void setRestNumber(long restNumber) {
        this.restNumber = restNumber;
    }
}
