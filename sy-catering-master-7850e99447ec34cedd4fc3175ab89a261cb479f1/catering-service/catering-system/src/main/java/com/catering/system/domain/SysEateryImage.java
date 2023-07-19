package com.catering.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.catering.common.core.annotation.Excel;
import com.catering.common.core.web.domain.BaseEntity;

/**
 * system对象 sys_eatery_image
 *
 * @author sy
 * @date 2022-01-03
 */
public class SysEateryImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String eateryImage;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String eateryImageName;

    /** 1:场景照 2.特色菜 */
    @Excel(name = "1:场景照 2.特色菜")
    private Integer eateryImageType;

    /** $column.columnComment */
    @Excel(name = "1:场景照 2.特色菜")
    private String eateryUid;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEateryImage(String eateryImage)
    {
        this.eateryImage = eateryImage;
    }

    public String getEateryImage()
    {
        return eateryImage;
    }
    public void setEateryImageName(String eateryImageName)
    {
        this.eateryImageName = eateryImageName;
    }

    public String getEateryImageName()
    {
        return eateryImageName;
    }
    public void setEateryImageType(Integer eateryImageType)
    {
        this.eateryImageType = eateryImageType;
    }

    public Integer getEateryImageType()
    {
        return eateryImageType;
    }
    public void setEateryUid(String eateryUid)
    {
        this.eateryUid = eateryUid;
    }

    public String getEateryUid()
    {
        return eateryUid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("eateryImage", getEateryImage())
            .append("eateryImageName", getEateryImageName())
            .append("eateryImageType", getEateryImageType())
            .append("eateryUid", getEateryUid())
            .toString();
    }
}
