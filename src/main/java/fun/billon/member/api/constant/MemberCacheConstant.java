package fun.billon.member.api.constant;

/**
 * 缓存相关常量配置
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
public class MemberCacheConstant {

    /**
     * fun.billon.member.model.UserModel用户相关缓存配置
     */
    public static final String CACHE_NAMESPACE_USER_MODEL = "fun.billon.member.api.model.UserModel";
    /**
     * 缓存键值account
     */
    public static final String CACHE_KEY_USER_ACCOUNT = "#{userModel.account}";
    /**
     * 缓存键值id
     */
    public static final String CACHE_KEY_USER_ID = "#{userModel.id}";


    /**
     * fun.billon.member.model.AdminModel系统管理员相关缓存配置
     */
    public static final String CACHE_NAMESPACE_ADMIN_MODEL = "fun.billon.member.api.model.AdminModel";
    /**
     * 缓存键值account
     */
    public static final String CACHE_KEY_ADMIN_ACCOUNT = "#{adminModel.account}";
    /**
     * 缓存键值id
     */
    public static final String CACHE_KEY_ADMIN_ID = "#{adminModel.id}";

}
