Thank you for downloading the Code Morphing project.  Code Morphing is
a research project being developed at Georgia Instituted of Technology
and University of Oregon.  The current morphing language being actively 
developed is MorphJ (or MJ), a morphing language extension for Java.

Project members:
  Shan Shan Huang (ssh@cc.gatech.edu)
  Yannis Smaragdakis (yannis@cs.uoregon.edu)

## Getting started with the BINARY download

Contents of the binary download:

directories
- ```morphing/MJ/MJBackend/src```
  - include executable jar ```MJCompiler.jar```
- ```morphing/MJ/examples```: includes some example MorphJ files
- ```morphing/MJ/testcases```: includes some test files.

To use:

Option1:
- Put ```morphing/MJ/MJBackend/src/MJCompiler.jar``` in your ```CLASSPATH```
- invoke:
```shell
java main.MJCompiler [files|directories]
```

For all compiler options, run:
```shell
java main.MJCompiler
```

Option2:
- You can directly invoke MJCompiler.jar as an executable jar file.
  Change into the directory containing MJCompiler.jar, invoke:

```shell
java -jar MJCompiler.jar [files|directories]
```

For all compiler options, run:
```shell
java -jar MJCompiler.jar
```


## Getting started with the SOURCE download

Contents of the source download:
- ```morphing/JastAddJ```: includes the Java compiler built using JastAdd.  
- ```morphing/MJ/MJFrontend```: source files for MJ frontend parsing and type checking
- ```morphing/MJ/MJFrontend```: source files for MJ backend classfile generation.
- ```morphing/MJ/examples```: includes some example MorphJ files
- ```morphing/MJ/testcases```: includes some test files.

To build:
- Change into ```morphing/MJ/MJBackend/src```
- run: ```ant build```

To use:
- First, put in CLASSPATH:
  ```morphing/MJ/MJBackend/src```
  ```morphing/MJ/MJBackend/thirdparty/asm-all-3.1.jar```
- Run:
  ```java main.MJCompiler [files|directories]```

To see all compiler options:
  ```java main.MJCompiler```

## Example files

Both binary and source distribution contains example 


## Release notes:

Version 0.21 06/04/2008

- 


Version 0.11 

- This is the initial release and by no means perfect or well-tested.  All files
in the examples and testcases directory runs. But there are many features not 
yet tested or developed. Among them:
  - modifier access checking of morphing code is not complete
  - reflectively declared statements do not handle try/catch blocks, loops,
    or any statements whose bytecode involve labels.
