package com.catering.system.service;

import java.util.List;
import java.util.Map;

import com.catering.system.domain.EateryCouponsModel;
import com.catering.system.api.domain.SysEateryCoupons;
import com.catering.system.domain.EateryImages;

/**
 * couponsService接口
 *
 * @author sy
 * @date 2022-01-11
 */
public interface ISysEateryCouponsService
{
    /**
     * 查询coupons
     *
     * @param couponsId couponsID
     * @return coupons
     */
    public SysEateryCoupons selectSysEateryCouponsById(Long couponsId);

    public Map<String, List<String>> queryEateryImages(String eateryUid);

    /**
     * 查询coupons列表
     *
     * @param sysEateryCoupons coupons
     * @return coupons集合
     */
    public List<EateryCouponsModel> selectSysEateryCouponsList(SysEateryCoupons sysEateryCoupons);

    public int queryCouponsCount(String eateryUid);

    public List<SysEateryCoupons> selectUserCoupons(String eateryUid);

    /**
     * 新增coupons
     *
     * @param sysEateryCoupons coupons
     * @return 结果
     */
    public int insertSysEateryCoupons(SysEateryCoupons sysEateryCoupons);

    /**
     * 修改coupons
     *
     * @param sysEateryCoupons coupons
     * @return 结果
     */
    public int updateSysEateryCoupons(SysEateryCoupons sysEateryCoupons);

    /**
     * 批量删除coupons
     *
     * @param couponsIds 需要删除的couponsID
     * @return 结果
     */
    public int deleteSysEateryCouponsByIds(Long[] couponsIds);

    /**
     * 删除coupons信息
     *
     * @param couponsId couponsID
     * @return 结果
     */
    public int deleteSysEateryCouponsById(Long couponsId);

    public SysEateryCoupons queryCoupons(String eateryUid, String couponsUid);
}
