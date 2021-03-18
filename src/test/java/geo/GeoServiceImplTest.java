package geo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @Test
    public void byIpTest() {

        GeoService geoService = new GeoServiceImpl();
        //LOCALHOST
        Assert.assertEquals(null,
                            geoService.byIp(GeoServiceImpl.LOCALHOST).getCountry());
        //MOSCOW_IP
        Assert.assertEquals(Country.RUSSIA,
                            geoService.byIp(GeoServiceImpl.MOSCOW_IP).getCountry());
        //NEW_YORK_IP
        Assert.assertEquals(Country.USA,
                            geoService.byIp(GeoServiceImpl.NEW_YORK_IP).getCountry());
        //RUSSIA
        Assert.assertEquals(Country.RUSSIA,
                            geoService.byIp("172.").getCountry());
        //USA
        Assert.assertEquals(Country.USA,
                            geoService.byIp("96.").getCountry());

    }


}
