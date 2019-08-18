import com.learnrest.rest.webservices.restfulwebservices.RestfulWebServicesApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = {RestfulWebServicesApplication.class})
public class PatientControllerTests {

    @Test
    public void whenValidUrlAndMethodAndContentType_thenReturns200() {
    }

    @Test
    public void whenValidInput_thenMapsToBusinessModel() {
    }

    @Test
    public void whenValidInput_thenReturnsUserResource() {
    }

    @Test
    public void whenNullValue_thenReturns400AndErrorResult() {
    }





}
