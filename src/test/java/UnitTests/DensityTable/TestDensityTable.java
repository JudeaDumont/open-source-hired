package UnitTests.DensityTable;

import com.example.model.DensityTable.DensityTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestDensityTable {

    @Test
    @Order(1)
    void t() {
        DensityTable densityTable = new DensityTable();
        assert (densityTable.getDensity("check") == 0);

        densityTable.Add("check", 1L);
        assert (densityTable.getDensity("check") == 1);

        densityTable.Add("check", 2L);
        assert (densityTable.getDensity("check") == 3);

        densityTable.Add("check", 0L);
        assert (densityTable.getDensity("check") == 3);
    }
}
