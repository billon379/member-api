package fun.billon.member.api.hystrix;

import fun.billon.common.constant.CommonStatusCode;
import fun.billon.common.model.ResultModel;
import fun.billon.member.api.feign.IMemberService;
import fun.billon.member.api.model.AdminModel;
import fun.billon.member.api.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 授权服务(AUTH)hystrix断路器
 *
 * @author billon
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class MemberServiceImplHystrix implements IMemberService {

    /**
     * 注册
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param paramMap       paramMap.account   账号(邮箱,最长32位)    必填
     *                       paramMap.password  密码(md5编码后的数据)  必填
     * @return
     */
    @Override
    @PostMapping(value = "/user")
    public ResultModel<Integer> register(@RequestHeader(value = "authentication") String authentication,
                                         @RequestHeader(value = "sid") String sid,
                                         @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:POST /user"
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 登录
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param paramMap       paramMap.account   账号(邮箱,最长32位)    必填
     *                       paramMap.password  密码(md5编码后的数据)  必填
     * @return
     */
    @Override
    @GetMapping(value = "/user")
    public ResultModel<Integer> login(@RequestHeader(value = "authentication") String authentication,
                                      @RequestHeader(value = "sid") String sid,
                                      @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:GET /user"
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 更新用户
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param uid            用户id
     * @param paramMap       用户信息
     * @return
     */
    @Override
    @PutMapping(value = "/user/id/{uid}")
    public ResultModel<UserModel> updateUser(@RequestHeader(value = "authentication") String authentication,
                                             @RequestHeader(value = "sid") String sid,
                                             @PathVariable(value = "uid") Integer uid,
                                             @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:PUT /user/id/" + uid
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 根据条件获取用户数
     *
     * @param paramMap paramMap.query      搜索条件    选填
     * @return
     */
    @Override
    @GetMapping("/user/count")
    public ResultModel<Integer> userCount(@RequestHeader(value = "authentication") String authentication,
                                          @RequestHeader(value = "sid") String sid,
                                          @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:GET /user/count"
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

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
    @Override
    @GetMapping("/user/search")
    public ResultModel<List<UserModel>> search(@RequestHeader(value = "authentication") String authentication,
                                               @RequestHeader(value = "sid") String sid,
                                               @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:GET /user/search"
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]" + "-D [paramMap:" + paramMap + "]");
        return resultModel;
    }

    /**
     * 获取用户信息
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param uid            用户id
     * @return
     */
    @Override
    @GetMapping(value = "/user/id/{uid}")
    public ResultModel<UserModel> getUserById(@RequestHeader(value = "authentication") String authentication,
                                              @RequestHeader(value = "sid") String sid,
                                              @PathVariable(value = "uid") Integer uid) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:GET /user/id/" + uid
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]");
        return resultModel;
    }

    /**
     * 获取用户信息
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param uids           用户uids
     * @return
     */
    @Override
    @GetMapping(value = "/user/ids/{uids}")
    public ResultModel<Map<Integer, UserModel>> getUserByIds(@RequestHeader(value = "authentication") String authentication,
                                                             @RequestHeader(value = "sid") String sid,
                                                             @PathVariable(value = "uids") String uids) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:GET /user/ids/" + uids
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]");
        return resultModel;
    }


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
    @Override
    @GetMapping(value = "/admin")
    public ResultModel<Integer> adminlogin(@RequestHeader(value = "authentication") String authentication,
                                           @RequestHeader(value = "sid") String sid,
                                           @RequestParam Map<String, String> paramMap) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:GET /admin"
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]");
        return resultModel;
    }

    /**
     * 获取系统管理员信息
     *
     * @param authentication 请求头中的鉴权信息
     * @param sid            内部服务id
     * @param adminUid       系统管理员id
     * @return
     */
    @Override
    @GetMapping(value = "/admin/id/{adminUid}")
    public ResultModel<AdminModel> getAdminById(@RequestHeader(value = "authentication") String authentication,
                                                @RequestHeader(value = "sid") String sid,
                                                @PathVariable(value = "adminUid") Integer adminUid) {
        ResultModel resultModel = new ResultModel();
        resultModel.setFailed(CommonStatusCode.HYSTRIX_FALLBACK, "MEMBER:HYSTRIX:FALLBACK:GET /admin/id/" + adminUid
                + " -H [Authentication:" + authentication + ",sid:" + sid + "]");
        return resultModel;
    }

}