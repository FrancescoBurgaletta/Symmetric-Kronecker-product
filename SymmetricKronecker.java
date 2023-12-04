class SymmetricKronecker {

    public static double[][] symmetric_kronecker_product(double[][] a, double[][] b) throws IllegalArgumentException {
    	if (a.length != a[0].length || b.length != b[0].length || a.length != b.length) {
    		throw new IllegalArgumentException("The symmetric Kronecker product can be performed only on square matrices of the same size.");
    	}

    	int resultSize = (a.length * (a.length + 1)) / 2;
    	double[][] product = new double[resultSize][resultSize];
    	int rowQ = 0, divQ = 0, modQ = 0, colT = 0, divT = 0, modT = 0;
    	double inverseSqrt2 = Math.pow(2, -0.5);

    	modT = 1;
    	colT = 1;
    	product[0][0] = a[0][0] * b[0][0];

    	while (divT + 1 < a.length) {
    		while (modT < a.length) {
    			product[0][colT] = (a[0][divT] * b[0][modT] + a[0][modT] * b[0][divT]) * inverseSqrt2;
    			colT++;
    			modT++;
    		}

    		divT++;
    		product[0][colT] = a[0][divT] * b[0][divT];
    		modT = divT + 1;
    		colT++;
    	}

    	rowQ = 1;
    	modQ = 1;
    	divT = 0;
    	modT = 1;

    	while (divQ + 1 < a.length) {
    		while (modQ < a.length) {
    			product[rowQ][0] = (a[divQ][0] * b[modQ][0] + a[modQ][0] * b[divQ][0]) * inverseSqrt2;
    			colT = 1;

    			while (divT + 1 < a.length) {
    				while (modT < a.length) {
    					product[rowQ][colT] = (a[divQ][divT] * b[modQ][modT] + a[modQ][modT] * b[divQ][divT] + a[divQ][modT] * b[modQ][divT] + a[modQ][divT] * b[divQ][modT]) * 0.5;
    					colT++;
    					modT++;
    				}

    				divT++;
    				product[rowQ][colT] = (a[divQ][divT] * b[modQ][divT] + a[modQ][divT] * b[divQ][divT]) * inverseSqrt2;
    				modT = divT + 1;
    				colT++;
    			}

    			rowQ++;
    			modQ++;
    			divT = 0;
    			modT = 1;
    		}

    		divQ++;
    		product[rowQ][0] = a[divQ][0] * b[divQ][0];
    		modQ = divQ + 1;
    		colT = 1;

    		while (divT + 1 < a.length) {
    			while (modT < a.length) {
    				product[rowQ][colT] = (a[divQ][divT] * b[divQ][modT] + a[divQ][modT] * b[divQ][divT]) * inverseSqrt2;
    				colT++;
    				modT++;
    			}

    			divT++;
    			product[rowQ][colT] = a[divQ][divT] * b[divQ][divT];
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
