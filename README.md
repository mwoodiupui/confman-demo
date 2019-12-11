# confman-demo
Demonstrates the definition and use of Integrated Extension Functions using Saxon-HE.

Saxon-HE does not read a configuration file, which is one way of registering functions coded in Java with Saxon-PE or Saxon-EE.
Another way is to find the configuration in your Java code and register them yourself.  Here is an example.

This example was written specifically to test the way I wanted to do this in DSpace, so it may be more elaborate than would be
necessary in the general case.
