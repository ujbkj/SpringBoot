package com.catering.system.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.catering.common.core.constant.MemberConstants;
import com.catering.common.core.domain.R;
import com.catering.common.core.utils.StringUtils;
import com.catering.system.domain.EateryCouponsModel;
import com.catering.system.domain.EateryImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.catering.system.api.domain.SysEateryCoupons;
import com.catering.system.service.ISysEateryCouponsService;
import com.catering.common.core.web.controller.BaseController;
import com.catering.common.core.web.domain.AjaxResult;
import com.catering.common.core.web.page.TableDataInfo;

/**
 * couponsController
 *
 * @author sy
 * @date 2022-01-11
 */
@RestController
@RequestMapping("/coupons")
public class SysEateryCouponsController extends BaseController
{
    @Autowired
    private ISysEateryCouponsService sysEateryCouponsService;

    /**
     * 查询coupons列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysEateryCoupons eateryAddress)
    {
        startPage();
        List<EateryCouponsModel> list = sysEateryCouponsService.selectSysEateryCouponsList(eateryAddress);
        return getDataTable(list);
    }

    @GetMapping("/queryEateryImages/{eateryUid}")
    public AjaxResult queryEateryImages(@PathVariable("eateryUid") String eateryUid){
        if (StringUtils.isEmpty(eateryUid)) {
            return AjaxResult.error("uid为空");
        }
        Map<String, List<String>> map = sysEateryCouponsService.queryEateryImages(eateryUid);
        return AjaxResult.success().put("facadeList", map.get("facadeList")).put("sceneList", map.get("sceneList"));
    }

    @GetMapping("/couponsList/{eateryUid}")
    public AjaxResult selectUserCoupons(@PathVariable("eateryUid") String eateryUid) {
        if (StringUtils.isEmpty(eateryUid)) {
            return AjaxResult.error("用户UID为空");
        }
       return AjaxResult.success(sysEateryCouponsService.selectUserCoupons(eateryUid));
    }

    @GetMapping(value = "/count/{eateryUid}")
    public AjaxResult queryCouponsCount(@PathVariable("eateryUid") String eateryUid) {
        if (StringUtils.isEmpty(eateryUid)) {
            return AjaxResult.error("用户UID为空");
        }

       return AjaxResult.success((sysEateryCouponsService.queryCouponsCount(eateryUid) >= MemberConstants.COUPONS_COUNT));
    }

    @GetMapping(value = "/queryCoupons/{eateryUid}/{couponsUid}")
    public R<SysEateryCoupons> queryCoupons(@PathVariable("eateryUid") String eateryUid ,@PathVariable("couponsUid") String couponsUid) {
        if (StringUtils.isEmpty(eateryUid)) {
            return R.fail("商家UID为空");
        }

        if (StringUtils.isEmpty(couponsUid)) {
            return R.fail("优惠卷UID为空");
        }

        return R.ok(sysEateryCouponsService.queryCoupons(eateryUid, couponsUid));
    }


    /**
     * 获取coupons详细信息
     */
    @GetMapping(value = "/{couponsId}")
    public AjaxResult getInfo(@PathVariable("couponsId") Long couponsId)
    {
        return AjaxResult.success(sysEateryCouponsService.selectSysEateryCouponsById(couponsId));
    }


    /**
     * 新增coupons
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody SysEateryCoupons sysEateryCoupons)
    {
        String couponsDiscounts = sysEateryCoupons.getCouponsDiscounts();
        String couponsRebate = sysEateryCoupons.getCouponsRebate();
        if (StringUtils.isEmpty(couponsDiscounts)) {
            return AjaxResult.error("打折不能为空");
        }

        if (StringUtils.isEmpty(couponsRebate)) {
            return AjaxResult.error("优惠不能为空");
        }
        BigDecimal discounts = new BigDecimal(couponsDiscounts);
        sysEateryCoupons.setCouponsDiscounts(String.valueOf(discounts.divide(new BigDecimal(10))));

        BigDecimal rebate = new BigDecimal(couponsRebate);
        sysEateryCoupons.setCouponsRebate(String.valueOf(rebate.divide(new BigDecimal(100))));
        return toAjax(sysEateryCouponsService.insertSysEateryCoupons(sysEateryCoupons));
    }

    /**
     * 修改coupons
     */
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody SysEateryCoupons sysEateryCoupons)
    {
        return toAjax(sysEateryCouponsService.updateSysEateryCoupons(sysEateryCoupons));
    }

    /**
     * 删除coupons
     */
	@DeleteMapping("/{couponsIds}")
    public AjaxResult remove(@PathVariable Long[] couponsIds)
    {
        return toAjax(sysEateryCouponsService.deleteSysEateryCouponsByIds(couponsIds));
    }
}
