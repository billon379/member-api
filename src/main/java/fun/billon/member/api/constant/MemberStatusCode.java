package fun.billon.member.api.constant;

/**
 * 用户模块错误码
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
public class MemberStatusCode {

    /**
     * 用户模块错误码偏移(110000)
     */
    public static final int MEMBER_STATUS_OFFSET = 110000;

    /**
     * 账号已注册:(110001)
     */
    public static final int ACCOUNT_EXISTS = MEMBER_STATUS_OFFSET + 1;

    /**
     * 账号不存在:(110002)
     */
    public static final int ACCOUNT_NOT_EXISTS = MEMBER_STATUS_OFFSET + 2;

    /**
     * 账号或密码不正确:(110003)
     */
    public static final int ACCOUNT_OR_PASSWORD_INCORRECT = MEMBER_STATUS_OFFSET + 3;

}