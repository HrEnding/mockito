package orz.hzc.mockito.common;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hr_Ending
 * @Date: 2021/1/17 12:17
 */
public class AccountLoginController {

    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String login(HttpServletRequest request) {
        final String userName = request.getParameter("userName");
        final String password = request.getParameter("password");

        Account account = accountDao.findAccount(userName, password);
        try {
            if (account == null) {
                return "/login";
            } else {
                return "/index.jsp";
            }
        } catch (Exception e) {
            return "/505";
        }


    }
}
