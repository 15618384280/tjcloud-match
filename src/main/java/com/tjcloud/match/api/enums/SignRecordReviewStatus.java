package com.tjcloud.match.api.enums;

/**
 * 审核状态: 审核状态(0-不通过,1-成功,2-已取消)
 * @author TJ_zhoupf
 *
 */
public enum SignRecordReviewStatus {

    PAYABLE ("不通过", 0),
    PAID("成功", 1),
    REFUND("已取消", 2);

    private final String text;
    private final int status;

    private SignRecordReviewStatus(String text, int status)
    {
        this.text = text;
        this.status = status;
    }

    public String getText()
    {
        return text;
    }

    public int getStatus()
    {
        return status;
    }

    public static String getText(int status)
    {
        for (SignRecordReviewStatus e : SignRecordReviewStatus.values())
        {
            if (e.getStatus() == status)
            {
                return e.getText();
            }
        }
        return "";
    }
}
