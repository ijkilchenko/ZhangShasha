ZhangShasha
===========

The Zhang-Shasha algorithm calculates the edit distance between trees by counting the minimum number of node insertions,
deletions, and relabelings needed to transform one tree into another. The idea is similar to the edit-distance between strings, but
much less popular or common. In calculating the edit-distance between strings, one counts the minimum number of character insertions,
deletions, and relabelings to transform one string into another. In fact, the case of strings is a special case of the edit
distance between trees. Go here: http://en.wikipedia.org/wiki/Edit_distance to learn more about the edit-distance between strings.

This project is the Java implementation of the Zhang-Shasha algorithm. Its applications include calculating distances between
RNA folds (where RNA folds are interpreted as a tree) and simply giving a metric (TODO: is the distance calculated a "mathematical" metric?)
between two trees.

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

TODO
====

1. [LOW] Generalize the Node class. Use Java generics. Then, extend node comparison to handle generics.
2. [MED] Write a better README file and include more comments throughout the project.
3. [LOW] traverse(), index(), and l() all traverse the tree individually making appropriate variables.
        Consider making just one method which traverses the tree making all appropriate variables at once.
4. [MED] Consider refactoring Tree and Node classes to make the algorithm more intuitive in terms of objects used.
5. [MED] Include ways to test the algorithm other than the sample trees hard-coded in the main class.
6. [LOW] Think if there is a way to generate random tree pairs where the distance is known before running the algorithm, then
        use these tree pairs to test the algorithm more rigorously.

