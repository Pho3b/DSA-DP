package dsa_dp.design_patterns.chain_of_responsibility.validators;

import dsa_dp.design_patterns.chain_of_responsibility.PieceOfSoftware;

public abstract class SoftwareValidator {
    protected SoftwareValidator next;

    public void setNext(SoftwareValidator v) {
        this.next = v;
    };
    abstract public boolean validate(PieceOfSoftware software);
}
