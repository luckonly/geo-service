package sender;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

public class MessageSenderImplTest {

    @Test
    public void sendRussianLocationTest () {

      GeoService geoService = Mockito.mock(GeoServiceImpl.class);
      when(geoService.byIp(Mockito.<String>any())).thenReturn(new Location("test",
                                                                                Country.RUSSIA,
                                                                                "test",
                                                                                1));
      LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
      when(localizationService.locale(Mockito.<Country>any())).thenReturn("Добро пожаловать");

      Map<String, String> headset = new HashMap();
      headset.put(MessageSenderImpl.IP_ADDRESS_HEADER,"Test");

      MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
      Assert.assertEquals("Добро пожаловать", messageSender.send(headset));

    }

    @Test
    public void sendNotRussianLocationTest () {

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        when(geoService.byIp(Mockito.<String>any())).thenReturn(new Location("test",
                Country.USA,
                "test",
                1));
        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Mockito.<Country>any())).thenReturn("Welcome");

        Map<String, String> headset = new HashMap();
        headset.put(MessageSenderImpl.IP_ADDRESS_HEADER,"Test");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Assert.assertEquals("Welcome", messageSender.send(headset));

    }

}
