package i18n;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    public void localeTest() {

        LocalizationService localizationService = new LocalizationServiceImpl();

        Assert.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
        Assert.assertEquals("Welcome", localizationService.locale(Country.USA));

    }

}
