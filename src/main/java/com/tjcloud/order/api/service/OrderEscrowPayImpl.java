package com.tjcloud.order.api.service;

import com.tjcloud.core.exception.ServiceException;
import org.springframework.stereotype.Component;

@Component
public class OrderEscrowPayImpl implements OrderEscrowPay{
    @Override
    public boolean escrowRefund(String outTradeNo, String refundNo, String refundTotalAmount, String actualAmount, String reason) throws ServiceException {
        return false;
    }
}
