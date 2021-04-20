package logic;

public class TableRow {
    private Integer id;
    private final Double integralResult;
    private final Long time;

    public TableRow(int id, double integralResult, long time) {
        this.id = id;
        this.integralResult = integralResult;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public Double getResult() {
        return integralResult;
    }

    public Long getTime() {
        return time;
    }
}
