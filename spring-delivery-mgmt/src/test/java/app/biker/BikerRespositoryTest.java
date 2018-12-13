package app.biker;

import app.biker.dto.BikerSummaryDTO;
import app.enums.StatusCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(value = {"test"})
public class BikerRespositoryTest {

    @Autowired
    BikerRepository bikerRepository;

    @Test
    public void contextLoads() {
        Assert.assertNotNull("the bikerRepository should be non-null",
                this.bikerRepository);
    }

    @Test
    public void testLoadingResultsInDatabase() {
        List<Biker> bikerList = this.bikerRepository.findAll();
        Assert.assertNotNull("there must be a response", bikerList);
        Assert.assertTrue(bikerList.size() == 3);
    }

    @Test
    public void testFindByStatusCode() {
        List<Biker> bikerList = this.bikerRepository.findByStatusCode(StatusCode.A);
        Assert.assertTrue(bikerList.size() != 0);
    }

    @Test
    public void testGetBikerSummary() {
        List<BikerSummaryDTO> listBikerSummary = this.bikerRepository.getAllActiveBikersSummary();
        Assert.assertNotNull(listBikerSummary);
        Assert.assertEquals("Rodrigo Batelli Bento", listBikerSummary.get(0).getFullName());
        Assert.assertEquals(new Long(1), listBikerSummary.get(0).getTotalDeliveries());
        Assert.assertEquals(new BigDecimal("4.32"), listBikerSummary.get(0).getTotalDistance());
        Assert.assertEquals(new BigDecimal("17.28"), listBikerSummary.get(0).getTotalDue());

        Assert.assertEquals("Lincoln Schelske", listBikerSummary.get(1).getFullName());
        Assert.assertEquals(new Long(1), listBikerSummary.get(1).getTotalDeliveries());
        Assert.assertEquals(new BigDecimal("3.23"), listBikerSummary.get(1).getTotalDistance());
        Assert.assertEquals(new BigDecimal("12.92"), listBikerSummary.get(1).getTotalDue());

    }
}
