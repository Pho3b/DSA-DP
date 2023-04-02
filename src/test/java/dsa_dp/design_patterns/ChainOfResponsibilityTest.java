package dsa_dp.design_patterns;

import dsa_dp.design_patterns.chain_of_responsibility.PieceOfSoftware;
import dsa_dp.design_patterns.chain_of_responsibility.validators.BugsValidator;
import dsa_dp.design_patterns.chain_of_responsibility.validators.MemoryLeaksValidator;
import dsa_dp.design_patterns.chain_of_responsibility.validators.PerformanceValidator;
import dsa_dp.design_patterns.chain_of_responsibility.validators.SoftwareValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChainOfResponsibilityTest {

    @Test
    public void completeChainValidationTest() {
        PieceOfSoftware pieceOfSoftware = new PieceOfSoftware();
        SoftwareValidator chain = retrieveValidatorsChain();

        Assertions.assertFalse(chain.validate(pieceOfSoftware));
        pieceOfSoftware.isBugged = false;
        Assertions.assertFalse(chain.validate(pieceOfSoftware));
        pieceOfSoftware.areThereMemoryLeaks = false;
        Assertions.assertFalse(chain.validate(pieceOfSoftware));
        pieceOfSoftware.areTherePerformanceIssues = false;
        Assertions.assertTrue(chain.validate(pieceOfSoftware));
    }

    private SoftwareValidator retrieveValidatorsChain() {
        BugsValidator bugsValidator = (new BugsValidator());
        MemoryLeaksValidator memoryLeaksValidator = new MemoryLeaksValidator();
        PerformanceValidator performanceValidator = new PerformanceValidator();

        bugsValidator.setNext(memoryLeaksValidator);
        memoryLeaksValidator.setNext(performanceValidator);

        return bugsValidator;
    }
}
