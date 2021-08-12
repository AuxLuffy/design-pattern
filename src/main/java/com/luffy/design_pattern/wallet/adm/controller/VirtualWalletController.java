package com.luffy.design_pattern.wallet.adm.controller;

import com.luffy.design_pattern.wallet.adm.service.VirtualWalletService;

import java.math.BigDecimal;

/**
 * 虚拟钱包管理器
 *
 * @author sunzhangfei
 * @since 2021/7/27 4:15 下午
 */
public class VirtualWalletController {
    private VirtualWalletService virtualWalletService;

    /**
     * 查询余额
     *
     * @param walletId 钱包id
     * @return
     */
    public BigDecimal getBalance(long walletId) {
        BigDecimal bigDecimal = virtualWalletService.getBalance(walletId);
        return bigDecimal;
    }

    /**
     * 出帐
     *
     * @param walletId
     * @param amount
     */
    public void debit(long walletId, BigDecimal amount) {

    }

    /**
     * 入帐
     *
     * @param walletId
     * @param amount
     */
    public void credit(long walletId, BigDecimal amount) {

    }

    /**
     * 转帐
     *
     * @param fromWalletId
     * @param toWalletId
     * @param amount
     */
    public void transfer(long fromWalletId, long toWalletId, BigDecimal amount) {

    }

}