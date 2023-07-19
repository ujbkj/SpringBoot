package com.catering.common.core.constant;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MemberConstants {


    public static final int WX_APPLET_TYPE_ID = 1;

    public static final int ZFB_APPLET_TYPE_ID = 2;

    /**
     *支付方式
     */

    public static final int WECHAT_PAY = 1;

    public static final int ALI_PAY = 2;

    /**
     * 平台订单
     */
    public static final int WECHAT_APPLET = 1;

    public static final int ALI_APPLET = 2;

    /**
     * 订单支付状态
     */
    public static final int STAY_PAY_STATUS_ID = 0;

    public static final int ALREADY_PAY_STATUS_ID = 1;

    public static final int NOT_PAY_STATUS_ID = 2;

    public static final int REFUNDED_PAY_STATUS_ID = 3;

    public static final int CANCELLED_PAY_STATUS_ID = 4;


    /**
     * 订单延时队列
     */
    public static final int DELAYED_DATE = 300000;

    public static final int ORDER_DELAYED_DATE = 10;

    public static final String CATERING_CALCULATOR_NAME = "catering-calculator";

    /**
     * 成功后分账延时
     */
    public static final int ACCOUNT_DELAYED_DATE = (1000 * 60 * 12);

    /**
     * 成功后打印订单
     */
    public static final int PRINT_DELAYED_DATE = 300000;

    public static final int COUPONS_COUNT = 3;

    public static final String ORDER_TYPE = "coupons";
}
