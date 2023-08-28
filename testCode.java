import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class YourClassTest {

    @Mock
    private Logger log;

    @InjectMocks
    private YourClass yourClass; // 仮定しているクラス名。実際のクラス名に置き換えてください。

    @Test
    public void testLogWarn() {
        List<BusinessErrors> errorList = Arrays.asList(new BusinessErrors("N011"), new BusinessErrors("N012"));
        yourClass.yourMethod(errorList, false); // yourMethodはテスト対象のメソッドです。引数を適切に設定してください。

        verify(log).warn("warn");
    }

    @Test
    public void testLogError() {
        List<BusinessErrors> errorList = Arrays.asList(new BusinessErrors("N014"));
        yourClass.yourMethod(errorList, true); // yourMethodはテスト対象のメソッドです。引数を適切に設定してください。

        verify(log).error("error");
    }

    @Test
    public void testNoLog() {
        List<BusinessErrors> errorList = Arrays.asList(new BusinessErrors("N014"));
        yourClass.yourMethod(errorList, false); // yourMethodはテスト対象のメソッドです。引数を適切に設定してください。

        verify(log, never()).warn("warn");
        verify(log, never()).error("error");
    }
}
