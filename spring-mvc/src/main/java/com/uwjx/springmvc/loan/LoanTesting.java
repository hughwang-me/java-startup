package com.uwjx.springmvc.loan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoanTesting {
    /**
     * 设贷款总额为A，银行月利率为R，总期数为n（个月），月还款额设为X，则各个月所欠银行贷款为：
     * <p>
     * 第一个月 A(1+R)-X
     * <p>
     * 第二个月 (A(1+R)-X)(1+R)-X=A(1+R)^2-X[1+(1+R)]
     * <p>
     * 第三个月 [A(1+R)-X)(1+R)-X](1+R)-X =A(1+R)^3-X[1+(1+R)+(1+R)^2] …
     * <p>
     * 由此可得第n个月后所欠银行贷款为 A(1+R)^n–X[1+(1+R)+(1+R)^2+…+(1+R)^(n-1)]= A(1+R)^n –X[(1+R)^n - 1]/R
     * <p>
     * 由于还款总期数为n，也即第n月刚好还完银行所有贷款，
     * <p>
     * 因此有 A(1+R)^n –X[(1+R)^n - 1]/R=0
     * <p>
     * 由此求得 X = AR(1+R)^n /[(1+R)^n - 1]
     */
    public static void main(String[] args) {
        int loanMoney = 100 * 10000;
        double lpr = 3.95 * 0.01;
        double bp = -25 * 0.01 * 0.01;
        double monthRate = (lpr + bp) / 12;
        int month = 12 * 20;

        double everyMonth = loanMoney * monthRate * Math.pow((1 + monthRate), month) / (Math.pow((1 + monthRate), month) - 1);
        log.warn("执行利率:{}", monthRate * 12);
        log.warn("月还款额:{}", everyMonth);

        double payed = 0; // 已归还本金
//        double unPayed = 0; //未归还本金
        double payedInterest = 0; //已支付利息
        for (int i = 1; i < month + 1; i++) {
            double currentMonthInterest = (loanMoney - payed) * monthRate; //当月利息
            double currentMonthPrincipal = everyMonth - currentMonthInterest; //当月归还本金
            payedInterest += currentMonthInterest;
            payed += currentMonthPrincipal;
            log.warn("第 {} 个月 剩余本金:{} -> 还款:{} , 其中利息: {} , 本金: {}", i, (loanMoney - payed), everyMonth, currentMonthInterest, currentMonthPrincipal);
        }
        log.warn("付了总利息:{}", payedInterest);
        log.warn("付了总金额:{}", (payedInterest + payed));
    }
}
