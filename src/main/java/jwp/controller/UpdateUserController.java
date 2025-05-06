package jwp.controller;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserController implements Controller {
    private final UserDao userDao = new UserDao();
    @Override
    public View execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User modifiedUser = new User(
                request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"));
        userDao.update(modifiedUser);
        return new JspView("redirect:/user/list");
    }
}
