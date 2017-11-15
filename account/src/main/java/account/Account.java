package account;

public class Account {
    private double banlance ;

    /**存钱操作
     * @param amount
     */
    public void deposit(double amount){
        banlance+=amount;
    }

    /**取钱操作
     * @param amount 需要取出的钱
     * @return 如果余额小于amount返回false，否则返回true
     */
    public boolean withdraw(double  amount) {
        if (banlance>amount){
            banlance-=amount;
            return true;
        }
        return false;
    }


    public double getBanlance() {
        return banlance;
    }
}