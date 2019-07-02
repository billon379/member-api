package fun.billon.member.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import fun.billon.common.model.PaginationModel;
import lombok.Data;

import java.util.Date;

/**
 * 用户
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class UserModel extends PaginationModel {

    /**
     * 主鍵-字段
     */
    private Integer id;
    /**
     * 账号-字段,长度20位(字母、数字、下划线)
     */
    private String account;
    /**
     * 密码-字段
     */
    @JSONField(serialize = false)
    private String password;
    /**
     * 密码盐-字段
     */
    @JSONField(serialize = false)
    private String salt;
    /**
     * 手机号-字段
     */
    private String phone;
    /**
     * 昵称-字段
     */
    private String nickname;
    /**
     * 性别(1为男性;2为女性)-字段
     */
    private Integer sex;
    /**
     * 用户头像-字段
     */
    private String headImgUrl;
    /**
     * 现金-字段
     */
    private Float cash;
    /**
     * 积分-字段
     */
    private Integer points;
    /**
     * 更新时间-字段
     */
    private Date updateTime;
    /**
     * 记录创建时间-字段
     */
    private Date createTime;

}
