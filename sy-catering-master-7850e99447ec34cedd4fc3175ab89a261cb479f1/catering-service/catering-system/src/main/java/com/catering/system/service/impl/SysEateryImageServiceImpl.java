package com.catering.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catering.system.mapper.SysEateryImageMapper;
import com.catering.system.domain.SysEateryImage;
import com.catering.system.service.ISysEateryImageService;

/**
 * systemService业务层处理
 *
 * @author sy
 * @date 2022-01-03
 */
@Service
public class SysEateryImageServiceImpl implements ISysEateryImageService
{
    @Autowired
    private SysEateryImageMapper sysEateryImageMapper;

    /**
     * 查询system
     *
     * @param id systemID
     * @return system
     */
    @Override
    public SysEateryImage selectSysEateryImageById(Long id)
    {
        return sysEateryImageMapper.selectSysEateryImageById(id);
    }

    /**
     * 查询system列表
     *
     * @param sysEateryImage system
     * @return system
     */
    @Override
    public List<SysEateryImage> selectSysEateryImageList(String eateryUid)
    {
        return sysEateryImageMapper.selectSysEateryImageList(eateryUid);
    }

    /**
     * 新增system
     *
     * @param sysEateryImage system
     * @return 结果
     */
    @Override
    public int insertSysEateryImage(List<SysEateryImage> eateryImages)
    {
        return sysEateryImageMapper.insertSysEateryImage(eateryImages);
    }

    /**
     * 修改system
     *
     * @param sysEateryImage system
     * @return 结果
     */
    @Override
    public int updateSysEateryImage(SysEateryImage sysEateryImage)
    {
        return sysEateryImageMapper.updateSysEateryImage(sysEateryImage);
    }

    /**
     * 批量删除system
     *
     * @param ids 需要删除的systemID
     * @return 结果
     */
    @Override
    public int deleteSysEateryImageByIds(Long[] ids)
    {
        return sysEateryImageMapper.deleteSysEateryImageByIds(ids);
    }

    /**
     * 删除system信息
     *
     * @param id systemID
     * @return 结果
     */
    @Override
    public int deleteSysEateryImageById(Long id)
    {
        return sysEateryImageMapper.deleteSysEateryImageById(id);
    }

    @Override
    public int deleteSysEateryImages(String eateryUid) {
        return sysEateryImageMapper.deleteSysEateryImages(eateryUid);
    }
}
