ZhangShasha
===========

The Zhang-Shasha algorithm calculates the edit distance between trees by counting the minimum number of node insertions,
deletions, and relabelings needed to transform one tree into another. The idea is similar to the edit-distance between strings and, 
in fact, edit-distance between strings is a special-case of this algorithm. In calculating the edit-distance between strings, 
one counts the minimum number of character insertions, deletions, and relabelings to transform one string into another. 
Go here: http://en.wikipedia.org/wiki/Edit_distance to learn more about the edit-distance between strings.

This project is the Java implementation of the Zhang-Shasha algorithm. 

Throughout the project, rather large trees were tested. In order to avoid manually allocating each Node object and connected these
Nodes accordingly, a simpler method was used. This project includes an easy way to build trees using preorder notation for trees.
Why preorder? Because preorder notation is inherent through the Zhang-Shasha algorithm itself.

Parenthesized strings such as "f(d(a c(b))e)" are passed to the Tree class's constructor to make the corresponding Tree object. For example,
"f(a b(c))" looks like this:

        f
       / \
      a   b
          |
          c


The project's main class include some sample trees anyone reading this can test the algorithm on. 
