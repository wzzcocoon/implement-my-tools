package cn.wzz.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理
 */
@Component
@Slf4j
public class PlatformExceptionHandler implements HandlerExceptionResolver, Ordered {
    private final static String errorMsg = "系统异常，请稍后重试";
    @Override
    public ModelAndView resolveException(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, Object paramObject, Exception paramException) {
        Map<String, Object> model = new HashMap<String, Object>();
        log.error("<<<<<<<<<<<< Error Uri {}. >>>>>>>>>>>>",paramHttpServletRequest.getRequestURI());
        log.error("<<<<<<<<<<<< Exception is {}. >>>>>>>>>>>>", paramException.getMessage());
        log.error("<<<<<<<<<<<< stackInfo is >>>>>>>>>>>>", paramException);
        model.put("errorMsg", errorMsg);
        model.put("stackTrace", paramException.getMessage());
        return new ModelAndView("pub/500", model);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }

}
