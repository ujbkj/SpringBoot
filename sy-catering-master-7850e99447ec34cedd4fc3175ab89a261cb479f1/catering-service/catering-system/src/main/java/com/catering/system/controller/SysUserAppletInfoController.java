package com.catering.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.catering.common.core.domain.R;
import com.catering.common.core.utils.StringUtils;
import com.catering.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.catering.common.log.annotation.Log;
import com.catering.common.log.enums.BusinessType;
import com.catering.common.security.annotation.PreAuthorize;
import com.catering.system.api.domain.SysUserAppletInfo;
import com.catering.system.service.ISysUserAppletInfoService;
import com.catering.common.core.web.controller.BaseController;
import com.catering.common.core.web.domain.AjaxResult;
import com.catering.common.core.utils.poi.ExcelUtil;
import com.catering.common.core.web.page.TableDataInfo;

/**
 * appletController
 *
 * @author sy
 * @date 2021-10-09
 */
@RestController
@RequestMapping("/applet")
public class SysUserAppletInfoController extends BaseController
{
    @Autowired
    private ISysUserAppletInfoService sysUserAppletInfoService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询applet列表
     */
    @PreAuthorize(hasPermi = "system:applet:list")
    @GetMapping("/list")
    public TableDataInfo list(SysUserAppletInfo userAppletInfo)
    {
        String phone = userAppletInfo.getPhone();
        if (!StringUtils.isEmpty(phone)) {
            String eateryUid = userService.selectEateryUid(phone);
            if (StringUtils.isEmpty(eateryUid)) {
                return null;
            }
            userAppletInfo.setEateryUid(eateryUid);
        }
        startPage();
        List<SysUserAppletInfo> list = sysUserAppletInfoService.selectSysUserAppletInfoList(userAppletInfo);
        return getDataTable(list);
    }

    /**
     * 导出applet列表
     */
    @PreAuthorize(hasPermi = "system:applet:export")
    @Log(title = "applet", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysUserAppletInfo sysUserAppletInfo) throws IOException
    {
        List<SysUserAppletInfo> list = sysUserAppletInfoService.selectSysUserAppletInfoList(sysUserAppletInfo);
        ExcelUtil<SysUserAppletInfo> util = new ExcelUtil<SysUserAppletInfo>(SysUserAppletInfo.class);
        util.exportExcel(response, list, "applet");
    }

    /**
     * 获取applet详细信息
     */
    @PreAuthorize(hasPermi = "system:applet:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysUserAppletInfoService.selectSysUserAppletInfoById(id));
    }

    @GetMapping(value = "/getAppLetIdInfo/{eateryUid}")
    public R<SysUserAppletInfo> getAppLetIdInfo(@PathVariable("eateryUid") String eateryUid)
    {

        if (eateryUid == null || "".equals(eateryUid)) {
            return R.fail("店家UID为空");
        }
        return R.ok(sysUserAppletInfoService.getAppLetIdInfo(eateryUid));
    }

    /**
     * 新增applet
     */
    @PreAuthorize(hasPermi = "system:applet:add")
    @Log(title = "applet", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserAppletInfo userAppletInfo)
    {
        String phone = userAppletInfo.getPhone();
        if (phone == null || "".equals(phone)) {
            return AjaxResult.error("手机号为空。");
        }
        String eateryUid = userService.selectEateryUid(phone);
        if (eateryUid == null || "".equals(eateryUid)) {
            return AjaxResult.error("eateryUid不存在。");
        }
        userAppletInfo.setEateryUid(eateryUid);
        return toAjax(sysUserAppletInfoService.insertSysUserAppletInfo(userAppletInfo));
    }

    /**
     * 修改applet
     */
    @PreAuthorize(hasPermi = "system:applet:edit")
    @Log(title = "applet", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserAppletInfo userAppletInfo)
    {
        return toAjax(sysUserAppletInfoService.updateSysUserAppletInfo(userAppletInfo));
    }

    /**
     * 删除applet
     */
    @PreAuthorize(hasPermi = "system:applet:remove")
    @Log(title = "applet", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysUserAppletInfoService.deleteSysUserAppletInfoByIds(ids));
    }
}
