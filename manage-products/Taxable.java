/** @author marcia.tobias */

package Week5Ex2;

interface Taxable {

    static final double dRate = 0.12; // 12% default tax
    static final double eRate = 0.10; // 10% for all electronics
    static final double tRate = 0.16; // 16% television
    static final double pRate = 0.05; // 5% more if the product has plastic material
    
    double taxReturn();
}


