package instead;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:servlet-context.xml","classpath:spring/applicationContext.xml"})
public class TestInsertLogAOP {

    /**
     *
     * @Title：testLogin
     * @Description: 
     */
    @Test
    public  void testGartenEnter() {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
