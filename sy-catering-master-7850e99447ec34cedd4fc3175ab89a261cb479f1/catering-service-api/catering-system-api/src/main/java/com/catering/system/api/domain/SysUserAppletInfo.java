package com.catering.system.api.domain;

import com.catering.common.core.web.domain.BaseEntity;

/**
 * applet对象 sys_user_applet_info
 *
 * @author sy
 * @date 2021-10-09
 */
public class SysUserAppletInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String eateryTitle;

    private String wxSubMchId;

    private String aliToken;

    private String aliUserId;

    private String eateryUid;

    private String aliAesKey;

    private String aliTemplateId;

    private String phone;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEateryTitle(String eateryTitle)
    {
        this.eateryTitle = eateryTitle;
    }

    public String getEateryTitle()
    {
        return eateryTitle;
    }
    public void setWxSubMchId(String wxSubMchId)
    {
        this.wxSubMchId = wxSubMchId;
    }

    public String getWxSubMchId()
    {
        return wxSubMchId;
    }
    public void setAliToken(String aliToken)
    {
        this.aliToken = aliToken;
    }

    public String getAliToken()
    {
        return aliToken;
    }
    public void setAliUserId(String aliUserId)
    {
        this.aliUserId = aliUserId;
    }

    public String getAliUserId()
    {
        return aliUserId;
    }
    public void setEateryUid(String eateryUid)
    {
        this.eateryUid = eateryUid;
    }

    public String getEateryUid()
    {
        return eateryUid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAliAesKey() {
        return aliAesKey;
    }

    public void setAliAesKey(String aliAesKey) {
        this.aliAesKey = aliAesKey;
    }

    public String getAliTemplateId() {
        return aliTemplateId;
    }

    public void setAliTemplateId(String aliTemplateId) {
        this.aliTemplateId = aliTemplateId;
    }
}
