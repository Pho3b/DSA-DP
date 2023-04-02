package dsa_dp.design_patterns.chain_of_responsibility.validators;

import dsa_dp.design_patterns.chain_of_responsibility.PieceOfSoftware;

public class BugsValidator extends SoftwareValidator {
    @Override
    public boolean validate(PieceOfSoftware software) {
        if (software.isBugged) {
            return false;
        }

        return next.validate(software);
    }
}
