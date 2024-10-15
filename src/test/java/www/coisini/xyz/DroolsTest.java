package www.coisini.xyz;

import org.junit.jupiter.api.Test;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import www.coisini.xyz.entity.Order;

@SpringBootTest
public class DroolsTest {

    @Autowired
    private KieBase kieBase;

    @Test
    public void droolsTest(){
        Order order = new Order();
        order.setAmount(200);
        KieSession kieSession = kieBase.newKieSession();
        kieSession.insert(order);
        kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("订单金额："+order.getAmount() + ",订单积分："+order.getScore());
    }
}
