class SymmetricKronecker {

    public static double[][] symmetric_kronecker_product(double[][] m1, double[][] m2) {
    	if (m1.length != m1[0].length || m2.length != m2[0].length || m1.length != m2.length) {
    		System.out.println("The symmetric Kronecker product can be performed only on square matrices of the same size.\n");
    
    		return null;
    	}

    	int resultSize = (m1.length * (m1.length + 1)) / 2;
    	double[][] product = new double[resultSize][resultSize];
    	int rowQ = 0, divQ = 0, modQ = 0, colT = 0, divT = 0, modT = 0;
    	double inverseSqrt2 = Math.pow(2, -0.5);

    	modT = 1;
    	colT = 1;
    	product[0][0] = m1[0][0] * m2[0][0];

    	while (divT + 1 < m1.length) {
    		while (modT < m1.length) {
    			product[0][colT] = (m1[0][divT] * m2[0][modT] + m1[0][modT] * m2[0][divT]) * inverseSqrt2;
    			colT++;
    			modT++;
    		}

    		divT++;
    		product[0][colT] = m1[0][divT] * m2[0][divT];
    		modT = divT + 1;
    		colT++;
    	}

    	rowQ = 1;
    	modQ = 1;
    	divT = 0;
    	modT = 1;

    	while (divQ + 1 < m1.length) {
    		while (modQ < m1.length) {
    			product[rowQ][0] = (m1[divQ][0] * m2[modQ][0] + m1[modQ][0] * m2[divQ][0]) * inverseSqrt2;
    			colT = 1;

    			while (divT + 1 < m1.length) {
    				while (modT < m1.length) {
    					product[rowQ][colT] = (m1[divQ][divT] * m2[modQ][divT] + m1[modQ][divT] * m2[divQ][divT] + m1[divQ][modT] * m2[modQ][modT] + m1[modQ][modT] * m2[divQ][modT]) * 0.5;
    					colT++;
    					modT++;
    				}

    				divT++;
    				product[rowQ][colT] = (m1[divQ][divT] * m2[modQ][divT] + m1[modQ][divT] * m2[divQ][divT]) * inverseSqrt2;
    				modT = divT + 1;
    				colT++;
    			}

    			rowQ++;
    			modQ++;
    			divT = 0;
    			modT = 1;
    		}

    		divQ++;
    		product[rowQ][0] = m1[divQ][0] * m2[divQ][0];
    		modQ = divQ + 1;
    		colT = 1;

    		while (divT + 1 < m1.length) {
    			while (modT < m1.length) {
    				product[rowQ][colT] = (m1[divQ][divT] * m2[divQ][modT] + m1[divQ][modT] * m2[divQ][divT]) * inverseSqrt2;
    				colT++;
    				modT++;
    			}

    			divT++;
    			product[rowQ][colT] = m1[divQ][divT] * m2[divQ][divT];
    			modT = divT + 1;
    			colT++;
    		}

    		rowQ++;
    		divT = 0;
    		modT = 1;
    	}

    	return product;
    }

}
