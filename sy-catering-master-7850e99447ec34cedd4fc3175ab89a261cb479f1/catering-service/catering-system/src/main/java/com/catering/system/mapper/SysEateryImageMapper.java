package com.catering.system.mapper;

import java.util.List;
import com.catering.system.domain.SysEateryImage;

/**
 * systemMapper接口
 *
 * @author sy
 * @date 2022-01-03
 */
public interface SysEateryImageMapper
{
    /**
     * 查询system
     *
     * @param id systemID
     * @return system
     */
    public SysEateryImage selectSysEateryImageById(Long id);

    /**
     * 查询system列表
     *
     * @param sysEateryImage system
     * @return system集合
     */
    public List<SysEateryImage> selectSysEateryImageList(String eateryUid);

    /**
     * 新增system
     *
     * @param sysEateryImage system
     * @return 结果
     */
    public int insertSysEateryImage(List<SysEateryImage> eateryImages);

    /**
     * 修改system
     *
     * @param sysEateryImage system
     * @return 结果
     */
    public int updateSysEateryImage(SysEateryImage sysEateryImage);

    /**
     * 删除system
     *
     * @param id systemID
     * @return 结果
     */
    public int deleteSysEateryImageById(Long id);

    /**
     * 批量删除system
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysEateryImageByIds(Long[] ids);

    public int deleteSysEateryImages(String eateryUid);
}
