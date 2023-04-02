package dsa_dp.design_patterns.chain_of_responsibility.validators;

import dsa_dp.design_patterns.chain_of_responsibility.PieceOfSoftware;

public class PerformanceValidator extends SoftwareValidator {
    @Override
    public boolean validate(PieceOfSoftware software) {
        return !software.areTherePerformanceIssues;
    }
}
