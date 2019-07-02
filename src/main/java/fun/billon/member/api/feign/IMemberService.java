package fun.billon.member.api.feign;

import fun.billon.common.model.ResultModel;
import fun.billon.member.api.hystrix.MemberServiceImplHystrix;
import fun.billon.member.api.model.AdminModel;
import fun.billon.member.api.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * member服务接口
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(value = "member", fallback = MemberServiceImplHystrix.class)
public interface IMemberService {

    /**
     * 注册
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param paramMap       paramMap.account   账号(邮箱,最长32位)    必填
     *                       paramMap.password  密码(md5编码后的数据)  必填
     * @return
     */
    @PostMapping(value = "/user")
    ResultModel<Integer> register(@RequestHeader(value = "authentication") String authentication,
                                  @RequestHeader(value = "sid") String sid,
                                  @RequestParam Map<String, String> paramMap);

    /**
     * 登录
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param paramMap       paramMap.account   账号(邮箱,最长32位)    必填
     *                       paramMap.password  密码(md5编码后的数据)  必填
     * @return
     */
    @GetMapping(value = "/user")
    ResultModel<Integer> login(@RequestHeader(value = "authentication") String authentication,
                               @RequestHeader(value = "sid") String sid,
                               @RequestParam Map<String, String> paramMap);

    /**
     * 更新用户
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param uid            用户id
     * @param paramMap       用户信息
     * @return
     */
    @PutMapping(value = "/user/id/{uid}")
    ResultModel<UserModel> updateUser(@RequestHeader(value = "authentication") String authentication,
                                      @RequestHeader(value = "sid") String sid,
                                      @PathVariable(value = "uid") Integer uid,
                                      @RequestParam Map<String, String> paramMap);

    /**
     * 根据条件获取用户数
     *
     * @param paramMap paramMap.query      搜索条件    选填
     * @return
     */
    @GetMapping("/user/count")
    ResultModel<Integer> userCount(@RequestHeader(value = "authentication") String authentication,
                                   @RequestHeader(value = "sid") String sid,
                                   @RequestParam Map<String, String> paramMap);

    /**
     * 搜索用户
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param paramMap       paramMap.query      搜索条件    选填
     *                       paramMap.pageSize   分页大小    选填
     *                       paramMap.pageIndex  分页页码    选填
     * @return
     */
    @GetMapping("/user/search")
    ResultModel<List<UserModel>> search(@RequestHeader(value = "authentication") String authentication,
                                        @RequestHeader(value = "sid") String sid,
                                        @RequestParam Map<String, String> paramMap);

    /**
     * 获取用户信息
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param uid            用户id
     * @return
     */
    @GetMapping(value = "/user/id/{uid}")
    ResultModel<UserModel> getUserById(@RequestHeader(value = "authentication") String authentication,
                                       @RequestHeader(value = "sid") String sid,
                                       @PathVariable(value = "uid") Integer uid);

    /**
     * 获取用户信息
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param uids           用户uids
     * @return
     */
    @GetMapping(value = "/user/ids/{uids}")
    ResultModel<Map<Integer, UserModel>> getUserByIds(@RequestHeader(value = "authentication") String authentication,
                                                      @RequestHeader(value = "sid") String sid,
                                                      @PathVariable(value = "uids") String uids);


    /**************************系统管理员*****************************/
    /**
     * 系统管理员登陆
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param paramMap       paramMap.account   系统管理员账号(最长32位)        必填
     *                       paramMap.password  系统管理员密码(md5编码后的数据)  必填
     * @return
     */
    @GetMapping(value = "/admin")
    ResultModel<Integer> adminlogin(@RequestHeader(value = "authentication") String authentication,
                                    @RequestHeader(value = "sid") String sid,
                                    @RequestParam Map<String, String> paramMap);

    /**
     * 获取系统管理员信息
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param adminUid       系统管理员id
     * @return
     */
    @GetMapping(value = "/admin/id/{adminUid}")
    ResultModel<AdminModel> getAdminById(@RequestHeader(value = "authentication") String authentication,
                                         @RequestHeader(value = "sid") String sid,
                                         @PathVariable(value = "adminUid") Integer adminUid);

}
