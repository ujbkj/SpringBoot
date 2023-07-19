package com.catering.system.service.impl;

import java.util.*;

import com.catering.common.core.utils.DateUtils;
import com.catering.system.domain.EateryCouponsModel;
import com.catering.system.domain.EateryImages;
import com.catering.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catering.system.mapper.SysEateryCouponsMapper;
import com.catering.system.api.domain.SysEateryCoupons;
import com.catering.system.service.ISysEateryCouponsService;

/**
 * couponsService业务层处理
 *
 * @author sy
 * @date 2022-01-11
 */
@Service
public class SysEateryCouponsServiceImpl implements ISysEateryCouponsService
{
    @Autowired
    private SysEateryCouponsMapper sysEateryCouponsMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询coupons
     *
     * @param couponsId couponsID
     * @return coupons
     */
    @Override
    public SysEateryCoupons selectSysEateryCouponsById(Long couponsId)
    {
        return sysEateryCouponsMapper.selectSysEateryCouponsById(couponsId);
    }

    @Override
    public Map<String, List<String>> queryEateryImages(String eateryUid) {
        List<String> facadeList = new ArrayList<>();
        List<String> sceneList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        sysEateryCouponsMapper.queryEateryImages(eateryUid).forEach(item -> {
            if (item.getEateryImageType() == 1) {
                facadeList.add(item.getEateryImage());
            } else {
                sceneList.add(item.getEateryImage());
            }
        });
        map.put("facadeList", facadeList);
        map.put("sceneList", sceneList);
        return map;
    }

    /**
     * 查询coupons列表
     *
     * @param sysEateryCoupons coupons
     * @return coupons
     */
    @Override
    public List<EateryCouponsModel> selectSysEateryCouponsList(SysEateryCoupons sysEateryCoupons)
    {
        sysEateryCoupons.setCurrentTime(new Date());
        return sysEateryCouponsMapper.selectSysEateryCouponsList(sysEateryCoupons);
    }

    @Override
    public int queryCouponsCount(String eateryUid) {
        return sysEateryCouponsMapper.queryCouponsCount(eateryUid);
    }

    @Override
    public List<SysEateryCoupons> selectUserCoupons(String eateryUid) {
        return sysEateryCouponsMapper.selectUserCoupons(eateryUid);
    }

    /**
     * 新增coupons
     *
     * @param sysEateryCoupons coupons
     * @return 结果
     */
    @Override
    public int insertSysEateryCoupons(SysEateryCoupons sysEateryCoupons)
    {
        sysEateryCoupons.creationCouponsUid();
        sysEateryCoupons.setCreateTime(DateUtils.getNowDate());
        sysEateryCoupons.setEateryType(sysUserMapper.queryEateryType(sysEateryCoupons.getEateryUid()));
        return sysEateryCouponsMapper.insertSysEateryCoupons(sysEateryCoupons);
    }

    /**
     * 修改coupons
     *
     * @param sysEateryCoupons coupons
     * @return 结果
     */
    @Override
    public int updateSysEateryCoupons(SysEateryCoupons sysEateryCoupons)
    {
        sysEateryCoupons.setUpdateTime(DateUtils.getNowDate());
        return sysEateryCouponsMapper.updateSysEateryCoupons(sysEateryCoupons);
    }

    /**
     * 批量删除coupons
     *
     * @param couponsIds 需要删除的couponsID
     * @return 结果
     */
    @Override
    public int deleteSysEateryCouponsByIds(Long[] couponsIds)
    {
        return sysEateryCouponsMapper.deleteSysEateryCouponsByIds(couponsIds);
    }

    /**
     * 删除coupons信息
     *
     * @param couponsId couponsID
     * @return 结果
     */
    @Override
    public int deleteSysEateryCouponsById(Long couponsId)
    {
        return sysEateryCouponsMapper.deleteSysEateryCouponsById(couponsId);
    }

    @Override
    public SysEateryCoupons queryCoupons(String eateryUid, String couponsUid) {
        return sysEateryCouponsMapper.queryCoupons(eateryUid, couponsUid);
    }
}
