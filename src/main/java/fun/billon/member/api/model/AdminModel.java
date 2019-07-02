package fun.billon.member.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * 系统管理员
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
public class AdminModel {

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
     * 昵称-字段
     */
    private String nickname;
    /**
     * 记录创建时间-字段
     */
    private Date createTime;

}
