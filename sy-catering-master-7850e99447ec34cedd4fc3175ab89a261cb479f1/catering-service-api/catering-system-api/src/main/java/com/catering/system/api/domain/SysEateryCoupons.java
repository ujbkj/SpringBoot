package com.catering.system.api.domain;


import com.catering.common.core.text.UUID;
import com.catering.common.core.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.Random;

/**
 * coupons对象 sys_eatery_coupons
 *
 * @author sy
 * @date 2022-01-11
 */
public class SysEateryCoupons extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long couponsId;

    private Integer couponsMoney;

    private String couponsDiscounts;

    private String couponsRebate;

    private Integer couponsType;

    private Integer couponsCount;

    private Long couponsDuration;

    private String eateryAddress;

    private String remarkAddress;

    private int EateryType;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expireTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date currentTime;

    private String couponsImage;

    private String couponsUid;

    private String eateryTitle;

    private String eateryUid;

    public void setCouponsId(Long couponsId)
    {
        this.couponsId = couponsId;
    }

    public Long getCouponsId()
    {
        return couponsId;
    }
    public void setCouponsMoney(Integer couponsMoney)
    {
        this.couponsMoney = couponsMoney;
    }

    public Integer getCouponsMoney()
    {
        return couponsMoney;
    }
    public void setCouponsDiscounts(String couponsDiscounts)
    {
        this.couponsDiscounts = couponsDiscounts;
    }

    public String getCouponsDiscounts()
    {
        return couponsDiscounts;
    }
    public void setCouponsRebate(String couponsRebate)
    {
        this.couponsRebate = couponsRebate;
    }

    public String getCouponsRebate()
    {
        return couponsRebate;
    }
    public void setCouponsType(Integer couponsType)
    {
        this.couponsType = couponsType;
    }

    public Integer getCouponsType()
    {
        return couponsType;
    }
    public void setCouponsCount(Integer couponsCount)
    {
        this.couponsCount = couponsCount;
    }

    public Integer getCouponsCount()
    {
        return couponsCount;
    }
    public void setCouponsDuration(Long couponsDuration)
    {
        this.couponsDuration = couponsDuration;
    }

    public Long getCouponsDuration()
    {
        return couponsDuration;
    }
    public void setEateryAddress(String eateryAddress)
    {
        this.eateryAddress = eateryAddress;
    }

    public String getEateryAddress()
    {
        return eateryAddress;
    }
    public void setCouponsImage(String couponsImage)
    {
        this.couponsImage = couponsImage;
    }

    public String getCouponsImage()
    {
        return couponsImage;
    }
    public void creationCouponsUid() {
        String uuid = new Date() + UUID.randomUUID(false).toString();
        int max=10;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        this.couponsUid = DigestUtils.md5DigestAsHex(uuid.getBytes()).substring(s, (10 + s));
    }

    public String getCouponsUid()
    {
        return couponsUid;
    }
    public void setEateryTitle(String eateryTitle)
    {
        this.eateryTitle = eateryTitle;
    }

    public String getEateryTitle()
    {
        return eateryTitle;
    }
    public void setEateryUid(String eateryUid)
    {
        this.eateryUid = eateryUid;
    }

    public String getEateryUid()
    {
        return eateryUid;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public int getEateryType() {
        return EateryType;
    }

    public void setEateryType(int eateryType) {
        EateryType = eateryType;
    }

    public String getRemarkAddress() {
        return remarkAddress;
    }

    public void setRemarkAddress(String remarkAddress) {
        this.remarkAddress = remarkAddress;
    }
}
