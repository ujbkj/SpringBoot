package com.catering.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.catering.common.core.domain.R;
import com.catering.common.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import com.catering.system.domain.SysEateryImage;
import com.catering.system.service.ISysEateryImageService;
import com.catering.common.core.web.controller.BaseController;
import com.catering.common.core.web.domain.AjaxResult;

/**
 * systemController
 *
 * @author sy
 * @date 2022-01-03
 */
@RestController
@RequestMapping("/eateryImage")
public class SysEateryImageController extends BaseController
{
    @Autowired
    private ISysEateryImageService sysEateryImageService;

    /**
     * 查询system列表
     */
    @PreAuthorize(hasPermi = "system:eateryImage:list")
    @GetMapping("/list")
    public AjaxResult list(String eateryUid)
    {
        if (StringUtils.isEmpty(eateryUid)) {
            return null;
        }
        List<SysEateryImage> list = sysEateryImageService.selectSysEateryImageList(eateryUid);
        return AjaxResult.success(list);
    }


    /**
     * 获取system详细信息
     */
    @PreAuthorize(hasPermi = "system:eateryImage:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysEateryImageService.selectSysEateryImageById(id));
    }

    /**
     * 新增system
     */
    @PreAuthorize(hasPermi = "system:eateryImage:add")
    @Log(title = "system", businessType = BusinessType.INSERT)
    @PostMapping
    @Transactional
    public AjaxResult add(@RequestBody List<SysEateryImage> eateryImages)
    {
        sysEateryImageService.deleteSysEateryImages(eateryImages.get(0).getEateryUid());
        return toAjax(sysEateryImageService.insertSysEateryImage(eateryImages));
    }

    /**
     * 修改system
     */
    @PreAuthorize(hasPermi = "system:eateryImage:edit")
    @Log(title = "system", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysEateryImage sysEateryImage)
    {
        return toAjax(sysEateryImageService.updateSysEateryImage(sysEateryImage));
    }

    /**
     * 删除system
     */
    @PreAuthorize(hasPermi = "system:eateryImage:remove")
    @Log(title = "system", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysEateryImageService.deleteSysEateryImageByIds(ids));
    }
}
