package com.catering.system.mapper;

import java.util.List;

import com.catering.system.domain.EateryCouponsModel;
import com.catering.system.api.domain.SysEateryCoupons;
import com.catering.system.domain.EateryImages;
import org.apache.ibatis.annotations.Param;

/**
 * couponsMapper接口
 *
 * @author sy
 * @date 2022-01-11
 */
public interface SysEateryCouponsMapper
{
    /**
     * 查询coupons
     *
     * @param couponsId couponsID
     * @return coupons
     */
    public SysEateryCoupons selectSysEateryCouponsById(Long couponsId);

    /**
     * 查询coupons列表
     *
     * @param sysEateryCoupons coupons
     * @return coupons集合
     */
    public List<EateryCouponsModel>   selectSysEateryCouponsList(SysEateryCoupons sysEateryCoupons);

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
     * 删除coupons
     *
     * @param couponsId couponsID
     * @return 结果
     */
    public int deleteSysEateryCouponsById(Long couponsId);

    public int queryCouponsCount(String eateryUid);

    public List<EateryImages> queryEateryImages(String eateryUid);

    public SysEateryCoupons queryCoupons(@Param("eateryUid") String eateryUid, @Param("couponsUid") String couponsUid);

    /**
     * 批量删除coupons
     *
     * @param couponsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysEateryCouponsByIds(Long[] couponsIds);


}
