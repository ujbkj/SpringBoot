package com.catering.system.mapper;

import java.util.List;

import com.catering.system.api.domain.SysUserAppletInfo;

/**
 * appletMapper接口
 *
 * @author sy
 * @date 2021-10-09
 */
public interface SysUserAppletInfoMapper
{
    /**
     * 查询applet
     *
     * @param id appletID
     * @return applet
     */
    public SysUserAppletInfo selectSysUserAppletInfoById(Long id);

    public SysUserAppletInfo getAppLetIdInfo(String eateryUid);

    /**
     * 查询applet列表
     *
     * @param sysUserAppletInfo applet
     * @return applet集合
     */
    public List<SysUserAppletInfo> selectSysUserAppletInfoList(SysUserAppletInfo sysUserAppletInfo);

    /**
     * 新增applet
     *
     * @param sysUserAppletInfo applet
     * @return 结果
     */
    public int insertSysUserAppletInfo(SysUserAppletInfo sysUserAppletInfo);

    /**
     * 修改applet
     *
     * @param sysUserAppletInfo applet
     * @return 结果
     */
    public int updateSysUserAppletInfo(SysUserAppletInfo sysUserAppletInfo);

    /**
     * 删除applet
     *
     * @param id appletID
     * @return 结果
     */
    public int deleteSysUserAppletInfoById(Long id);

    /**
     * 批量删除applet
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserAppletInfoByIds(Long[] ids);
}
