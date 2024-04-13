package ship.project_noa.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;



public class ManageInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!isAdmin(request)) {
            response.sendRedirect("/login/logout");
            return false;
        }
        return true;
    }

    /*@Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            if(modelAndView != null && !Objects.equals(modelAndView.getViewName(), "/common/hiddenFrame") && modelAndView.getModel().get("requestMap") != null){
                Map<String,Object> map = (Map<String, Object>) modelAndView.getModel().get("requestMap");

            }
        }*/
    private boolean isAdmin(HttpServletRequest request){
        return request.getSession().getAttribute("session_admin_idx") != null;
    }
}

