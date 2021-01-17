package orz.hzc.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import orz.hzc.mockito.common.Account;
import orz.hzc.mockito.common.AccountDao;
import orz.hzc.mockito.common.AccountLoginController;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

/**
 * @Author: Hr_Ending
 * @Date: 2021/1/17 12:30
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {
    private AccountDao accountDao;
    private HttpServletRequest request;

    private AccountLoginController accountLoginController;

    @Before
    public void setUp() {
        this.accountDao = Mockito.mock(AccountDao.class);
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess() {
        Account account = new Account();
        Mockito.when(request.getParameter("userName")).thenReturn("admin");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);

        assertThat(accountLoginController.login(request), equalTo("/index.jsp"));

    }
}
