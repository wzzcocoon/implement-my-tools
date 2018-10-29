package cn.wzz.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import cn.wzz.bean.AuthorUser;
import cn.wzz.bean.BaseEntity;
import cn.wzz.util.BeanUtil;



// ServletRequestUtils
// WebRequest
public abstract class WebAction {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        request.setAttribute("contextPath", request.getContextPath());
        // 图片下载预览路径
//        request.setAttribute("imgPath", PropertiesUtil.getUPLOAD("img_path"));
//        request.setAttribute("imgPath", "http://localhost:8080/test/");

        // log.info("init WebAction...");
    }

    public Object getBean(Class<? extends BaseEntity> aClass) {
        return BeanUtil.getBean(aClass, request);
    }

    public List getBeanList(Class<? extends BaseEntity> aClass) {
        return BeanUtil.getBeanList(aClass, request, true);
    }

	public List<?> getBeanListByFix(Class<? extends BaseEntity> aClass, String prefix, String postfix) {
		return BeanUtil.getBeanList(aClass, prefix, postfix, request);
	}
    public AuthorUser getUser() throws Exception {
        AuthorUser user = WebTools.getLoginUser(SecurityContextHolder.getContext().getAuthentication());
        // 说明用户失效 则抛出异常
        if (user == null) {
            throw new Exception("无法获取当前登录用户信息");
        }
        // log.info(request.getRequestedSessionId()+"/"+user.getUserName()+"/"+request.getRequestURI());
        return user;
    }

    /**
     * 判断用户是否有相应角色
     *
     * @param role
     * @return
     * @throws Exception
     */
    public String checkRole(String role) throws Exception {
        String result = "0";
        List<String> list = getUser().getUserRole();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (role.equals(list.get(i))) {
                    result = "1";
                    break;
                }
            }
        }
        return result;
    }
}
