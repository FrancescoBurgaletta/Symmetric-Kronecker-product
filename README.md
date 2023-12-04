#The symmetric Kronecker product

Here i propose an implementation of the symmetric Kronecker product as described in [this paper](https://www.math.uwaterloo.ca/~hwolkowi/henry/reports/kronthesisschaecke04.pdf):

$$G \otimes_s H = \frac{1}{2} Q \left( G\otimes H + H\otimes G \right) Q^T$$

This implementation exploits the implicit structure of the Q symmetric vectorizing matrix with modular arithmetic, making its storing unnecessary.
The intermediate Kronecker products are also unnecessary, since they are treated implicitly within the algorithm.
Thus, the space complexity of this implementation is only $O \left( 1 \right)$, counting only the variables.
The time complexity, however, is the same as the Kronecker product, that is $O \left( n^4 \right)$.