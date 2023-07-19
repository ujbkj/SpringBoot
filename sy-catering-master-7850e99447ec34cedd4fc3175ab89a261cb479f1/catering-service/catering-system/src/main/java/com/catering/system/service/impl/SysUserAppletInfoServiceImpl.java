package com.catering.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenAuthAppAesSetRequest;
import com.alipay.api.response.AlipayOpenAuthAppAesSetResponse;
import com.catering.common.core.utils.DateUtils;
import com.catering.system.api.feign.RemoteAddMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catering.system.mapper.SysUserAppletInfoMapper;
import com.catering.system.api.domain.SysUserAppletInfo;
import com.catering.system.service.ISysUserAppletInfoService;

/**
 * appletService业务层处理
 *
 * @author sy
 * @date 2021-10-09
 */
@Service
public class SysUserAppletInfoServiceImpl implements ISysUserAppletInfoService
{
    @Autowired
    private SysUserAppletInfoMapper sysUserAppletInfoMapper;

    @Autowired
    private RemoteAddMemberService memberService;

    /**
     * 查询applet
     *
     * @param id appletID
     * @return applet
     */
    @Override
    public SysUserAppletInfo selectSysUserAppletInfoById(Long id)
    {
        return sysUserAppletInfoMapper.selectSysUserAppletInfoById(id);
    }

    @Override
    public SysUserAppletInfo getAppLetIdInfo(String eateryUid) {
        return sysUserAppletInfoMapper.getAppLetIdInfo(eateryUid);
    }

    /**
     * 查询applet列表
     *
     * @param sysUserAppletInfo applet
     * @return applet
     */
    @Override
    public List<SysUserAppletInfo> selectSysUserAppletInfoList(SysUserAppletInfo sysUserAppletInfo)
    {
        return sysUserAppletInfoMapper.selectSysUserAppletInfoList(sysUserAppletInfo);
    }

    /**
     * 新增applet
     *
     * @param sysUserAppletInfo applet
     * @return 结果
     */
    @Override
    public int insertSysUserAppletInfo(SysUserAppletInfo sysUserAppletInfo)
    {
        sysUserAppletInfo.setCreateTime(DateUtils.getNowDate());
        sysUserAppletInfo.setAliAesKey(getUserAES(sysUserAppletInfo.getAliTemplateId()));
        Map<String, String> map = new HashMap<>();
        map.put("type", "MERCHANT_ID");
        map.put("account", "1613514826");
        map.put("name", "湖南飞漱科技有限公司");
        map.put("subMchId", sysUserAppletInfo.getWxSubMchId());

        map.put("relationType", "SERVICE_PROVIDER");

        memberService.profitSharingAddReceiverPayOrder(map);
        return sysUserAppletInfoMapper.insertSysUserAppletInfo(sysUserAppletInfo);
    }

    /**
     * 修改applet
     *
     * @param sysUserAppletInfo applet
     * @return 结果
     */
    @Override
    public int updateSysUserAppletInfo(SysUserAppletInfo sysUserAppletInfo)
    {
        sysUserAppletInfo.setUpdateTime(DateUtils.getNowDate());
        sysUserAppletInfo.setAliAesKey(getUserAES(sysUserAppletInfo.getAliTemplateId()));
        return sysUserAppletInfoMapper.updateSysUserAppletInfo(sysUserAppletInfo);
    }

    public String getUserAES(String merchantAppId) {
        try {
            String gateway = "https://openapi.alipay.com/gateway.do";

            String isvAppId = "2021002187642882";
            String isvAppPrivateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCM6Ai5DY9fzZbg56B6XqlAKj/6s62/Jrs9PUm/3chIG4EiqpS4tFdwbHpf3xaKDXNahPyFVlwTtDFRsRg8vCAzM7bvR2MYCxxqCikZy0E3eFGHoMFxylyYuxgq1kL86QiyHzyEuSZtcLsiXacMv9TM3SoAoyA88eawdMx6KJqQlawSzW6+26r6endY+FWj5NlUMcXtmSugMfukYVG7lyDqftjytCdTls3ob6ZPWwe9zrxGtcUHTDsJpGI2OpH+Mc2qmCMcHtmwDu13F6+0QZTd8QW7WFswd13O6dZJkxhFbYQth5uX4BsEM7gkDfMkyivMRCJW6RDnnkFOpH+EMXVtAgMBAAECggEASpYsv+AYq8rE+gpCHWRsTQXQViG0cAHNjU4a8tAwS1Mb2UDYdqknu+AAKy2I3cze6eSJUv9ywA9bJ/YJcWTX2qKeTCzKnJiNEuiL9xZrUDSFW7jRjS1kNIic81f1n7CvJLJ6M3tahwXsWPWgDpSgzUypBitTTk9yIKfC8Ur6/lshWoDRVKgTTJOPewd2mELi1d+TmosJPQePJa6eArkY3Ah1Wn8eZ43EESylvV0Dt+rImiILcYW3/KMTebVrsiD3GTLRQV7Hwyv8WUrh8f7EKw3TWkkl1xpiE7se5Qvn6d6oaTUY/aoa6vjgeKFEmx99aQt4aSeJPrfxyykplLGfAQKBgQDXBPq2jh0/7zTS/NMbKvKJ/NDCBuoemMxkxrIG4NkRO+gclIyyzG3ZSASg4sM2Z2ebHdFGyDmRwoTXIaOor+JtD4sd/XXwmH15tv58inPRBWTEyhE+WtmEX+p+q1X6I10r+T8A4Ib7V+9qHeH2uIQ17i4DogXXh5Gxg3WZOGHYrQKBgQCnwwBzehtvrk6T/tFwDJc5jxr8/joS3ZQ9pZSj4KFjSj+PR58IREWCaH3Nb7Obqtlyqo1Fdv45TLV//aAeLtEv9Y9tEKsKzTrG3suRAivDWG0YPnwxJe7HPhAccPH7B965IHGltpwHXU7xUeTl71a3FjNU7vbSKh5mwYBv163nwQKBgAzfy3Mqxy2Q0QThBnLV+3evn4A+kb4LQBG4o+gthlG12Iv9iP8bpmggG8bWTQHw5w8uld07F9dWYkXPSdFL1q7ZA2dkSa+CMeEbx9kFITIetI3j22x0XBnE9HFpKNi1TVrYraEL0Ik0Fq2v5Fu1aJUiEbc9+EOTZnHOgTgPXCxxAoGBAIWqSFy5yMx2DGO8nzDwxzj0PaOgB7NqWqe3mzPrUYtj6DqH7T1P8DYUfU/HFUsNmI3VOBRF2A7dgKuG8CG8Wa4lsG5M3osPtCop7/YMzcOqW9n6R0d9mr+jQoD2uMazoZDNOd+4HJ99h92cy40s4mGkTaf5ci1Ho8tpl6UFKqnBAoGASxxa0NX64cszk5PhVOVsdlt8C1QM6GRR280UuZj5K8M7iivuLYb1WJm2uSJ349FEyI+S0qWHNhmMHSdih5xhLpfOlblORPwijmnIFSv+p2lteKyPEi5pkczEm3m4sxzSk83K+REf3RHHToKsnPgbcIHL05y1IzKKVVNAikti+x4=";
            String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwwNCccdwzlUiun7A/C/SOelqvxcCl6zCbHR9RaRgIN73ciffZ5uNzC56++6U51fXyjMB+/+BBGFDIIqhE7ItHonianjYuaCVdoac7BtJmi56D4gDCA9xwUZ0asH7lDqVueY9PEC2rH6PJ28XJRqyByP2Zvg+Qh2BDwgZbU5q3iLrpl6agnW8JyETNx1TLyzPG49vmq6emITgUAFtNaFOLSoB4/+9OqPOQZhhy+faovs0GbNYcl+3oZgKgN9RtFBFPrXiUWrrxNxt73L9S3bdikamlYi8G+VMO4AztFhzCCZVqBPjYuAG/bmk0RR8qJNNmYgvggl4IZdKfFMBAU2uXwIDAQAB";
            String isvAppAesKey = "4zMVhLLoi/zZRXzsOTYsrw==";

            AlipayClient alipayClient = new DefaultAlipayClient(
                    gateway,
                    isvAppId,
                    isvAppPrivateKey,"json","GBK",
                    alipayPublicKey,"RSA2",
                    isvAppAesKey,
                    "AES");

            AlipayOpenAuthAppAesSetRequest request = new AlipayOpenAuthAppAesSetRequest();
            String str = "{merchant_app_id: "+ merchantAppId+"}";
            request.setBizContent (str);

            AlipayOpenAuthAppAesSetResponse response = alipayClient.execute(request);
            if (response.isSuccess()) {
                return response.getAesKey();
            } else {
                return null;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 批量删除applet
     *
     * @param ids 需要删除的appletID
     * @return 结果
     */
    @Override
    public int deleteSysUserAppletInfoByIds(Long[] ids)
    {
        return sysUserAppletInfoMapper.deleteSysUserAppletInfoByIds(ids);
    }

    /**
     * 删除applet信息
     *
     * @param id appletID
     * @return 结果
     */
    @Override
    public int deleteSysUserAppletInfoById(Long id)
    {
        return sysUserAppletInfoMapper.deleteSysUserAppletInfoById(id);
    }
}
