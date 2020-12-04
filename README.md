# Logic app
(better name needed)

## Purpose
The goal of this repo is to provide a platform for generic logic operations (checking for consistency, validity, explanations, etc.) by way of an easy-to-use DSL. 

## Mission
The purpose is achieved by way of three parts:
- The DSL specification and generator (`za.org.cair.logic_app`)
- An IDE plugin (`za.org.cair.logic_app.ide`)
- A webapp editor (`za.org.cair.logic_app.web`)

## Usage

### On the CLI

Xtext compilers are not typically used on the command like (like e.g. `gcc` and `javac`) so support (especially in CI contexts) is very limited. Through some shady hacks I got it working (for now). 

Download the compiler jar from the "CLI logic lang compiler" workflow build artifacts. Create a file written in the specified logic language (with `.logic` as file extension). Compile as follows:

```sh
java -jar logic-compiler.jar example.logic
```

Ignore the reflection warnings. They are caused in Java 11 onwards by a lib xtext depends on and will be updated once the developers there get their act together. [More info](https://github.com/eclipse/xtext-core/issues/506).


### As library / on Web / in IDE

TODO


