# blog 1

## Iterators & Iterables

### Do you think making the Graph Iterable makes semantic sense? Discuss briefly, and think of both sides.
Making a graph iterable allows for easy traversal of its nodes or edges.  

### Is a Graph an iterator or an iterable in this case?
It is an iterator and an iterable, both valid.

### What would the .iterator method return in this case?
.iterator method will return the graph it self.  

### There is a problem with this approach though. Inside your blog post, describe a test that would cause this implementation to fail.
If the graph return itself as iterator, then the iterators are not independent. One iterator call next() will affect others. 

## Iterator Invalidation
graph.removeNode() will broken the iteraor of the graph, some node will not be visited if they lost all the edges. 


# blog 2

## Q1) Why doesn’t the compiler warn me that I have this bug in my code?
The FlowerBox class accept Flower and does not distinct different flowers.  

## Q2) Why do I have to cast the list of flowers that are returned from their respective boxes?
Their respective boxes just have different variable name, they do not know the real class type.  

## Q3) Does the compiler warn or give an error about the bug in the code, now that the flower box is using generics? Why?
Yes. The flower box's generic parameter does not fit the request.  

## Q4) Explain how the information provided by the compiler helped you fix the bug? Why is the type system happy now that the bug is fixed?
The compiler said "The method addFlower(Sunflower) in the type FlowerBox<Sunflower> is not applicable for the arguments (Rose)".  
After the bug is fixed, the type is applicable for the arguments.  

## Q5) Remove all of the casts from the routeHarvest method. This part of the code should have no warnings or errors now. Why does this work without us having to cast anything?
The type is applicable for the left side.  

## Q6) What do you think is the advantage of using Generics here over creating subclasses for the Sunflower Box and the Rose Box?
The different box have all the same method . The only difference is the parameter's type.  