package xqy.msa.springbootweb;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import xqy.msa.springbootweb.auth.domain.User;
import xqy.msa.springbootweb.auth.service.UserService;
import xqy.msa.springbootweb.config.WebConfig;

import java.util.Collection;

/**
 * Created by xqy on 18/1/11.
 */
//1 老式写法
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {WebConfig.class,App.class})
//2
//@SpringBootApplication(scanBasePackages = "xqy.msa.springbootweb.*")
//3
@SpringBootTest
@RunWith(SpringRunner.class)

@ActiveProfiles("test")
public class TbUserTest {

    @Autowired
    UserService userService;

    @Test
    public void test1(){
        System.out.println("---- test1 ----");
    }

    @Test
    public void test2(){
        System.out.println(" ------ test2 ...");
        User user = userService.loadUserByName("admin");
        System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getAuthorities()+" -- "+user.toString());
        if(user.getAuthorities() != null){
            for(GrantedAuthority auth:user.getAuthorities()){
                System.out.println(" auth: "+auth.toString());
            }
        }
        System.out.println("------- end test2 ...");
    }

    @Test
    public void test3(){
        System.out.println(" ------ test3 ...");
        Collection<GrantedAuthority> aus = userService.getUserAuthority("admin");
        for(GrantedAuthority au : aus){
            System.out.println(" au: "+ au.toString());
        }
        System.out.println(" ------ end test3 ...");
    }
}
