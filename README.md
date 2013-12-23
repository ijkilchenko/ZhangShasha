ZhangShasha
===========

A Java implementation of the Zhang-Shasha algorithm for tree edit distance.

The original paper describing the algorithm can be found here http://filer.case.edu/axi48/ZhangShasha.pdf .

1. This project includes an easy way to build trees.
Parenthesized strings such as "f(d(a c(b))e)" which represent trees in preorder notation can be passed to Tree class's constructor. 
2. ...
...

TODO
====

1. [MED] Generalize the Node class. Use Java generics. 
2. [MED] Write a better README file.
3. [HIGH] Fix bugs which occasionally overwrite forestdistances for some reason. 
4. [LOW] I have traverse(), index(), and l() methods which all traverse the tree making ArrayList variables which are later used. Consider making just one method which traverses the tree making all ArrayList variables at once. 

