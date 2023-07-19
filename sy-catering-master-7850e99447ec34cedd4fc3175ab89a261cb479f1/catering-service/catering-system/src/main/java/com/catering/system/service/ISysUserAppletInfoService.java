package com.catering.system.service;

import java.util.List;
import com.catering.system.api.domain.SysUserAppletInfo;

/**
 * appletService接口
 *
 * @author sy
 * @date 2021-10-09
 */
public interface ISysUserAppletInfoService
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
     * 批量删除applet
     *
     * @param ids 需要删除的appletID
     * @return 结果
     */
    public int deleteSysUserAppletInfoByIds(Long[] ids);

    /**
     * 删除applet信息
     *
     * @param id appletID
     * @return 结果
     */
    public int deleteSysUserAppletInfoById(Long id);
}
