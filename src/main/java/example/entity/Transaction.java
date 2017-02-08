package example.entity;

/**
 transaction 交易内容
 FromType：发送方角色 //centerBank:0,Bank:1,Company:2
 FromID：发送方 ID
 ToType：接收方角色 //Bank:1,Company:2
 ToID：接收方 ID
 Time：交易时间
 Number：交易数额
 ID：交易 ID
 */
public class Transaction {
    private String id;
    private long time;
    private String transaction;
    private int fromType;
    private String fromID;
    private int toType;
    private String toID;
    private String number;


}
