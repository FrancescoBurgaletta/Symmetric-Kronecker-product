# The symmetric Kronecker product

Here i propose an implementation of the symmetric Kronecker product as described in [this paper](https://www.math.uwaterloo.ca/~hwolkowi/henry/reports/kronthesisschaecke04.pdf):

$$G \otimes_s H = \frac{1}{2} Q \left( G\otimes H + H\otimes G \right) Q^T$$

This implementation exploits the implicit structure of the $Q$ symmetric vectorizing matrix with modular arithmetic, making its storing unnecessary. The two intermediate Kronecker products are also unnecessary, since they are treated implicitly within the algorithm. Thus, the space complexity of this implementation is only $O \left( 1 \right)$.

The time complexity, however, is the same as the Kronecker product, because a square matrix of size $\frac{n(n+1)}{2}$ is produced. The time complexity, in conclusion, is still $O \left( n^4 \right)$, and it cannot be lowered, because such time is necessary just to fill the resulting matrix.

Numerical error is also reduced, because the external $\frac{1}{2}$ factor and the $\frac{1}{\sqrt{2}}$ factor internal to the $Q$ matrix have been taken into account beforehand, saving avoidable additions and multiplications.

## WARNING
The code has only proven successful on the toy example provided along with the algorithm. Further testing is needed.
