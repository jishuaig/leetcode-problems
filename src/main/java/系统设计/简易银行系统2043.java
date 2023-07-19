package 系统设计;

public class 简易银行系统2043 {

    class Bank {

        private long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (isNotValid(account1) || isNotValid(account2))
                return false;
            if (money < 0)
                return false;
            if (balance[account1 - 1] < money) {
                return false;
            }
            balance[account1 - 1] = balance[account1 - 1] - money;
            balance[account2 - 1] = balance[account2 - 1] + money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (isNotValid(account))
                return false;
            if (money < 0)
                return false;
            balance[account - 1] = balance[account - 1] + money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (isNotValid(account))
                return false;
            if (money < 0)
                return false;
            if (balance[account - 1] < money) {
                return false;
            }
            balance[account - 1] = balance[account - 1] - money;
            return true;
        }

        private boolean isNotValid(int account) {
            if (account < 1 || account > balance.length) {
                return true;
            }
            return false;
        }
    }

}
