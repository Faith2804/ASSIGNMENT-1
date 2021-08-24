# ASSIGNMENT-1
#I used JGrasp for this assignment and tested it in ubuntu through the virtual code. The structure of the code supports both JGrasp and Ubuntu. In JGrasp you have to comment out some part of code, while in Ubuntu you can use it straight forward.
#
#
#
#
###
# QUESTION
Parallel programming with ForkJoin framework
The size of the filter determines the number of neighbours considered for the median. In this
assignment, you will consider only one-dimensional data sets and filters of odd size, ranging
from 3 to 21 data items.
For example, a median filter of size 3 applied to the simple 1D array x:
x = [2 80 6 3 1]
produces output array y:
y = [2 6 6 3 1]
where each element of y is calculated as follows:
y[1] = Median[2 80 6] = 6
y[2] = Median[80 6 3] = 6
y[3] = Median[6 3 1] = 3
Note that the borders are not changed and that the size of the borders depends on the filter
width. In this example, the border is 1 element wide. The naïve approach to median filtering
sorts the elements within the filter window at each step to calculate the median (which will
then be the middle element). Using this naïve approach (which we will do in this assignment)
the median computation can be quite expensive, especially if the filter window is large.
Therefore, in this assignment you will attempt to parallelize the problem in order to speed it
up. You will:
• Use the Java Fork/Join framework to parallelize the median filter operation using a
divide-and-conquer algorithm. Do not use any other method of parallelizing this problem, 
as mentioned in lectures.The size of the filter determines the number of neighbours considered for the median. In this
assignment, you will consider only one-dimensional data sets and filters of odd size, ranging
from 3 to 21 data items.
For example, a median filter of size 3 applied to the simple 1D array x:
x = [2 80 6 3 1]
produces output array y:
y = [2 6 6 3 1]
where each element of y is calculated as follows:
y[1] = Median[2 80 6] = 6
y[2] = Median[80 6 3] = 6
y[3] = Median[6 3 1] = 3
Note that the borders are not changed and that the size of the borders depends on the filter
width. In this example, the border is 1 element wide. The naïve approach to median filtering
sorts the elements within the filter window at each step to calculate the median (which will
then be the middle element). Using this naïve approach (which we will do in this assignment)
the median computation can be quite expensive, especially if the filter window is large.
Therefore, in this assignment you will attempt to parallelize the problem in order to speed it
up. You will:
• Use the Java Fork/Join framework to parallelize the median filter operation using a
divide-and-conquer algorithm. Do not use any other method of parallelizing this problem, 
as mentioned in lectures.
